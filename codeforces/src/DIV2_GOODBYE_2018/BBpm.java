package DIV2_GOODBYE_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class BBpm {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        int obs[][] = readLines(n, bfr);
        int clues[][] = readLines(n, bfr);
        int solx[][] = new int[n][n];
        int soly[][] = new int[n][n];
        int maxc = -1;
        Pair maxp = new Pair(-1,-1);
        HashMap<Pair, Integer> map= new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                solx[i][j] = obs[i][0] + clues[j][0];
                soly[i][j] = obs[i][1] + clues[j][1];
                int x = solx[i][j];
                int y = soly[i][j];
                Pair p = new Pair(x,y);
                Integer count = map.get(p);
                int added = 1;
                if(count == null){
                    map.put(p, added);
                }else{
                    added = count + 1;
                    map.put(p, added);
                }
                if(added >= maxc){
                    maxc = added;
                    maxp = p;
                }
            }
        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Pair, Integer> pair = (Map.Entry)it.next();
            if((int)pair.getValue() == n){
                Pair p = pair.getKey();
                System.out.println(p.x + " " + p.y);
                break;
            }
        }
    }

    public static int [][] readLines(int n, BufferedReader bfr) throws IOException {
        int obs[][] = new int[n][2];
        for(int l = 0; l < n; l++){
            String ds[] = bfr.readLine().split(" ");
            obs[l][0] = Integer.parseInt(ds[0]);
            obs[l][1] = Integer.parseInt(ds[1]);
        }
        return obs;
    }
}

class Pair{
    public Integer x,y;

    public Pair(int x, int y){
        this.x = x; this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Pair)obj).x == this.x && ((Pair)obj).y == this.y;
    }
}