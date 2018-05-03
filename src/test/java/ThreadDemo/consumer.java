package ThreadDemo;

public class consumer extends  Thread {
    private int num ;
    private store store;

    public consumer(){

    }

    public consumer(store store) {
        this.store = store;
    }

    public consumer(int num, store store) {
        this.num = num;
        this.store = store;
    }

    @Override
    public void run() {
        consume(num);
    }

    public void consume(int num ){
        store.consume(num);
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
