

import java.io.*;
import java.util.*;

public class Hai {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("hai.dat"));
        String text = in.nextLine();
        String[] words = text.split(" ");
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String regex = in.nextLine();
            int count = 0;
            String result = "";
            for (String word : words) {
                if (word.matches(regex)) {
                    result += word + " ";
                    count++;
                }
            }
            if (count == 0) {
                result = "No matches.";
            }
            System.out.printf("%-10s %s%n", regex, result);
        }  
        
    }
}
