public class Rotate_Function {

    class Solution {
        public int maxRotateFunction(int[] A) {
            int prevValue = 0;
            int sum = 0;
            int n = A.length;

            for (int i = 0; i < n; ++i) {
                sum += A[i]; // get: 1A+1B+1C+1D+...
                prevValue += i * A[i]; // get: F(0) first
            }

            int result = prevValue;
            for (int i = 1; i < n; i++) { // start from index=1
                prevValue = prevValue + sum - n * A[n - i];
                result = Math.max(result, prevValue);
            }

            return result;
        }
    }
}
class Solution {
    public int maxRotateFunction(int[] nums) {
        int f = 0;
        int s = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            f += i * nums[i];
            s += nums[i];
        }
        int ans = f;
        for (int i = 1; i < n; ++i) {
            f = f + s - n * nums[n - i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}