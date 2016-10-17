/**
 * Created by Mauricio on 10/8/2016.
 */
public class LetterInventory {
    public int[] counts;
    private int size;
    private static final int DEFAULT_SIZE = 26;

    public LetterInventory() {

        counts = new int[DEFAULT_SIZE];
    }

    public LetterInventory(String data) {
        counts = new int[DEFAULT_SIZE];
        size = 0;
        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            int x = lowerAscii(data.charAt(i));
            if (x != -1) counts[x]++;
        }
        size = data.length();
    }

    public static int lowerAscii(char c) {
        int x = (int) c;
        if (x == 32) return -1; // space
        if (x > 64 && x < 91) { // uppercase char
            x -= 65;
            return x;
        }
        if (x > 96 && x < 123) { // lowercase char
            x -= 97;
            return x;
        }
        throw new IllegalArgumentException();
    }

    // get count at letter
    public int get(char letter) {
        int x = lowerAscii(letter);
        if (x != -1) return counts[x];
        throw new IllegalArgumentException();
    }

    public void set(char letter, int value) {
        int x = lowerAscii(letter);
        if (x != -1) {
            size -= counts[x];
            size += value;
            counts[x] = value;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int size() {
        return size;
    }

    public String toString() {
        String rsf;
        if (size == 0) return "[]";
        rsf = "[";
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < counts[i]; j++) {
                rsf = rsf.concat(String.valueOf(((char) (i + 97))));
            }
        }
        rsf = rsf.concat("]");
        return rsf;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LetterInventory add(LetterInventory other) {
        if (other.isEmpty()) return this;
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            counts[i] += other.counts[i];
        }
        size += other.size();
        return this;
    }

    public LetterInventory substract(LetterInventory other) {
        if (other.isEmpty()) return this;
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            counts[i] -= other.counts[i];
            if (counts[i] < 0) return null;
        }
        size -= other.size();
        return this;
    }

    public double getLetterPercentage(char letter) {
        int x = lowerAscii(letter);
        if (x != -1) {
            return (double) get(letter) / (double) size;
        }
        throw new IllegalArgumentException();
    }

}
