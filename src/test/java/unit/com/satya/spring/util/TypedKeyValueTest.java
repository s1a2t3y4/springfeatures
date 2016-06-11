 

package unit.com.satya.spring.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sca.configuration.service.util.TypedKeyValue;

 

public final class TypedKeyValueTest {
	@Test
	public void testConstructor() {
		TypedKeyValue<String, Integer> keyValue = new TypedKeyValue<String, Integer>(
				"abc", 123);

		assertTrue(keyValue.getKey().equals("abc"));
		assertTrue(keyValue.getValue() == 123);
	}

	@Test
	public void testToString() {
		TypedKeyValue<String, Integer> keyValue = new TypedKeyValue<String, Integer>(
				"abc", 123);

		assertTrue("abc 123".equals(keyValue.toString()));

		keyValue = new TypedKeyValue<String, Integer>("abc", null);

		assertTrue("abc ".equals(keyValue.toString()));

	}

	@Test
	public void testEquals() {
		TypedKeyValue<String, Integer> keyValue = new TypedKeyValue<String, Integer>(
				"abc", 123);

		assertTrue(keyValue.equals(new TypedKeyValue<String, Integer>(
				"abc", 123)));

		assertTrue(!keyValue.equals("abc 123"));

		keyValue = new TypedKeyValue<String, Integer>("abc", null);

		assertTrue(keyValue.equals(new TypedKeyValue<String, Integer>("abc", null)));

	}

}