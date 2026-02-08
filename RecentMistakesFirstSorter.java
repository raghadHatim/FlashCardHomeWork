import java.util.Scanner;

public class RecentMistakesFirstSorter {

    Scanner scanner = new Scanner(System.in); // Input from user
    boolean Study = true; // for start method to check continue or stop 

    CardOrganizer[] currentOrder = CardOrganizer.values(); // to keep orginl order after wrong answer attemp 
    
    /* round method to start rounds when user want to and keep run until user stop it */
    public void round() { 

        
    CardOrganizer[] mistakes = new CardOrganizer[currentOrder.length]; // array store object from CardOrganizer ( Wrong answer )
    CardOrganizer[] correct = new CardOrganizer[currentOrder.length]; // array store object from CardOrganizer ( correct answer )

        int m = 0; // mistake increament 
        int c = 0; // correct increament

        for (CardOrganizer r : currentOrder) {

            System.out.println("** " + r.name() + " **");
            System.out.print("Enter the date: ");
            String userDate = scanner.nextLine();
            System.out.print("Enter the leader: ");
            String userLeader = scanner.nextLine();
            
            // compare user answer with right answer 
            if (userDate.equals(r.getDate()) &&
                userLeader.equals(r.getLeader())) {

                System.out.println("Correct");
                correct[c++] = r; // store correct answer in correct array

            } else {
                System.out.println("Incorrect");
                mistakes[m++] = r; // store mistakes answer in mistakes array
            }
        }

        // for NEXT round change order 
        CardOrganizer[] nextOrder = new CardOrganizer[currentOrder.length];

        int index = 0;

        // wrong first
        for (int i = 0; i < m; i++) {
            nextOrder[index++] = mistakes[i];
        }

        // correct second
        for (int i = 0; i < c; i++) {
            nextOrder[index++] = correct[i];
        }

        if(mistakes[0] == null){
        currentOrder = CardOrganizer.values(); // so will keep orginal order  
        }else{
        currentOrder = nextOrder;
        } // swap 
    }
    // user call this method to start 
    public void start() {

        while (Study) {
            // calling round until user want to stop 
            round();

            System.out.print("\nDo you want to stop? (y/n): ");
            Study = scanner.nextLine().equalsIgnoreCase("n"); // if n continue if y stop
        }

        System.out.println("Finish...");
    }
}


