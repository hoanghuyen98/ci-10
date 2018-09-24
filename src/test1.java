public class test1 {
    public int count;
    // method
    public test1(){
        this.count = 0;
    }

    public test1 (int count){
        this.count = count;
    }

    public void plus(int x) {
        count = count + x;
    }

    public void print(){
        System.out.println(count);
    }

}
