package Android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Android_main {
	//创建一个返回随机数函数 Rand
	String question;
	String option;
	String answer; 
	public static void main(String[] args) {
		Android_main and =  new Android_main();
		and.ConMysql();
		and.Check();
		}
	public static int Rand(){
		int r;
		r = (int)(1+Math.random()*4-1+1);
		return r;
	}
	public void  ConMysql(){
		int r = Rand();
		//System.out.print(r);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbName = "questions";	                     //数据库名
	   		String url1="jdbc:mysql://localhost/" + dbName;
	   		String url2="?user=root&password=123456"; 
	   		String url3="&useUnicode=true&characterEncoding=UTF-8";
	   		String url =url1+url2+url3;
	   		Connection con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from android where id='"+r+"'");
			if(rs.next()){
				question = rs.getString(2);
				option = rs.getString(3);
				answer = rs.getString(4);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void Check(){
		System.out.println(question);
		System.out.println(option);
		Scanner in = new Scanner(System.in);
		String ans = in.nextLine();
		if(answer.equals(ans)){
			System.out.println("正确");
		}
		else{
			System.out.println("错误");
		}
		
	}
}
