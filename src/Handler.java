import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Handler {
	
	public static int s, min, max, mean;
	
	public static int Sum (ArrayList<Integer> list){
		int s = 0;
		for(int i = 0; i<list.size(); i++){
			s += list.get(i);
		}
		return s;
	}
	
	public static int Min (ArrayList<Integer> list){
		int min = list.get(0);
		for(int i = 0; i<list.size(); i++){
			if (min>list.get(i)){
				min = list.get(i);
			}
		}
		return min;
	}
	
	public static int Max (ArrayList<Integer> list){
		int max = list.get(0);
		for(int i = 0; i<list.size(); i++){
			if (max<list.get(i)){
				max = list.get(i);
			}
		}
		return max;
	}
	
	public static int Mean (int sum, ArrayList<Integer> list){
		int s = sum;
		mean = s/(list.size()+1);
		return mean;
	}
	
	public static void getIntResultFirst (ArrayList<Integer> list){
		ArrayList<Integer> res = HandIntFirst(list); 
		
		System.out.println("Сумма элементов массива: " + res.get(0));
		System.out.println("Минимальный элемент массива: " + res.get(1));
		System.out.println("Максимальный элемент массива: " + res.get(2));
		System.out.println("Среднее значение элементов массива: " + res.get(3));
	}
	
	public static void getIntResultSecond (ArrayList<Integer> list, int q) throws IOException{
		ArrayList<Integer> res = HandIntSecond(list, q); 
		
		try(FileWriter writer = new FileWriter("Int2.txt", false)){
			for (int i=0;i<res.size();i++){
				writer.write(Integer.toString(res.get(i))+ " ");
			}
	        writer.flush();
		}
		System.out.println("Массив записан в файл");
		
	}
	
	public static ArrayList<Integer> HandIntFirst (ArrayList<Integer> list){
		ArrayList<Integer> Result = new ArrayList<>();
		Result.add(Sum(list));
		Result.add(Min(list));
		Result.add(Max(list));
		Result.add(Mean(Sum(list),list));
				
		return Result;
	}
	
	public static ArrayList<Integer> HandIntSecond (ArrayList<Integer> list, int q){
		ArrayList<Integer> res = new ArrayList<>(); 
		if (q==2){
			for (int i =0; i<list.size();i++){
				if (list.get(i) % 2==0){
					res.add(list.get(i));
					//System.out.println(res.get(i));
				}
			}
		}
		else{
			for (int i =0; i<list.size();i++){
				if (list.get(i)%2!=0){
					res.add(list.get(i));
				}
			}
		}
		
		/*for (int i=0;i<res.size();i++){
			System.out.println(res.get(i));
			System.out.println("/n");
		}*/
				
		return res;
	}
	
	public static ArrayList<String> HandStrFirst (String[][] list){
		ArrayList<String> Result = new ArrayList<>();
		
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] != " "){
					Result.add(list[i][j]);
				}
			}
		}
	
		return Result;
	}
	
	public static void getStrResultFirst (String[][] list){
		ArrayList<String> res = HandStrFirst(list); 
		
		System.out.println("«Cклеенная» строка: ");
		for (int i=0;i<res.size();i++){
		System.out.print(res.get(i));
		}
	}
	
	public static ArrayList<Integer> HandStrSecond (String[][] list){
		ArrayList<Integer> Result = new ArrayList<>();
		int amt = 0;
		int length = 0;
		
		Result.add(list.length);
		
		for (int i = 0; i < list.length; i++) {
			amt = 0;
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] != (" ")){
					amt+=1;
					length += list[i][j].length();
				}
			}
			Result.add(amt);			
		}
		Result.add(length);
	
		return Result;
	}
	
	public static void getStrResultSecond (String[][] list){
		ArrayList<Integer> res = HandStrSecond(list); 
		
		int line = res.get(0);
		int S = 0;
		res.remove(0);
		System.out.println("Количество строк: "+ line);
		
		for (int i=0;i<line;i++){
			System.out.println("Количество слов в " + (i) + " строке: " + res.get(i));
			S+=res.get(i);
		}
		System.out.println("Количество слов всего: " + S);
		System.out.println("Количество символов всего: " + res.get(res.size()-1));
		
	}

}
