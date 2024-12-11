import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// how many 2 letter words exist, how many words are tied for the longest word, how many palindromes exist in the file
public class Words{
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException{
        f = new File("words.txt");
        int twoLetter = twoLetter();
        int longestlen = longestlen();
        int longestTotal = longestTotal();
        int palindromes = palindromes();
        System.out.println(twoLetter);
        System.out.println(longestlen);
        System.out.println(longestTotal);
        System.out.println(palindromes);

    }
    public static int twoLetter() throws FileNotFoundException{
        Scanner s = new Scanner(f);
        int twoLetter = 0;
        while (s.hasNext()) {
            String word = s.next();
            int wLen = word.length();
            if (wLen == 2){
                twoLetter++;
            }
        }
        s.close();
        return twoLetter;
    }
    public static int longestlen() throws FileNotFoundException{
        Scanner s = new Scanner(f);
        int longestlen = 0;
        while (s.hasNext()) {
           String word = s.next();
           longestlen = Math.max(longestlen, word.length());
        }
        s.close();
        return longestlen; 
    }
    public static int longestTotal() throws FileNotFoundException{
        Scanner s = new Scanner(f);
        int longestTotal = 0;
        int longestlen = longestlen();
        // return longestlen;
        while (s.hasNext()){
            String word = s.next();
            int wordLen = word.length();
            
            if (wordLen == longestlen){
                longestTotal++;
            }
        }
        s.close();
        return longestTotal;
    }
    public static boolean reverse(String str) throws FileNotFoundException{
        int strLength = str.length();
        String reverseStr = "";
        for (int i = (strLength - 1); i >=0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }
        if (str.equals(reverseStr)) {
            return true;
        }
        else {
            return false;
        }
    }
    public static int palindromes() throws FileNotFoundException{
        Scanner s = new Scanner(f);
        int palTotal = 0;
        while (s.hasNext()){
            String word = s.next();
            boolean rev = reverse(word);
            if (rev == true){
                palTotal++;
            }
        }
        s.close();
        return palTotal;
    }


}