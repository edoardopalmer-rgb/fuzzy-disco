package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
  private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();

  public static WebDriver get(){
    if (TL.get()==null){
      boolean headless = Boolean.parseBoolean(System.getProperty("headless","true"));

      WebDriverManager.chromedriver().setup();
      ChromeOptions opt = new ChromeOptions();
      if (headless) opt.addArguments("--headless=new");
      opt.addArguments("--window-size=1920,1080");
      opt.addArguments("--disable-gpu");
      opt.addArguments("--disable-extensions");
      opt.addArguments("--disable-popup-blocking");
      opt.addArguments("--dns-prefetch-disable");
      opt.addArguments("--disable-features=Translate,IsolateOrigins,site-per-process");
      opt.setPageLoadStrategy(PageLoadStrategy.NONE); // non blocchiamo sul full load

      // lingua EN: aiuta a trovare i testi “Accept all”
      opt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
      Map<String,Object> prefs = new HashMap<>();
      prefs.put("intl.accept_languages", "en-US,en");
      opt.setExperimentalOption("prefs", prefs);

      WebDriver d = new ChromeDriver(opt);
      d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
      d.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
      d.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
      TL.set(d);
    }
    return TL.get();
  }

  public static void quit(){
    if (TL.get()!=null){ TL.get().quit(); TL.remove(); }
  }
}
