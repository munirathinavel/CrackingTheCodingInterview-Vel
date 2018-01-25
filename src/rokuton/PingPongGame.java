package rokuton;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PingPongGame {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		// Scanning the number of Players
		// System.out.println("Enter the number of Players:");
		int noOfPlayers = s.nextInt();
		Map<Integer, Integer> players = new HashMap<Integer, Integer>();
		int startTime = 0;
		int endTime = 0;
		for (int i = 0; i < noOfPlayers; i++) {
			// System.out.println("Enter each player's available time: (starttime
			// endtime)");
			// Scanning each players startTime & endTime
			startTime = s.nextInt();
			endTime = s.nextInt();
			updatePlayersMap(players, startTime, endTime);
		}
		s.close();

		int singles = 0;
		int doubles = 0;
		// Identifying probabilities of singles & doubles.
		for (Map.Entry<Integer, Integer> player : players.entrySet()) {
			if (player.getValue() == 2 || player.getValue() == 3) {
				singles++;
			} else if (player.getValue() >= 4) {
				doubles++;
			}
		}

		System.out.println(singles + " " + doubles);

	}

	private static void updatePlayersMap(Map<Integer, Integer> players, int startTime, int endTime) {

		// Setting number of players available on each hour
		while (startTime++ < endTime) {
			players.put(startTime, (players.get(startTime) == null ? 0 : players.get(startTime)) + 1);
		}

	}
}
