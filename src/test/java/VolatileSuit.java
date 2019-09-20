import java.util.HashMap;
import java.util.Map;

/**
 * ClassName VolatileSuit
 * Date 2019/9/6
 *
 * @author wangyi
 **/
public class VolatileSuit {

    private  Map configOptions;

    private static boolean initialized =false;

    private char[] configText;


    public static void main(String[] args) {

        VolatileSuit volatileSuit = new VolatileSuit();

        new Thread(new Runnable() {
            @Override
            public void run() {

                volatileSuit.processConfigOptions(volatileSuit.configText, volatileSuit.configOptions);

                initialized =true;
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!initialized){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("111111111111");
                    System.out.println(volatileSuit.configText.length);
                }
            }
        }).start();



    }

    private void processConfigOptions(char[] configText, Map configOptions){

        System.out.println("=========================");

        configText = new char[]{'a','b','c'};
        configOptions = new HashMap();

        configOptions.put("1",2);

        System.out.println("<<<<<<<<<<<<<<<<<");
    }




}
