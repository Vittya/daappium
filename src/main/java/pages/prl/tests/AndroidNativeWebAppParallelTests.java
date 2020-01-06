package pages.prl.tests;

import annot.DrukkaStudio;
import interpreter.parser.ScannerByLine;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.prl.scrn.webdroid.SimplePage;
import util.Filter;
import util.MethodCallAggregator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;


public class AndroidNativeWebAppParallelTests {

    private final static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";

    private AndroidDriver<MobileElement> driver;
    private ScannerByLine scn;
    private MethodCallAggregator methodCallAggregator;

    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "chromeDriverPort", "chromeDriverPath"})
    public void setup(String platform, String udid, String chromeDriverPort, @Optional String chromeDriverPath) throws Exception {
        URL url = new URL(APPIUM_SERVER_URL);

        String[] platformInfo = platform.split(" ");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);


        capabilities.setCapability("chromeDriverPort", chromeDriverPort);

        if (chromeDriverPath != null) {
            capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("w3c",false);
            capabilities.setCapability(AndroidMobileCapabilityType.CHROME_OPTIONS,options);
        }

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);



        driver = new AndroidDriver<MobileElement>(url, capabilities);
        scn = new ScannerByLine(Filter.finder("C:\\Users\\ideig\\Documents")[0]);
        methodCallAggregator = new MethodCallAggregator();
    }
    @DrukkaStudio(canGoToJira = false)
    @Test
    public void testFindOwner() throws InvocationTargetException, IllegalAccessException, IOException, InterruptedException, NoSuchMethodException {

            SimplePage page = new SimplePage(driver);


       /* scn.processLineByLine().forEach((k,v)->{
            try {
                methodCallAggregator.reflectiveListInitializer(page, k, v);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
*/
       String story = "De hogy mindennap eljön! Na nem, azt már mégsem! Hogy felidézze minden: egy ferde tekintet, egy régi tárgy, egy poros fénykép, a szélfújta levelek, az eső, az eldübörgő vonatok zaja. " +
               "Na nem! Alig merek már kinézni az ablakon. Ott szokott előbukkanni a Szomorúság, a faluvégi dombhát mögül." +
               " Hű, komor ám, sötétbarna! Lép egyet, s már a Ráday-kastély tetején van, még egyet, s már itt áll a vasúti kocsma udvarán; s mi neki onnan az én ablakom! Semmi. Már kopog. \"Dehogy eresztlek - gondolom -, dehogy!\" Törődik is vele! " +
               "Átszivárog az ablaküvegen, betelepszik a szobámba. A fekete feketébb lesz tőle, a barna barnább, a pirosok kialusznak, elszürkülnek a sárgák, megfakulnak a kékek, a zöldek, mint a hamu. " +
               "Reménykedem mindig, hogy nem hozzám jön. Annyian laknak errefelé... És már kopog is, kopp... kopp";

       page.goToUrl("https://drukkadigitals.com/")
               .clickIt("/html/body/div[1]/div/div[1]/div[2]/section/div[1]/div[1]/div/div/div/div/button")
               .typeText("unom@bana.nt","/html/body/div[3]/div/div[1]/div/div/div/div[2]/form/fieldset/div[1]/input")
                .typeText("Iqbal Jumu'ah","/html/body/div[3]/div/div[1]/div/div/div/div[2]/form/fieldset/div[2]/input")
                    .typeText("Al Kassab","/html/body/div[3]/div/div[1]/div/div/div/div[2]/form/fieldset/div[3]/input")
                        .typeText("06301234567","/html/body/div[3]/div/div[1]/div/div/div/div[2]/form/fieldset/div[4]/input")
       .clickIt("/html/body/div[3]/div/div[1]/div/div/div/div[2]/form/fieldset/div[7]/div/div/label")
       .typeText(story,"/html/body/div[3]/div/div[1]/div/div/div/div[2]/form/fieldset/div[6]/textarea")
       .clickIt("/html/body/div[3]/div/div[1]/div/div/div/div[2]/form/fieldset/div[8]/button");

        for (LogEntry entry : driver.manage().logs().get("browser")) {

            if(entry.getLevel().toString().equals("WARNING")||entry.getLevel().toString().equals("ERROR"))
                for(String s:entry.getMessage().split("\""))
            System.out.println(s);
        }







/*


        ScannerByLine scn = new ScannerByLine(Filter.finder("C:\\Users\\ideig\\Documents")[0]);
        Context ctx = new Context();
        ctx.fillUp(scn.processLineByLine());
        Expression q = new Select("name",new From("people"));
        Expression q1 = new Select("surname", new From("people"));

      for(int i=0;i<q.interpret(ctx).size();i++) {




          methodCallAggregator.reflectiveListInitializer(page.toPage(), q.interpret(ctx).get(i));
          methodCallAggregator.invokeMethodList(page, q1.interpret(ctx).get(i));


    }
        driver.manage().logs().getAvailableLogTypes();
        System.out.println(driver.manage().logs().get("logcat"));

        final String message = "Trockij híressé vált páncélvonatán beutazta a frontokat; 1919. október 2-án Szentpétervár védelmében jelentős érdemei voltak, de ugyanúgy szerepe volt Kolcsak és Vrangel csapatainak szétverésében. Szabad óráiban Terrorizmus és kommunizmus című híres Karl Kautsky elleni vitairatát írta a vonaton. 1920 nyarán aktívan részt vett a lengyelországi hadjárat megszervezésében. A polgárháború vége felé közeledve Trockijt egyre inkább a belső gazdasági problémák megoldása foglalkoztatta.";
//for(int i=0;i<100;i++) {
    page.goToUrl("http://192.168.1.76:8080/")
            .clickIt("//*[@id=\"app\"]/div/div/div/div[1]/div/div[1]/div[1]/div/div[2]/li[3]")
            .clickIt("//*[@id=\"price-container\"]/div/div[2]/div[3]/div[2]/div/button")
            .typeText("Korpás János|//*[@id=\"contactForm\"]/div[1]/div/input")
            .typeText("johnny@korpas.hu|//*[@id=\"contactForm\"]/div[2]/div/input")
            .typeText(message + "|//*[@id=\"contactForm\"]/div[3]/textarea")
            .clickIt("//*[@id=\"contactForm\"]/div[4]/div[2]/button");
*/


//}
/*

for (int i = 0; i < 1000; i++) {

                page.goToUrl("https://app.echosafe.eu/")
                ;
                .clickIt(By.xpath("//*[@id=\"home-index\"]/div[1]/div[1]/div/div/div/div/button"))
                .typeText("aurel.bumsfeld@blinkenlights.nl",By.xpath("//*[@id=\"email\"]"))
                .typeText("Aurél",By.xpath("//*[@id=\"firstname\"]"))
                .typeText("Bumsfeld",By.xpath("//*[@id=\"lastname\"]"))
                .typeText("0036205326666", By.xpath("//*[@id=\"phone\"]"))
                .clickIt(By.xpath("//*[@id=\"fromWhere\"]/div[1]/label"))
                .typeText("****TESzT****",By.xpath("//*[@id=\"notes\"]"))
                .clickIt(By.xpath("//*[@id=\"ContactUsFormForm\"]/fieldset/div[7]/div/div/label"))
                ;//.clickIt(By.xpath("//*[@id=\"ContactUsFormForm\"]/fieldset/div[8]/button"));

 */




    }

    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }


}

