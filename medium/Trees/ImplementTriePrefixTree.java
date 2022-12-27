
class TrieNode{
    /*concept -> the reason why trie is very efficient because
     each trie node has an ARRAY of trie objects(all 26 possiblities in the array), so jumping from one character
          to the other while searching ALWAYS hapens linearly*/
    private final Integer R = 26;

    private TrieNode links[];
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char c){
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c){
        return links[c-'a'];
    }

    public void put(char c, TrieNode node){
        links[c-'a'] = node;
    }
    public boolean isEnd(){
        return isEnd;
    }
    public void setEnd(){
        isEnd = true;
    }


}
public class ImplementTriePrefixTree {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containsKey(c)){
                node = node.get(c);
            }
            else{
                return false;
            }
        }
        return node.isEnd();
    }

    public boolean startsWith(String word) {
        TrieNode node = root;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containsKey(c)){
                node = node.get(c);
            }
            else{
                return false;
            }
        }
        return true;
    }

}
