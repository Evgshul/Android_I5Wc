package org.jtm;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * JUnit test, which will run inside IDE
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 * Note that GUI objects are not created for these tests.
 */
public class JUnitTest {


    @Test
    public void testConstructor() {
        MainActivity test = new MainActivity();
        assertNotNull(test);
        assertEquals("Red color is not set to 0 at the start", 0, test.getRedBar());
        assertEquals("Green color is not set to 0 at the start", 0, test.getGreenBar());
        assertEquals("Blue color is not set to 0 at the start", 0, test.getBlueBar());
    }

}