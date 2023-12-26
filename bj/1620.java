import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Map<String, Integer> nameMap = new HashMap<String, Integer>();
    
    static Map<Integer, String> numberMap = new HashMap<>();
    
    
    public static void main(String[] args) throws IOException {


        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        
        for(int i = 1; i < n+1; i++) {
        	String pocketmon = br.readLine();
        	nameMap.put(pocketmon, i);
        	numberMap.put(i, pocketmon);
        }
        
        
        for (int i = 0; i < m; i++) {
        	
        	String inputData = br.readLine();
        	//숫자일 경우
        	if(isNumeric(inputData)) {
        		System.out.println(numberMap.get(Integer.parseInt(inputData)));
        	}else {
        		System.out.println(nameMap.get(inputData));
        		
        	}
        }
 
       
    }


	private static boolean isNumeric(String inputData) {
		
		try {
			Integer.parseInt(inputData);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
}