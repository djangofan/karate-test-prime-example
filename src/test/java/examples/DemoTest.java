package examples;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest extends TestBase {

    private static final String REPORT_TITLE = "karate-test-prime-example";
    private static final String GLOBAL_IGNORE_ALL = "~@ignore";

    public static void main(String[] args) {
        new DemoTest().runAPITests();
    }

    @Test
    public void runAPITests() {
        Results results = Runner.parallel(5, "classpath:examples", GLOBAL_IGNORE_ALL);

        Assert.assertTrue("Did not find any cucumber tests to execute.",results.getFeatureCount() > 0);

        generateReport(results.getReportDir());

        Assert.assertEquals("Had at least one test failure.  See the HTML report for details.", 0, results.getFailCount());
    }

    static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);

        List<String> jsonPaths = jsonFiles.stream().map(File::getAbsolutePath).collect(Collectors.toList());

        Configuration config = new Configuration(new File("target"), REPORT_TITLE);
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);

        reportBuilder.generateReports();
    }
}
