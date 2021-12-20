package Test;

import logic.TreeBinary;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TreeBinaryTest {
    private TreeBinary<Integer> bts;

    void setup(){
        bts = new TreeBinary<>((numOne,numTwo) -> Integer.compare( numOne,numTwo));
        bts.addNode(50 );
        bts.addNode(10 );
        bts.addNode(69 );
        bts.addNode(5 );
        bts.addNode(34 );
        bts.addNode(57 );
        bts.addNode(18 );
        bts.addNode(40 );
        bts.addNode(63 );
    }

    @Test
    void testFindNode(){
        setup();
        assertNotNull( bts.findNode( 50 ) );
        assertNotNull( bts.findNode( 5 ) );
        assertNotNull( bts.findNode( 63 ) );
        assertEquals(50, bts.findNode( 50).getInfo());
        assertNull( bts.findNode(54 ) );
    }

    @Test
    void isEmpty() {
        assertTrue(bts.isEmpty());
        setup();
        assertFalse(bts.isEmpty());
    }

}