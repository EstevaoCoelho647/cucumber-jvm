package io.cucumber.core.plugin;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static io.cucumber.core.plugin.BytesEqualTo.isBytesEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;

class NoPublishFormatterTest {
    @Test
    public void should_print_banner() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        NoPublishFormatter noPublishFormatter = new NoPublishFormatter(out);
        noPublishFormatter.setMonochrome(true);
        noPublishFormatter.printBanner();
        assertThat(bytes, isBytesEqualTo("" +
                "┌─────────────────────────────────────────────────────────────────────────────┐\n" +
                "│ Share your Cucumber Report with your team at https://reports.cucumber.io    │\n" +
                "│ Activate publishing with one of the following:                              │\n" +
                "│                                                                             │\n" +
                "│ src/test/resources/cucumber.properties:    cucumber.publish.enabled=true    │\n" +
                "│ Environment variable:                      CUCUMBER_PUBLISH_ENABLED=true    │\n" +
                "│ JUnit:                                     @CucumberOptions(publish = true) │\n" +
                "│                                                                             │\n" +
                "│ More information at https://reports.cucumber.io/docs/cucumber-jvm           │\n" +
                "│                                                                             │\n" +
                "│ To disable this message, add cucumber.publish.quiet=true to                 │\n" +
                "│ src/test/resources/cucumber.properties                                      │\n" +
                "└─────────────────────────────────────────────────────────────────────────────┘\n"));
    }

}
