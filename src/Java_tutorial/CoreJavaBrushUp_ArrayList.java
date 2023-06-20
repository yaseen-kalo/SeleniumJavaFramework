package Java_tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CoreJavaBrushUp_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> arr = new ArrayList<String>();
		
		arr.add("Learn");
		arr.add("Selenium");
		arr.add("With");
		arr.add("Yaseen");
//		get value against specific index
//		System.out.println(arr.get(3));
		
//		for(int i = 0; i < arr.size(); i++)
//		{
//			System.out.print(arr.get(i)+ " ");
//		}
		
		for(String s : arr)
		{
			System.out.print(s+ " ");
		}
		
		System.out.println("\n" + arr.contains("Selenium"));
		
		//Create array, assign some values and then convert it into arrayList;
		String[] names = {"Waleed", "Noman", "Arslan"};
		
		List<String> namesArrayList = Arrays.asList(names);
		
		System.out.print(namesArrayList.contains("Arslan"));
	}

}
