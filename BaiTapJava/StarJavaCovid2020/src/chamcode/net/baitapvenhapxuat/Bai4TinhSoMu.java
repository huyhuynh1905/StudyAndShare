package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai4TinhSoMu {
    public static void main(String[] args) {
        //Đề vài chỉ yêu cầu tính số mũ 2,3,4
        Scanner sc = new Scanner(System.in);
        int a = 0;
        do {
            System.out.println("Nhập số a < 100:");
            a = Integer.parseInt(sc.nextLine());
        } while (a>100);

        int a2 = a*a;
        int a3 = a*a*a;
        int a4 = a*a*a*a;
        System.out.println("Số mũ 2 > 3 > 4: "+a2+" "+a3+" "+a4);


    }
}
