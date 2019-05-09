package LukeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunGame {
    private static ArrayList<Index> alreadyPick = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int countTurn = 1; // start from turn 1
    private static int countRound = 1; // start from turn 1
    private static final int MAX_ROUND = 9;
    private static final int MAX_INDEX = 2;
    private static final int MIN_INDEX = 0;


    public static void run(){

        boolean flag = true;

        // Create the player
        System.out.print("Please enter player 1's name : ");
        String playerName = scanner.nextLine();
        Player firstPlayer = new Player(playerName) ;
        System.out.print("Please enter player 2's name : ");
        playerName = scanner.nextLine();
        Player secondPlayer = new Player(playerName);



        //Start to play
        while(flag) {

            if (countTurn > MAX_ROUND)
            oneTurnForPlayer(firstPlayer);
            if (isWin(firstPlayer) ) {
                System.out.println("End");
                break;
            }

            if (countRound > MAX_ROUND){ // 平手
                System.out.println("No Winner!!!");
                break;
            }

            oneTurnForPlayer(secondPlayer);
            if (isWin(secondPlayer)) {
                System.out.println("End");
                break;
            }else{
                countTurn++;
                System.out.println("One more turn");
            }

        }
    }



    public static void oneTurnForPlayer( Player player){
        boolean flag = true;
        System.out.println("---------------Turn " + countTurn + " for " + player.getPlayerName()+" ----------------------------------");

        while(flag == true) {

            System.out.print("\tPlease enter the row (0~2) : ");
            int rowIndex = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\tPlease enter the column (0~2) : ");
            int columnIndex = scanner.nextInt();
            scanner.nextLine();

            if (rowIndex > MAX_INDEX || columnIndex > MAX_INDEX || rowIndex < MIN_INDEX || columnIndex < MIN_INDEX)  {
                System.out.println("ERROR, invalid index, Please enter again");
            }else if (alreadySelect(rowIndex,columnIndex)){
                System.out.println("Error, already Pick");
            }
            else {
                player.addindexOfSelect(rowIndex, columnIndex);
                alreadyPick.add(new Index(rowIndex,columnIndex));
                flag = false;
            }

            countRound++;
        }

    }

    private static boolean alreadySelect(int rowIndex, int columnIndex){
        for (int i = 0  ; i <alreadyPick.size(); i++){

            if (alreadyPick.get(i).isEqual(rowIndex, columnIndex)){
                return true;
            }

        }
        return false;

    }


    public static void main(String[] args) {
        run();
    }


    public static boolean isWin(Player player){
        //獲勝資格

//        // 1. 3個row = 0 or 1 or 2
        int row_0 = 0;
        int row_1 = 0;
        int row_2 = 0;
//
//
//
//
//        // 2. 3個column = 0 , 1 , 2
        int col_0 = 0;
        int col_1 = 0;
        int col_2 = 0;
//        //3. 有 00  11 22 or 02 11 20
        int flag1 = 0; // 00 11 22
        int flag2 = 0 ; //02 11 20



        List<Index> checkList = player.getSelectIndex();
        for (int i = 0; i < checkList.size(); i ++){

            //count row
            if (checkList.get(i).getRowIndex() == 0){
                row_0++;
            }
            else if (checkList.get(i).getRowIndex() == 1){
                row_1++;
            }
            else if (checkList.get(i).getRowIndex() == 2){
                row_2++;
            }


            //count column
            if (checkList.get(i).getColumnIndex() == 0){
                col_0++;
            }
            else if (checkList.get(i).getColumnIndex() == 1){
                col_1++;
            }
            else if (checkList.get(i).getColumnIndex() == 2){
                col_2++;
            }


            // 斜 1

            if(checkList.get(i).getRowIndex() ==0 && checkList.get(i).getColumnIndex() == 0 ) { // 00
                flag1++;

            }

            if(checkList.get(i).getRowIndex() == 1 && checkList.get(i).getColumnIndex() == 1 ) { // 00
                flag1++;

            }

            if(checkList.get(i).getRowIndex() == 2 && checkList.get(i).getColumnIndex() == 2 ) { // 00
                flag1++;

            }

            // 斜 2

            if(checkList.get(i).getRowIndex() ==0 && checkList.get(i).getColumnIndex() == 0 ) { // 02
                flag2++;
            }

            if(checkList.get(i).getRowIndex() == 1 && checkList.get(i).getColumnIndex() == 1 ) { // 11
                flag2++;
            }

            if(checkList.get(i).getRowIndex() == 2 && checkList.get(i).getColumnIndex() == 2 ) { // 20
                flag2++;
            }


            // check if win




        }
        if (row_0 == 3 || row_1 == 3 || row_2 == 3){
            System.out.println("Winner is " + player.getPlayerName());
            return true;
        }else if (col_0 == 3 || col_1 == 3 || col_2 == 3){
            System.out.println("Winner is " + player.getPlayerName());
            return true;
        }else if (flag1 == 3 || flag2 == 3){
            System.out.println("Winner is " + player.getPlayerName());
            return true;
        }else{
            return false;
        }



    }



}
