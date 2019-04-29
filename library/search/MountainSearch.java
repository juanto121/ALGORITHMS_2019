public class MountainSearch {
  public static void main(String[] args) {
    int a[] = {1,2,3,4,2,0};
    int idxmax = search(a);
  }

  private static int search(int[] a) {
    int left = 0;
    int right = a.length-1;
    int mid = (left+right)/2;
    int res = -1;
    int len = a.length-1;
    while( len == 0 ){
      if((mid==0 || a[mid-1] < a[mid]) && (mid==len || a[mid+1] > a[mid])){
        res = mid;
        break;
      }
    }

    return res;
  }
}
