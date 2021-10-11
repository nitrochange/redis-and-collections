import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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

        redis.clear();

    }

    @Test
    public void testDeletefromMap() {

        Map<String, Integer> redis = new RediskaMap<>();

        redis.put("key2345", 34534);
        Assert.assertEquals(Integer.valueOf(34534),redis.get("key2345"));

        redis.remove("key2345");
        Assert.assertNull(redis.get("key2345"));

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

        redis.remove("key");

        Assert.assertFalse(redis.containsKey("key"));
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


    @Test
    public void testKeySetAndValues() {
        Map<String, Integer> redis = new RediskaMap<>();

        redis.put("Key1", 10);
        redis.put("Key2", 32);
        redis.put("Key3", 54);
        redis.put("Key4", 76);


        List<String> keys = new ArrayList<>(redis.keySet());
        List<String> trueKeys = new ArrayList<>();
        List<Integer> trueValues = new ArrayList<>();

        trueKeys.add("Key1");
        trueKeys.add("Key2");
        trueKeys.add("Key3");
        trueKeys.add("Key4");

        trueValues.add(10);
        trueValues.add(32);
        trueValues.add(54);
        trueValues.add(76);

        Collections.sort(keys);
        Collections.sort(trueValues);

        Assert.assertArrayEquals(trueKeys.toArray(), keys.toArray());

        List<Integer> sortedValues = new ArrayList<>();
        sortedValues.addAll(redis.values());
        Collections.sort(sortedValues);

        Assert.assertArrayEquals(trueValues.toArray(),
                sortedValues.toArray());
    }

    @Test
    public void testEntrySet() {
    }
}
