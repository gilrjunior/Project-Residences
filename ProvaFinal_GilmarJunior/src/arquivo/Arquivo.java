/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivo;

import bancoDAO.BancoDAO;
import classes.Dono;
import classes.Residencia;
import classes.Venda;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tela.TelaDonos;

/**
 *
 * @author User
 */
public class Arquivo {
    
    
    public static int i = 0;
    
    public void Gera_txt(){
    
    try{
            String caminho = "C:\\Users\\User\\Desktop\\Prova_Final_POOV\\RelatorioTXT_"+i+".txt";
            i++;
            BancoDAO  bancodao = null;
            File file = new File(caminho);
                if(file.createNewFile())
                {
                    JOptionPane.showMessageDialog(null, "O arquivo foi criado");
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    try {
                         bancodao = new BancoDAO();
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaDonos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TelaDonos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    ArrayList <Dono> listadonos = bancodao.mostraDono(0, "");
                    ArrayList <Venda> listavenda = bancodao.mostraVenda(0);
                    ArrayList <Residencia> listaresidencia = bancodao.mostraResidencia(0, "");
                    
                    bw.write("Informações sobre os Donos de Casas");
                    bw.newLine();
                    bw.newLine();
                    
                    for(Dono dono : listadonos){
                        
                        bw.write(dono.getNome()+"  -  "+dono.getCpf()+"  -  "+dono.getTelefone()+"  -  "+dono.getRendaMensal());
                        bw.newLine();
                    }
                    
                    bw.newLine();
                    bw.newLine();
                    
                    bw.write("Informações sobre as Residências: ");
                    bw.newLine();
                    bw.newLine();
                    
                    for(Residencia res : listaresidencia){
                        
                        bw.write(res.getCod_res()+"  -  "+res.getArea()+"  -  "+res.getRua()+","+res.getNum()+"  -  "+res.getBairro());
                        bw.newLine();
                    }
                    
                    bw.newLine();
                    bw.newLine();
                    
                    bw.write("Informações sobre as Vendas: ");
                    bw.newLine();
                    bw.newLine();
                    
                    for(Venda venda : listavenda){
                        
                        bw.write(venda.getCod_venda()+"  -  "+venda.getCpf()+"  -  "+venda.getCod_res()+"  -  "+venda.getData()+"  -  "+venda.getValor());
                        bw.newLine();
                    }
                    
                    bw.close();
                    fw.close();
                }else{
                    System.out.println("O arquivo não foi criado.");
                }
	}catch(IOException e){
            System.out.print("Erro: "+e.toString());
	}
    
    }

    
}
