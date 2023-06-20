package Java_tutorial;

public class CoreJavaBrushUp_ForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,34,53,23,25,56};
		
		for(int i = 0; i< arr.length; i++)
		{
			System.out.println("Array number: " + (i+1) + " : "+ arr[i]);
		}
		
		String[] names = {"Learning","Selenium","Academy"};
		
		for(int i = 0; i< names.length; i++)
		{
			System.out.println(names[i]);
		}
		
	}

}
