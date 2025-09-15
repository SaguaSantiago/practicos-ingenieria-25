public class FizzBuzz {
    public static String compute (int n) {
        String res = "";
        boolean first = true;
        for(int i=1; i<=n; i++){
            if(!first) res += ", ";

            if(i % 3 == 0) res += "Fizz";
            if(i % 5 == 0) res += "Buzz";

            if(i % 3 != 0 && i % 5 != 0) res += i;
            first = false;
        }
        return res;
    }
}