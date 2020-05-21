package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 14/05/2020
 */
public class Bai5TamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 3 cạnh tam giác: ");
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        if (!(a+b>c&&b+c>a&&a+c>b)){
            System.out.println("NO");
        } else {
            double p = (a+b+c)/2;
            double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            System.out.println("Chu vi: "+p);
            System.out.println("Diện tích: "+s);
        }
    }
}
