class Solution {
        public String minWindow(String s, String t) {

                int[] need = new int[128];
                        int[] window = new int[128];

                                // Store frequency of characters in t
                                        for (char c : t.toCharArray()) {
                                                    need[c]++;
                                                            }

                                                                    int left = 0;
                                                                            int right = 0;

                                                                                    int count = 0;
                                                                                            int minLength = Integer.MAX_VALUE;
                                                                                                    int start = 0;

                                                                                                            while (right < s.length()) {

                                                                                                                        char c = s.charAt(right);
                                                                                                                                    window[c]++;

                                                                                                                                                // Character is required and its required frequency is satisfied
                                                                                                                                                            if (need[c] > 0 && window[c] <= need[c]) {
                                                                                                                                                                            count++;
                                                                                                                                                                                        }

                                                                                                                                                                                                    // Window is valid
                                                                                                                                                                                                                while (count == t.length()) {

                                                                                                                                                                                                                                // Update minimum window
                                                                                                                                                                                                                                                if (right - left + 1 < minLength) {
                                                                                                                                                                                                                                                                    minLength = right - left + 1;
                                                                                                                                                                                                                                                                                        start = left;
                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                        char leftChar = s.charAt(left);
                                                                                                                                                                                                                                                                                                                                        window[leftChar]--;

                                                                                                                                                                                                                                                                                                                                                        // Removing a required character makes window invalid
                                                                                                                                                                                                                                                                                                                                                                        if (need[leftChar] > 0 &&
                                                                                                                                                                                                                                                                                                                                                                                            window[leftChar] < need[leftChar]) {
                                                                                                                                                                                                                                                                                                                                                                                                                count--;
                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                left++;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                        right++;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (minLength == Integer.MAX_VALUE) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    return "";
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    return s.substring(start, start + minLength);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
