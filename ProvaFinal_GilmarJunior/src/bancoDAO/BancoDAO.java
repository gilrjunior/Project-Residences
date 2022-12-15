
package bancoDAO;

import classes.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoDAO {
    
     Connection conexao;
    
    public BancoDAO() throws SQLException, ClassNotFoundException{
        this.conexao = Conexao.getConexao();
    }
    
    public void insertDono(Dono dono){
        PreparedStatement ps;
        String query = "insert into dono values(?,?,?,?)";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, dono.getCpf());
            ps.setString(2, dono.getNome());
            ps.setString(3, dono.getTelefone());
            ps.setFloat(4, dono.getRendaMensal());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao inserida com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
        }
    }
    
    public void insertResidencia(Residencia residencia){
        PreparedStatement ps;
        String query = "insert into residencia values(?,?,?,?)";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setInt(1, residencia.getCod_res());
            ps.setFloat(2, residencia.getArea());
            ps.setString(3, residencia.getRua()+" - "+residencia.getNum());
            ps.setString(4, residencia.getBairro());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao inserida com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
        }
    }
    
    public void insertVenda(Venda venda){
        PreparedStatement ps;
        String query = "insert into venda values(?,?,?,?,?)";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, venda.getCod_venda());
            ps.setString(2, venda.getCpf());
            ps.setInt(3, venda.getCod_res());
            ps.setString(4, venda.getData().toString());
            ps.setFloat(5, venda.getValor());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao inserida com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
        }
    }
    
    public void updateDono(Dono dono){
        PreparedStatement ps;
        String query = "update dono set cpf=?, nome=?, telefone=?, renda_mensal=? where cpf=?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, dono.getCpf());
            ps.setString(2, dono.getNome());
            ps.setString(3, dono.getTelefone());
            ps.setFloat(4, dono.getRendaMensal());
            ps.setString(5, dono.getCpf());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao atualizada com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao atualizar no banco: "+e.toString());
        }
    }
    
    public void updateResidencia(Residencia residencia){
        PreparedStatement ps;
        String query = "update residencia set cod_residencia=?, area=?, endereco=?, bairro=? where cod_residencia=?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setInt(1, residencia.getCod_res());
            ps.setFloat(2, residencia.getArea());
            ps.setString(3, residencia.getRua()+" - "+residencia.getNum());
            ps.setString(4, residencia.getBairro());
            ps.setInt(5, residencia.getCod_res());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao atualizada com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao atualizar no banco: "+e.toString());
        }
    }
    
    public void updateVenda(Venda venda){
        PreparedStatement ps;
        String query = "update venda set cod_venda=?, cpf=?, cod_residencia=?, data=?, valor_venda=? where cod_venda=?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, venda.getCod_venda());
            ps.setString(2, venda.getCpf());
            ps.setInt(3, venda.getCod_res());
            ps.setString(4, venda.getData().toString());
            ps.setFloat(5, venda.getValor());
            ps.setString(6, venda.getCod_venda());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao atualizada com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao atualizar no banco: "+e.toString());
        }
    }
    
    public void excluirDono(String cpf){

        PreparedStatement ps;
        String query = "delete from dono where cpf =?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, cpf);
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "\n Informacao removida com sucesso.");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao alterar no banco: "+e.toString());
        }
        
    }
    
    public void excluirResidencia(int cod_res){

        PreparedStatement ps;
        String query = "delete from residencia where cod_residencia=?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setInt(1, cod_res);
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "\n Informacao removida com sucesso.");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao alterar no banco: "+e.toString());
        }
        
    }
    
    public void excluirVenda(String cod_venda){

        PreparedStatement ps;
        String query = "delete from venda where cod_venda=?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, cod_venda);
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "\n Informacao removida com sucesso.");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao alterar no banco: "+e.toString());
        }
        
    }
    
     public ArrayList<Dono> mostraDono(int verif, String cpf){
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Dono> listadonos = null;
        String query  = "select * from dono order by nome";
        if(verif == 1){
            query  = "select * from dono where cpf=?";
        }
        
        try{
            ps = this.conexao.prepareStatement(query);
            if(verif == 1){
                ps.setString(1, cpf);
            }
            res = ps.executeQuery();
            listadonos = new ArrayList();
            
            while(res.next())
            {
                Dono dono = new Dono();
                
                dono.setCpf(res.getString("cpf"));
                dono.setNome(res.getString("nome"));
                dono.setTelefone(res.getString("telefone"));
                dono.setRendaMensal(res.getFloat("renda_mensal"));
                
                listadonos.add(dono);
            }
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (listadonos);
        
    }
     
    public ArrayList<Residencia> mostraResidencia(int verif, String bairro){
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Residencia> listaresidencia = null;
        String query  = "select * from residencia";
        if(verif == 1){
            query  = "select * from residencia where bairro=?";
        }
        
        try{
            ps = this.conexao.prepareStatement(query);
            if(verif == 1){
                ps.setString(1, bairro);
            }
            res = ps.executeQuery();
            listaresidencia = new ArrayList();
            
            while(res.next())
            {
                Residencia residencia = new Residencia();
                
                residencia.setCod_res(res.getInt("cod_residencia"));
                residencia.setArea(res.getFloat("area"));
                String a[] = res.getString("endereco").split(" - ");
                residencia.setRua(a[0]);
                residencia.setNum(a[1]);
                residencia.setBairro(res.getString("bairro"));
                
                
                listaresidencia.add(residencia);
            }
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (listaresidencia);
        
    }
    
    public ArrayList<Venda> mostraVenda(int verif){
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Venda> listavendas = null;
        String query  = "select * from venda";
        if(verif == 1){
            query  = "select * from residencia where data > ?";
        }
        
        try{
            ps = this.conexao.prepareStatement(query);
            if(verif == 1){
                ps.setString(1, "current_date() - interval'180' day");
            }
            res = ps.executeQuery();
            listavendas = new ArrayList();
            
            while(res.next())
            {
                Venda venda = new Venda();
                
                venda.setCod_venda(res.getString("cod_venda"));
                venda.setCpf(res.getString("cpf"));
                venda.setCod_res(res.getInt("cod_residencia"));
                venda.setData(res.getDate("data").toLocalDate());
                venda.setValor(res.getFloat("valor_venda"));
                
                listavendas.add(venda);
            }
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (listavendas);
        
    }
    
}
