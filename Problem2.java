package JavaProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

class employeeVO {
	int empid;
	String empname;
	double annualincome;
	double incometax=0;

	public employeeVO(int empid, String empname, double annualincome) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.annualincome = annualincome;
		//this.incometax = incometax;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getAnnualincome() {
		return annualincome;
	}

	public void setAnnualincome(double annualincome) {
		this.annualincome = annualincome;
	}

	public double getIncometax() {
		return incometax;
	}

	public void setIncometx(double incometx) {
		this.incometax = incometx;
	}

	@Override
	public String toString() {
		return "employeeVO [empid=" + empid + ", empname=" + empname + ", annualincome=" + annualincome + ", incometax="
				+ incometax + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(annualincome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + empid;
		result = prime * result + ((empname == null) ? 0 : empname.hashCode());
		temp = Double.doubleToLongBits(incometax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		employeeVO other = (employeeVO) obj;
		if (Double.doubleToLongBits(annualincome) != Double.doubleToLongBits(other.annualincome))
			return false;
		if (empid != other.empid)
			return false;
		if (empname == null) {
			if (other.empname != null)
				return false;
		} else if (!empname.equals(other.empname))
			return false;
		if (Double.doubleToLongBits(incometax) != Double.doubleToLongBits(other.incometax))
			return false;
		return true;
	}
}

class employeeBO {
	public void calincomeTax(employeeVO evo) {
		double incometax = evo.getAnnualincome() * (30 / 100.0);
		evo.setIncometx(incometax);
	}
}

class employeeSort implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		employeeVO evo1 = (employeeVO) o1;
		employeeVO evo2 = (employeeVO) o2;
		int retValue = 0;
		if (evo1.getIncometax() < evo2.getIncometax())
			retValue = 1;
		else if (evo1.getIncometax() < evo2.getIncometax())
			retValue = -1;
		else
			retValue = 0;
		return retValue;
	}
}

public class Problem2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int num;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of employees : ");
		num=Integer.parseInt(br.readLine());
		
		employeeVO emp[]=new employeeVO[num];
		for(int i=0; i<num; i++) {
			System.out.println("Enter empid : ");
			int empid=Integer.parseInt(br.readLine());
			System.out.println("Enter empname : ");
			String empname=br.readLine();
			System.out.println("Enter annual income : ");
			double income=Double.parseDouble(br.readLine());
			emp[i]=new employeeVO(empid,empname,income);
		}
		
		employeeBO ebo=new employeeBO();
		for(int i=0; i<num; i++) {
			ebo.calincomeTax(emp[i]);
			System.out.println(emp[i]);
		}
	}

}
