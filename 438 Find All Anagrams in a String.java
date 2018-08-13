class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        char[] sary = s.toCharArray();
        char[] pary = p.toCharArray();
        int plen = pary.length;
        int slen = sary.length;
        
        if(slen < plen){
            return new ArrayList<Integer>();
        }
        
        int[] ary = new int[256];
        int[] comr = new int[256];
        
        for(int i = 0; i < plen; i++){
            ary[sary[i]]++;
            comr[pary[i]]++;
        }
        int size = slen - plen;
        
        
        ArrayList<Integer> solution = new ArrayList<Integer>(size);
        for(int i = 0; i <= size; i++){
            boolean isEqual = true;
            for(int j = 'a'; j <= 'z'; j++){
                if(ary[j] != comr[j]){
                    isEqual = false;
                }
            }
            if(isEqual){solution.add(i);}
            
            if(i != size){
                ary[sary[i]]--;
                ary[sary[i+plen]]++;
            }
        }
        return solution;
        
    }
}
