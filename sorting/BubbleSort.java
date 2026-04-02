public class BubbleSort {

    // 冒泡排序（升序）
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // 提前结束优化
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // 如果一轮没有交换，说明已经有序
            if (!swapped) break;
        }
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        bubbleSort(arr);

        System.out.print("排序结果: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
