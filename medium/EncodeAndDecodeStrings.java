public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String char258 = Character.toString((char) 258);
        if(strs.size() == 0){
            return char258;
        }
        StringBuilder output = new StringBuilder();
        String delimiter = Character.toString((char) 257);
        for(String currentString : strs){
            output.append(currentString);
            output.append(delimiter);
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String char258 = Character.toString((char) 258);
        if(s.equals(char258)){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList();
        StringBuilder current = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == (char) 257){
                result.add(current.toString());
                current = new StringBuilder();
            }
            else {
                current.append(Character.toString(c));
            }
        }
        result.add(current.toString());
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));