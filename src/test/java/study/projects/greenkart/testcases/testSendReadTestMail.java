package study.projects.greenkart.testcases;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import study.common.BaseTest;
import study.keywords.WebUI;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testSendReadTestMail extends BaseTest{

    public void sendEmail(String to, String subject, String body){
        final String from = "your-email@gmail.com"; // Your email address
        final String username = "your-email@gmail.com"; // Your email username
        final String password = "your app password";    // Your app password (see how to generate: https://www.youtube.com/watch?v=weA4yBSUMXs)

        String host = "smtp.gmail.com";  // SMTP server

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void readEmail(){
        String apiKey = "your api key"; // Replace with your Testmail.app API key
        String inboxId = "397r8"; // Replace with your Testmail.app inbox ID

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.testmail.app/api/json?apikey=" + apiKey + "&namespace=" + inboxId))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Emails: " + responseBody);

            // Here you can parse the JSON response to get specific details about the emails

            // Parse JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode emailsNode = rootNode.get("emails");

            // Iterate over emails and print details
            for (JsonNode emailNode : emailsNode) {
                String subject = emailNode.get("subject").asText();
                String body = emailNode.get("text").asText();
                System.out.println("Subject: " + subject);
                System.out.println("Body: " + body);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readLatestEmail() {
        String apiKey = "your api key"; // Replace with your Testmail.app API key
        // this key took from: https://testmail.app/console#apikeys (login with bui.binh.k56@gmail.com)
        String inboxId = "397r8"; // Replace with your Testmail.app inbox ID

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.testmail.app/api/json?apikey=" + apiKey + "&namespace=" + inboxId))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Emails: " + responseBody);

            // Here you can parse the JSON response to get specific details about the emails

            // Parse JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode emailsNode = rootNode.get("emails");

            // Iterate over emails and print details
            for (JsonNode emailNode : emailsNode) {
                String subject = emailNode.get("subject").asText();
                String body = emailNode.get("text").asText();
                String from = emailNode.get("from").asText();

                System.out.println("Subject: " + subject);
                System.out.println("Body: " + body);
                System.out.println("From: " + from);
                if (body.length() > 0) {
                    return body;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Test
    public void testSendEmailbyTestMail(){

        String to = "397r8.test@inbox.testmail.app";
        String subject = "Subject auto1";
        String body = "Content created by auto1";

        sendEmail(to, subject, body);
        readLatestEmail();

    }

    public void loginAndForgotPasswordInTwitter(){

        String twitterURl = "https://x.com/i/flow/login";
        String emailAddress = "397r8.test@inbox.testmail.app";
        By btnForgotPassword = By.xpath("//span[text()='Forgot password?']");
        By inputEmail = By.xpath("//input");
        By btnNext = By.xpath("//button[.='Next']");
        By labelSendEmailConfirm = By.xpath("//span[contains(.,'Send an email to')]");
        By inputCode = By.xpath("//input");


        WebUI.getURL(twitterURl);
        WebUI.sleep(2);
        WebUI.clickElement(btnForgotPassword);
        WebUI.setText(inputEmail, emailAddress);
        WebUI.clickElement(btnNext);
        WebUI.clickElement(labelSendEmailConfirm);
        WebUI.clickElement(btnNext);

        String emailBody = readLatestEmail();
//        String emailBody = "Please enter this verification code to get started on X: 127764 Verification codes expire after two hours.";
        String regex = "\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailBody);
        if (matcher.find()) {
            System.out.println("Found verification code: " + matcher.group());
            WebUI.setText(inputCode, matcher.group());
            WebUI.clickElement(btnNext);
        } else {
            System.out.println("Verification code not found.");
        }


    }
    @Test
    public void testForgotPasswordInTwitter(){
        loginAndForgotPasswordInTwitter();
    }

}
