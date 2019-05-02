package DIV2_EDU_64;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    for(int i = 0; i < n; i++) {
      char word[] = scan.nextLine().toCharArray();

      int count[] = new int[32];
      for(char c : word) count[c-'a']++;

      ArrayList<String> wordSingle = new ArrayList<>();
      for(int j = 0; j < count.length; j++) {
        if(count[j] > 0) wordSingle.add(String.valueOf( (char)(j+'a') ));
      }

      String single[] = new String[wordSingle.size()];
      wordSingle.toArray(single);

      StringBuilder stb = new StringBuilder();

      for(int j = 0; j < single.length; j+=2) {
        for(int f = 0; f < count[(single[j].charAt(0)-'a')]; f++) {
          stb.append(single[j]);
        }
      }

      StringBuilder secondPart = new StringBuilder();

      for(int j = 1; j < single.length; j+=2) {
        for(int f = 0; f < count[single[j].charAt(0)-'a']; f++) {
          secondPart.append(single[j]);
        }
      }


      char result[] = (secondPart.toString() + stb.toString() ).toCharArray();
      boolean possible = true;
      for(int j = 1; j < word.length; j++) {
        if(result[j]-'a'-1 == result[j-1]-'a' || result[j]-'a'+1 == result[j-1]-'a')
          possible = false;
      }

      char result2[] = (stb.toString() + secondPart.toString()).toCharArray();
      boolean possible2 = true;
      if(!possible) {
        for(int j = 1; j < word.length; j++) {
          if(result2[j]-'a'-1 == result2[j-1]-'a' || result2[j]-'a'+1 == result2[j-1]-'a')
            possible2 = false;
        }
      }

      System.out.println(possible?(secondPart.toString()+stb.toString()):(possible2?(stb.toString() + secondPart.toString()):"No answer"));
    }
  }
}
