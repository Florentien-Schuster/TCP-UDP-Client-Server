import java.io.*;
import java.net.*;
class TCPServer {
    public static void main(String[] args) throws Exception{

        //erzeuge WelcomeSocket für Port 2345
        int port = 2345;
        ServerSocket welcomeSocket = new ServerSocket(port);

        while(true) {

            //erzeuge Socket bei Verbindungswunsch von Client
            Socket connectSocket = welcomeSocket.accept();

            //erzeuge Eingabestrom für Socket
            InputStream in = connectSocket.getInputStream();
            DataInputStream dataIn = new DataInputStream(in);

            // prueft, ob die Zahlen der empfangenen Pakete fortlaufend sind.
            int expectedNumber = 0;
            for(int i = 0; i <= 1000000; i++){
                int receivedNumber = dataIn.readInt();
                if(receivedNumber != expectedNumber){
                    System.out.println("Error! Expected number: " + expectedNumber + ", number received: " + receivedNumber);
                }
                expectedNumber++;
            }

            connectSocket.close();

        }

    }
}
