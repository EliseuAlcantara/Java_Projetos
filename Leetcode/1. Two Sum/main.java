class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        for(int i = 0; i<nums.length;i++){
            for(int k = 0; k <nums.length;k++){
                if(k == i)k++;
                if(nums[i] + nums[k] == target){
                    result[0] = i;
                    result[1] = k;
                    return result;
                }
            }
           
        }
        return result;
    }
}