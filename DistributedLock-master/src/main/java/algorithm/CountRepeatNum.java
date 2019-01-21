package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: liuyao
 * @Date: 2019/1/21 15:18
 * @Description:
 */
public class CountRepeatNum {

    public static void main(String []args){
        System.out.println("Hello World");
        Integer[] a = {12,20,15,16,15,12,30,45,23,20};
        array1(a);

    }

    /**
     * 
     * 功能://统计数组中重复元素的个数
     * @param array
     * void
     */
    public static void array1(Integer[] array){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            Integer integer = map.get(array[i]);
            map.put(array[i], integer == null?1:integer+1);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }
LinkedList<String> li;
}
