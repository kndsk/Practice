package algorithm;

/**
 * @Auther: liuyao
 * @Date: 2019/1/15 10:08
 * @Description:冒泡排序，时间复杂度n^2
 */
public class BubbleSort {

    /**
     *  冒泡法排序
     *  比较相邻的元素。如果第一个比第二个小，就交换他们两个。
     *  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最小的数。
     *  针对所有的元素重复以上的步骤，除了最后一个。
     *  持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

     *
     * @param numbers
     *            需要排序的整型数组
     */
    public static void bubbleSortSc(int[] numbers) {
        int temp; // 记录临时中间值
        int size = numbers.length; // 数组大小
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) { // 交换两数的位置

                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void main(String []args){
        System.out.println("Hello World");
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        bubbleSortSc(a);
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }

    }

}
