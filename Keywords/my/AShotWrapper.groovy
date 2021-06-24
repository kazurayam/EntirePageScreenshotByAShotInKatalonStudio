package my

import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies


class AShotWrapper {

	/**
	 * 
	 * @param driver
	 * @param file
	 * @param timeout
	 * @param dpr Device-Pixel-Ratio
	 * @return
	 */
	static BufferedImage takeEntirePageImage(WebDriver driver, int timeout = 500, float dpr = 2.0f) {
		Screenshot screenshot =
				new AShot().coordsProvider(new WebDriverCoordsProvider())
				.shootingStrategy(
				ShootingStrategies.viewportPasting(
				ShootingStrategies.scaling(dpr), timeout
				)
				)
				.takeScreenshot(driver)
		return screenshot.getImage()
	}

	static void saveEntirePageImage(WebDriver driver, File file, int timeout = 500, float dpr = 2.0f) {
		BufferedImage image = takeEntirePageImage(driver, timeout, dpr)
		ImageIO.write(image, "PNG", file)
	}
}
