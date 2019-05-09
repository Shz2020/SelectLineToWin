package LukeGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;
    private ArrayList<Index> indexArrayList;

    public Player(String playerName) {
        this.playerName = playerName;
        this.indexArrayList = new ArrayList<>();
    }

    public List<Index> getSelectIndex(){
        return indexArrayList;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public boolean addindexOfSelect(int rowIndex, int columnIndex){
        if (hasTheSameIndex(rowIndex,columnIndex )|| !isValidIndex(rowIndex, columnIndex)){
            System.out.println("Can not add the index");
            return false;
        }

        indexArrayList.add(new Index(rowIndex, columnIndex));
        System.out.println("Add works");
        return true;

    }


    private boolean hasTheSameIndex(int rowIndex, int columnIndex){

        for (int i = 0; i < indexArrayList.size(); i++){

            if (indexArrayList.get(i).isEqual(rowIndex, columnIndex)){
                System.out.println("Has the same Index Already");
                return true;  // if has the same return true
            }
        }
        return false; // else return false


    }


    private boolean isValidIndex (int rowIndex, int columnIndex){
        //Control the valid index
        int validMaxRow = 2;
        int validMaxColumn = 2;
        //Control end

        if (rowIndex > validMaxRow || rowIndex < 0){
            System.out.println("invalid row index, greater than " + validMaxRow + " or smaller than 0 ");
            return false;
        }else if (columnIndex > validMaxColumn || rowIndex < 0 ){
            System.out.println("invalid row index, greater than " + validMaxColumn + " or smaller than 0 ");
            return false;
        }

        return true;

    }



}
