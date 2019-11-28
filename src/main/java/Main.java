import org.testng.TestNG;
import org.testng.collections.Lists;
import util.ListenerNG;

import java.util.List;

public class Main {

    public static void main(String... args){
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("C:\\Users\\ideig\\IdeaProjects\\daappium\\WebAppSuite");
        testng.addListener(new ListenerNG());
        testng.setTestSuites(suites);
        testng.run();
    }
}
