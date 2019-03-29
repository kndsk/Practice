package redis;


import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by liuyang on 2017/4/20.
 */
public class Test {

	  public static void main(String[] args) {
	    	//sortSet排序
		  JedisUtil jedisUtil= JedisUtil.getInstance();

		  JedisUtil.SortSet sortSet=jedisUtil.new SortSet();
		  sortSet.zadd("userRank",20,"lili");
		  sortSet.zadd("userRank",30,"lili2");
		  sortSet.zadd("userRank",40,"lili3");
		  sortSet.zadd("userRank",50,"lili4");
		  sortSet.zadd("userRank",70,"lili6");
		  sortSet.zadd("userRank",60,"lili5");

		  Long data = sortSet.zrevrank("userRank","lili");
		  System.out.println("lili排名为："+(data+1));

		  //前3名
		  Set<String> dd = sortSet.zrevrange("userRank",0,2);
		  for (String str : dd) {
			  System.out.println(str);
		  }

	  }
	  

}
