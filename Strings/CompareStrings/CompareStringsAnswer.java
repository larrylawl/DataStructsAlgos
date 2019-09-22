public int[] compareStrings(String A, String B){
        String[] strsA = A.split(","), strsB = B.split(",");
        int lenA = strsA.length, lenB = strsB.length;
        int[] freqs = new int[11];
        int[] res = new int[lenB];
        for(String s: strsA){
            if(s.length() == 0) continue;
            int[] counts = new int[26];
            int minIdx = 26;
            for(char c: s.toCharArray()){
                ++counts[c - 'a'];
                minIdx = Math.min(minIdx, c - 'a');
            }
            int freq = counts[minIdx];
            freqs[freq]++;
        }
        // use prefix sum to easily get sum from idx 0 to i
        for(int i = 1; i < 11; ++i)
            freqs[i] += freqs[i - 1];
        for(int i = 0; i < lenB; ++i){
            String s = strsB[i];
            int[] counts = new int[26];
            int minIdx = 26;
            for(char c: s.toCharArray()){
                ++counts[c - 'a'];
                minIdx = Math.min(minIdx, c - 'a');
            }
            int freq = counts[minIdx];
            res[i] = (freq - 1 >= 0)? freqs[freq - 1]: 0;
        }
        return res;
    }
