package unitTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.browser.BrowserFactory;
import com.shaft.io.ExcelFileManager;
import com.shaft.io.ReportManager;

public class tests_io_excelFileManager {

    ExcelFileManager testDataReader;
    // WebDriver driver;

    @Test
    public void getCellData_rowName_expectedToPass() {
	ReportManager.log(testDataReader.getCellData("testRowValue"));
    }

    @BeforeClass // Set-up method, to be run once before the first test
    public void beforeClass() {
	System.setProperty("testDataFilePath", "src/test/resources/TestDataFiles/testSuite01/TestData.xlsx");
	testDataReader = new ExcelFileManager(System.getProperty("testDataFilePath"));
	// driver = BrowserFactory.getBrowser(testDataReader);
    }

    @AfterClass(alwaysRun = true) // Tear-down method, to be run once after the last test
    public void afterClass() {
	BrowserFactory.closeAllDrivers();
    }

    @AfterMethod
    public void afterMethod() {
	ReportManager.getTestLog();
    }

}
