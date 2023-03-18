package dados;


public class Imobiliaria {
    private String nomeImobiliaria;
    private Imovel[] imoveis = new Imovel[10];
    private int quatidadeImoveis = 0;
    public Imobiliaria(String nomeImobiliaria, Imovel[] imoveis, int quatidadeImoveis) {
        this.nomeImobiliaria = nomeImobiliaria;
        this.imoveis = imoveis;
        this.quatidadeImoveis = quatidadeImoveis;
    }
    public Imobiliaria(){};

    public String getNomeImobiliaria() {
        return nomeImobiliaria;
    }
    public void setNomeImobiliaria(String nomeImobiliaria) {
        this.nomeImobiliaria = nomeImobiliaria;
    }
    public Imovel[] getImoveis() {
        return imoveis;
    }
    public void setImoveis(Imovel imovel) {
        if(this.quatidadeImoveis < 10){
            this.imoveis[this.quatidadeImoveis] = imovel;
            this.quatidadeImoveis ++;
        }
    }
    public int getQuatidadeImoveis() {
        return quatidadeImoveis;
    }
    public void setQuatidadeImoveis(int quatidadeImoveis) {
        this.quatidadeImoveis = quatidadeImoveis;
    }
    public Imovel[] filtrarPorArea(float x){
        Imovel[] imoveisOrdenados = new Imovel[this.quatidadeImoveis];
        Imovel aux = new Imovel();
        for(int i = 0;i<this.quatidadeImoveis;i+=1){
            for(int in = i;in<this.quatidadeImoveis;in+=1){
                if(this.imoveis[in].areaTotal() >= x && !this.imoveis[in].equals(aux)){
                    imoveisOrdenados[i] = this.imoveis[in];
                    break;
                }
            }
        }
        for(int i =0;i<imoveisOrdenados.length;i+=1){
            for(int in =i;in<imoveisOrdenados.length;in+=1){
                if((imoveisOrdenados[in]!=null)&&(imoveisOrdenados[i].getPreco() > imoveisOrdenados[in].getPreco())){
                    aux = imoveisOrdenados[i];
                    imoveisOrdenados[i] = imoveisOrdenados[in];
                    imoveisOrdenados[in] = aux;
                }
            }
        }
        return imoveisOrdenados;
    }
    public String toString() {
        String imoveisString = "Imoveis: ";
        for (int i = 0; i < this.quatidadeImoveis; i += 1) {
            imoveisString += "\n\nID-" + i + "\n";
            imoveisString += this.imoveis[i].toString();
        }
        return imoveisString;
    }
    
}
