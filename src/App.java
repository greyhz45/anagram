import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 1st word: ");
        String a = input.nextLine();
        System.out.print("Enter 2nd word: ");
        String b = input.nextLine();

        System.out.println(anagram(a, b));
    }

    static String anagram(String a, String b) {
        Map<String, Integer> strA = new HashMap<String, Integer>();
        Map<String, Integer> strB = new HashMap<String, Integer>();
        String[] tempArr = null;
        
        if (a.length() == b.length()) {
            if(a != null) {
                tempArr = a.toUpperCase().split("");
                for (String string : tempArr) {
                    if(strA.containsKey(string))
                    strA.replace(string, strA.get(string) + 1);
                    else
                        strA.put(string, 0);
                }
            }
            
            if(b != null) {
                tempArr = b.toUpperCase().split("");
                for (String string : tempArr) {
                    if(strB.containsKey(string))
                        strB.replace(string, strB.get(string) + 1);
                    else
                        strB.put(string, 0);
                }
            }
            
            for(Map.Entry<String, Integer> mapA:strA.entrySet()) {
                if((strB.containsKey(mapA.getKey())) && (strB.get(mapA.getKey()) == mapA.getValue())) {
                    strB.remove(mapA.getKey());
                }
            }

            if(strB.isEmpty()) {
                return "Anagram!";
            }
        }

        return "Not Anagram!";
        
    }
    
}
