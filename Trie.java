import java.util.*;
import java.util.Map.Entry;

public class Trie{

    private TrieNode root;

    public Trie(){
        root = new TrieNode('-'); //filler character
    }

    public void insert(String wordToInsert){
        TrieNode current = root;
        for(char letter : wordToInsert.toCharArray()){
            if(current.getChildren().containsKey(letter)){
                current = current.getChildren().get(letter);
            } else{
                TrieNode node = new TrieNode(letter);
                current.getChildren().put(letter,node);
                current = node;
            }
        }
        current.setIsEnd(true);
    }

    public List<String> autoComplete(String prefix){

        StringBuilder builder = new StringBuilder();
        TrieNode current = root;
        for(char letter : prefix.toCharArray()){
            if(!current.getChildren().containsKey(Character.toUpperCase(letter)) &&
               !current.getChildren().containsKey(Character.toLowerCase(letter))) {
                return Collections.emptyList();
            }
            if(current.getChildren().get(Character.toUpperCase(letter)) != null){
                current = current.getChildren().get(Character.toUpperCase(letter));
                builder.append(Character.toUpperCase(letter));
            }else{
                current = current.getChildren().get(Character.toLowerCase(letter));
                builder.append(Character.toLowerCase(letter));
            }
        }
        if(current.getChildren().entrySet().isEmpty()){
            return Collections.singletonList(prefix);
        }
        return getAllWords(current, builder.toString());
    }

    private List<String> getAllWords(TrieNode current, String prefix){
        List<String> results = new ArrayList<>();
        for(Entry<Character, TrieNode> map : current.getChildren().entrySet()){
            if(map.getValue().isEnd()){
                results.add(prefix + map.getValue().getLetter());
            }
            results.addAll(getAllWords(map.getValue(), prefix + map.getValue().getLetter()));
        }
        Collections.sort(results); //this really isn't needed
        return results;
    }


}

