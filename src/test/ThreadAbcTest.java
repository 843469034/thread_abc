package test;

/**
 * Created by Administrator on 2019/1/29.
 */

public class ThreadAbcTest {

    public static void main(String[] args) {
        Thread a = new Thread(new Task("A", 0));
        Thread b = new Thread(new Task("B", 1));
        Thread c = new Thread(new Task("C", 2));
        a.start();
        b.start();
        c.start();
    }

    static class Task implements Runnable {

        private String one;
        private int count;
        private static int num = 0;//这步很关键  staitc  让变量资源共享给所有对象

        public Task(String one, int count) {
            this.one = one;
            this.count = count;
        }

        @Override
        public void run() {

            int i = 0;
            while (i < 10) {
                synchronized (Task.class) {
                    if (num % 3 == count) { //每3次循环
                        num++;
                        System.out.println(one+"    num: "+num);
                    } else {
                        continue;
                    }
                }
                i++;
            }
        }
    }
}