import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mauricio on 10/8/2016.
 */
public class LetterInventoryTest {
    LetterInventory li;

    @org.junit.Before
    public void setUp() throws Exception {
        String data = "aaaZ";
        li=new LetterInventory(data);
    }

    @Test
    public void initTest(){
        System.out.println(li.toString());
        li=new LetterInventory("asd fDsdf");
        System.out.println(li.toString());
    }

    @org.junit.Test
    public void testGet() throws Exception {
        char a='a';
        assertEquals(3,li.get(a));
    }

    @org.junit.Test
    public void testSet() throws Exception {
        char a='a';
        li.set(a,8);
        assertEquals(8,li.get(a));
    }

    @org.junit.Test
    public void testSize() throws Exception {
        assertEquals(4,li.size());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        String data = "aaaZ";
        System.out.println(li.toString());
    }

    @org.junit.Test
    public void testIsEmpty() throws Exception {
        assertFalse(li.isEmpty());
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        String data2="bc";
        LetterInventory other = new LetterInventory(data2);
        li.add(other);
        assertEquals(3,li.get('a'));
        assertEquals(1,li.get('b'));
    }


    @org.junit.Test
    public void testGetLetterPercentage() throws Exception {
        assertEquals(li.get('A'),3);
        assertEquals(li.size(),4);
        assertEquals(0.75,li.getLetterPercentage('a'),0.01);
    }
}