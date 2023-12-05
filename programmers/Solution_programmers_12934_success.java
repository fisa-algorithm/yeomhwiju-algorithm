package step04.builderpattern;

class Solution_programmers_12934_success {

	public long solution(long n) {
		long answer = -1;
		for (long i = 1; i <= n; i++) {
			if ((long) Math.pow(i, 2) == n) {
				answer = (long) Math.pow(i + 1, 2);
				break;
			}
		}
		return answer;
	}
}
