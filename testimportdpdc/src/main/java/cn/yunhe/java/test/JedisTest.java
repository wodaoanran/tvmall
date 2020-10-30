package cn.yunhe.java.test;

//import redis.clients.jedis.Client;


import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis client =new Jedis("192.168.68.56",6379);
        client.auth("123456");
//        client.set("spring","我在用spring");

        System.out.println(client.get("spring"));
    }
}
