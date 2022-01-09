package pracazaliczeniowa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/Zadanie-Zaliczeniowe_2.feature",
        plugin = {"pretty","html:out"})

public class zaliczenie_2test {
}
