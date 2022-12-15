package classes;

import java.time.LocalDate;
import java.util.Objects;

public class Venda {
    
    private String cod_venda;
    private String cpf;
    private int cod_res;
    private LocalDate Data;
    private float valor;

    public Venda(String cod_venda, String cpf, int cod_res, LocalDate Data, float valor) {
        this.cod_venda = cod_venda;
        this.cpf = cpf;
        this.cod_res = cod_res;
        this.Data = Data;
        this.valor = valor;
    }

    public Venda() {
        this.cod_venda = "";
        this.cpf = "";
        this.cod_res = 0;
        this.valor = 0;
    }

    public String getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(String cod_venda) {
        this.cod_venda = cod_venda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCod_res() {
        return cod_res;
    }

    public void setCod_res(int cod_res) {
        this.cod_res = cod_res;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate Data) {
        this.Data = Data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Venda{" + "cod_venda=" + cod_venda + ", cpf=" + cpf + ", cod_res=" + cod_res + ", Data=" + Data + ", valor=" + valor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cod_venda);
        return hash;
    }   
    
    
}
