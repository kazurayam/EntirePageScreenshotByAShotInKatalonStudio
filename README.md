# Taking entire page screenshots and measure diff by AShot


This is a simple [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this out onto you PC and run it using your Katalon Studio.

This demo was originally developed with Katalon Studio version 5.4.2, tested ok with v7.9.1.


## Problem to solve

I wanted to take an screenshot of a Web page. The target page was supposed to have the height over 10,000px.

I wanted to take screenshots of a web page in the Development environment and the Production Environment, and compare how much different they are. If a significant difference is found exceeding a certain criteria (e.g, diff > 3.0%), then I want my test to fail to notify developers of unexpected change found.

I tried Katalon's built-in `WebUI.takescreenshot()`. I found, it can only take visual portion; it can not take the image of entire page.

## Solution

By searching I found a Java Library called AShot.
- https://github.com/yandex-qatools/ashot

>WebDriver Screenshot utility
>1. Takes a screenshot of a WebElement on different platforms (i.e. desktop browsers, iOS Simulator Mobile Safari, Android Emulator Browser)
>2. Decorates screenshots
>3. Provides flexible screenshot comparison

I was impressed with the simplicity of the sample code of capturing the entire page by AShot. So I tried AShot in Katalon Studio.

I have found AShot works like a charm.

## Demos

1. clone this git repository onto your PC
2. The jar of AShot is avaiblable at the [Maven Repository](https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot). `ashot-1.5.4.jar` file is already included in the project's `Drivers` folder.
4. run Test Cases. The output PNG images will be written into `Screenshots` directory.

### Demo1: Katalon Studio built-in feature: taking screenshot when test failed

Execute `[Test Suites/TS1_screenshot_taken_when_failed]`. It will call [Test Cases/TC1_ks-built-in_screenshot_taken](Scripts/TC1_screenshot_taken_when_failed/Script1624585535537.groovy). This TestCase will fail intentionally. As this project is configured to take screenshot when execution failed (Project > Settings > Execution), Katalon Studio will automatically take a screenshot and save an image into the Reports folder. The HTML reports will show the image included.

### Demo2: Katalon Studio built-in feature: taking a screenshot of viewport

Execute [`Test Cases/TC2_viewport_screenshot`](Scripts/TC2_viewport_screenshot/Script1624585545780.groovy). This demonstrates how to use the `WebUI.takeScreenshot()` keyword which is a built-in Katalon Studio. This keyword takes an image of the viewport, not entire page.

### Demo3: saving entire page image

Execute ['Test Cases/TC3_save_entire_page_image'](Scripts/TC3_save_entire_page_image/Script1624584723862.groovy). This demonstrates how to take entire page screenshot and save image into file. This uses a custom keyword: ['my.AShotWrapper'](Keywords/my/AShotWrapper.groovy), which is a thin wrapper of AShot. Another custom keyword ['my.DevicePixelRatioResolver'](Keywords/my/DevicePixelRatioResolver.groovy) is used to detect [Device-Pixel-Ratio](https://developer.mozilla.org/en-US/docs/Web/API/Window/devicePixelRatio) of the current platform.

A sample output -> [`Screenshots/TC3_save_entire_page_image.png`](Screenshots/TC3_save_entire_page_image.png)

### Demo4: comparing two images and measure how much different

Execute ['Test Cases/TC4_imageDiffer](Scripts/TC4_imageDiffer/Script1535956206390.groovy). This takes screenshots of a pair of URLs (almost similar but are different) to save them into files:
- Original https://katalon-demo-cura.herokuapp.com/
- Mimic http://demoaut-mimic.kazurayam.com/

This compares 2 images and measure how much these are different. The difference is calculated to a figure. When the difference larger than the given criteria (e.g, 3.0 %), the test fails.

Sample output:

#### screenshot of the Original

![oritinal](Screenshots/TC4_original.png)

#### screenshot of the Mimic

![mimic](Screenshots/TC4_mimic.png)

#### image diff

![diff](Screenshots/TC4_imageDiff.png)

### DemoX: taking entire screenshot of an extremely tall page

Here is an example web page, which has extremely large "height".

<img src="Screenshots/TCx_fontAwesome.png" width="200" style="border: 1px solid #999">
