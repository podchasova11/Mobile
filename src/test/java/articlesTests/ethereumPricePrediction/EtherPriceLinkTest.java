package articlesTests.ethereumPricePrediction;

import abstractSetting.AbstractTest;
import io.qameta.allure.*;
import org.example.pageElements.EthereumPricePredictionElements;
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

public class EtherPriceLinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(EtherPriceLinkTest.class);

    @Epic("Articles")
    @Feature("Ethetium price precondition for 2022 and beyond: Will ETH ever hit $10,000?")
    @DisplayName("Test№24")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    @Test
    void etherPriceLinkTest() throws IOException {
        try {
            EthereumPricePredictionElements tapElement = new EthereumPricePredictionElements(getAndroidDriver());
            tapElement.goToArticles();
            Thread.sleep(2000);
            tapElement.tapEthereumPricePrediction();
            Thread.sleep(3000);
            tapElement.tapEtherPrice();
            getAndroidDriver().context("WEBVIEW_chrome");
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (Ethereum price prediction) EtherPriceLinkTest- False" + System.currentTimeMillis() + ".png");
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()))));
            logger.error("org.example.articlesTests (Ethereum price prediction) EtherPriceLinkTest- False");
        }
        Assertions.assertTrue(getAndroidDriver().getTitle().equals("ETH/USD Chart | Live Ethereum to US Dollar Price"));
        Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://capital.com/eth-usd-chart"));
        logger.info("(Ethereum price prediction) EtherPriceLinkTest- passed");
    }
}
