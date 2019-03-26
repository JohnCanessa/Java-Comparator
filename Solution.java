import java.util.*;


/*
 * Comparator that sorts them in order of decreasing score.
 * If 2 or more players have the same score, 
 * sort those players alphabetically by name. 
 */
class Checker implements Comparator<Player> {
	
	public int compare(Player p1, Player p2) {
		
		// **** sort by score ****
		if (p1.score > p2.score)
			return -1;
		if (p1.score == p2.score) {
			
			// **** sort by name ****
			return p1.name.compareTo(p2.name);
		}
		return 1;
	}
}


/*
 * Player class.
 */
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

/*
 * Test scaffolding.
 */
class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}