public class BinarySearch {
  public static void main(String[] args) {
    int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,89,103,5463,222222};
    System.out.println(search(a, 55));
  }

  private static int search(int[] a, int x) {
    int left = 0;
    int right = a.length-1;
    int res = -1;

    while(left <= right) {
      int mid = (left + right) / 2;

      if(a[mid] == x) {
        res = mid;
        break;
      }

      if(x > a[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return res;

  }
}
