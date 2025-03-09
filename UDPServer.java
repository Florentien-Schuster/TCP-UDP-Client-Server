import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class UDPServer {
    public static void main(String argv[]) throws Exception{

        //Erzeuge DatagrammSocket auf Port 2345
        int port = 2345;
        DatagramSocket serverSocket = new DatagramSocket(port);

        byte[] numbers = new byte[1024];
        int expectedNumber = 0;
        
        while(true) {
            
            //reserviere Speicher fuer empfangenes Datagramm
            DatagramPacket receivePacket = new DatagramPacket(numbers, numbers.length);

            //Empfange Datagramm
            serverSocket.receive(receivePacket);

            //Auspacken der Integers aus receivePacket
            int clientNumber = ByteBuffer.wrap(receivePacket.getData(), 0, receivePacket.getLength()).getInt();

            //Vergleich mit aktueller Zahl
            if(expectedNumber != clientNumber){
            	System.out.println("Error! Expected number: " + expectedNumber + ", received number: " + clientNumber + ".\n");
            	expectedNumber = clientNumber;
            }
            expectedNumber++;

        }
    }
}


/*
public static ByteBuffer wrap(byte[] array,
                              int offset,
                              int length)

Wraps a byte array into a buffer.

The new buffer will be backed by the given byte array; that is, modifications to the buffer will cause the array to be modified and vice versa. The new buffer's capacity will be array.length, its position will be offset, its limit will be offset + length, and its mark will be undefined. Its backing array will be the given array, and its array offset will be zero.

Parameters:
    array - The array that will back the new buffer
    offset - The offset of the subarray to be used; must be non-negative and no larger than array.length. The new buffer's position will be set to this value.
    length - The length of the subarray to be used; must be non-negative and no larger than array.length - offset. The new buffer's limit will be set to offset + length.
Returns:
    The new byte buffer
*/
