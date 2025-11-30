class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum =0;
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int num :nums){
            sum = (sum+num)%p;
        }
        int target = sum%p;
        if(target == 0){
            return 0;
        }
       
       int curr = 0;
       mp.put(0,-1);
       int result = n;

       for(int i=0; i<n; i++){
        curr = (curr+nums[i])%p;

        int remain = (curr - target+p)%p;
        if(mp.containsKey(remain)){
            result = Math.min(result,i-mp.get(remain));
        }
        mp.put(curr,i);
       }
       return result == n ? -1 : result;

    }
}
