package util;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ListenerNG implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite START: "+suite.getOutputDirectory());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite FINISH: "+suite.getAllInvokedMethods());
    }
}
