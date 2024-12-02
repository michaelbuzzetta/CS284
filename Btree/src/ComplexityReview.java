public class ComplexityReview {

    /**
     *   i  |1  2  ...  n
     * -----------------------------------
     *   j  |1  2  ...  n
     * -----------------------------------
     * total|1  1+2=3   1+2+...+n=n(n+1)/2
     */
    public static int methodA(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; i++) {
                counter++;
            }
        }
        return counter;
    }


    /**
     *   i  |1   2   ...   n
     * -----------------------------------
     *   j  |n   n   ...   n
     * -----------------------------------
     * total|n   n+n=2*n   n+...+n=n*n=n^2
     */
    public static int methodB(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; i++) {
                counter++;
            }
        }
        return counter;
    }
}
