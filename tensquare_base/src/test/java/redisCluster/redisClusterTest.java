package redisCluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/4/23 10:23
 */
public class redisClusterTest {

    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(1);
        // 最大空闲数
        poolConfig.setMaxIdle(1);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("47.102.125.192", 7001));
        nodes.add(new HostAndPort("47.102.125.192", 7002));
        nodes.add(new HostAndPort("47.102.125.192", 7003));
        nodes.add(new HostAndPort("47.102.125.192", 7004));
        nodes.add(new HostAndPort("47.102.125.192", 7005));
        nodes.add(new HostAndPort("47.102.125.192", 7006));
        JedisCluster cluster = new JedisCluster(nodes, poolConfig);
        cluster.rpush("YUMG","yumg");
        System.out.println(cluster.lpop("YUMG"));
        try {
            cluster.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
