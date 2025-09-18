package runner;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps,hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
  value = "pretty, html:target/cucumber.html, json:target/cucumber.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @wip")
public class CucumberTest {


}
