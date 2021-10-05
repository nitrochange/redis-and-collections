import config.Redis;
import redis.clients.jedis.Jedis;

public class Main {

    private static boolean set() {
        return false;
    }

    private static void loadConfig(String path){
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("key", "value");
        System.out.println(jedis.get("key"));
    }
}
