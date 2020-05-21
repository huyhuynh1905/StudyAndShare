package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai5TongHaiSoNangCao {
    public static void main(String[] args) {
        //Tương tự bài 2 nhưng là số lớn>>>Kiểu long
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập số a: ");
        long a = Long.parseLong(sc.nextLine());
        System.out.println("Nhập số b: ");
        long b = Long.parseLong(sc.nextLine());
        System.out.println("Tổng hai số: "+(a+b));
    }
}
