package problems;

public class HackerRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = new int[] { 100, 100, 50, 40, 40, 20, 10 };
		System.out.println("Alice rank is : " + ranked(scores, 25));
	}

	public static int ranked(int[] scores, int levelScore) {
		int rank = 0;
		int previousScore = -1;
		for (int i = 0; i < scores.length; i++) {
			int currentScore = scores[i];
			if ((levelScore <= previousScore || previousScore == -1) && levelScore >= currentScore) {
				if(previousScore==-1)
					return 1;
				if (levelScore < previousScore)
					return rank + 1;
				else
					return rank;
			}
			if (currentScore != previousScore) {
				rank++;
				previousScore = currentScore;
			}

		}
		return (previousScore == levelScore) ? rank : rank + 1;
	}

}
