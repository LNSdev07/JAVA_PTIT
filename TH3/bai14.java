

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

class MonHoc implements Comparable<MonHoc>
{
	private String maMon,
				   tenMon,
				   soTC,
				   hinhThucLT,
				   hinhThucTH;

	public MonHoc(String maMon, String tenMon, String soTC, String hinhThucLT, String hinhThucTH) 
	{
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.soTC = soTC;
		this.hinhThucLT = hinhThucLT;
		this.hinhThucTH = hinhThucTH;
	}

	public String getMaMon() 
	{
		return maMon;
	}

	public String getHinhThucTH() 
	{
		return hinhThucTH;
	}

	@Override
	public int compareTo(MonHoc o) 
	{
		if(maMon.compareTo(o.getMaMon()) >= 0)
			return 1;
		return -1;
	}
	
	@Override
	public String toString()
	{
		return maMon + " " +
			   tenMon + " " +
			   soTC + " " + 
			   hinhThucLT + " " +
			   hinhThucTH;
	}
}

public class bai14
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner sc = new Scanner(new File("MONHOC.in"));
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MonHoc> MH = new ArrayList<>(); 
		while(n-- > 0)
		{
			MH.add(new MonHoc(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		Collections.sort(MH);
		for(MonHoc i : MH)
		{
			if(!i.getHinhThucTH().equals("Truc tiep"))
				System.out.println(i);
		}
 	}
}