package DIV3_531;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dsc[] = scan.nextLine().split(" ");
        int n = Integer.parseInt(dsc[0]);
        int k = Integer.parseInt(dsc[1]);
        String _arr[] = scan.nextLine().split(" ");
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        boolean possible = true;
        for(int i = 0; i < n; i++){
            int item = Integer.parseInt(_arr[i]);
            Integer cnt = map.get(item);

            if(cnt == null)
                cnt = 1;
            else
                cnt++;

            if(cnt > k){
                possible = false;
                break;
            }

            map.put(item, cnt);
        }

        if(possible) {
            System.out.println("YES");
            StringBuilder stb = new StringBuilder(n);
            boolean seen[] = new boolean[5001];
            for(int i = 0; i < n; i++){
                int item = Integer.parseInt(_arr[i]);
                int c = map.get(item);
                stb.append((!seen[item]&&k>0?k--:c)+ " ");
                seen[item]=true;
                map.put(item, c-1);
            }
            System.out.println(stb);
        }else{
            System.out.println("NO");
        }
    }
}
