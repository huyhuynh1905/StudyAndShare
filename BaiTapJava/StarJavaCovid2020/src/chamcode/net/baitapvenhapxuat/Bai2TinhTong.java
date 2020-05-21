package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai2TinhTong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số a:");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số b:");
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("Tổng hai số là: "+(a+b));
    }
}
