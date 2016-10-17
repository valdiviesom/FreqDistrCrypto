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
        int x;
        for (int i = 0; i < data.length(); i++) {
            x = ((int) data.charAt(i)) - 97;
            if (x >= 0 && x < 26) {
                counts[x]++;
                size++;
            }
        }
    }

    public int get(char letter) {
        String s = new String();
        s = s.concat(String.valueOf(letter)).toLowerCase();
        int x = ((int) s.charAt(0)) - 97;
        if (x < 0 || x > 26) throw new IllegalArgumentException();
        return counts[x];
    }

    public void set(char letter, int value) {
        String s = new String();
        s = s.concat(String.valueOf(letter)).toLowerCase();
        int x = ((int) s.charAt(0)) - 97;
        if (x < 0 || x > 26) throw new IllegalArgumentException();
        size -= counts[x];
        counts[x] = value;
        size += counts[x];
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
        String s = new String();
        s = s.concat(String.valueOf(letter)).toLowerCase();
        int x = ((int) s.charAt(0)) - 97;
        if (x < 0 || x > 26) throw new IllegalArgumentException();
        return ((double) get(letter) / (double) size);
    }

}
