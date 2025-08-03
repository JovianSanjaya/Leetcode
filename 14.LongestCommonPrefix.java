class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Total number of strings in array
        int numberOfStrings = strs.length;

        // Loop through each character of the first string.
        for(int index=0;index<strs[0].length();index++){
            // Compare the character with the same position in the remaining strings.
            for(int stringIndex=1;stringIndex<numberOfStrings;stringIndex++){
                // Check two conditions here: 
                // 1. If the current string is shorter than the current character index, or
                // 2. If the current character does not match the character in the first string.
                // In either case, that means we've found the end of the common prefix.
                if(strs[stringIndex].length() <= index || strs[stringIndex].charAt(index) != strs[0].charAt(index)){
                    return strs[0].substring(0,index);
                }
            }
        }
        
        // If we manage to check all characters of the first string without finding a mismatch,
        // it means that the entire first string is a common prefix.
        return strs[0];
    }
}