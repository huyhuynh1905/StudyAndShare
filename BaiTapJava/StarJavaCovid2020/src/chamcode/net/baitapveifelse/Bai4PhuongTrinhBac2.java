package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 14/05/2020
 */
public class Bai4PhuongTrinhBac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập các tham số a,b,c của ptr:");
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        double delta = b*b-4*a*c;
        if (a==0&&b==0&&c==0){
            System.out.println("VSN");
        } else if (delta<0){
            System.out.println("VN");
        } else if (delta==0){
            double x = -b/2*a;
            System.out.println("Nghiệm kép: "+x);
        } else {
            double x1 = (-b-Math.sqrt(delta))/(2*a);
            double x2 = (-b+Math.sqrt(delta))/(2*a);
            System.out.println("Nghiệm x1: "+x1);
            System.out.println("Nghiệm x2: "+x2);
        }
    }
}
