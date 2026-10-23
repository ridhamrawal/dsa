class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        
        // Initialize arrays with -1 to represent unmapped characters
        for (int i = 0; i < 256; i++) {
            mapS[i] = -1;
            mapT[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            // If the mapping already exists, check if it matches the current character
            if (mapS[c1] != -1 && mapS[c1] != c2) {
                return false;
            }
            if (mapT[c2] != -1 && mapT[c2] != c1) {
                return false;
            }
            
            // Establish the mapping
            mapS[c1] = c2;
            mapT[c2] = c1;
        }
        
        return true;
    }
}