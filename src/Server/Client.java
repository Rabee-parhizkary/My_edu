package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    // A client has a socket to connect to the server and a reader and writer to receive and send messages respectively.
    private Socket socket;
    public Client(Socket socket) {
        this.socket = socket;
    }

    // Sending a message isn't blocking and can be done without spawning a thread, unlike waiting for a message.
    public void sendMessage() {

    }

    // Listening for a message is blocking so need a separate thread for that.
    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    // Helper method to close everything so you don't have to repeat yourself.
    public void closeEverything(Socket socket) {
        // Note you only need to close the outer wrapper as the underlying streams are closed when you close the wrapper.
        // Note you want to close the outermost wrapper so that everything gets flushed.
        // Note that closing a socket will also close the socket's InputStream and OutputStream.
        // Closing the input stream closes the socket. You need to use shutdownInput() on socket to just close the input stream.
        // Closing the socket will also close the socket's input stream and output stream.
        // Close the socket after closing the streams.
        try {

            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Run the program.
    public static void main(String[] args) throws IOException {

        // Create a socket to connect to the server.

        Socket socket = new Socket("localhost", 1234);

        // Pass the socket and give the client a username.
        Client client = new Client(socket);

        // Infinite loop to read and send messages.

        client.listenForMessage();
        client.sendMessage();
    }

}
