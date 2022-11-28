

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MonHoc
{
	private String maMon,
				   tenMon,
				   soTC;
	
	public MonHoc(String maMon, String tenMon, String soTC) 
	{
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.soTC = soTC;
	}

	public String getMaMon() 
	{
		return maMon;
	}

	public void setMaMon(String maMon) 
	{
		this.maMon = maMon;
	}

	public String getTenMon() 
	{
		return tenMon;
	}

	public void setTenMon(String tenMon) 
	{
		this.tenMon = tenMon;
	}

	public String getSoTC() 
	{
		return soTC;
	}

	public void setSoTC(String soTC) 
	{
		this.soTC = soTC;
	}
}

class LichGD implements Comparable<LichGD>
{
	private String maNhom,
				   maMon,
				   ngayGiangDay,
				   hoTenGV,
				   phongHoc;
	
	private int kipHoc;

	private static int soLuongLH = 1;
	
	public LichGD(String maMon, String ngayGiangDay, String kipHoc, String hoTenGV, String phongHoc) 
	{
		this.maNhom = String.format("HP%03d", soLuongLH++);
		this.maMon = maMon;
		this.ngayGiangDay = ngayGiangDay;
		this.kipHoc = Integer.parseInt(kipHoc);
		this.hoTenGV = hoTenGV;
		this.phongHoc = phongHoc;
	}
	
	public String getMaMon() 
	{
		return maMon;
	}

	@Override
	public int compareTo(LichGD o) 
	{
		if(ngayGiangDay.compareTo(o.ngayGiangDay) > 0)
			return 1;
		else if(ngayGiangDay.compareTo(o.ngayGiangDay) == 0)
		{
			if(kipHoc > o.kipHoc)
				return 1;
			else if(kipHoc == o.kipHoc)
				return hoTenGV.compareTo(o.hoTenGV);
			return -1;
		}
		else 
		{
			return -1;
		}
	}
	
	@Override
	public String toString()
	{
		return maNhom + " " +
			   ngayGiangDay + " " +
			   kipHoc + " " +
			   hoTenGV + " " +
			   phongHoc;
	}
}

public class bai9
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
	
	public static void main(String[] args) throws FileNotFoundException
	{
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<MonHoc> MH = new ArrayList<>();
        while(n-- > 0)
        {
        	MH.add(new MonHoc(sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
        }
        sc1.close();
        
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        int a = Integer.parseInt(sc2.nextLine());
        ArrayList<LichGD> LH = new ArrayList<>(); 
        while(a-- > 0)
        {
        	LH.add(new LichGD(sc2.nextLine(), sc2.nextLine(), sc2.nextLine(), sc2.nextLine(), sc2.nextLine()));
        }
        Collections.sort(LH);
        String temp = sc2.nextLine();
        for(MonHoc i :MH)
        {
        	if(temp.equals(i.getMaMon()))
        	{
        		System.out.println("LICH GIANG DAY MON " + i.getTenMon() + ":" );
        	}
        }
        for(LichGD i : LH)
        {
        	if(i.getMaMon().equals(temp))
        		System.out.println(i);
        }
    }
}