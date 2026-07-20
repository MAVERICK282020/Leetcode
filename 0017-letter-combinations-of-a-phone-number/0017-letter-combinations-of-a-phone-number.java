import java.util.*;

class Solution {
    List<String> ans = new ArrayList<>();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return ans;
        dfs(digits, 0, "");
        return ans;
    }

    void dfs(String d, int i, String s) {
        if (i == d.length()) {
            ans.add(s);
            return;
        }
        for (char c : map[d.charAt(i) - '0'].toCharArray())
            dfs(d, i + 1, s + c);
    }
}