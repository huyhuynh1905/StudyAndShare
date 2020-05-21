package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 15/05/2020
 */
public class Bai7CuocDienThoai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập số phút gọi: ");
        int minute = Integer.parseInt(sc.nextLine());
        int priceDefault = 25000;
        if (minute<=50){
            System.out.println("Giá cước thanh toán: "+ (priceDefault+600*minute));
        } else if (minute<=200){
            System.out.println("Giá cước thanh toán: "+ (priceDefault+400*minute));
        } else {
            System.out.println("Giá cước thanh toán: "+(priceDefault+200*minute));
        }
    }
}
