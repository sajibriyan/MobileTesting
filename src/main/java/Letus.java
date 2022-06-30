import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Letus {

    static AppiumDriver driver;

    public static void main(String[] args) {

        try{
            openCalculator();
        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

    }
    public static <MobileElement> void openCalculator() throws Exception {

        DesiredCapabilities cap= new DesiredCapabilities();

        cap.setCapability("deviceName", "AOSP on IA Emulator");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");

        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url =new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver (url, cap);

        System.out.println("Application Started......");

        WebElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        WebElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
        WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        WebElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));

        WebElement results= driver.findElement(By.className("android.widget.TextView"));
        two.click();
        plus.click();
        three.click();
        equals.click();
        results.click();

        String res = results.getText();
        System.out.println("\n The Result is: "+res);

        System.out.println("Completed...");
    }
}
