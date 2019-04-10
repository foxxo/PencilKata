package com.kata;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PencilMain {
    public static void main(String[] args) {
        System.out.println("Beginning unit tests for Pencil Kata...");

        Result result = JUnitCore.runClasses(PencilTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println( result.getRunCount() - result.getFailureCount() + " tests successful. Runtime was " + result.getRunTime() + "ms");
    }
}
