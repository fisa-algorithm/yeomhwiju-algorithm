
class Solution_programmers_12916 {
	
	public int countCharacterP(String s) {
		
		
		int pCount = 0;
		
		
		for(int i =0; i<s.length(); i++){
			if(s.charAt(i) == 'P') {
				pCount++;
			}
		}
		return pCount;
		
	}
	
	
	public int countCharacterY(String s) {
		
		
		int yCount = 0;
		
		
		for(int i =0; i<s.length(); i++){
			if(s.charAt(i) == 'Y') {
				yCount++;
			}
		}
		return yCount;
		
	}
	
	
	
	

	public boolean isMatchCount(String s) {
		s =s.toUpperCase();
		
		int countUppercaseP = countCharacterP(s);
		int countCharacterY = countCharacterY(s);

		return countUppercaseP == countCharacterY;

	}

	public boolean solution(String s) {
		boolean answer = isMatchCount(s);

		return answer;
	}

}