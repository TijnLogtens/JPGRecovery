import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class JPGRecovery {


    // For now, this main method simply copies the file untill it finds a byte "11111111".
    // It does serve as a good starting point and illustrates 
    // the use of DataInputStream and DataOutputStream.

    public static void main(String[] args) {
	try {
    	DataInputStream in = new DataInputStream(new FileInputStream(args[0]));
	    DataOutputStream out = new DataOutputStream(new FileOutputStream("firstPartOfFile.img"));
	    byte byte1 = in.readByte();

	    while ((in.available() > 0) && (byte1 != (byte) 0xff)) {

		out.writeByte(byte1);
		byte1 = in.readByte();
	    
	    }
	    
	    out.writeByte(byte1);

	} catch (IOException e) {
	    System.err.println("Caught IOException: " + e.getMessage());
	}
    }
}
