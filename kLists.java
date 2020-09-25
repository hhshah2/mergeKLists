public class kLists {

    public double[] mergekLists (double[][] outerArray) {
        if (outerArray.length == 0) {
            return new double[0];
        }

       
        double[] result = outerArray[0];
        for (int i = 1; i < outerArray.length; i++) {
            result = merge(result, outerArray[i]);
        }
        return result;
    }

    public double[] merge(double[] left, double[] right) {
        int i = 0;
        int l = 0;
        int r = 0;
        int leftLength = left.length;
        int rightLength = right.length;

        double[] result = new double[leftLength + rightLength];

        while(l < leftLength && r < rightLength){
            if (left[l] <= right[r]) {
                result[i] = left[l++];
            }
            else {
                result[i] = right[r++];
            }
            i++;
        }

        while(l < leftLength) { 
            result[i++] = left[l++];
        }

        while(r < rightLength) {
            result[i++] = right[r++];
        }
        return result;
    }


    public static void main(String args[]) {
        kLists mergeK = new kLists();
        double[][] test = { {9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27} };

        double[] result = mergeK.mergekLists(test);

        System.out.print("[");
        for (int i = 0; i < result.length - 1; i++) {
            System.out.print(result[i] + ", ");
        }
        if (result.length > 0) {
            System.out.print(result[result.length-1]);
        }
        System.out.print("]\n");

    }
}