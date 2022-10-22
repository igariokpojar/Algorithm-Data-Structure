import java.util.HashSet;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        HashSet<Integer> s = new HashSet();
        for (int i : nums) {
            if
            (s.contains(i)) {
                s.remove(i);
            } else {
                s.add(i);
            }
        }
        for (int i : s) {
            return i;
        }
        return 0;
    }
/*   -- Second Solution
    int res=0;
        for(int i : nums){
        res =res ^ i;
    }
        return res;

 */
}


