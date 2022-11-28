package bai1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class CongNhan{
    private String id;
    private String ten;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String maSoThue;
    private String ngayKi;

    public CongNhan(int id, String ten, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKi) {
        this.id = chuanHoa(id);
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKi = ngayKi;
    }

    public String chuanHoa(int id){
        String s = String.valueOf(id);
        while(s.length() <5){
            s = "0"+s;
        }
        return s;
    }

    @Override
    public String toString() {
        return this.id +" "+ this.ten +" "+ this.gioiTinh +" "+
                this.ngaySinh+ " "+ this.diaChi+ " "+ this.maSoThue +" "+ this.ngayKi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
}

public class Main {
    public static void main(String[] args) {
        List<CongNhan> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=1; i<= n; i++){
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            String maSoThue = sc.nextLine();
            String ngayKi = sc.nextLine();

            CongNhan congNhan = new CongNhan(i, ten, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKi);
            list.add(congNhan);
        }

        Collections.sort(list, new Comparator<CongNhan>() {
            @Override
            public int compare(CongNhan o1, CongNhan o2) {
                SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

                try {
                    Date d1 = format.parse(o1.getNgaySinh());
                    Date d2 = format.parse(o2.getNgaySinh());
                    if(d1.compareTo(d2) <=0) return -1;
                    else return 1;

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        for(CongNhan x : list){
            System.out.println(x.toString());
        }
    }
}
