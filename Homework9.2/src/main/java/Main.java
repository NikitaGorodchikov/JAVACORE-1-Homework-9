import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 80;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");

            out.println("What`s your name? :^D");

            final String name = in.readLine();
            out.println(String.format("Hi %s!", name));

            out.println("Are you child? (yes/no)");

            final String answer = in.readLine();
            if (answer.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else if (answer.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            } else {
                out.println(String.format("Sorry, %s. I don't understand you :^(", name));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
