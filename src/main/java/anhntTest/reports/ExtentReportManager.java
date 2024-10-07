package anhntTest.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("exports/ExtentReport/ExtentReport.html");
        reporter.config().setReportName("Extent Report | HRM");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Final Project Automation Test | HRM");
        extentReports.setSystemInfo("Author", "TuanAnh");
        extentReports.setSystemInfo("Version", "1.0");
        return extentReports;
    }

}
