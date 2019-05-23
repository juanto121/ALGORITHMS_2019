import java.util.*;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        cases = 0;
        for(int t = 0; t < cases; t++) {
            String word = scan.nextLine();
            int totalCount = solve(word);
            System.out.println(totalCount);
        }
    }

    private static int solve(String word) {
        int totalCount = 0;
        for(int len = 1; len < word.length(); len++) {
            HashMap<Integer, Integer> set = new HashMap<>();
            for(int start = 0; start+len <= word.length(); start++){
                int code = 0;
                for(int i = 0; i < len; i++) {
                    code += word.charAt(start + i);
                    System.out.print(word.charAt(start + i));
                }
                System.out.println("");
                Integer current = set.get(code);
                if(current == null) set.put(code, 1);
                else set.put(code, current + 1);
            }
            Iterator<Map.Entry<Integer, Integer>> it = set.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer, Integer> map = it.next();
                int v = map.getValue();
                if(v > 1) {
                    int choosev = choose(v, 2);
                    totalCount += choosev;
                    //System.out.println(choosev);
                }
            }
        }
        return totalCount;
    }

    private static int choose(int n, int k) {
        if(k == 0 || n == k) {
            return 1;
        } else {
            return choose(n-1, k) + choose(n-1, k-1);
        }
    }

}
