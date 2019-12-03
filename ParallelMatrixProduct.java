package Thread;

public class ParallelMatrixProduct {
    private int numStream;
    private UsualMatrix a;
    private UsualMatrix b;
    private UsualMatrix result;
    private int begin;
    private int end;

    public ParallelMatrixProduct(UsualMatrix m1, UsualMatrix m2, int stream) throws IndexException {
        if ((stream > m1.getRows()) || (stream <= 0))
            throw new IndexException("Very much/little stream");
        numStream = stream;
        a = m1;
        b = m2;
        result = new UsualMatrix(a.getRows(), b.getColumns());
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < b.getColumns(); j++) {
                result.setElement(i, j, 0);
            }
        }
        begin = 0;
        end = a.getRows() / numStream;
        MyStream[] threads = new MyStream[numStream];
        for (int i = 0; i < numStream; i++) {
            threads[i] = new MyStream(a, b, result, begin, end);
            threads[i].start();
            begin += a.getRows() / numStream;
            end += a.getRows() / numStream;
            if ((a.getRows() - end) < (a.getRows() / numStream)) {
                end = a.getRows();
            }
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }

    public UsualMatrix getResult() {
        return result;
    }


}
