package apresentacao;
import dados.*;

public class Apresentacao {

    private static Endereco endereco1 = new Endereco("Samtarem","Floresta","Joinville","Santa Catarina",89211675,157);
    private static Endereco endereco2 = new Endereco();

    private static Produto produto1 = new Produto(0001,"Refrigerante","Refrigerante de cola 350ml","Bebida",3.50,"Coca-Cola");
    private static Produto produto2 = new Produto();
    
    private static ClienteAPP cliente1 = new ClienteAPP("Leonardo de Souza","02010204913",18,9,2003,endereco1);
    private static ClienteAPP cliente2 = new ClienteAPP();

    private static Produto[] produtostest = new Produto[] {produto1,produto2};
    private static PedidoApp pedido1 = new PedidoApp("A000001","Cartão debito",endereco1,cliente1,produtostest,2,(produto1.getPrecoProduto()+produto2.getPrecoProduto()));
    private static PedidoApp pedido2 = new PedidoApp();

    private static Funcionario funcionario1 = new Funcionario("Edinaldo Pereira","Caixa","11111111111","40028922",endereco2);
    private static Funcionario funcionario2 = new Funcionario();

    public static void main(String[] args) {
        endereco2.setBairro("iririu");
        endereco2.setCidade("joinville");
        endereco2.setCep(55380290);
        endereco2.setEstado("Santa Catarina");
        endereco2.setNumeroCasa(132);
        endereco2.setRua("Orivaldo Pereira");

        produto2.setIdProduto(0002);
        produto2.setDescricaoProduto("Batatinha onduladas");
        produto2.setMarcaProduto("Pringles");
        produto2.setNomeProduto("Pringles de Bacon");
        produto2.setPrecoProduto(15.75);
        produto2.setTipoProduto("Batata Chips");

        cliente2.setCpf("128754998892");
        cliente2.setDataAno(2000);
        cliente2.setDataDia(10);
        cliente2.setDataMes(10);
        cliente2.setEndereco(endereco2);
        cliente2.setNomeCliente("Eduardo Silva");

        pedido2.setCliente(cliente2);
        pedido2.setCodigoProduto("A000002");
        pedido2.setEnderecoEntrega(endereco2);
        pedido2.setMetodoPagamento("Dinheiro");
        pedido2.setPrecoTotal(20);
        pedido2.setpedidosProdutos(produto1);
        pedido2.setpedidosProdutos(produto2);

        funcionario2.setCpf("18347298473298");
        funcionario2.setEndereco(endereco2);
        funcionario2.setNomeFuncionario("Carlos alberto");
        funcionario2.setSetorFuncionario("Limpeza");
        funcionario2.setTelefone("840375437857349");
        
        System.out.println(pedido1.toString());
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(pedido2.toString());
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(funcionario2.toString());
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(funcionario1.toString());
        System.out.println("\n");
        System.out.println("\n");
    }

    










}
