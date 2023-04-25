/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author User
 */

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        //abrir a conexao
        Socket socket = new Socket ("localhost", 3334);
        
        //definir stream de saida de dados do cliente
        ObjectOutputStream saida = new ObjectOutputStream (socket.getOutputStream());
        Pessoa p = new Pessoa ("Fulano Silva","Rua do rio", 6000, 30);
        saida.writeObject(p);
        
        //fechar a stream de saida de dados
        saida.close();
        
        //fecha o socket
        socket.close();
    }
    
}