class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap <Integer, Boolean> map = new HashMap<>();

        for(int i : nums) {
            if(map.containsKey(i)){

            return true;
            }
            map.put(i,true);
        } 
        return false;
    }
}