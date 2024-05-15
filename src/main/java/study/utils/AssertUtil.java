package study.utils;

import io.qameta.allure.Step;
import org.testng.Assert;

public class AssertUtil {

    public static void showLog(){
        LogUtils.info("Passed Assertion at line %s: in method %s - file %s".formatted(Thread.currentThread().getStackTrace()[3].getLineNumber(),
                Thread.currentThread().getStackTrace()[3].getMethodName(),Thread.currentThread().getStackTrace()[3].getFileName()));
    }

    @Step("Verify Assert True with condition {0}")
    public static void assertTrue(boolean condition, String message){
        if(condition) {
            showLog();
        }
        Assert.assertTrue(condition, message);
    }

    @Step("Verify Assert True with condition {0}")
    public static void assertTrue(boolean condition){
        if(condition) {
            showLog();
        }
        Assert.assertTrue(condition);
    }

    @Step("Verify Assert False with condition {0}")
    public static void assertFalse(boolean condition, String message){
        if(condition) {
            showLog();
        }
        Assert.assertFalse(condition, message);
    }

    @Step("Verify Assert False with condition {0}")
    public static void assertFalse(boolean condition){
        if(condition) {
            showLog();
        }
        Assert.assertFalse(condition);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(int actual, int expect, String message){
        if(actual == expect) {
            showLog();
        }
        Assert.assertEquals(actual, expect, message);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(int actual, int expect){
        if(actual == expect) {
            showLog();
        }
        Assert.assertEquals(actual, expect);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(float actual, float expect, String message){
        if(actual == expect) {
            showLog();
        }
        Assert.assertEquals(actual, expect, message);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(float actual, float expect){
        if(actual == expect) {
            showLog();
        }
        Assert.assertEquals(actual, expect);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(String actual, String expect, String message){
        if(actual.equals(expect)) {
            showLog();
        }
        Assert.assertEquals(actual, expect, message);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(String actual, String expect){
        if(actual.equals(expect)) {
            showLog();
        }
        Assert.assertEquals(actual, expect);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(double actual, double expect, String message){
        if(actual == expect) {
            showLog();
        }
        Assert.assertEquals(actual, expect, message);
    }

    @Step("Verify Assert Equals  with actual: {0}, expect: {1}")
    public static void assertEquals(double actual, double expect){
        if(actual == expect) {
            showLog();
        }
        Assert.assertEquals(actual, expect);
    }

}
