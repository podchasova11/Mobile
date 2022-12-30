package articlesTests.shibuInuPricePrediction;

import abstracts.AbstractTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Link;
import org.example.pageElement.ArticlesElements;
import org.example.utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;

public class BitcoinBtcLinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(BitcoinBtcLinkTest.class);

    @Test
    @DisplayName("Tect№5: Articles - Shibu inu price prediction")
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    void bitcoinBtcLinkTest() throws Exception {
        try {
            TouchAction touchAction = new TouchAction(getAndroidDriver());
            ArticlesElements tapElement = new ArticlesElements(getAndroidDriver());
            tapElement.goToArticles();
            tapElement.tapShibaInuPrice();
            Thread.sleep(3000);
            touchAction
                    .press(PointOption.point(620, 2000))
                    .moveTo(PointOption.point(620, 720))
                    .release()
                    .perform();
            tapElement.tapBitcoinBtc();
            Thread.sleep(15000);
            getAndroidDriver().context("WEBVIEW_chrome");
            Thread.sleep(3000);
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (Shibu inu price prediction)  BitcoinBTCLinkTest- False" + System.currentTimeMillis() + ".png");
            MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()));
            logger.error("org.example.articlesTests (Shibu inu price prediction) BitcoinBTCLinkTest- False");
        }
        Assertions.assertTrue(getAndroidDriver().getTitle().equals("BTC/USD Chart | Live Bitcoin to US Dollar Price"));
        Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://capital.com/btc-usd-chart"));
        logger.info("(Shibu inu price prediction) BitcoinBTCLinkTest- passed");

    }
}