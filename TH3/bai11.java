import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien
{
	private String maSV,
				   hoTen,
				   soDT;

	public SinhVien(String maSV, String hoTen, String soDT) 
	{
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.soDT = soDT;
	}

	public String getMaSV() 
	{
		return maSV;
	}

	public String getHoTen() 
	{
		return hoTen;
	}

	public String getSoDT() 
	{
		return soDT;
	}
}

class BaiTap
{
	private String tenBT;
	
	private int soTT;
	
	private static int soLuongBT = 1;

	public BaiTap(String tenBT) 
	{
		this.soTT = soLuongBT++;
		this.tenBT = tenBT;
	}

	public String getTenBT() 
	{
		return tenBT;
	}

	public int getSoTT() 
	{
		return soTT;
	}
	
}

class Nhom implements Comparable<Nhom>
{
	private String maSV,
				   hoTen,
				   soDT,
				   tenBT;
	
	private int soTT;

	public Nhom(String maSV, int soTT) 
	{
		this.maSV = maSV;
		this.soTT = soTT;
	}

    public int getSoTT()
    {
        return soTT;
    }

    public String getMaSV()
    {
        return maSV;
    }

	public void setHoTen(String hoTen) 
	{
		this.hoTen = hoTen;
	}

	public void setSoDT(String soDT) 
	{
		this.soDT = soDT;
	}

	public void setTenBT(String tenBT) 
	{
		this.tenBT = tenBT;
	}

	@Override
	public int compareTo(Nhom o) 
	{
		return maSV.compareTo(o.maSV);
	}
	
	@Override
	public String toString()
	{
		return maSV + " " +
			   hoTen + " " +
			   soDT + " " +
			   soTT + " " + 
			   tenBT;
	}
}

public class bai11
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int a = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> SV = new ArrayList<>();
        while(a-- > 0)
        {
            SV.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }

        sc = new Scanner(new File("BAITAP.in"));
        int  b = Integer.parseInt(sc.nextLine());
        ArrayList<BaiTap> BT = new ArrayList<>();
        while(b-- > 0)
        {
            BT.add(new BaiTap(sc.nextLine()));
        }

        sc = new Scanner(new File("NHOM.in"));
        ArrayList<Nhom> N = new ArrayList<>();
        while(sc.hasNext())
        {
            Nhom temp = new Nhom(sc.next(), sc.nextInt());
            for(SinhVien i: SV)
            {
                if(i.getMaSV().equals(temp.getMaSV()))
                {
                    temp.setHoTen(i.getHoTen());
                    temp.setSoDT(i.getSoDT());
                    break;
                }
            }

            for(BaiTap i: BT)
            {
                if(i.getSoTT() == temp.getSoTT())
                {
                    temp.setTenBT(i.getTenBT());
					break;
                }
            }

            N.add(temp);
        }
        Collections.sort(N);
        for(Nhom i: N)
        {
        	System.out.println(i);
        }
	}
}