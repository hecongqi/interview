package google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 谷歌面试题
 * 给了一些消息 和对应的日期和时间, 如果消息并不在最近10秒钟内打印过 那么就打印. 同时有可能多条消息到达(1秒之内).
 */
public class PrintMessage {

    Map<Integer,Long> map = new HashMap<>();

    public void printMessage(long time, String msg){
        if(!map.isEmpty()){
            //哈希一下，可以减小内存占用
            int hash = msg.hashCode();
            long current = System.currentTimeMillis();
            //此处也是为了减少内存占用
            map.entrySet().removeIf(entry -> current - entry.getValue() > 10 * 1000);
            if(!map.containsKey(hash)){
                map.put(hash,current);
                System.out.println(msg);
            }
        }
    }
}
