import java.util.Scanner;

public class TicTacToeRunner
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		char p = 'X';
		TicTacToeClass ttt = new TicTacToeClass();
		int i;

		while ( ! ( ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull() ) )
		{
			ttt.displayBoard();
			System.out.print( "'" + p + "', choose your location (0-8): " );
			i = keyboard.nextInt();
		

			while ( ttt.isValid(i) == false || ttt.playerAt(i) != ' ' )
			{
				if ( ttt.isValid(i) == false )
					System.out.println("That is not a valid location. Try again.");
				else if ( ttt.playerAt(i) != ' ' )
					System.out.println("That location is already full. Try again.");

				System.out.print( "Choose your location (0-8): " );
				i = keyboard.nextInt();
			}

			ttt.playMove( p, i );

			if ( p == 'X' )
				p = 'O';
			else
				p = 'X';

		}

		ttt.displayBoard();

		if ( ttt.isWinner('X') )
			System.out.println("X is the winner!");
		if ( ttt.isWinner('O') )
			System.out.println("O is the winner!");
		if ( ttt.isCat() )
			System.out.println("The game is a tie.");
            keyboard.close();

	}
}
