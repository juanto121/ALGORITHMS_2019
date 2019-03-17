package DIV3_531;

import java.util.*;

public class B {

    static ArrayList<HashSet<Integer>> colorsUsedInGroup = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dsc[] = scan.nextLine().split(" ");

        int n = Integer.parseInt(dsc[0]);
        int k = Integer.parseInt(dsc[1]);

        String _arr[] = scan.nextLine().split(" ");
        int arr[] = new int[n];

        boolean isPossible = true;
        int numOfItemsGroup[] = new int[5001];

        for(int i = 0; i < 5001; i++){
            colorsUsedInGroup.add(new HashSet<>());
        }

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(_arr[i]);
            numOfItemsGroup[arr[i]]++;
            if(numOfItemsGroup[arr[i]] > k) isPossible = false;
        }

        if(isPossible){
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < n; i++){
                stb.append(nextNotUsedForGroup(arr[i], i, k)).append(" ");
            }
            System.out.println("YES");
            System.out.println(stb.toString());
        }else{
            System.out.println("NO");
        }

    }

    public static int nextNotUsedForGroup(int g, int index, int k) {
        HashSet<Integer> usedInG = colorsUsedInGroup.get(g);
        int nextAllowedColor = -1;

        if(index < k){
            nextAllowedColor = index + 1;
        }

        for(int i = 1; nextAllowedColor == -1 && i <= k; i ++) {
            if(!usedInG.contains(i)) {
                nextAllowedColor = i;
                break;
            }
        }

        usedInG.add(nextAllowedColor);

        return nextAllowedColor;
    }
}
