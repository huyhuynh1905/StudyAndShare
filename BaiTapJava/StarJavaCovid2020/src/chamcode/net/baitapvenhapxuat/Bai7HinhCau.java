package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai7HinhCau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào bán kính hình cầu: ");
        double r = Double.parseDouble(sc.nextLine());
        double s = 4*Math.PI*(r*r);
        double v = (Math.PI*(r*r*r)*4)/3;
        System.out.println("Diện tích: "+s);
        System.out.println("Thể tích: "+v);
    }
}
