package algorithm;

import java.util.LinkedList;

/**
 * @Auther: liuyao
 * @Date: 2019/1/15 09:34
 * @Description:java算法50个人围成一圈数到三和三的倍数时出圈，问剩下的人是谁？在原来的位置是多少？
 */
public class WeiQuan {

    public static int removeNM(int n, int m) {
        LinkedList ll = new LinkedList();
        //初始化数据
        for(int i = 0; i < n; i++) {
            ll.add(new Integer(i + 1));
        }

        //删除3的倍数，求最后一个
        int removed = -1;
        while (ll.size() > 1) {
            removed = (removed + m) % ll.size();
            ll.remove(removed--);
        }
        return ((Integer) ll.get(0)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(removeNM(50, 3));
    }
}
