class Solution {
    class pair{
    String first;
    int second;
    pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair>q = new LinkedList<>();
        q.add(new pair(beginWord,1));

        HashSet<String>st = new HashSet<>();

        int len = wordList.size();
        for(int i = 0; i<len; i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord)  == true)return steps;
        

    for(int i = 0; i<word.length(); i++){
        for(char ch = 'a'; ch<='z';ch++){
            char replacedCharArray[] =  word.toCharArray();  //['h','i','t']
            replacedCharArray[i] = ch;  // ['a','i','t'],...
           
            String replacedWord = new String(replacedCharArray); // convert in string

            if(st.contains(replacedWord)== true){
                st.remove(replacedWord);
                q.add(new pair(replacedWord,steps+1));
            }
        }
    }
  }
  return 0;
        
    }
}
