package config;
import redis.clients.jedis.Jedis;
//implement a singleton pattern for Jedis instance
public class Redis {
    private static Jedis redis;

    public Redis(Jedis redis) {
        this.redis = redis;
    }

    public static Jedis getRedis() {
        return redis;
    }
}
