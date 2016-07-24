package Android;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.*;
public class Tran {
	static String question;
	static String option;
	static String answer;
	static final String regex = "(\\d+)([、])(.*)([（].([ABCD]).[）])";
	static final String regex_noa = "(\\d+)([、])(.*)";
	static final String regex_ta = "asf";
	Connection con;
	Statement st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("android.txt"));
		Tran tr = new Tran();
		tr.ConMysql();
		String updateSQL;
		Pattern r = Pattern.compile(regex);
		Pattern nor = Pattern.compile(regex_noa);
		Pattern tr1 = Pattern.compile(regex_ta);
		Matcher m;
		Matcher nom;
		Matcher tm;
		do{
			question = br.readLine();
			option = br.readLine();
			option = option+"\n"+br.readLine();
			option = option+"\n"+br.readLine();
			option = option+"\n"+br.readLine();
			answer = br.readLine();
			if(question != null){
				m=r.matcher(question);
				nom=nor.matcher(question);
				tm=tr1.matcher(question);
				
				if(m.find()){
					System.out.println(m.group(3));
					System.out.println(option);
					System.out.println(m.group(5));
					updateSQL= "insert into android values(null,'"+m.group(3)+"','"+option+"','"+m.group(5)+"')";
					tr.Update(updateSQL);	
				}
				else if(nom.find()){
					System.out.println(nom.group(3));
					System.out.println(option);
					updateSQL= "insert into android values(null,'"+nom.group(3)+"','"+option+"','')";
					tr.Update(updateSQL);
				}


			}
		}while(question != null);
		br.close();
	}
	public void ConMysql(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbName = "questions";	                     //数据库名
	   		String url1="jdbc:mysql://localhost/" + dbName;
	   		String url2="?user=root&password=123456"; 
	   		String url3="&useUnicode=true&characterEncoding=UTF-8";
	   		String url =url1+url2+url3;
	   		con = DriverManager.getConnection(url);
	   		st = con.createStatement();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void Update(String updateSQL){
		try{
			st.executeUpdate(updateSQL);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
