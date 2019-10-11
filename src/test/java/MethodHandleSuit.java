import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;


/**
 * ClassName MethodHandleSuit
 * Date 2019/9/5
 *
 * @author wangyi
 **/
public class MethodHandleSuit {

    static class ClassA{
        public void println(String s){
            System.out.println("s"+s);
        }
    }
    public void bar(Object o) {
    }

    private static MethodHandle getPrintlnMn(Object reveiver) throws Throwable{

        MethodType mt = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(reveiver.getClass(), "println",mt).bindTo(reveiver);

    }



    public static void main(String[] args) throws Exception{
//        Object obj = System.currentTimeMillis() %2 ==0? System.out: new ClassA();


        String jsonStr = "{\"jsonrpc\": \"2.0\",\"method\":\"\\xFFa2spamDanmuPredict\",\"id\":1}";



        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = l.findVirtual(MethodHandleSuit.class, "bar", t);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            try {
                mh.invokeExact(new MethodHandleSuit(), new Object());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }


    }
}
