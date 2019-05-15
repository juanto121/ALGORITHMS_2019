package DIV2_EDU_65;

import java.util.HashMap;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a[] = new int[6];
        System.out.println("? 1 1");
        a[0] = (int) Math.sqrt(scan.nextInt());
        System.out.println("? 2 2");
        a[1] = (int) Math.sqrt(scan.nextInt());
        System.out.println("? 3 4");
        int ma = scan.nextInt();
        System.out.println("? 4 5");
        int mb = scan.nextInt();

        HashMap<Integer, Mixed> map = new HashMap<Integer, Mixed>();
        map.put(32, new Mixed(32,4, 8));map.put(60, new Mixed(60,4, 15));map.put(64, new Mixed(64,4, 16));map.put(92, new Mixed(92,4, 23));map.put(168, new Mixed(168,4, 42));map.put(120, new Mixed(120,8, 15));map.put(128, new Mixed(128,8, 16));map.put(184, new Mixed(184,8, 23));map.put(336, new Mixed(336,8, 42));map.put(240, new Mixed(240,15, 16));map.put(345, new Mixed(345,15, 23));map.put(630, new Mixed(630,15, 42));map.put(368, new Mixed(368,16, 23));map.put(672, new Mixed(672,16, 42));map.put(966, new Mixed(966,23, 42));
        Mixed amap = map.get(ma);
        Mixed bmap = map.get(mb);
        int common = amap.common(bmap);

        a[3] = common;
        a[2] = amap.val / common;
        a[4] = bmap.val / common;

        a[5] = 108 - (a[0] + a[1] + a[2] + a[3] + a[4]);
        System.out.println("! "+ printarr(a));
        System.out.flush();

    }

    private static String printarr(int[] a) {
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            stb.append(a[i] +" ");
        }
        return stb.toString();
    }
}

class Mixed {
    int val;
    int min;
    int max;
    public Mixed(int v, int mn, int mx) {
        val = v;
        min = mn;
        max = mx;
    }
    public int common(Mixed b) {
        if(this.min == b.min || this.min == b.max) return this.min;
        if(this.max == b.min || this.max == b.max) return this.max;
        return 0;
    }
}

/*

        int repe[] = new int[10000];
        int nums[] = {4,8,15,16,23,42};
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                System.out.println(nums[i] + " " + nums[j] + "=" + nums[i]*nums[j]);
                repe[nums[i]*nums[j]]++;
            }
        }

        for(int i = 0; i < repe.length; i++) {
            if(repe[i] > 0) {
                System.out.println(i + " " + repe[i]);
            }
        }
 */