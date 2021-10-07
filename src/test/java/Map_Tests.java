import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Map_Tests {

    @Before
    public void configure() {
    }

    @Test
    public void testSimpleMapStorage() {

        Map<String, Integer> redis = new RediskaMap<>();
        Map<String, Integer> testData = new HashMap<>();

        testData.put("Key1", 10);
        testData.put("Key2", 32);
        testData.put("Key3", 54);
        testData.put("Key4", 76);

        // we should not use putAll method because
        // in this test we want only test simple put method
        //redis.putAll(testData);
        redis.put("Key1", testData.get("Key1"));
        redis.put("Key2", testData.get("Key2"));
        redis.put("Key3", testData.get("Key3"));
        redis.put("Key4", testData.get("Key4"));

        Assert.assertEquals(testData.get("Key1"), redis.get("Key1"));
        Assert.assertEquals(testData.get("Key2"), redis.get("Key2"));
        Assert.assertEquals(testData.get("Key3"), redis.get("Key3"));
        Assert.assertEquals(testData.get("Key4"), redis.get("Key4"));

    }

    @Test
    public void testDeletefromMap() {

        Map<String, Integer> redis = new RediskaMap<>();

        redis.put("key234", 34534);
        Assert.assertEquals(redis.get("key234"), Integer.valueOf(34534));

        redis.remove("key234");
        Assert.assertNull(redis.get("key234"));

    }

    @Test
    public void testSizeAndIsEmpty(){

        Map<String, Integer> redis = new RediskaMap<>();

        Assert.assertTrue(redis.isEmpty());
        Assert.assertEquals(redis.size(), 0);

        redis.put("key2", 34543454);
        redis.put("key3", 489568);

        Assert.assertFalse(redis.isEmpty());
        Assert.assertEquals(redis.size(), 2);

        redis.remove("key2");

        Assert.assertFalse(redis.isEmpty());
        Assert.assertEquals(redis.size(), 1);

        redis.remove("key3");

        Assert.assertEquals(redis.size(), 0);
        Assert.assertTrue(redis.isEmpty());
    }

    @Test
    public void testContainsKeyAndContainsValue() {

        Map<String, Integer> redis = new RediskaMap<>();

        redis.put("key", 10);

        Assert.assertTrue(redis.containsKey("key"));
        Assert.assertTrue(redis.containsValue(10));

        redis.remove("key");

        Assert.assertFalse(redis.containsKey("key"));
        Assert.assertFalse(redis.containsValue(10));
    }

    @Test
    public void testPutAllAndClear() {
        Map<String, Integer> redis = new RediskaMap<>();
        Map<String, Integer> testData = new HashMap<>();

        testData.put("Key1", 10);
        testData.put("Key2", 32);
        testData.put("Key3", 54);
        testData.put("Key4", 76);

        redis.putAll(testData);

        Assert.assertEquals(testData.get("Key1"), redis.get("Key1"));

        redis.clear();

        Assert.assertTrue(redis.isEmpty());
        Assert.assertNull(redis.get("Key1"));

    }

    //TODO дописать KeySet
    @Test
    public void testKeySetAndValues() {
        Map<String, Integer> redis = new RediskaMap<>();
        Map<String, Integer> testData = new HashMap<>();

        testData.put("Key1", 10);
        testData.put("Key2", 32);
        testData.put("Key3", 54);
        testData.put("Key4", 76);

        Assert.assertArrayEquals(redis.values().toArray(new Integer[0]),
                testData.values().toArray(new Integer[0]) );


    }

    @Test
    public void testEntrySet() {
        //TODO реализовать
    }
}
