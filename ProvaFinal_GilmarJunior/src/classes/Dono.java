
package classes;

public class Dono {
    
    private String cpf;
    private String nome;
    private String telefone;
    private float rendaMensal;

    public Dono(String cpf, String nome, String telefone, float rendaMensal) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.rendaMensal = rendaMensal;
    }
    
    public Dono() {
        this.cpf = "";
        this.nome = "";
        this.telefone = "";
        this.rendaMensal = 0;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    @Override
    public String toString() {
        return "Dono{" + "cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", rendaMensal=" + rendaMensal + '}';
    }
    
    
    
    
}
