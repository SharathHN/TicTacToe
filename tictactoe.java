import java.util.Scanner;

//Two player tictactoe game to demonstarte object oriented concept of java
class Board {
    char board[][] = new char[3][3];

    Board() {
        for (int i = 0; i < 3; i++) {
            board[i][0] = ' ';
            board[i][1] = ' ';
            board[i][2] = ' ';
        }
    }

    void display() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("|" + " " + board[i][0] + " " + "|" + " " + board[i][1] + " " + "|" + " " + board[i][2]
                    + " " + "|");
            System.out.println("-------------");
        }

    }
    boolean HorizontalCheck(char c){
        int i;
        for(i=0;i<3;i++)
        {
            if(board[i][0]==c && board[i][1]==c && board[i][2]==c){
                return true;
            }
        }
        return false;
    }
    boolean VerticalCheck(char c){
        int i;
        for(i=0;i<3;i++)
        {
            if(board[0][i]==c && board[1][i]==c && board[2][i]==c){
                return true;
            }
        }
        return false;
    }
    boolean DiagonalCheck(char c){
        int i;
        for(i=0;i<3;i++)
        {
            if(board[0][0]==c && board[1][1]==c && board[2][2]==c){
                return true;
            }
            if(board[0][2]==c && board[1][1]==c && board[2][0]==c){
                return true;

            }
        }
        return false;
    }



}

class Player {

    String name;
    Scanner sc=new Scanner(System.in);
    Player(String name) {
        this.name = name;
    }

    void MakeMove(Board b, int i, char c) {
       while(true){
           char temp;
           if (i < 4) {
           
                temp=b.board[2][i - 1]; 
            
        } else if (i < 7) {
            
                temp=b.board[1][i - 4];
            
        } else {
            
                temp=b.board[0][i - 7];
        }
        if(temp==' '){
            temp=c;
            if (i < 4) {
           
                b.board[2][i - 1]=c; 
            
        } else if (i < 7) {
            
                b.board[1][i - 4]=c;
            
        } else {
            
                b.board[0][i - 7]=c;
        }
        break;
        }
        else{
            System.out.println("Cell already occupied.Enter valid number\n");
            i=sc.nextInt();
        }
       }
        b.display();
    }

}

class tictactoe {
    public static void main(String args[]) {
        Board b = new Board();
        Scanner s=new Scanner(System.in);
        b.display();
        char c = 'X',d='O';
        int i;
        System.out.println("Entre player1 name\n");
        Player p = new Player(s.next());
        System.out.println("Entre player2 name\n");
        Player q=new Player(s.next());
        System.out.println("........The game begins.........");
        while(true){
            System.out.println(p.name+"'s turn\n");
            i=s.nextInt();
            p.MakeMove(b, i, c);
            if(b.HorizontalCheck(c) || b.VerticalCheck(c)||b.DiagonalCheck(c)){
                System.out.println(p.name+" wins");
                break;

            }
            System.out.println(q.name+"'s turn\n");
            i=s.nextInt();
            q.MakeMove(b, i, d);
            if(b.HorizontalCheck(d) || b.VerticalCheck(d)||b.DiagonalCheck(d)){
                System.out.println(q.name+" wins");
                break;

            }


        }
        s.close();
    }
}