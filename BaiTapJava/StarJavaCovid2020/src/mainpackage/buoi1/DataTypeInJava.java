package mainpackage.buoi1;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 21/03/2020
 */
public class DataTypeInJava {
    public static void main(String[] args) {
        /*Kiểu dữ liệu nguyên thủy: Byte, short, integer, float, double, long, char*/
        //Kiểu số nguyên phổ biến:
        int intVar = 10; //Giá trị (32bit - 4byte): -2^31 > 2^31-1.
        byte byteVar = 12; //Giá trị (8bit - 1 byte): -2^7 > 2^7-1.
        //Kiểu số có dấu chấm động:
        float floatVar = 135.5f; //Giá trị 32bit - 4byte.
        double doubleVar = 124.7d; //Giá trị 64bit - 8byte;

        System.out.println("intVar: "+intVar);
        System.out.println("byteVar: "+byteVar);
        System.out.println("floatVar: "+floatVar);
        System.out.println("doubleVar: "+doubleVar);
        //Các phép tính
        int intResult = intVar/3;
        float floatResult = floatVar/3;

        System.out.println("intResult: "+intResult);
        //Ép kiểu:
        float divResult = (float) intVar/3;
        System.out.println("divResult: "+divResult);
    }
}
