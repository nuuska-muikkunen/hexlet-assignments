package exercise;

import java.lang.CharSequence;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;
    ReversedSequence(String string) {
        StringBuilder temp = new StringBuilder(string);
        this.str = temp.reverse().toString();
    }
    @Override
    public int length() {
        return this.str.length();
    }

    @Override
    public char charAt(int index) {
        return this.str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.str.subSequence(start, end);
    }
    @Override
    public String toString() {
        return this.str;
    }
}
// END
