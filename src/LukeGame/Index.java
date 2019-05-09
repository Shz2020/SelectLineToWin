package LukeGame;

public class Index {
    private int rowIndex;
    private int columnIndex;


    public Index(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }


    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

   public boolean isEqual(int rowIndex, int columnIndex){
        if (this.rowIndex == rowIndex && this.columnIndex == columnIndex){
            return true;
        }
        return false;  // if not same return false;

   }

    @Override
    public String toString() {
        return this.rowIndex  +""+ this.columnIndex;
    }
}
