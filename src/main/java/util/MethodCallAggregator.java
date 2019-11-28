package util;

import com.sun.istack.Nullable;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodCallAggregator {

    private List<Method> methodList;

   public MethodCallAggregator(){
        methodList = new ArrayList<>();
    }

    public void reflectiveListInitializer(Object o, String functionName, Class... parameters){
        try {
           methodList.add(o.getClass().getMethod(functionName,parameters));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    public void invokeMethodList(Object o, @Nullable Object... objects) throws InvocationTargetException, IllegalAccessException {
        for(Method m:methodList){
            if(objects!=null)
            m.invoke(o,objects);
            else
            m.invoke(o);
        }
    }
}
