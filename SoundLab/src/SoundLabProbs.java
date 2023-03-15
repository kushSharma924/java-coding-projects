public class SoundLabProbs {
    // fields
    // constructors
    // 2
    public SoundLabProbs() {
        ;
    }
    // methods
    // 3
    public int lastIndexOf(int[] nums, int value) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }
    // 4
    // Fill up the 5 Gallon bucket and then pour that into the 3 gallon bucket until the 3 gallon bucket is full. You now have 2 gallons of water in the 5 gallon bucket. Now empty the 3 gallon bucket and pour the 2 gallons that you had in the 5 gallon bucket into the 3 gallon bucket. You now have 2 gallons of water in your 3 gallon bucket and an empty 5 gallon bucket. Fill up the 5 gallon bucket and pour into the 3 gallon bucket until it's full. You now have 4 gallons in your 5 gallon bucket.
    // 5
    public int range(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        return max - min;
    }
    // 6
    public int minDifference(int[] nums) {
        int minDif = Math.abs(nums[0] - nums[1]);
        for (int i = 1; i < nums.length - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) < minDif) minDif = Math.abs(nums[i] - nums[i + 1]);
        }
        return minDif;
    }
    // 7
    public String reverseWords(String str) {
        String[] array = str.split(" ");
        for (int i = 0; i < array.length/2; i++) {
            String temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        String newStr = "";
        for (String s : array) {
            newStr += s + " ";
        }
        return newStr;
    }
    // 8
    public int priceIsRight(int[] bids, int price) {
        int lowestDif = Integer.MAX_VALUE;
        int num = -1;
        for (int i : bids) {
            if (price - i < lowestDif && price - i > 0) {
                lowestDif = price - i;
                num = i;
            }
        }
        return num;
    }
    // 9
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}