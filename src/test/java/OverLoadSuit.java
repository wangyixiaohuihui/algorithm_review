import java.io.Serializable;

/**
 * ClassName OverLoadSuit
 * Date 2019/9/5
 *
 * @author wangyi
 **/
public class OverLoadSuit {


//    public static  void sayHello(Object o){
//
//        System.out.println("object");
//    }
//    public static  void sayHello(int o){
//
//        System.out.println("int");
//    }


    public static  void sayHello(Long o){

        System.out.println("Long");
    }


//    public static  void sayHello(long o){
//
//        System.out.println("long");
//    }

//    public static  void sayHello(char o){
//
//        System.out.println("char");
//    }

//    public static  void sayHello(Character o){
//
//        System.out.println("Character");
//    }

//    public static  void sayHello(char ...args){
//
//        System.out.println("....args");
//    }

    public static  void sayHello(Serializable arg){

        System.out.println("Serializable");
    }


    public static void main(String[] args) {

        sayHello('a');
    }
}
