package test;

/**
 * Created by Administrator on 2019/2/11.
 */
public class ThreadAbcTestMy {
    public  static  void  main(String[] args){
        Thread A = new Thread(new Task("A",0));
        Thread B = new Thread(new Task("B",1));

        Thread C = new Thread(new Task("C",2));
        A.start();
        B.start();
        C.start();
    }


    static class Task implements  Runnable{
        private  String one;
        private  int count;
        private  static int num =0;
        public  Task(String one,int count){
            this.one= one;
            this.count = count;
        }
        @Override
        public void run() {
            int i=0;
            while(i<10){
              synchronized (Task.class){


                  if(num%3 == count){
                      num++;
                      System.out.println(one);

                  }else{
                      continue;
                  }

              }


                i++;
            }
        }
    }

}
