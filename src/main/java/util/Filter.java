package util;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import java.io.File;
import java.util.*;

public class Filter {

    public static File[] finder(String dirName){
        File dir = new File(dirName);

        return dir.listFiles((dir1, filename) -> filename.endsWith(".vktr"));

    }

    public static String[] preProcessor(String valueList){

       if(valueList.contains("|"))
           return valueList.split("|");
       else
           return new String[]{valueList};
    }


}