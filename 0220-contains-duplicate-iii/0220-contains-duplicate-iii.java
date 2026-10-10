import java.util.TreeSet;

class Solution 
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) 
    {
        if (nums == null || nums.length < 2 || indexDiff < 1 || valueDiff < 0) 
        {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) 
        {
            long val = (long) nums[i];

            Long ceiling = set.ceiling(val - valueDiff);

            if (ceiling != null && ceiling <= val + valueDiff) 
            {
                return true;
            }

            set.add(val);

            if (i >= indexDiff) 
            {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}