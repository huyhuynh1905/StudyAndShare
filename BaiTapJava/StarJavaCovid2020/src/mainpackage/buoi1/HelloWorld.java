package mainpackage.buoi1;

/**
 * @author HuyHuynh on 21/03/2020
 * @project StarJavaCovid2020
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");
        /* Biến trong java có 3 loại:
        * Biến cục bộ - biến local.
        * Biến toàn cục - biến instant.
        * Biến tĩnh - biến static*/

        //Biến cục bộ:
        int localVar = 5;

        System.out.println("localVar: "+localVar);
        System.out.println("staticVar: "+staticVar);

        new HelloWorld().showVariable();

    }
    //Biến instant - không dùng được trong các method có static:
    private int instantVar = 15;
    //Biến static - biến được khởi tạo ngay khi chương trình được thực thi:
    static int staticVar = 10;
    private void showVariable(){
        System.out.println("instantVar: "+instantVar);
        System.out.println("staticVar in show method: "+staticVar);
    }
}
