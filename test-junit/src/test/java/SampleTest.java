import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SampleTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

//    @Test
//    public void Log(){
////        logger.info("THis is info");
////        logger.fatal("This is fatal");
////        logger.error("This is error");
////        logger.debug("This is debug");
////        logger.warn("This is warn");
////        logger.trace("This is trace");
//    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }
    @Test
    public void openPage() {
        driver.get(cfg.url());
        logger.info(driver.getTitle().equals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям"));
        logger.info("Открыта страница отус");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
