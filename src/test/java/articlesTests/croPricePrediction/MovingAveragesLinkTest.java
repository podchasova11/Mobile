package articlesTests.croPricePrediction;

import abstractSetting.AbstractTest;
import io.qameta.allure.*;
import org.example.pageElements.ArticlesElements;
import org.example.utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MovingAveragesLinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(MovingAveragesLinkTest.class);

    @Epic("Articles")
    @Feature("CRO price prediction: Will the Crypto.com token rebound?")
    @DisplayName("Test№11")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    @Test
    void movingAveragesLinkTest() throws IOException {
        try {
            ArticlesElements tapElement = new ArticlesElements(getAndroidDriver());
            tapElement.goToArticles();
            Thread.sleep(3000);
            tapElement.tapCroPrice();
            Thread.sleep(4000);
            tapElement.tapMovingAverages();
            Thread.sleep(1000);
            getAndroidDriver().context("WEBVIEW_chrome");
            Thread.sleep(1000);
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (CRO price prediction) MovingAveragesLinkTest- False" + System.currentTimeMillis() + ".png");
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()))));
            logger.error("org.example.articlesTests (CRO price prediction) MovingAveragesLinkTest- False");
        }
        Assertions.assertTrue(getAndroidDriver().getTitle().equals("Moving average (MA) | Definition and Meaning | Capital.com"));
        Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://capital.com/moving-average-definition"));
        logger.info("(CRO price prediction) MovingAveragesLinkTest- passed");
    }
}
