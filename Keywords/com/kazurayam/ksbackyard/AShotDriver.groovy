package com.kazurayam.ksbackyard

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

public class AShotDriver {

	@Keyword
	static void takeEntirePage(WebDriver webDriver, File file) {
		Screenshot screenshot = new AShot().
				shootingStrategy(ShootingStrategies.viewportPasting(100)).
				takeScreenshot(webDriver)
		ImageIO.write(screenshot.getImage(), "PNG", file)
	}
}