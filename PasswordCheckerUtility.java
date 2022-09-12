package password;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
/**
 * 
 * @author Anh Pham
 *
 */
public class PasswordCheckerUtility {
// This is the Constructor
	public PasswordCheckerUtility() {
		
	}
	
	/**
	 * comparePasswords() checks if the two String are the same as each other, checks validation.
	 * These two strings are inputed in the GUI.
	 * @param password - The password
	 * @param passwordConfirm - The 2nd password to compare to
	 * @throws UnmatchedException if they aren't the same
	 */

public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
{
	if(!(password.matches(passwordConfirm)))
	{
		throw new UnmatchedException();
	}
}
/**
 * comparePasswordsWithReturn() checks if the two String are the same as each other AND return if its true or false.
 * These two strings are inputed in the GUI.
 * @param password - The password
 * @param passwordConfirm - The 2nd password to compare to
 *	@return true if they are the same
 */

public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
{
	
	if(password.matches(passwordConfirm))
			{
		return true;
			}
	else {
	return false;
		 }
}


/**
 * 
 * isValidLength(), checks if the password has more than or equal to 6 digit.
 * @param password - The password
 *	@return true if there're more than 6 digits
 *	@throws LengthException if there aren't
 */
public static boolean isValidLength(String password) throws LengthException
{
	if(password.length()>=6) {
		return true;
	}
	else {
		throw new LengthException();
	}
}
/**
 * 
 * hasUpperAlpha() , using isUpperCase to check every char in the password if it's uppercased or not.
 * @param password - The password
 *	@return true if it has uppercase
 *	@throws NoUpperAlphaException if it doesn't
 */

public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
{
	 for (int i = 0; i < password.length(); i++) {
		    if (Character.isUpperCase(password.charAt(i))) {
		      return true;
		    }
		    }
	 throw new NoUpperAlphaException();
}
/**
 * 
 * hasLowerAlpha(), using isLowerCase to check every char in the password if it's lowercased or not.
 * @param password - The password
 *	@return true if it has lowercase
 *	@throws NoLowerAlphaException if it hasn't
 */

public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
{
	for (int i = 0; i < password.length(); i++) {
	    if (Character.isLowerCase(password.charAt(i))) {
	      return true;
	    }
	    }
 throw new NoLowerAlphaException();
}

/**
 * 
 * hasDigit(), using isDigit to check if every char in the password if it's a numeric value or not.
 * @param password - The password
 *	@return true if there is a numeric value
 *	@throws NoDigitException if there isn't
 */

public static boolean hasDigit(String password) throws NoDigitException
{
	for (int i = 0; i < password.length(); i++) {
	    if (Character.isDigit(password.charAt(i))) {
	      return true;
	    }
	    }
 throw new NoDigitException();
}

/**
 * 
 * hasSpecialChar(), using the method provided in the word doc, check if the string have a special symbol or not.
 * @param password - The password
 *	@return true if there's no symbol
 *	@throws NoSpecialCharactersException if there is
 */

public static boolean hasSpecialChar(String password) throws NoSpecialCharactersException
{
	Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	Matcher matcher = pattern.matcher(password);
	if(!(matcher.matches())){
		return true;
	}
	else {
	throw new NoSpecialCharactersException();
	}
}
/**
 * 
 * NoSameCharInSequence(),  checks if 3 continous char in the string is the same or not. *	
 * @param password - The password
 * 	@return true if every 3 consecutive chars are not the same
 *	@throws InvalidSequenceException if they are
 */

public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
{
	char char1=' ';
	char char2 = ' ';
	char char3=' ';
	for(int i = 0; i < password.length(); i++) {
		char3 = char2;
		char2 = char1;
		char1 = password.charAt(i);
		 if (char1==char2 && char2 == char3) {
			 throw new InvalidSequenceException();
		 }
		}
		 return true;
}

/**
 * 
 * isValidPassword(), check everything above, if they are all true, this return true.
 * @param password - The password.
 * @return true if everything is correct.
 * @throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharactersException, InvalidSequenceException
 */


public static boolean isValidPassword(String password) 
throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharactersException, InvalidSequenceException
{
	isValidLength(password);
	hasUpperAlpha(password);
	hasLowerAlpha(password);
	hasDigit(password);
	NoSameCharInSequence(password);
	hasSpecialChar(password);
	return true;
}

/**
 * 
 * hasBetweenSixAndNineChars(), checks if the password is between 6 and 9 digits.
 *  @param password - The password
 * 	@return true if met requirement
 *	
 */

public static boolean hasBetweenSixAndNineChars(String password)
{
	if(password.length()>=6 && password.length()<=9)
	{
		return true;
	}
	else 
	{
	return false;
	}
}
/**
 * 
 * isWeakPassword(), checks if the password is between 6 and 9 digits and valid.
 * 	@return false if wrong for both
 *	@throws WeakPasswordException if it's between six and nine and is valid
 */

public static boolean isWeakPassword(String password) throws WeakPasswordException 
{
	if(hasBetweenSixAndNineChars(password)) 
	{
		throw new WeakPasswordException();
		
	}
	else
	{
		return false;
	}
}
/**
 * 
 * getInvalidPasswords(), using bodies of previous methods, this allow the ArrayList to check and return if its wrong.
 * @param passwords - List of passwords
 * 	@return ArrayList of wrong passwords
 */
public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
	ArrayList<String> invalid = new ArrayList<String>();
//Length
	for(String password: passwords) {
		
		if(!(password.length()>=6)) {
			invalid.add(password+=" – The password must be at least 6 characters long");
			continue;
			
		}
//Uppercase
		boolean upper = false;
		for (int i = 0; i < password.length(); i++) {
		 
			if ((Character.isUpperCase(password.charAt(i)))) {
		    	upper = true;
		    }	

		}	
		if(!upper) {
			invalid.add(password+=" - The password must contain at least one uppercase alphabetic character");
		continue;
		}
		
//Lowercase
		boolean lower=false;
		for (int i = 0; i < password.length(); i++) {
		 
			if ((Character.isLowerCase(password.charAt(i)))) {
		    	lower = true;
		    }	
		}		
		if(!lower) {
			invalid.add(password+=" - The password must contain at least one lowercase alphabetic character");
			continue;
		}
		
//Numeric
		boolean number=false;
		for (int i = 0; i < password.length(); i++) {
		 
			if ((Character.isDigit(password.charAt(i)))) {
		    	number = true;
		    }	
		}		    
		if(!number) {
			invalid.add(password+=" – The password must contain at least one digit");
			continue;
		}


	//Special Char
		boolean special = false;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(!(matcher.matches())){
			special = true;
		}
		if(!special) {
			invalid.add(password+=" - The password must contain at least one special character");
			continue;
		}
		
	//Same Char 
		char char1=' ';
		char char2 = ' ';
		char char3=' ';
		for(int i = 0; i < password.length(); i++) {
			char3 = char2;
			char2 = char1;
			char1 = password.charAt(i);
			 if (char1==char2 && char2 == char3) {
				 invalid.add(password+=" – The password cannot contain more than two of the same character in sequence.");
				 continue;
			 }
			}
}
	return invalid;

}
}

