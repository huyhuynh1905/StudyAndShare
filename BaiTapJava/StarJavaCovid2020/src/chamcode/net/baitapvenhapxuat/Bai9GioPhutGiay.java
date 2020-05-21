package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai9GioPhutGiay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào giây phút giờ: ");
        int second = Integer.parseInt(sc.nextLine());
        int minute = Integer.parseInt(sc.nextLine());
        int hour = Integer.parseInt(sc.nextLine());
        System.out.println(hour+":"+minute+":"+second);

    }
}
