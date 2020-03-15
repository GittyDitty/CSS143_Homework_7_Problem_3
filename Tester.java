import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class Tester{

    @Test
    public void insertAutoTest(){
        Trie tester = new Trie();
        tester.insert("hello");
        tester.insert("high");
        tester.insert("seattle");
        tester.insert("seatac");
        tester.insert("see");
        tester.insert("hollow");
        tester.insert("how");

        List<String> results = tester.autoComplete("h");
        List<String> expected = Arrays.asList("hello", "high", "hollow", "how");
        assertEquals(expected, results);

        List<String> results2 = tester.autoComplete("se");
        List<String> expected2 = Arrays.asList("seatac", "seattle", "see");
        assertEquals(expected2, results2);

        List<String> results3 = tester.autoComplete("sea");
        List<String> expected3 = Arrays.asList("seatac", "seattle");
        assertEquals(results3, expected3);

        List<String> results4 = tester.autoComplete("ho");
        List<String> expected4 = Arrays.asList("hollow", "how");
        assertEquals(results4, expected4);

        List<String> results5 = tester.autoComplete("xyz");
        List<String> expected5 = new ArrayList();
        assertEquals(results5, expected5);
    }

}
