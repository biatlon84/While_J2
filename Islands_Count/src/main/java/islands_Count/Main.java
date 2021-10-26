package islands_Count;

public class Main {
	public static boolean[][] map = new boolean[][] { { true, true, true, false }, { false, true, false, false },
			{ true, false, false, false }, { false, false, false, true } };

	public static int count = 1;
	public static int m = map.length;
	public static int n = map[0].length;
	public static int[][] mapLabel = new int[m][n];

	public static void main(String[] args) {
		System.out.print(ilendsCaunt());
	}

	public static void dfs(int mS, int nS) {

		if (map[mS][nS] != true || mapLabel[mS][nS] == count) {
			return;
		}

		mapLabel[mS][nS] = count;
		if (nS < n - 1)
			dfs(mS, nS + 1);
		if (mS < m - 1)
			dfs(mS + 1, nS);
		if (nS > 0)
			dfs(mS, nS - 1);
		if (mS > 0)
			dfs(mS - 1, nS);

	}

	public static int ilendsCaunt() {

		for (int j = 0; j < m; j++) {

			for (int i = 0; i < n; i++) {

				if (true == map[j][i] && mapLabel[j][i] != count) {
					count++;
					dfs(j, i);

				}

			}

		}

		return count - 1;
	}
}
