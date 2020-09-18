import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String host = "netology.homework";
        int port = 80;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println(in.readLine());

            String name = scanner.nextLine();
            out.println(name);

            System.out.println(in.readLine());
            System.out.println(in.readLine());

            String yesNo = scanner.nextLine();
            out.println(yesNo);

            System.out.println(in.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
