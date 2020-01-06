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

    public void reflectiveListInitializer(Object o, String functionName, @Nullable String params) throws InvocationTargetException, IllegalAccessException {

        try {

            Method m = o.getClass().getMethod(functionName,String.class);
            invokeMethodList(m,o,params);

            System.out.println("reflected");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



    }


   /* private void invokeMethodList(Object o, @Nullable Object... objects) throws InvocationTargetException, IllegalAccessException {
        for(Method m:methodList){
            if(objects!=null)
            m.invoke(o,objects[(methodList.indexOf(m))]);
            else
            m.invoke(o);
            System.out.println("invoked "+m.toString());
        }
    }
*/

    private void invokeMethodList(Method m,Object o, @Nullable Object... objects) throws InvocationTargetException, IllegalAccessException {

            if(objects!=null)
                m.invoke(o,objects);
            else
                m.invoke(o);

            System.out.println("invoked "+m.toString());

    }

    public void dispose(){
       methodList.clear();
    }
}
