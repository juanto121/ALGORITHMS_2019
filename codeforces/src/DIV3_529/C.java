package DIV3_529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tks = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(tks.nextToken());
        int k = Integer.parseInt(tks.nextToken());

        Stack<Integer> q = new Stack<>();
        int hob = Integer.highestOneBit(n);
        q.push(hob);
        int ntp = n - hob;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(hob, 1);
        while(ntp > 0){
            hob = Integer.highestOneBit(ntp);
            q.push(hob);
            ntp -= hob;
            map.put(hob, 1);
        }

        if(k < q.size() || k > n) System.out.println("NO");
        else {
            int sum = q.size();
            while (!q.isEmpty() && sum < k) {
                int f = q.pop();
                if (f == 1) continue;
                if (f / 2 > 1) {
                    q.push(f / 2);
                    q.push(f / 2);
                }
                Integer cntpows = map.get(f / 2);
                map.put(f / 2, (cntpows != null ? cntpows : 0) + 2);
                map.put(f, map.get(f) - 1);
                sum += 1;
            }

            if (sum < k) System.out.println("NO");
            else {
                ArrayList<Integer> sumands = new ArrayList<>();
                System.out.println("YES");
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> pair = (Map.Entry) it.next();
                    for (int i = 0; i < pair.getValue(); i++) {
                        sumands.add(pair.getKey());
                    }
                }

                StringBuilder stb = new StringBuilder(k);
                for (Integer i : sumands) {
                    stb.append(i + " ");
                }
                System.out.println(stb.toString());
            }
        }
    }
}
