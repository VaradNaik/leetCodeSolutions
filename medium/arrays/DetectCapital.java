class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n==1){
            return true;
        }
        boolean isFirstCapital = false;
        if(Character.isUpperCase(word.charAt(0))){
            isFirstCapital = true;
        }
        if(!isFirstCapital){
            for(int i = 1;i < n;i++){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        }
        else{
            boolean checkAllCapital = false;
            if(Character.isUpperCase(word.charAt(1))){
                checkAllCapital = true;
            }
            if(checkAllCapital){
                for(int i = 2;i<n;i++){
                    if(!Character.isUpperCase(word.charAt(i))){
                        return false;
                    }
                }
            }
            else{
                for(int i = 2;i<n;i++){
                    if(Character.isUpperCase(word.charAt(i))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}