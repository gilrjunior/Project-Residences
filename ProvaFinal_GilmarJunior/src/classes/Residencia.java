package classes;

public class Residencia {
    
    private int cod_res;
    private float area;
    private String rua;
    private String num;
    private String bairro;

    public Residencia(int cod_res, float area, String rua, String num, String bairro) {
        this.cod_res = cod_res;
        this.area = area;
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
    }
    
    public Residencia() {
        this.cod_res = 0;
        this.area = 0;
        this.rua = "";
        this.num = "";
        this.bairro = "";
    }

    public int getCod_res() {
        return cod_res;
    }

    public void setCod_res(int cod_res) {
        this.cod_res = cod_res;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Residencia{" + "cod_res=" + cod_res + ", area=" + area + ", rua=" + rua + ", num=" + num + ", bairro=" + bairro + '}';
    }
    
    
    
    
}
