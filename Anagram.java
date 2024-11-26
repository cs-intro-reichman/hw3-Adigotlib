

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);
		if (s1.length() != s2.length())
		{
			return false;
		}
		int length1 = s1.length();
		int length2 = s2.length();
		boolean anagrams = true;
		for (int i = 0; length1 < i; i++ )
		{
			char c = s1.charAt(i);
			for (int j = 0; length2 > j; j++)
			{
				if (s2.indexOf(c) == -1)
				{
					anagrams = false;
				}
				else 
				{
					anagrams = true;
					String news1= "";
					String news2= "";
					for (int z = 0; z < s1.length(); z++)
					{
						if (s2.indexOf(c) == z)
						{
							news2 = news2 + "";
						}
						else 
						{
							news2 = news2 + s2.charAt(z);

						}
						 if (i==z)
						 {
							news1= news1 + "";
						 }
						 else
						 {
							news1 = news1 + s1.charAt(z);
						 }
					}
					s1 = preProcess(news1);
					s2 = preProcess(news2);
				}
				
			}		
		}
		if (s1.length() != s2.length())
		{
			anagrams = false;
		}
		return anagrams;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String clean = "";
		int i = 0;
		while (i < str.length())
		{
			char now = str.charAt(i);
			if ((now >= 'a') && (now <= 'z'))
			{
				clean = clean + now;
				i++;
			}
			else
			{
			if ((now >= 'A')  && (now <= 'Z') )
			{
				clean = clean + ((char)(now + 32));
			}
			i++;
			}
		}
		return clean;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String anagram = "";
		String cleanstr = preProcess(str); 
		int lenthclean= cleanstr.length();
		int i = 0;
		while ( i < lenthclean) 
		{
			int Whichchar = (int)((Math.random())* lenthclean);
			anagram = anagram + cleanstr.charAt(Whichchar);
			String cleanString = "";
			for (int z = 0; z < lenthclean; z++ )
			{
				if (z != Whichchar)
				{
					cleanString =cleanString + cleanstr.charAt(z);
				}
			}
			cleanstr = cleanString;
			lenthclean= cleanstr.length();
		}

		return anagram;
	}
}
