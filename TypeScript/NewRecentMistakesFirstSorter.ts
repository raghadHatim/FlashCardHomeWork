
import { Card, CardOrganizer } from "./CardOrganizer";
import readline from "readline"; // Input from user

export class NewRecentMistakesFirstSorter {
  
    // Input from user
  private rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  private study: boolean = true; // for start method to check continue or stop
  private currentOrder: Card[] = [...CardOrganizer]; // to keep orginl order after wrong answer attemp

  private ask(question: string): Promise<string> {
    return new Promise(resolve => {
      this.rl.question(question, (answer: string) => resolve(answer));
    });
  }
  /* round method to start rounds when user want to and keep run until user stop it */
  async round(): Promise<void> {

    let mistakes: Card[] = []; // array store object from CardOrganizer ( Wrong answer )
    let correct: Card[] = []; // array store object from CardOrganizer ( correct answer )

    for (const card of this.currentOrder) {

      console.log(`** ${card.name} **`);
      const userDate = await this.ask("Enter the date: ");
      const userLeader = await this.ask("Enter the leader: ");

      if (userDate === card.date && userLeader === card.leader) {  // compare user answer with right answer
        console.log("Correct");
        correct.push(card); // store correct answer in correct array
      } else {
        console.log("Incorrect");
        mistakes.push(card); // store mistakes answer in mistakes array
      }
    }

    // for NEXT round change order 
    if (mistakes.length === 0) {
      this.currentOrder = [...CardOrganizer]; // keep original order
    } else {
      this.currentOrder = [...mistakes, ...correct]; // swap
    }
  }

  async start(): Promise<void> { // user call this method to start 

    while (this.study) {
      await this.round(); // calling round until user want to stop 

      const stop = await this.ask("\nDo you want to stop? (y/n): ");
      this.study = stop.toLowerCase() === "n";
    }

    console.log("Finish...");
    this.rl.close();
  }
}
