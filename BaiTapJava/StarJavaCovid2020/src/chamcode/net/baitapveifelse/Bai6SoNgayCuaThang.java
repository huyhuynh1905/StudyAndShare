package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 15/05/2020
 */
public class Bai6SoNgayCuaThang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập tháng: ");
        int month = Integer.parseInt(sc.nextLine());
        if (month==1|month==3|month==5|month==7|month==8|month==10|month==12){
            System.out.println("Tháng "+month+" có 31 ngày!");
        } else if (month==2|month==4|month==6|month==9|month==11){
            //Cho tháng 2 có 30 ngày luôn
            System.out.println("Tháng "+month+" có 30 ngày");
        } else {
            System.out.println("Bạn nhập sai tháng!");
        }
    }
}
