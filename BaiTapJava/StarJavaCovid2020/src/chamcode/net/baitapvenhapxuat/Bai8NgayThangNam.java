package chamcode.net.baitapvenhapxuat;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 12/05/2020
 */
public class Bai8NgayThangNam {
    public static void main(String[] args) {
        //Bài này nhập vào 3 só rồi xuất ra định dạng ngày tháng năm
        //Ở mức cơ bản thì chỉ là nối chuỗi
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ngày tháng năm: ");
        int date = Integer.parseInt(sc.nextLine());
        int month = Integer.parseInt(sc.nextLine());
        int year = Integer.parseInt(sc.nextLine());

        System.out.println(date+"/"+month+"/"+year);

    }
}
