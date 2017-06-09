
package collections.map.hashmap;

import collections.map.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class HashMapTest {

    private Map<String, String> map;

    @Before
    public void init(){
        this.map = new HashMap();
    }

    @After
    public void free(){
        this.map = null;
    }

    @Test
    public void put() throws Exception {
        String key = "key";
        String key1 = "key1";
        String key2 = "key2";
        String key3 = null;
        String value = "value";

        map.put(key, value);
        map.put(key1, value);
        map.put(key2, value);
        map.put(key3, value);

        String v1 =  map.get(key);
        String v2 =  map.get(key1);
        String v3 =  map.get(key2);
        String v4 =  map.get(key3);

        assertEquals("value", v1);
        assertEquals("value", v2);
        assertEquals("value", v3);
        assertEquals("value", v4);


        String kd = "abcd";
        String val1 = "val1";
        String val2 = "val2";

        map.put(kd, val1);
        map.put(kd, val2);

        assertEquals(val2, map.get(kd));
    }

    @Test
    public void get() throws Exception {
        map.put("kg1", "vg1");
        map.put("kg2", "vg2");
        map.put("kg3", "vg3");
        map.put("kg4", "vg4");
        map.put("kgc", "vgc");
        map.put("kgc", "vgc2");


        assertNotNull(map.get("kg1"));
        assertNotNull(map.get("kg2"));
        assertNotNull(map.get("kg3"));
        assertNotNull(map.get("kg4"));
        assertNotNull(map.get("kgc"));

        assertEquals("vg1", map.get("kg1"));
        assertEquals("vg2", map.get("kg2"));
        assertEquals("vg3", map.get("kg3"));
        assertEquals("vg4", map.get("kg4"));
        assertEquals("vgc2", map.get("kgc"));

        map.clear();
        assertNull(map.get("kg4"));
    }

    @Test
    public void remove() throws Exception {
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");

        map.remove("k1");
        assertEquals(3, map.size());

        map.remove("k1");
        assertEquals(3, map.size());

        assertNull(map.get("k1"));
        assertNotNull(map.get("k2"));

        map.remove("randomKey:rngm2ireeberbewr");
        assertEquals(3, map.size());

        map.clear();
        map.remove("randomKey2:weopbn4iorjhnio345jio34ji4");
        assertEquals(0, map.size());

    }

    @Test
    public void size() throws Exception {
        assertEquals(0, map.size());

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        assertEquals(4, map.size());

        map.clear();
        assertEquals(0, map.size());

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        map.remove("key1");

        assertEquals(3, map.size());

        map.remove("key2");
        assertEquals(2, map.size());

        map.remove("key3");
        assertEquals(1, map.size());

        map.remove("key3");
        assertEquals(1, map.size());

        map.remove("key4");
        assertEquals(0, map.size());

        map.remove("key4");
        assertEquals(0, map.size());

        map.remove("nokey");
        assertEquals(0, map.size());
    }

    @Test
    public void clear() throws Exception {
        map.put("key", "value");
        assertFalse(map.empty());

        map.clear();
        assertTrue(map.empty());
    }

    @Test
    public void empty() throws Exception {
        assertTrue(map.empty());

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        assertFalse(map.empty());

        map.clear();

        assertTrue(map.empty());
    }

    @Test
    public void containsKey() throws Exception {
        assertFalse(map.containsKey("eeglweioroj"));

        map.put("asd", "wfebe");
        assertTrue(map.containsKey("asd"));

        map.put("aaa111", "qwer");
        map.put("aaa111", "newval");
        assertTrue(map.containsKey("asd"));
        assertTrue(map.containsKey("aaa111"));

        map.remove("asd");
        assertFalse(map.containsKey("asd"));
        assertTrue(map.containsKey("aaa111"));


        map.clear();
        assertFalse(map.containsKey("anykey"));
    }

    @Test
    public void containsValue() throws Exception {
        assertFalse(map.containsValue("randomValue"));

        map.put("k1", "value1");
        assertTrue(map.containsValue("value1"));

        map.put("aaa111", "oldValue");
        map.put("aaa111", "newValue");
        assertTrue(map.containsValue("value1"));
        assertTrue(map.containsValue("newValue"));

        map.remove("k1");
        assertFalse(map.containsValue("value1"));
        assertTrue(map.containsValue("newValue"));


        map.clear();
        assertFalse(map.containsValue("anyvalue"));
    }

    @Test
    public void nulls(){
        map.put(null, "value");
        assertEquals("value", map.get(null));
        map.clear();

        map.put("key", null);
        assertNull(map.get("key"));
        map.clear();

        map.put(null, "value1");
        map.put(null, "value2");
        assertEquals("value2", map.get(null));
        map.clear();

        map.put("key", null);
        assertNull(map.get("key"));
        map.put("key", "value");
        assertEquals("value", map.get("key"));
        map.put("key", null);
        assertEquals(null, map.get("key"));

    }
}