package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 14/05/2020
 */
public class Bai1Max2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số a:");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số b:");
        int b = Integer.parseInt(sc.nextLine());
        if (a>b){
            System.out.println("A lớn hơn B.");
        } else if (b>a){
            System.out.println("B lớn hơn A.");
        } else {
            System.out.println("2 Số bằng nhau!");
        }
        //Cách không dùng if else :)))
        System.out.println("Max bằng Math.max: "+Math.max(a,b));
    }
}
