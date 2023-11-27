/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolojacarros;

/**
 *
 * @author Aluno
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmpacotamentoVendas {
    
     public static void gravarArquivosVendas(ArrayList<Vendas> list, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            arq.delete();
            arq.createNewFile();
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(list);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    public static ArrayList<Vendas> lerArquivosVendas(String nomeArq) {
        ArrayList<Vendas> list = new ArrayList();
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                list = (ArrayList<Vendas>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        return (list);

    }
    
}
