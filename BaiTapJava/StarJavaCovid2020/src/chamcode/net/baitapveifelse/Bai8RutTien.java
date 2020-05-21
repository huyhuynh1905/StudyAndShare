package chamcode.net.baitapveifelse;

import java.util.Scanner;

/**
 * @project: StarJavaCovid2020
 * @author: HuyHuynh on 15/05/2020
 */
public class Bai8RutTien {
    private static final int NAMTRAM = 500000;
    private static final int HAITRAM = 200000;
    private static final int MOTTRAM = 100000;
    private static final int NAMCHUC = 50000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tienRut;
        do {
            System.out.println("Nhập số tiền cần rút(bội số 50k): ");
            tienRut = Integer.parseInt(sc.nextLine());
        } while (tienRut%NAMCHUC!=0);
        int soTien500K = tienRut/NAMTRAM;
        int soTien200K = (tienRut-(soTien500K*NAMTRAM))/HAITRAM;
        int soTien100K = (tienRut-soTien500K*NAMTRAM-soTien200K*HAITRAM)/MOTTRAM;
        int soTien50K = (tienRut-soTien500K*NAMTRAM-soTien200K*HAITRAM-soTien100K*MOTTRAM)/NAMCHUC;
        System.out.println("Danh sách số tờ tiền:");
        System.out.println("- Số tờ 500K: "+soTien500K);
        System.out.println("- Số tờ 200K: "+soTien200K);
        System.out.println("- Số tờ 100K: "+soTien100K);
        System.out.println("- Số tờ 50K: "+soTien50K);
    }
}
