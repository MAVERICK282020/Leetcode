import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index,
                           List<String> parts, List<String> result) {

        // Exactly 4 segments must use all digits
        if (parts.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        // Try segments of length 1, 2, or 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;
            }

            String segment = s.substring(index, index + len);

            // No leading zeros
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                break;
            }

            // Value must be between 0 and 255
            if (Integer.parseInt(segment) > 255) {
                break;
            }

            parts.add(segment);
            backtrack(s, index + len, parts, result);
            parts.remove(parts.size() - 1); // Backtrack
        }
    }
}