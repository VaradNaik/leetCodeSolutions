class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<>();
        while(true){
            int squaredSum = 0;
            while(n > 0){
                squaredSum += Math.pow((n%10),2);
                n= n/10;
            }
            n = squaredSum;
            if(squaredSum == 1){
                return true;
            }
            if(hashSet.contains(squaredSum)){
                return false;
            }
            hashSet.add(squaredSum);
        }
    }
}