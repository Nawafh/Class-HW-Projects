public class Decoder
{
	byte[] bytesIn;
	int lengthOfBytesIn;
	String[] decoded = {"11110", "01001", "10100", "10101",
			            "01010", "01011", "01110", "01111",
			            "10010", "10011", "10110", "10111",
			            "11010", "11011", "11100", "11101"};
	
	public Decoder()
	{	
	}
	
	public String convert4Bto5B(byte[] receiveBuf, int inReceiveBuf) throws InvalidException
	{
		StringBuilder tmp = new StringBuilder();
		int value = 0;

	    bytesIn = receiveBuf;
	    lengthOfBytesIn = inReceiveBuf;

		for(int i = 0; i < inReceiveBuf; ++i)
		{
	        char c = (char)receiveBuf[i];
	        
	        value += value;
			if(c == '1')
			{
				++value;
			}
			else if(c != '0')
			{
				throwError(i);
			}
			if(i % 4 == 3)
			{
				if((value < 0) || (value > 15))
				{
					throw new InvalidException(new String("Unknown error occurred"), new String(""));
				}
				tmp.append(decoded[value]);
				value = 0;
			}
		}
		if(inReceiveBuf % 4 != 0)
		{
			if((value < 0) || (value > 15))
			{
				throw new InvalidException(new String("Unknown error occurred"), new String(""));
			}
			tmp.append(decoded[value]);
			value = 0;
		}
		return tmp.toString();
	}

			
	private void throwError(int i) throws InvalidException
	{
		StringBuilder error = new StringBuilder(),
		errorPointer = new StringBuilder();
	
		for(int j = 0; j < lengthOfBytesIn; ++j)
		{
			error.append((char)bytesIn[j]);
			if(j <= i)
			{
				errorPointer.append((j < i) ? ' ' : '^');
			}
		}
		throw new InvalidException(error.toString(), errorPointer.toString());
	}
}