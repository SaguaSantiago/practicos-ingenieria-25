import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int count = 0;
    public int Add(String s){
        count++;
        if(s.length() == 0) return 0;
        else if(s.length() == 1) return Integer.parseInt(s);
        else {
            String delimiter = "(,|\n)";
            String numbersSection = s;
            if (s.startsWith("//")) {
                int delimiterEnd = s.indexOf("\n");
                delimiter = s.substring(2, delimiterEnd);
                if(delimiter.startsWith("[")){
                    Pattern p = Pattern.compile("\\[(.*?)\\]");
                    Matcher m = p.matcher(delimiter);
                    boolean flag = true;
                    delimiter = "(";
                    while(m.find()){
                        if(!flag) delimiter += "|";
                        delimiter += m.group(1);
                        flag = false;
                    }
                    delimiter += ")";
                }
                numbersSection = s.substring(delimiterEnd + 1);
            }
            System.out.println(delimiter);
            // separa por el delimitador y suma
            String[] numbers = numbersSection.split(delimiter);
            int res = 0;
            List<Integer> negatives = new LinkedList<Integer>();
            System.out.println(Arrays.toString(numbers));
            for(int i=0; i<numbers.length; i++){
                int num = Integer.parseInt(numbers[i]);
                if(num >= 1000) continue;
                if(num<0) negatives.add(num);
                res += num; 
            }
            if(!negatives.isEmpty()) {
                String msgRes = "";
                boolean flag = true;
                for (Integer n : negatives)  {
                    if(!flag) msgRes += ",";
                    msgRes += n;
                    flag = false;
                }
                throw new IllegalArgumentException("negatives not allowed: "+ msgRes);
            }
            return res;
        }
    }

    public int getCalledCount () {
        return count;
    }
}