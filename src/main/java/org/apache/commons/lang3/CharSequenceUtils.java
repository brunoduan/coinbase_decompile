package org.apache.commons.lang3;

public class CharSequenceUtils {
    static boolean regionMatches(CharSequence cs, boolean ignoreCase, int thisStart, CharSequence substring, int start, int length) {
        if ((cs instanceof String) && (substring instanceof String)) {
            return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
        }
        return cs.toString().regionMatches(ignoreCase, thisStart, substring.toString(), start, length);
    }
}
