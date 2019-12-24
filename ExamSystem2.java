import java.io.*;

class var
{
	int rollno,total;
	String name;
	int sub1,sub2,sub3,sub4,sub5;
	float per;
	String div;
}

class s extends var 
{	
	void addStudent() throws IOException
	{
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("\nEnter Details of Student");
		System.out.print("Enter Student Name: ");
		name = br.readLine();
		System.out.print("Enter Student Roll No: ");
		rollno = Integer.parseInt(br.readLine());
	}
	
	void addMarks() throws IOException
	{
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.print("Enter marks of M3: ");
		sub1 = Integer.parseInt(br.readLine());
		if(sub1<0 || sub1>100) {System.out.println("Range should be from 0 to 100"); addMarks();} 
		System.out.print("Enter marks of DATA: ");
		sub2 = Integer.parseInt(br.readLine());
		if(sub2<0 || sub2>100) {System.out.println("Range should be from 0 to 100"); addMarks();} 
		System.out.print("Enter marks of DIS: ");
		sub3 = Integer.parseInt(br.readLine());
		if(sub3<0 || sub3>100) {System.out.println("Range should be from 0 to 100"); addMarks();} 
		System.out.print("Enter marks of DLDA: ");
		sub4 = Integer.parseInt(br.readLine());
		if(sub4<0 || sub4>100) {System.out.println("Range should be from 0 to 100"); addMarks();} 
		System.out.print("Enter marks of ECCF: ");
		sub5 = Integer.parseInt(br.readLine());
		if(sub5<0 || sub5>100) {System.out.println("Range should be from 0 to 100"); addMarks();} 
		if(sub1>=29 && sub1<=31) {sub1=32;} 
		if(sub2>=29 && sub2<=31) {sub2=32;}
		if(sub3>=29 && sub3<=31) {sub3=32;}
		if(sub4>=29 && sub4<=31) {sub4=32;}
		if(sub5>=29 && sub5<=31) {sub5=32;}

	}
	
	void calResult()
	{
		total= sub1+sub2+sub3+sub4+sub5;
		per = (float)total/5;
		div = per >= 35 ? "Pass" : "Fail";
	}
	
	void display()
	{	
		if(name!=null)
		{
		System.out.printf("%5s %10s %10s %10s %10s %10s %10s %10s %10s %10s","RollNo","Name","M3","DATA","DIS","DLDA","ECCF","Total","Percentage","Division");
		System.out.println();
		System.out.printf("%5s %10s %10s %10s %10s %10s %10s %10s %10s %10s",rollno,name,sub1,sub2,sub3,sub4,sub5,total,per,div);
		System.out.println();
		}
		else
		{
		System.out.println("No record found for specified student");
		}
	}
	
	void displayAll()
	{
		if(name!=null)
		{
		System.out.printf("%5s %10s %10s %10s %10s",rollno,name,total,per,div);
		}
	}
}

class ExamSystem2
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int i=1;
		s s1[] = new s[6];
		s1[1]=new s();
		s1[2]=new s();
		s1[3]=new s();
		s1[4]=new s();
		s1[5]=new s();
		while(true)
		{
			System.out.println("\n\nEnter your operation");
			System.out.println("\n1.Add Student Details \n2.Edit Marks \n3.Display Result \n4.Display All Results \nAny other key to Exit");
			int ch = Integer.parseInt(br.readLine());
			System.out.println(new String(new char[50]).replace("\0", "\r\n"));
			menu: switch(ch)
			{
				case 1: 
						System.out.println("Select Student no.: ");
						i = Integer.parseInt(br.readLine()); 
						if(i<1 || i>5) {System.out.println("Student range is from 1 to 5"); break menu;}
						s1[i].addStudent();
						s1[i].addMarks();
						System.out.println(new String(new char[50]).replace("\0", "\r\n"));
						break;			
				case 2: 
						System.out.println("Select Student no.: ");
						i = Integer.parseInt(br.readLine());
						if(i<1 || i>5) {System.out.println("Student range is from 1 to 5"); break menu;}
						s1[i].addMarks();
						System.out.println(new String(new char[50]).replace("\0", "\r\n"));
						break;					
				case 3: 					
						System.out.println("Select Student no.: ");
						i = Integer.parseInt(br.readLine());
						if(i<1 || i>5) {System.out.println("Student range is from 1 to 5"); break menu;}
						s1[i].calResult();
						s1[i].display();				
						break;
				case 4: 			
						System.out.printf("%5s %10s %10s %10s %10s","RollNo","Name","Total","Percentage","Division");
						System.out.println();
						for(int n=1; n<6; n++)
						{
							s1[n].calResult();
							s1[n].displayAll();
							System.out.println();
						}
						break;
				default:
						System.exit(0);
						break;
			}
		}
	}
}