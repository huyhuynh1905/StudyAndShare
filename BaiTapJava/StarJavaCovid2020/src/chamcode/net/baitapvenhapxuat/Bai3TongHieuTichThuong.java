package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai3TongHieuTichThuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào giá trị a và b:");
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("In ra tổng hiệu tích thương:");
        System.out.printf("%d %d",a+b,a-b);
        System.out.printf("\n%d %f",a*b,(float)a/b);
    }
}
