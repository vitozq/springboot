package ThreadDemo;

public class producer extends  Thread {
    private int num ;
    private store store;

    public producer(){

    }

    public producer(store store) {
        this.store = store;
    }

    public producer(int num, ThreadDemo.store store) {
        this.num = num;
        this.store = store;
    }

    @Override
    public void run() {
        produce(num);
    }
    public void produce(int num ){
        store.produce(num);
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ThreadDemo.store getStore() {
        return store;
    }

    public void setStore(ThreadDemo.store store) {
        this.store = store;
    }
}
