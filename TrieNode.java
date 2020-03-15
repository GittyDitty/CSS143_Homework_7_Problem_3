import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private char letter;
    private Map<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode(char letter){
        this.letter = letter;
        this.children = new HashMap<>();
    }

    public char getLetter(){
        return letter;
    }

    @Override //for general testing
    public String toString(){
        return Character.toString(letter);
    }

    public Map<Character, TrieNode> getChildren(){
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children){
        this.children = children;
    }

    public boolean isEnd(){
        return isEndOfWord;
    }

    public void setIsEnd(boolean endOfWord){
        isEndOfWord = endOfWord;
    }
}
