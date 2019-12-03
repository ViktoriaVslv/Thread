package Thread;

public class MyStream extends Thread {

    private UsualMatrix a;
    private UsualMatrix b;
    private UsualMatrix result;
    private int begin ;
    private int end;

    public  MyStream (UsualMatrix m1, UsualMatrix m2, UsualMatrix res, int begin, int end){
       this.a = m1;
       this.b = m2;
       this.result = res;
       this.begin = begin;
       this.end = end;
    }
    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            for (int j = 0; j < b.getColumns(); j++) {
                result.setElement(i, j, 0);
                for (int k = 0; k < a.getColumns(); k++) {
                    result.setElement(i, j, result.getElement(i, j) + a.getElement(i, k) * b.getElement(k, j));
                }
            }
        }
    }
    public UsualMatrix getResult1() {
        return result;
    }
}
