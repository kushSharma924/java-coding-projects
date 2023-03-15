import java.util.*;
public class MorseCode {
    private final String   alphabet = "abcdefghijklmnopqrstuvwxyz1234567890 ";
    private final String[] morse    = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "|"};
    private HashMap<String, String> toText;
    private HashMap<String, String> toCode;
    public MorseCode() {
        toText = new HashMap<String, String>();
        toCode = new HashMap<String, String>();
        for (int i = 0; i < alphabet.length(); i++) {
            toText.put(morse[i], alphabet.substring(i, i + 1));
            toCode.put(alphabet.substring(i, i + 1), morse[i]);
        }
    }
    public String encode(String s) {
        Scanner parser = new Scanner(s);
        String ans = "";
        while (parser.hasNext()) {
            String word = parser.next();
            for (int i = 0; i < word.length(); i++) {
                ans += toCode.get(word.substring(i, i + 1)) + " ";
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public String decode(String s) {
        Scanner parser = new Scanner(s);
        String ans = "";
        while (parser.hasNext()) {
            String code = parser.next();
            ans += toText.get(code);
        }
        return ans;
    }
}
