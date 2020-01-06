import interpreter.core.Context;
import interpreter.core.Expression;
import interpreter.core.From;
import interpreter.core.Select;
import interpreter.parser.ScannerByLine;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.TestNG;
import org.testng.collections.Lists;
import util.Filter;
import util.ListenerNG;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {



    public void startServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"",null, new File("C:\\Users\\ideig"));
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String... args) throws IOException {
      /*



*/
        //System.out.println(list);

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("C:\\Users\\ideig\\IdeaProjects\\daappium\\WebAppSuite");
        testng.addListener(new ListenerNG());
        testng.setTestSuites(suites);
        testng.run();



    }
}
