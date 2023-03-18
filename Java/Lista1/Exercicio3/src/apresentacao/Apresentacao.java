package apresentacao;
import dados.*;

public class Apresentacao { 
    private static Imovel imovel1 = new Imovel();
    private static Imovel imovel2 = new Imovel();
    private static Imobiliaria imobiliaria = new Imobiliaria();
    public static void main(String[] args) {
        imovel1.setComprimento(10);
        imovel1.setLargura(2);
        imovel1.setPreco(120000);
        imovel2.setComprimento(10);
        imovel2.setLargura(4);
        imovel2.setPreco(40);
        imobiliaria.setImoveis(imovel2);
        imobiliaria.setImoveis(imovel1);
        Imovel[] imoveisFiltrados=new Imovel[4];
        imoveisFiltrados = imobiliaria.filtrarPorArea(30);
        for(int i = 0; i < imoveisFiltrados.length; i+=1){
            if(imoveisFiltrados[i]!=null)
                System.out.println(imoveisFiltrados[i].toString());
        }
    }
}
