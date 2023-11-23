package model.domain;

/**
 * 컴파일 에러로 틀림 - 테케 2개 틀림
 * 
 * 시간 복잡도 줄이기..
 */
class Solution_programmers_12934 {

	public static long dfs(long number, long n) {

		if (number * number > n) {
			return -1;

		} else if (number * number == n) {
			return number;
		}

		return dfs(number + 1, n);
	}

	public static long solution(long n) {

		long result = dfs(1, n);

		if (result == -1) {
			return -1;
		}

		return (result + 1) * (result + 1);

	}

	public static void main(String[] args) {
		solution(121);
	}
}