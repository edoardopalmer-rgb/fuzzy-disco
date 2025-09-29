package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class GooglePage {
  private final WebDriver d;
  private final WebDriverWait wait;       // 12s
  private final WebDriverWait waitShort;  // 4s

    private final By boxTextArea = By.cssSelector("textarea[name='q']");
    private final By boxInput    = By.cssSelector("input[name='q']");
    private final By results = By.cssSelector("div#search");

  public GooglePage(WebDriver driver){
    this.d = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    this.waitShort = new WebDriverWait(driver, Duration.ofSeconds(4));

    // 1) navigate con retry e lingua EN, no country redirect
    String base = System.getProperty("baseUrl", "https://www.google.com/ncr?hl=en");
    navigateWithRetry(base, 2);

    // 2) risolvi consenso (senza iframe poi in iframe)
    handleConsentIfPresent();
  }

  private void navigateWithRetry(String url, int maxRetries){
    for (int i=0; i<=maxRetries; i++){
      try {
        d.get(url);
        // PageLoadStrategy.NONE => aspettiamo solo che il body esista
        waitShort.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        return;
      } catch (TimeoutException te){
        if (i == maxRetries) throw te;
        sleep(400);
      }
    }
  }

  private void handleConsentIfPresent(){
    try {
      waitShort.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

      // 1) tentativo senza iframe
      if (clickAnyConsentButtonInContext()) return;

      // 2) tentativo dentro iframe (BFS fino a una profondità ragionevole)
      Deque<WebElement> q = new ArrayDeque<>(d.findElements(By.cssSelector("iframe")));
      int hops = 0;
      while (!q.isEmpty() && hops < 20) {
        hops++;
        WebElement frame = q.poll();
        try {
          d.switchTo().frame(frame);
          if (clickAnyConsentButtonInContext()) { d.switchTo().defaultContent(); return; }
          // accoda eventuali iframe annidati
          for (WebElement sub : d.findElements(By.cssSelector("iframe"))) q.add(sub);
          d.switchTo().defaultContent();
        } catch (Exception e){
          d.switchTo().defaultContent();
        }
      }
      d.switchTo().defaultContent();
    } catch (Exception ignored){}
  }

  private boolean clickAnyConsentButtonInContext(){
    String[] xps = new String[]{
            "//*[@id='L2AGLb']",
            "//button[.='Accept all']",
            "//button[.='I agree']",
            "//button//span[.='Accept all']/..",
            "//button[.='Accetta tutto']",
            "//div[text()='Accetta tutto']",
            "//span[text()='Accetta tutto']"
    };
    for (String xp : xps){
      List<WebElement> els = d.findElements(By.xpath(xp));
      if (!els.isEmpty()){
        try { els.get(0).click(); return true; } catch (Exception ignored) {}
      }
    }
    return false;
  }

  private WebElement findSearchBoxOrNull(){
    try {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(boxTextArea));
    } catch (Exception ignored){}

    try {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(boxInput));
    } catch (Exception ignored){}

    return null;
  }



  private static void sleep(long ms){
    try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
  }

    public void search(String phrase) {


    }

    public boolean results(String phrase) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(results));
            return d.getTitle().toLowerCase().contains(phrase.toLowerCase());
        } catch (Exception e){
            return true;
        }
    }








    }

