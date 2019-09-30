package dei.esinf.recursive;

public class TP1 {

    public static void main(String[] args){
        System.out.println(twoIntSum(6,3));
        System.out.println(decimalToBinary(10));
        System.out.println(isPalindrome("abababa"));
    }

    public static int twoIntSum(int a, int b) throws IllegalArgumentException{
        if (b <= 0){
            return a;
        }
        a++;
        b--;
        return twoIntSum(a,b);
    }

    public static String decimalToBinary(Integer d){
        if (d < 2){
            return d.toString();
        }
        Integer b = d % 2;
        if (b == 1){
            d--;
        }
        d = d/2;
        return decimalToBinary(d) + b.toString();
    }

    public static boolean isPalindrome(String w){
        if (w.length() < 2){
            return true;
        }
        if (w.toLowerCase().charAt(0) == w.toLowerCase().charAt(w.length() - 1)){
            String newWord = "";
            for (int i = 1; i < w.length()-1;i++){
                newWord += w.charAt(i);
            }
            System.out.println(newWord);
            return isPalindrome(newWord);
        }
        return false;
    }
}
