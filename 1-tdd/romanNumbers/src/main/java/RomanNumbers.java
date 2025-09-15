import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumbers {
   public RomanNumbers () {}
   Map<Integer, String> decimalToRomans = Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100, "C", 500, "D", 1000, "M");
   int[] orderedRomans = {1000,500,100,50,10,5,1};
   String getRomans(int number){
        StringBuilder sb = new StringBuilder(Integer.toString(number));
        int length = sb.length();
        // System.out.println(sb.toString());
        for(int i=length-1; i>=0; i--){
            int digit = Integer.parseInt(sb.charAt(i)+"") * (int) Math.pow(10, length - 1 - i);
            System.out.println(i +" "+ sb.length());
            if(decimalToRomans.containsKey(digit)) {
                sb.setCharAt(i,decimalToRomans.get(digit).charAt(0));
                continue;
            }
            String repl = "";
            for(int k=0; k<orderedRomans.length && digit > 0; k++){
                int n = orderedRomans[k];
                int repeated = 0;
                while(n<=digit) {
                    repeated++;
                    if(repeated > 3) break;
                    repl += decimalToRomans.get(n);
                    digit -= n;
                    System.out.println(repl.toString());
                }
                if(repeated>3) {
                    repl = decimalToRomans.get((int) Math.pow(10,i)) + decimalToRomans.get(orderedRomans[k-1]);
                    digit = 0;
                }
            }
            sb.replace(i, i+1, repl);
        }

        return sb.toString();
    }
}