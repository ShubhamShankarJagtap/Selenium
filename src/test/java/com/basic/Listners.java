package com.basic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners implements ITestListener {

    ExtentSparkReporter sparkReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport() {

        sparkReporter = new ExtentSparkReporter(".//Excel//ExtentReport.htm");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);

        // Add system information
        reports.setSystemInfo("Version", "1.1");
        reports.setSystemInfo("OS", "WINDOWS 11");
        reports.setSystemInfo("Browser", "Chrome");
        reports.setSystemInfo("Machine", "HP");
        reports.setSystemInfo("User", "SHUBHAM JAGTAP.");

        // Add report configurations
        sparkReporter.config().setDocumentTitle("QA_SHUBHAM_TEST_REPORT");
        sparkReporter.config().setDocumentTitle("FUNCTIONAL_TEST_REPORT");
        sparkReporter.config().setTimelineEnabled(true);
        sparkReporter.config().setTimeStampFormat("HH:MM:SS:ms");
        sparkReporter.config().setTheme(Theme.STANDARD);
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("methods execution has been finished.");
        reports.flush();
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("method invocation has been started.");
        configureReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " has been failed.", ExtentColor.RED));
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test = reports.createTest(result.getName());
        test.log(Status.SKIP,
                MarkupHelper.createLabel(result.getName() + " method has been skipped ", ExtentColor.BLUE));
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println((result.getName()) + " : method execution has been started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test = reports.createTest(result.getName());
        test.log(Status.PASS,
                MarkupHelper.createLabel(result.getName() + " mehod has been successful", ExtentColor.GREEN));

    }
}
