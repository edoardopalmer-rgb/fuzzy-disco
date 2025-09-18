package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

public class Hooks {
  @Before
  public void before(){ DriverFactory.get(); }

  @AfterStep
  public void afterStep(Scenario sc){
    if (sc.isFailed()){
      byte[] shot = ((TakesScreenshot) DriverFactory.get()).getScreenshotAs(OutputType.BYTES);
      sc.attach(shot, "image/png", "failed-step");
    }
  }

  @After
  public void after(){ DriverFactory.quit(); }
}
