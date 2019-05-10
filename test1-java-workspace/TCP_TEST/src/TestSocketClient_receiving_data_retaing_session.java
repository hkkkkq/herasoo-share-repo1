
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocketClient_receiving_data_retaing_session {
    /**
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
    	
    	String ip = "10.217.136.61";
//    	String ip = "10.225.137.132";
    	int port = 9032;
//    	String ip = "192.168.70.41";
//    	int port = 9029;
    	
//    	String sendData1 = "1637IFTCPTCP001      123456789012345678901234567890123456789012345678901234567890123456789011234567890                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     98912014102811111116001112006122200005BS000011000  101234123411117501111234567            0                         123456789012123456789012123456789012123456789012123456789012123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789020120917        20120917 12345678 12345678901234567890123456789012345678901234567890                                                                                                                                                                                                                                   1";
    	String sendData1 = "0015111112222233333\n";
    	

    	Socket socket = null;
    	OutputStreamWriter out = null;
    	InputStreamReader in = null;
    	try {
            // Create a connection to the server socket on the server application
            socket = new Socket(ip, port);
            
            boolean isWrite = false;
            //boolean isWrite = true;
//            boolean isSleep = false;
//            long sleepTime = 5000;
//            
//            if( isSleep ) {
//	            try {
//	            	System.out.println("[Client] Sleep Time::" + sleepTime + "(ms)");
//					Thread.sleep(sleepTime);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//            }
           

            if( isWrite ) {
	            // Send a message to the client application
	            out = new OutputStreamWriter(socket.getOutputStream());
	            
	            out.write(sendData1);
	            out.flush();
	            System.out.println("[Client] Send Data::" + sendData1.length());
	            
	            // Read and display the response message sent by server application
	            String message = null;
	            in = new InputStreamReader(socket.getInputStream());
	            char[] cbuf = new char[80];
	            if( in.read(cbuf) > 0 ) {
	            	message = new String(cbuf);
	            }
	            
	            System.out.println("[Client] Recv Data::[" + message.length() + "]" + message);
	            
	            socket.close();
	
            } else {
            	
            	String message = null;
	            in = new InputStreamReader(socket.getInputStream());
	            char[] cbuf = new char[14];
	            if( in.read(cbuf) > 0 ) {
	            	message = new String(cbuf);
	            }
	            
//	            System.out.println("*********************************************************");
	            System.out.println("[Client] Recv Data::[" + message.length() + "]" + message);
	            
	            //socket.close();
            }
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
}