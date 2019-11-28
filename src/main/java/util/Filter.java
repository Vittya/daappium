package util;

import java.io.File;

public class Filter {

    public static File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles((dir1, filename) -> filename.endsWith(".vktr"));

    }

}