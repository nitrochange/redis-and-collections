import config.Redis;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static boolean set() {
        return false;
    }

    private static void loadConfig(String path){
    }

    private static long loadList(Jedis jedis, String key, List<String> values) {

        String[] arr = values.toArray(new String[0]);
        return jedis.lpush(key, arr);

    }

    public static void main(String[] args) {

        Map<String, Integer> mp = new RediskaMap<>();
        //System.out.println(mp.put("key1", 10));
        mp.put("key1", 10);
        System.out.println(mp.get("key1"));


    }
}
