import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class UDPClient {

    public static void main(String argv[]) throws Exception{

        //Einlesen und Pruefen der Aufrufzeile
        if(argv.length < 2){
            System.out.println("Fehlerhafter Aufruf.");
        }

        String hostId = argv[0];
        int port = Integer.parseInt(argv[1]);

        //Uebersetzung des Hostnamen in IP-Adresse mit DNS
        InetAddress ipAddress = InetAddress.getByName(hostId);

        //Erzeuge ClientSocket
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sendData;

        //sende Datagramm an Server
        for(int i = 0; i <= 1000000; i++){

            //Verpacken der Integers in Byte-Array
            sendData = ByteBuffer.allocate(4).putInt(i).array();

            //Erzeuge Datagramm mit zu sendenden Daten, Laenge, IP-Adresse, Port
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);

            //Sende Datagramm an Server
            clientSocket.send(sendPacket);
            //Thread.sleep(1);

        }

        clientSocket.close();
    }
}
