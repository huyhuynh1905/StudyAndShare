package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai6ChuViDienTichHCN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 2 cạnh: ");
        int dai = Integer.parseInt(sc.nextLine());
        int rong = Integer.parseInt(sc.nextLine());

        System.out.println("Chu vi hình chữ nhật là: "+(dai+rong)*2);
        System.out.println("Diện tích hcn là: "+dai*rong);
    }
}
