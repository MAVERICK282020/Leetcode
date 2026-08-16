class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Digit
            if (c >= '0' && c <= '9') {
                digitSeen = true;

                if (exponentSeen) {
                    digitAfterExponent = true;
                }
            }

            // Dot
            else if (c == '.') {

                // Dot cannot come after exponent
                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // e or E
            else if (c == 'e' || c == 'E') {

                // e needs a number before it
                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                digitAfterExponent = false;
            }

            // + or -
            else if (c == '+' || c == '-') {

                // Sign is valid only at beginning
                // OR immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e'
                           && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Anything else
            else {
                return false;
            }
        }

        return digitSeen && digitAfterExponent;
    }
}