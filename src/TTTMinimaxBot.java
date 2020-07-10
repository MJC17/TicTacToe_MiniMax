import java.util.Random;

public class TTTMinimaxBot {

	char player;
	char opponent;
	int predictionDepth;

	TTTMinimaxBot(char player, char opponent, int predictionDepth) {

		this.player = player;
		this.opponent = opponent;
		this.predictionDepth = predictionDepth;
	}

	char[][] makeMove(char[][] board) {

		MinimaxMove[] possibleNextMoves = new MinimaxMove[9];
		int highestPredictionScore = 0;
		int nextMovesCount = 0;

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {

				if (board[x][y] == ' ') {

					MinimaxMove currentPossibleMove = new MinimaxMove(player, opponent, this.predictionDepth);
					currentPossibleMove.MovePerdiction(board, x, y);

					if (currentPossibleMove.getScore() > highestPredictionScore) {
						highestPredictionScore = currentPossibleMove.getScore();
						nextMovesCount = 1;
						possibleNextMoves = new MinimaxMove[8];
						possibleNextMoves[nextMovesCount - 1] = currentPossibleMove;

					} else if (currentPossibleMove.getScore() == highestPredictionScore) {
						nextMovesCount += 1;
						possibleNextMoves[nextMovesCount - 1] = currentPossibleMove;

					}

				}
			}
		}

		return possibleNextMoves[new Random().nextInt(nextMovesCount - 1)].getCurrentMove();
	}
}
