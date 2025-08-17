package Server;


// 1. Open a socket.
// 2. Open an input stream and output stream to the socket.
// 3. Read from and write to the stream according to the server's protocol.
// 4. Close the streams.
// 5. Close the socket.

import CW.loginCw;
import Frame.General.Login;
import Logic.User;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * When a client connects the server spawns a thread to handle the client.
 * This way the server can handle multiple clients at the same time.
 *
 * This keyword should be used in setters, passing the object as an argument,
 * and to call alternate constructors (a constructor with a different set of
 * arguments.
 */

// Runnable is implemented on a class whose instances will be executed by a thread.
public class ClientHandler implements Runnable {

    // Array list of all the threads handling clients so each message can be sent to the client the thread is handling.
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private static String type;
    // Id that will increment with each new client.

    // Socket for a connection, buffer reader and writer for receiving and sending data respectively.
    private Socket socket;
    private ArrayList<Integer> cardsNum = new ArrayList<>();

    private String clientUsername;

    // Creating the client handler from the socket the server passes.
    public ClientHandler(Socket socket) {
        this.socket = socket;

        // Add the new client handler to the array so they can receive messages from others.
        clientHandlers.add(this);
            new Login().setVisible(true);
    }

    // Everything in this method is run on a separate thread. We want to listen for messages
    // on a separate thread because listening (bufferedReader.readLine()) is a blocking operation.
    // A blocking operation means the caller waits for the callee to finish its operation.
    @Override
    public void run() {

    }


    // Send a message through each client handler thread so that everyone gets the message.
    // Basically each client handler is a connection to a client. So for any message that
    // is received, loop through each connection and send it down it.
    public void broadcastMessage(String messageToSend) {

    }

    // If the client disconnects for any reason remove them from the list so a message isn't sent down a broken connection.
    public void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUsername + " has left the chat!");
    }

    // Helper method to close everything so you don't have to repeat yourself.
    public void closeEverything(Socket socket) {
        // Note you only need to close the outer wrapper as the underlying streams are closed when you close the wrapper.
        // Note you want to close the outermost wrapper so that everything gets flushed.
        // Note that closing a socket will also close the socket's InputStream and OutputStream.
        // Closing the input stream closes the socket. You need to use shutdownInput() on socket to just close the input stream.
        // Closing the socket will also close the socket's input stream and output stream.
        // Close the socket after closing the streams.

        // The client disconnected or an error occurred so remove them from the list so no message is broadcasted.
        removeClientHandler();
        try {

            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        ClientHandler.type = type;
    }
}

