package letter;


import content.Money;
import content.Text;
import displayer.Displayer;
import letter.PromissoryNote;
import letter.RegisteredLetter;
import letter.SimpleLetter;
import letter.UrgentLetter;


import entity.BankAccount;
import entity.City;
import entity.Inhabitant;


public class PostMain {

public static void main(String[] args){

		
		/* Declaration of variables*/
		City lille = new City("Lille");
		
		BankAccount jackBank = new BankAccount(150);
		BankAccount michelBank = new BankAccount(150);
		BankAccount mouleBank = new BankAccount(150);
		
		Inhabitant jack = new Inhabitant(lille,"Jack",jackBank);
		Inhabitant michel = new Inhabitant(lille,"Michel",michelBank);
		Inhabitant martin = new Inhabitant(lille,"Martin",mouleBank);
		
		lille.addInhabitant(michel);
		lille.addInhabitant(martin);
		lille.addInhabitant(jack);

		/* Day 1 */
		Displayer.getDisplayer().display("------------- JOUR 1 ----------------\n");
		
		/* Step 1 : Simple letter*/	
		Text t = new Text("bonjour");
		
		lille.sendLetter(new SimpleLetter(t, jack, martin));
		lille.sendLetter(new SimpleLetter(t,michel, martin));
		
		/* Watch in the post box */
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* Step 2 : Promissory Letter */
		
		/* creation of amount and simple letter */
		Money moneyContent = new Money(50);
		
		PromissoryNote l1 = new PromissoryNote(moneyContent, jack, michel);
		/* add of amount in the simple letter */
		//l1.setContent(moneyContent);
		lille.sendLetter(l1);
		
		/* Watch in the post box */		
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* end of day send letters to their receiver */
		lille.distributeLetter();
		
		/*  Watch in the post box  */		
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* verification of the account */
		//c.getAccountCity();

		
		/* day 2 */
		Displayer.getDisplayer().display("------------- JOUR 2 ----------------\n");
		
		/* creation of a simple letter and a registred decorator */
		RegisteredLetter reg = new RegisteredLetter(new SimpleLetter(t, martin, jack));
		lille.sendLetter(reg);
		
		/*  Watch in the post box  */		
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* creation of a simple letter and a urgent decorator */
		UrgentLetter urg = new UrgentLetter (new SimpleLetter(t, michel, martin));
		lille.sendLetter(urg);
		
		/* creation of a promissory letter and a urgent decorator */
		//moneyContent.setContent(20);
		PromissoryNote p2 =new PromissoryNote (moneyContent, michel, jack);
		//p2.setContent(moneyContent);
		urg = new UrgentLetter(p2);
		lille.sendLetter(urg);
		
		
		/*  Watch in the post box  */		
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* end of day send letters to their receiver */
		lille.distributeLetter();
		
		/*  Watch in the post box  */		
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* verification of the account */
		//c.getAccountCityState();
		
		
		/* jour 3 */
		Displayer.getDisplayer().display("------------- JOUR 3 ----------------\n");
		
		/* creation of a simple letter and a registred decorator and a urgent decorator */
		reg= new RegisteredLetter(new SimpleLetter(t, jack, michel));
		urg = new UrgentLetter(reg);
		//urg.setLetter(reg);
		
		lille.sendLetter(urg);
		
		/*  Watch in the post box  */		
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* Account verification */
		//c.getAccountCityState();
		
		/* end of day send letters to their receiver */
		lille.distributeLetter();
		
		/*  Watch in the post box  */		
		Displayer.getDisplayer().display("\n");
		lille.bag();
		Displayer.getDisplayer().display("\n");
		
		/* Account verification */
		//c.getAccountCityState();
		
		
	}

}
