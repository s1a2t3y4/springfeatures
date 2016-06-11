 
package unit.com.satya.spring.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Properties;

import org.junit.Test;

import com.satya.springfeatures.util.Utils;

 
public class UtilsTest {
    @Test
    public void testIsNothing()
    {
        assertTrue(Utils.isNothing(" "));
        assertTrue(!Utils.isNothing("a"));
        assertTrue(Utils.isNothing(""));
        assertTrue(Utils.isNothing("\t"));
    }
    
    @Test
    public void testCapFirtsChar()
    {
        assertTrue(Utils.capFirstChar(null) == null);

        assertTrue("   ".equals(Utils.capFirstChar("   ")));

        assertTrue("This is a test"
                .equals(Utils.capFirstChar("this is a test")));

        assertTrue("  this is a test  ".equals(Utils
                .capFirstChar("  this is a test  ")));
    }
    
    
    @Test
    public void testStr2Properties()
    {
        Properties props = Utils.str2Properties(null);
        
        assertNotNull(props);
        
        assertTrue(props.isEmpty());
        
        props = Utils.str2Properties("\t\n");
        
        assertTrue(props.isEmpty());
        
        props = Utils.str2Properties("abcd");
        
        assertTrue("".equals(props.getProperty("abcd")));
        
        props = Utils.str2Properties("prop1=value1, prop2=value2");
        
        assertTrue("value1".equals(props.getProperty("prop1")));
        assertTrue("value2".equals(props.getProperty("prop2")));
        
        props = Utils.str2Properties("prop1=\"value1\", prop2=value2");
        
        assertTrue("\"value1\"".equals(props.getProperty("prop1")));
        assertTrue("value2".equals(props.getProperty("prop2")));
        
        props = Utils.str2Properties("   {prop12=value12, prop21=value21}  ");
        
        assertTrue("value12".equals(props.getProperty("prop12")));
        assertTrue("value21".equals(props.getProperty("prop21")));

    }
    
    @Test
    public void testMakeString()
    {
        assertTrue("".equals(Utils.makeString(null)));
        
        assertTrue("  ".equals(Utils.makeString("  ")));
        
        assertTrue("123".equals(Utils.makeString(123)));
        
        assertTrue("123".equals(Utils.makeString("123")));
    }
    
    @Test
    public void testStr2BelongsTo()
    {
        assertFalse(Utils.str2BelongsTo("abc, 123", "456", ",", true));
        
        assertTrue(Utils.str2BelongsTo("abc, 123", "123", ",", true));
        
        assertFalse(Utils.str2BelongsTo("aBc, 123", "abc", ",", false));
        
        assertTrue(Utils.str2BelongsTo("aBc, 123", "abc", ",", true));
    }
    
    @Test
    public void testCompareToNulls()
    {
        assertTrue(Utils.compare(null, null) == 0);
        
        assertTrue(Utils.compare(1, null) == 1);
        
        assertTrue(Utils.compare(null, 1) == -1);
    }

    
    @Test
    public void testCompareToInt()
    {
        assertTrue(Utils.compare(2, 1) == 1);
        
        assertTrue(Utils.compare(2, 2) == 0);
        
        assertTrue(Utils.compare(1, 2) == -1);
    }

    @Test
    public void testCompareToDates()
    {
        Date now = new Date();
        
        assertTrue(Utils.compare(now, new Date(now.getTime() - 1000)) == 1);
        
        assertTrue(Utils.compare(now, now) == 0);
        
        assertTrue(Utils.compare(now, new Date(now.getTime() + 1000)) == -1);
    }
    
    @Test
    public void testDateConverter()
    {
        assertTrue(Utils.date2Str(
                Utils.str2Date("01/02/2010", null, "MM/dd/yyyy"), "MM/dd/yyyy")
                .equals("01/02/2010"));
    }
    
    @Test
    public void testGetDefaultTimeZone()
    {
        assertNotNull(Utils.getDefaultTimeZone());
    }

    @Test
    public void testGetStackTraceAsString()
    {
        try {
            throw new Exception("this is a test");
        }
        catch (Exception ex) {
            assertTrue(Utils.getStackTraceAsString(ex).contains("this is a test"));
        }
    }
    
}
