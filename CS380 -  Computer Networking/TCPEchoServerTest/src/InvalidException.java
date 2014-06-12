/**
 * Class indicates a bad character has been found in the input
 * buffer to be decoded.
 */
/**
 * @author Christopher Franklin
 *
 */
public class InvalidException extends Exception {
	static final long serialVersionUID = 1; // version number
	String mBadString;                      // invalid string
	String mPointsToBadChar;                // points to invalid character
	
	InvalidException(String badString, String pointsToBadChar)
	{
		mBadString = badString;
		mPointsToBadChar = pointsToBadChar;
	}
	
	String badString()
	{
		return mBadString;
	}
	
	String pointToBadChar()
	{
		return mPointsToBadChar;
	}
}
