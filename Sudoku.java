import java.util.Scanner;

class Sudoku{

    public boolean isSafe(char [][]board,int row,int col,int number){
        //row & coloumn
        for(int i=0;i<board.length;i++){
            if (board[i][col]==(char)(number +'0')){
                return false;
            } 
            if (board[row][i]==(char)(number +'0')){
                return false;
            }
        } 
        //grid condition
        int sr=(row/3)* 3;
        int sc =(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==(char)(number +'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper (char [][] board,int row ,int col){
        if(row==board.length){
            return true;
        }
        int nrow=0;
        int ncol=0;
        if (col != board.length-1) {
            nrow=row;
            ncol=col+1;
        }else{
            nrow=row+1;
            ncol=0;
        }    
        if (board[row][col] !='.') {
            if(helper(board, nrow, ncol)){
                return true;
            }
        }else{
            for(int i=1;i<=9;i++){
                if (isSafe(board,row,col,i)) {
                    board[row][col]=(char)(i+'0');
                    if(helper(board, nrow, ncol))
                    { return true;}
                    else{
                        board[row][col]='.';
                    }
                }
            }
        }
        return false;
    }
        
   public void solveSudoku(char[][] board){
helper(board, 0, 0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" HELLO WELCOME TO SUDOKU SOLVER PROGRAM \nPRESS 1 FOR SOLVING SYSTEM DEFINED SUDOKU\nPRESS 2 FOR SOLVING USER DEFINED VALUES OF SUDOKU \nPRESS 0 TO EXIT THE PROGRAM  ");
        int A=scanner.nextInt();
        Sudoku solution = new Sudoku();
         switch (A) {
            case 1:
        
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board1);
        

        // Print the solved sudoku board
        for (char[] row : board1) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        break;
        case 2:
        
        char[][] board = new char[9][9];
       

        System.out.println("Enter the Sudoku puzzle (use '.' for empty cells):");
        for (int i = 0; i < 9; i++) {
            String row = scanner.next();
            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        solution.solveSudoku(board);

        // Print the solved sudoku board
        System.out.println("Solved Sudoku:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        break ;
        case 0:
        { System.out.println(" THANKYOU FOR VISITING ");
        break;}
        default :
        System.out.println(" WRONG METHOD OF INPUT PLEASE TRY AGAIN");
    }
    scanner.close();
    
}}
