package Android;

import java.util.regex.*;

public class Regular {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "10、用ImageView组件显示的图片，往往放到哪个文件夹下 ";
		String regex = "(\\d+)([、])(.*)";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(text);
		if(m.find()){
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			System.out.println(m.group(3));
			System.out.println(m.group(4));
			System.out.println(m.group(5));	
		}
	}

}
