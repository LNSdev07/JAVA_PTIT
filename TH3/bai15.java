import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class DanhSachLuuTru implements Comparable<DanhSachLuuTru>
{
	private String hoTen,
			       maPhong,
			       ngayDen,
			       ngayDi;
	
	private int maSV;
	
	private long ngayO;
	
	private static int soLuongKH = 1	;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 	
	public DanhSachLuuTru(String hoTen, String maPhong, String ngayDen, String ngayDi) throws ParseException 
	{
		this.maSV = soLuongKH++;
		this.hoTen = hoTen;
		this.maPhong = maPhong;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
		
		Date d1 = sdf.parse(ngayDen),
			 d2 = sdf.parse(ngayDi);
		
		ngayO = (d2.getTime() - d1.getTime()) / (24 * 3600 * 1000);
	}
	
	public long getNgayO() 
	{
		return ngayO;
	}

	@Override
	public int compareTo(DanhSachLuuTru o) 
	{
		if(ngayO <= o.getNgayO())
			return 1;
		return -1;
	}
	
	@Override
	public String toString()
	{
		return String.format("KH%02d", maSV) + " " +
			   hoTen + " " +
			   maPhong + " " +
			   ngayO;
	}
}

public class bai15
{

	public static void main(String[] args) throws IOException, ParseException
	{
		Scanner sc = new Scanner(new File("KHACH.in"));
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<DanhSachLuuTru> DS = new ArrayList<>();
		while(n-- > 0)
		{
			DS.add(new DanhSachLuuTru( sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine() ) );
		}
		Collections.sort(DS);
		for(DanhSachLuuTru i : DS)
			System.out.println(i);
    }

}