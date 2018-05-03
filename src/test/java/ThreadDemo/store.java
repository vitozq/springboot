package ThreadDemo;

import java.util.LinkedList;

public class store {
    private final int MAX_SIZE= 50;
    private LinkedList<Object>  list =new LinkedList<Object>();

    //生产num个商品
    public void produce(int num ){
        synchronized (list){
            while(list.size()+num>MAX_SIZE){
                System.out.println("【要生产的产品数量】:" + num + " \t 【库存量】:"
                        + list.size() + "\t 暂时不能执行生产任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i=0;i<num;i++ ){
                list.add(num);
            }
            System.out.print("生产"+num+"个商品，当前仓库容量为"+list.size()+"\n");
            list.notifyAll();
        }
    }

    //生产num个商品
    public void consume(int num ){
        synchronized (list){
            while(list.size()<num){
                System.out.println("【要消费的产品数量】:" + num + " \t 【库存量】:"
                        + list.size() + "\t 暂时不能执行消费任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i=0;i<num;i++ ){
                list.remove();
            }
            System.out.print("消费"+num+"个商品，当前仓库容量为"+list.size()+"\n");
            list.notifyAll();
        }
    }


    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }
}
