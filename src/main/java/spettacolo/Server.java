package spettacolo;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public void avvia(){
        try(
            ServerSocket server = new ServerSocket(12345);
            ExecutorService pool =  Executors.newCachedThreadPool();
    ){
            System.out.println("Server aperto sulla porta " + server.getLocalPort());
            while(true){
                System.out.println("Server in ascolto...");
                Socket client = server.accept();
                System.out.println("Connessione accettata dal client all' indirizzo " + client.getInetAddress());

                pool.execute(new ClientHandler(client));
            }

        }
        catch(IOException e){
            System.out.println("Errore di Input/Output" + e.getMessage());
        }
        catch(Exception e){
            System.out.println("C'è stato un errore");
        }
    }
}
