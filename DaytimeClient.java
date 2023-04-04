import java.net.*;
import java.io.*;
public class DaytimeClient
{
    public static void main(String args[])
    {
        Socket theSocket;
        String hostName;
        DataInputStream theTimeStream;
        if(args.length>0)
        {
            hostName = args[0];
        }
        else
        {
            hostName = "localhost";
        }
        try
        {
            theSocket = new Socket(hostName, 13);
            theTimeStream = new DataInputStream(theSocket.getInputStream());
            String theTime = theTimeStream.readLine();
            System.out.println("It is "+theTime+" at "+hostName);
        }
        catch(UnknownHostException e)
        {
            System.err.println(e);
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
}