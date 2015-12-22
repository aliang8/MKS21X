public class BarCode implements Comparable{

    private String _zip;
    private int _checkDigit;
    private static final String[]codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

    public BarCode(String zip) {
	try {
	    Integer.parseInt(zip);
	    if (zip.length() == 5) {
		_zip = zip;
		_checkDigit = checkSum();
	    }
	    else {
		throw new IllegalArgumentException("Please make sure your input has a length of exactly 5!");
	    }
	}
	catch (NumberFormatException e) {
	    throw new NumberFormatException("Please make sure that your string only contains numbers!"); 
	}
    }

    public BarCode(BarCode x){
	this(x._zip);
    }

    private int checkSum(){
	int sum = 0;
	for (int i = 0; i < _zip.length(); i++) {
	    sum += _zip.charAt(i) - '0';
	}
	return sum % 10;
    }

    public String toString(){
	String code = _zip + Integer.toString(_checkDigit) +  " |";
	for (int i = 0; i < _zip.length(); i++) {
	    code += codes[_zip.charAt(i) - '0'] + "";
	}
	code += codes[_checkDigit];
	return code + "|";
    }


    public boolean equals(Object other){
	return this == other || (other instanceof BarCode && _zip.equals(((BarCode)other)._zip));
    } 

    public int compareTo(Object other){
	if (other instanceof BarCode) {
	    (_zip+_checkDigit).compareTo(((BarCode)other)._zip+((BarCode)other)._checkDigit);
	}
	return toString().compareTo(other.toString());
    }


    public static void main(String[] args) {
	BarCode b = new BarCode("02345");
	System.out.println(b);
	System.out.println(b.checkSum());
	BarCode b2 = new BarCode(b);
	System.out.println(b.equals(b2));
    }
}
