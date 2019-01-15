package algorithm;

/**
 * @Auther: liuyao
 * @Date: 2019/1/15 09:37
 * @Description: 寻找字符数组中某个子集的索引
 */
public class IndexOfSc {
    public static void main(String[] args){
        char []str=new char[]{'a','b','c','d'};
        char []s=new char[]{'b','c'};
        int num = indexOfLy(str,0,str.length,s,0,s.length,0);
        System.out.println(num);
    }

    /**
     *
     * @param source          原字符数组
     * @param sourceOffset    开始位置
     * @param sourceCount     原字符数组长度
     * @param target          目标字符串
     * @param targetOffset    开始位置
     * @param targetCount     目标字符串长度
     * @param fromIndex       搜索位置
     * @return
     */
    public static int indexOfLy(char[] source, int sourceOffset, int sourceCount,
                                char[] target, int targetOffset, int targetCount,
                                int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]== target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
}
