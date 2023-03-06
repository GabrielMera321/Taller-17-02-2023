package co.edu.unbosque.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private int puerto;
    private ServerSocket servidorSocket;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public void iniciar() throws IOException {
        servidorSocket = new ServerSocket(puerto);
        System.out.println("Servidor iniciado en el puerto " + puerto);

        while (true) {
            Socket socket = servidorSocket.accept();
            new Cliente(socket).start();
        }
    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor(1070);
            servidor.iniciar();
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}

