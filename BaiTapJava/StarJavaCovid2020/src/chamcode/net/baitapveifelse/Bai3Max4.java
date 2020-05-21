package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 14/05/2020
 */
public class Bai3Max4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 4 số liên tiếp:");
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        int d = Integer.parseInt(sc.nextLine());
        if (a>b&&a>c&&a>d){
            System.out.println("Max là "+a);
        } else if (b>a&&b>c&&b>d){
            System.out.println("Max là "+b);
        } else if (c>a&&c>b&&c>d){
            System.out.println("Max là "+c);
        } else if (d>a&&d>b&&d>c){
            System.out.println("Max là "+d);
        }

        //Cách khác không dùng if else
        System.out.println("Max bằng hàm max: "+Math.max(Math.max(a,b),Math.max(c,d)));
    }
}
