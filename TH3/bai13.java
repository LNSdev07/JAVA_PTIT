

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang>
{
	private String maKH,
				   tenKH,
				   gioiTinh,
				   diaChi,
				   ngaySinh;
	
	private Date d;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static int soLuongKH = 1;
	
	public KhachHang(String tenKH, String gioiTinh,String ngaySinh, String diaChi) throws ParseException 
	{
		this.maKH = String.format("KH%03d", soLuongKH++);
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		
		d = sdf.parse(ngaySinh);
		this.ngaySinh = sdf.format(d);
		chuanHoaTen();
	}
	
	private void chuanHoaTen()
	{
		String arr[] = tenKH.trim().split("\\s+");
		tenKH = "";
		for(String i:arr)
		{
			tenKH += (i.charAt(0) + "").toUpperCase() + i.substring(1).toLowerCase() + " ";
		}
		tenKH = tenKH.trim();
	}

	@Override
	public int compareTo(KhachHang o) 
	{
		return d.compareTo(o.d);
	}
	
	@Override
	public String toString()
	{
		return maKH + " " +
			   tenKH + " " +
			   gioiTinh + " " +
			   diaChi + " " +
			   ngaySinh;
	}
}

public class bai13
{
//	private static void ghiDuLieuXuongFile() throws IOException
//	{
//		OutputStream os = new FileOutputStream("D:\\Learning\\jav\\123\\src\\test\\DATA2.in");
//		ObjectOutputStream oos = new ObjectOutputStream(os);
//		ArrayList<Integer> arr = new ArrayList<>();
//		for(int i = 1001; i <= 10000 ; i++)
//		{
//			arr.add(i);
//		}
//		oos.writeObject(arr);
//		oos.flush();
//	}
	
	public static void main(String[] args) throws FileNotFoundException, ParseException
	{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> KH = new ArrayList<>();
        while(n-- > 0)
        {
        	KH.add(new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(KH);
        for(KhachHang i: KH)
        	System.out.println(i);
    }
}