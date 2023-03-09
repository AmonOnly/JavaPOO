package PR2_1_Apresentação;
import PR2_1_Dados.*;

public class Main {
    public static void main(String[] args){
        Grupo t = new Grupo();
        Pessoa p1 = new Pessoa();
        p1.setNome("Leonardo");
        p1.setAltura(1.71f);
        p1.setIdade(20);
        p1.setMassa(74.2f);

        Pessoa p2 = new Pessoa();
        p2.setNome("Carlos");
        p2.setAltura(1.63f);
        p2.setIdade(14);
        p2.setMassa(62.2f);

        Pessoa p3 = new Pessoa();
        p3.setNome("Marcelo");
        p3.setAltura(1.80f);
        p3.setIdade(23);
        p3.setMassa(78.1f);

        Pessoa p4 = new Pessoa();
        p4.setNome("Milus");
        p4.setAltura(1.85f);
        p4.setIdade(43);
        p4.setMassa(81.8f);

        Pessoa p5 = new Pessoa();
        p5.setNome("Ytam");
        p5.setAltura(1.51f);
        p5.setIdade(10);
        p5.setMassa(44.6f);

        t.setPessoa(p1);
        t.setPessoa(p2);
        t.setPessoa(p3);
        t.setPessoa(p4);
        t.setPessoa(p5);

        t.ordena();
        for(int i = 0;i<5;i++){
            System.out.println("Nome: " + t.getPessoas()[i].getNome());
            System.out.println("Altura: " + t.getPessoas()[i].getAltura());
            System.out.println("Idade: " + t.getPessoas()[i].getIdade());
            System.out.println("Massa " + t.getPessoas()[i].getMassa());
            System.out.println("IMC: " + t.getPessoas()[i].calculaimc());
        }
    }
}
