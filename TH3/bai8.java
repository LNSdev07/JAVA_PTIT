

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MonHoc implements Comparable<MonHoc>
{
	private String maMH,
		    	   tenMH,
		    	   soTC;

	public MonHoc(String maMH, String tenMH, String soTC) 
	{
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTC = soTC;
	}
	
	public String getTenMH() 
	{
		return tenMH;
	}

	@Override
	public String toString()
	{
		return maMH + " " + tenMH + " " + soTC;
	}

	@Override
	public int compareTo(MonHoc o) 
	{
		if(tenMH.compareTo(o.getTenMH()) >=0 )
			return 1;
		return -1;
	}
}

public class bai8
{


	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new File("MONHOC.in"));
		int n = Integer.parseInt(scanner.nextLine());
		ArrayList<MonHoc> MH = new ArrayList<>();
		while(n-- > 0)
		{
			MH.add(new MonHoc(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
		}
		Collections.sort(MH);
		for(MonHoc i : MH)
			System.out.println(i);
    }

}