



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
		str1 = preProcess(str1);
        str2 = preProcess(str2);

        str1 = str1.replace(" ", "");
        str2 = str2.replace(" ", "");
        if (str1.length() != str2.length()) {
            return false; 
        }

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int lenght1 = 0;
            int lenght2 = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (ch == str1.charAt(j)) {
                    lenght1++;
                }
            }
            for (int g = 0; g < str2.length(); g++) {
                if (ch == str2.charAt(g)) {
                    lenght2++;
                }
            }
            if (lenght1 != lenght2) {
                return false;
            }
        }
        return true;
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
			}
			if (now == ' ') 
			{
				clean = clean + now;
			}
			else
			{
			if ((now >= 'A')  && (now <= 'Z') )
			{
				clean = clean + ((char)(now + 32));
			}
			}
			i++;
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
