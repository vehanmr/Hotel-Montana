package Servlet;

public class book extends Thread {
	int avilable=0;
	int want=0;
	String msg="";
	
	public book(int avilable,int want)
	{
		this.avilable=avilable;
		this.want=want;
		
	}
	
	
	public void reserve(int avilable,int want)
	{
		if(avilable>want)
		{
			avilable=avilable-want;
			msg="Cannot Reserve";
		}
		else
		{
			msg="Reserved Successfully ! Room Count :"+want +"\n"+"Using Thread Class";
		}
		
	}
	
	public String getmsg()
	{
		return msg;
	}
	
	public void run()
	{
		book book1=new book(avilable, want);
		Thread thread= new Thread(book1);
		thread.start();
		book1.reserve(avilable, want);
		thread.stop();
		
	}
	
}
