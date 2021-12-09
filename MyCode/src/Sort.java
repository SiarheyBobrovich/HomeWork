import java.util.Arrays;

public class Sort {
    private int[] sortedArray;

    public Sort(int a, int b) {
        sortedArray = sortInts(a, b);
    }

    public Sort(int[] a, int[] b) {
        sortedArray = sort(a, b);
    }

    public Sort(int a, int b, int c) {
        sortedArray = sort(sortInts(a, b), new int[]{c});
    }

    private static int[] sort(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int index = 0;
        int indexA = 0;
        int indexB = 0;
        while (indexA < a.length || indexB < b.length) {
            if(indexB >= b.length) {
                result[index++] = a[indexA++];
            }
            while (indexB < b.length) {
                if(indexA >= a.length) {
                    result[index++] = b[indexB++];
                }else if (a[indexA] == b[indexB]) {
                    result[index++] = a[indexA++];
                    result[index++] = b[indexB++];
                    break;
                }else if (a[indexA] < b[indexB]) {
                    result[index++] = a[indexA++];
                    break;
                }else {
                    result[index++] = b[indexB++];
                    break;
                }
            }
        }
        return result;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    private static int[] sortInts(int a, int b) {
        return new int[]{Math.min(a, b), Math.max(b, a)};
    }

    @Override
    public String toString() {
        return Arrays.toString(sortedArray);
    }
}
