package BJ;
import java.util.*;
public class Game {
    private int game_status = 3;//0 for draw, 1 for player win, 2 for player loss, 3 for continue
    private int userCards = 0;// Value of users cards
    private int dealerCards = 0;// Value of dealers cards
    public  int user_wallet;//Value of Users wallet
    public int[] AICards = new int[4];//Value of AIs cards, each element is the value of
    public void run() {
        char choice;
        Scanner sc = new Scanner(System.in);
        int i ;
        int faceupCard = 0;//Stores dealers face up card
        for(i = 1;i <= 2;i++)
        {
            userCards += getNewCard();
            if(i == 1)
            {
                faceupCard = getDealer_Cards();
            }
        }
        while (game_status == 3) {
            System.out.println("Value of your Cards:" + getUserCards());
            System.out.println("Value of Dealers Face Up Card:" + faceupCard);
            System.out.println("Choose Hit or Stand");
            choice = sc.next().charAt(0);
            if (choice == 'h') {
                hit();
            } else if (choice == 's') {
                stand();
            }
            end_check();
        }
        end_display();
    }
    private void end_display()
    {
        System.out.println("Value of your Cards:" + getUserCards());
        System.out.println("Value of Dealers Cards:" + getDealer_Cards());
        if(game_status == 3)
        {
            if(getUserCards() == getDealer_Cards())
            {
                System.out.println("Draw");
                System.exit(0);
            }
            else if(getUserCards() > getDealer_Cards())
            {
                System.out.println("You Won");
                System.exit(0);
            }
            else
            {
                System.out.println("You Lost");
                System.exit(0);
            }
        }
        if(game_status == 1)
        {
            System.out.println("You Won");
        }
        else if(game_status == 2)
        {
            System.out.println("You Lost");
        }
    }
    private void end_check()
    {
        if(getUserCards() == 21)//If users cards = 21
        {
           if(getDealer_Cards() == 21)
           {
               game_status = 0;
           }
           else {
               game_status = 1;
           }
        }
        else if(getUserCards() < 21)//If users cards < 21
        {
            if(getDealer_Cards() == 21)
            {
                game_status = 2;
            }
            else if(getDealer_Cards() < 21)
            {
                game_status = 3;
            }
            else {
                game_status = 1;
            }
        }
        else {
            game_status = 2;
        }
    }
    private void hit()
    {
        this.userCards += getNewCard();
        this.dealerCards += getNewCard();
    }
    private void stand()
    {
        end_check();
        end_display();
    }
    private int getNewCard()
    {
        return (int) (Math.random() * 10 + 1);
    }
    public int getUser_wallet()
    {
        return  user_wallet;
    }
    public int getGame_status()
    {
        return game_status;
    }
    private int getUserCards()
    {
        return  userCards;
    }
    private int getDealer_Cards()
    {
        return  dealerCards;
    }
}
