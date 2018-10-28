package leetcode;

public class MergedContainer implements Comparable<MergedContainer>{
    int[] arr;
    int index;


    public MergedContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }



    public int compareTo(MergedContainer o) {
        return this.arr[this.index] - o.arr[o.index];
    }
}
