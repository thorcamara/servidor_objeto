/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author User
 */

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;

public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        //definir o serverSocket
        ServerSocket serverSocket = new ServerSocket(3334);
        System.out.println("A porta 3334 foi aberta !!");
        System.out.println("Servidor esperando receber objeto de cliente..");

        //aguardar solicitacao do cliente
        Socket socket = serverSocket.accept();

        //mostrar endereco ip que se conectou
        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

        //definir stream de entrada de dados no servidor
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        Pessoa p = (Pessoa) entrada.readObject();
        System.out.println("Nome  : " + p.getNome()
                + "\nEndereco   : " + p.getEndereco()
                +"\nSalario     :" + p.getSalario()
                + "\nIdade  :" + p.getIdade());

        //fechar a stream de entrada de dados
        entrada.close();

        //fechar sockets de comunicacao e conexao
        socket.close();
        serverSocket.close();
    }

}