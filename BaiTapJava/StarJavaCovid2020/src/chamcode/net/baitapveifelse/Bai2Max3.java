package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 14/05/2020
 */
public class Bai2Max3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lần lượt 3 số:");
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        if (a>b&&a>c){
            System.out.println("Max là "+a);
        } else if (b>a&&b>c){
            System.out.println("Max là "+b);
        } else if (c>a&&c>b){
            System.out.println("Max là "+c);
        } else {
            System.out.println("Có các giá trị bằng nhau cùng lớn nhất!");
        }

        //Cách khác không if else
        System.out.println("Max bằng hàm max: "+Math.max(Math.max(a,b),c));
    }
}
