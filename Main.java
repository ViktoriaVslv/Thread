package Thread;

public class Main {
    public static void main (String [] args){
        try {
            UsualMatrix x1 = new UsualMatrix(4, 4);
            //System.out.println(m1);
            UsualMatrix x2 = new UsualMatrix(4, 4);
            //System.out.println(m2);
            UsualMatrix x3 = new UsualMatrix(1, 1);
            UsualMatrix x4 = new UsualMatrix(1, 1);
            x3 = x1.product(x2);
            System.out.println(x3);
            ParallelMatrixProduct pmpX = new ParallelMatrixProduct(x1, x2, 4);
            x4 = pmpX.getResult();
            System.out.println(x4);


            UsualMatrix m1 = new UsualMatrix(2000, 2000);
            //System.out.println(m1);
            UsualMatrix m2 = new UsualMatrix(2000, 2000);
            //System.out.println(m2);
            UsualMatrix m3 = new UsualMatrix(1, 1);
            UsualMatrix m4 = new UsualMatrix(1, 1);
            long time1 = System.currentTimeMillis();
            m3 = m1.product(m2);
            long time2 = System.currentTimeMillis() - time1;
           // System.out.println(m3);
            System.out.println("Время обычного умножения: " + time2);
           // System.out.println("потоки: " +  Runtime.getRuntime().availableProcessors());

            time1 = System.currentTimeMillis();
            ParallelMatrixProduct pmp = new ParallelMatrixProduct(m1, m2, 2);
            time2 = System.currentTimeMillis() - time1;
           // m4 = pmp.getResult();
           // System.out.println(m4);
            System.out.println("Время 2 потока умножения: " + time2);
            time1 = System.currentTimeMillis();
            ParallelMatrixProduct pmp2 = new ParallelMatrixProduct(m1, m2, 4);
            time2 = System.currentTimeMillis() - time1;
            System.out.println("Время умножения 4 потока: " + time2);
            time1 = System.currentTimeMillis();
            ParallelMatrixProduct pmp3 = new ParallelMatrixProduct(m1, m2, 6);
            time2 = System.currentTimeMillis() - time1;
            System.out.println("Время умножения 6 потока: " + time2);
            time1 = System.currentTimeMillis();
            ParallelMatrixProduct pmp4 = new ParallelMatrixProduct(m1, m2, 8);
            time2 = System.currentTimeMillis() - time1;
            System.out.println("Время умножения 8 потока: " + time2);
        }
        catch (ArithException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }



    }
}
