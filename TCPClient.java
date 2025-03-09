import java.io.*;
import java.net.*;
class TCPClient {
    public static void main(String[] args) throws Exception{

        //Dem Client-Programm wird beim Aufruf Servername bzw. -IP-Adresse und der Serverport übergeben
        String serverName = args[0];
        int serverPort = Integer.parseInt(args[1]);

        //erzeuge Clientsocket, verbinde mit Server
        Socket clientSocket = new Socket(serverName, serverPort);

        //erzeuge Ausgabe Strom für Socket
        OutputStream out = clientSocket.getOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);
        for(int i = 0; i <= 1000000; i++){
            dataOut.writeInt(i);
        }

        //Der Client wird beendet, sobald er alle Zahlen gesendet hat.
        clientSocket.close();

    }
}
