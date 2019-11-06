package util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AndroidUtils {
    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final HashMap<Character,AndroidKey> keyHashMap = new HashMap<Character, AndroidKey>(){{
        put('a',AndroidKey.A);
        put('b',AndroidKey.B);
        put('c',AndroidKey.C);
        put('d',AndroidKey.D);
        put('e',AndroidKey.E);
        put('f',AndroidKey.F);
        put('g',AndroidKey.G);
        put('h',AndroidKey.H);
        put('i',AndroidKey.I);
        put('j',AndroidKey.J);
        put('k',AndroidKey.K);
        put('l',AndroidKey.L);
        put('m',AndroidKey.M);
        put('n',AndroidKey.N);
        put('o',AndroidKey.O);
        put('p',AndroidKey.P);
        put('q',AndroidKey.Q);
        put('r',AndroidKey.R);
        put('s',AndroidKey.S);
        put('t',AndroidKey.T);
        put('u',AndroidKey.U);
        put('v',AndroidKey.V);
        put('w',AndroidKey.W);
        put('x',AndroidKey.X);
        put('y',AndroidKey.Y);
        put('z',AndroidKey.Z);
        put('.',AndroidKey.PERIOD);
        put('@',AndroidKey.AT);
        put('1',AndroidKey.DIGIT_1);
        put('2',AndroidKey.DIGIT_2);
        put('3',AndroidKey.DIGIT_3);
        put('|',AndroidKey.CAPS_LOCK);

    }};
    private static AndroidKey[] alphabetKeys = {
            AndroidKey.A,
            AndroidKey.B,
            AndroidKey.C,
            AndroidKey.D,
            AndroidKey.E,
            AndroidKey.F,
            AndroidKey.G,
            AndroidKey.H,
            AndroidKey.I,
            AndroidKey.J,
            AndroidKey.K,
            AndroidKey.L,
            AndroidKey.M,
            AndroidKey.N,
            AndroidKey.O,
            AndroidKey.P,
            AndroidKey.Q,
            AndroidKey.R,
            AndroidKey.S,
            AndroidKey.T,
            AndroidKey.U,
            AndroidKey.V,
            AndroidKey.W,
            AndroidKey.X,
            AndroidKey.Y,
            AndroidKey.Z
    };

    private static AndroidKey[] emailKeys = {
            AndroidKey.AT,
            AndroidKey.NUMPAD_DOT
    };

    public static AndroidKey resolveKeys(char c){
       return alphabetKeys[Arrays.asList(alphabet).indexOf(c)];
    }


    public static void outputIfMatchPassOrFail(String expectedValue, String actualValue){
        String result;
        if (expectedValue.trim().contains(actualValue.trim())){
            result = "(PASS)";
        } else {
            result = "(FAIL)";
        }

        System.out.println("ÉRTÉKEK:\n----------------------");
        System.out.println("\t* VÁRT: " + expectedValue);
        System.out.println("\t* KAPOTT: " + actualValue);
        System.out.println("===> " + result+"\n----------------------");
    }

    public static void commandEvaluator(AndroidDriver<MobileElement> driver,String code){
        char[] chars = code.toCharArray();
        for(char c:chars){
            driver.pressKey(new KeyEvent(keyHashMap.get(c)));
        }

    }

    public static AndroidKey getEmailKey(int i){
        return emailKeys[i];
    }
}
