It's a project containing 4 tests on Instagram app:
1. Post using camera
2. Post using picture in resources/truecat.jpg  

Requirements:  
Appium 1.20.2  
Java 8  
Running android 8 emulator (you can use one from android studio adv)

This test are not guaranteed to run on android 6 and 7

!!!  
To run test properly, it's required to have test user in Google Smart Lock. By default, it uses the very first user in list.  
To change order, you can change index of locator of loginUsingGoogleCredos in StartPage class.