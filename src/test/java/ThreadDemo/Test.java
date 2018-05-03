package ThreadDemo;

public class Test {
    public static void main (String []args){
        store store =new store();
        producer producer =new producer(10,store);
        consumer consumer =new consumer(10,store);

//        Thread t1 =new Thread(producer);
//        Thread t2 =new Thread(consumer);
//        t1.start();
//        t2.start();
        consumer.start();
        producer.start();

        // 生产者对象  
        producer p1 = new producer(store);
        producer p2 = new producer(store);
        producer p3 = new producer(store);
        producer p4 = new producer(store);
        producer p5 = new producer(store);
        producer p6 = new producer(store);
        producer p7 = new producer(store);

        // 消费者对象  
        consumer c1 = new consumer(store);
        consumer c2 = new consumer(store);
        consumer c3 = new consumer(store);

        // 设置生产者产品生产数量  
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量  
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(1);

        // 线程开始执行  
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }


}
