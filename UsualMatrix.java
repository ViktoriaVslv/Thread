package Thread;

public class UsualMatrix {
    private int row;
    private int column;
    private int[][] mtr;

    public UsualMatrix (int x, int y){
        row=x;
        column=y;
        mtr= new int[row][column];
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                mtr[i][j]=(int) (Math.random() * 10);
            }
        }
    }
    public void setElement(int x, int y, int value) throws IndexException{
        if ((x >= row) || (y >= column) || (y < 0) || (x < 0)) {
            throw new IndexException("No element");
        }
        mtr[x][y]=value;
    }

    public int getElement(int x, int y) throws IndexException{
        if ((x >= row) || (y >= column) || (y < 0) || (x < 0)) {
            throw new IndexException("No element");
        }
        return mtr[x][y];
    }

    public int getRows(){
        return row;
    }

    public int getColumns(){
        return column;
    }

    public String toString(){
        StringBuilder str= new StringBuilder();
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                str.append(this.getElement(i, j)).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }
    public UsualMatrix product(UsualMatrix n) throws ArithException{
        if (this.column != n.getRows())  {
            throw new ArithException("You cannot multiply matrices because the number of columns in the first matrix is not equal to the number of rows in the second matrix");
        }
        UsualMatrix res= new UsualMatrix (this.row, n.getColumns());
        for( int i=0; i<this.row; i++){
            for( int j=0; j<n.getColumns(); j++){
                res.setElement(i, j, 0);
                for( int k=0; k<this.column; k++){
                    res.setElement(i, j, res.getElement(i, j)+this.getElement(i, k)*n.getElement(k, j));
                }
            }
        }
        return res;
    }
}
