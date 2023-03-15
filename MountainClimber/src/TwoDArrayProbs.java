import java.util.Arrays;
public class TwoDArrayProbs {
//  instance variables (3a)
    private int[][] nums;
//  constructors (3b)
    public TwoDArrayProbs(int[][] nums) {
        this.nums = nums;
    }
//  methods
//  4
    public int sum() {
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            for (int c = 0; c < nums[r].length; c++) {
                sum += nums[r][c];
            }
        }
        return sum;
    }
//  5
    public boolean isSquare() {
        for (int r = 1; r < nums.length; r++) {
            if (nums[r].length != nums[r - 1].length) {
                return false;
            }
        }
        return (nums.length == nums[0].length) ? true : false;
    }
//  6
    public void addMatrix(int[][] other) {
        for (int r = 0; r < nums.length; r++) {
            for (int c = 0; c < nums[r].length; c++) {
                nums[r][c] = other[r][c];
            }
        }
        print();
    }
    private void print() {
        String s = "{";
        for (int r = 0; r < nums.length; r++) {
            s += "{";
            for (int c = 0; c < nums[r].length; c++) {
                s += nums[r][c] + ",";
            }
            s = s.substring(0, s.length() - 1);
            s += "}, ";
        }
        s = s.substring(0, s.length() - 2);
        s += "}";
        System.out.println(s);
    }
//  7
//  The main is the mask is the catcher on home plate
//  8
    public int columnSum(int col) {
        int colSum = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r].length > col) {
                colSum += nums[r][col];
            }
        }
        return colSum;
    }
//  9
    public boolean isColumnMagic() {
        int numCol = nums[0].length;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r].length > numCol) {
                numCol = nums[r].length;
            }
        }
        for (int c = 1; c < numCol; c++) {
            if (columnSum(c) != columnSum(c - 1)) {
                return false;
            }
        }
        return true;
    }
//  10
    public int diagDifference() {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[0 + i][0 + i] - nums[0 + i][nums[i].length - 1 - i]);
        }
        return Math.abs(sum);
    }
}
