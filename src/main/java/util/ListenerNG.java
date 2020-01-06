package util;

import annot.DrukkaStudio;
import org.testng.*;

public class ListenerNG implements ISuiteListener, ITestListener {

    private String[] resultCodes = new String[]{"Uncaught Error","Pass","Fail","Skip"};
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite START: "+suite.getOutputDirectory());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite ["+suite.getName()+" IDE JÖN A TESZT ID] FINISHED: \n======================\n");

        for (IInvokedMethod invokedMethod : suite.getAllInvokedMethods())
            System.out.println("|"+invokedMethod.getTestMethod().getMethodName()+": "+resultCodes[invokedMethod.getTestResult().getStatus()]);

    }

    @Override
    public void onTestFailure(ITestResult result){
        DrukkaStudio drukka = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(DrukkaStudio.class);
        if(drukka.canGoToJira())
            System.out.println("prod");
    }
}
