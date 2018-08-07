Taking entire page screenshot by AShot in Katalon Studio
=====================

This is a simple [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this out onto you PC and run it using your Katalon Studio.

This demo was developed with Katalon Studio version 5.4.2.

## Problem to solve

I wanted to take an screenshot of a Web page. The target page was supposed to have the height over 10,000px.

I tried WebUI.takescreenshot() and found it can only take visual portion; it can not take the image of entire page.

## Solution

By searching I found a Java Library called AShot.
- https://github.com/yandex-qatools/ashot

>WebDriver Screenshot utility
>1. Takes a screenshot of a WebElement on different platforms (i.e. desktop browsers, iOS Simulator Mobile Safari, Android Emulator Browser)
>2. Decorates screenshots
>3. Provides flexible screenshot comparison

I was impressed with the simplicity of the sample code of capturing the entire page by AShot. So I tried AShot in Katalon Studio.

I have found AShot works like a charm.

## How to run the demo

1. clone this git repository onto your PC
2. The jar of AShot is avaiblable at the Maven Repository https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot
3. ashot-1.5.4.jar file is already included in the project's `./Dirvers` folder.
4. open [`Test Cases/TC1`](https://github.com/kazurayam/EntirePageScreenshotByAShotInKatalonStudio/blob/master/Scripts/TC1/Script1533622426100.groovy) and run it with any browser you like.
5. a png file will be written into `./Reports/screenshot.png`

Here I show the screenshot taken by AShot:
<img src="https://github.com/kazurayam/EntirePageScreenshotByAShotInKatalonStudio/blob/master/docs/screenshot.png" width="40" style="border: 1px solid #999">
