package dados;
import java.util.Arrays;
import java.util.Date;
public class PedidoApp {
    private String codigoProduto,metodoPagamento;
    private Endereco enderecoEntrega;
    private ClienteAPP cliente;
    private Produto [] produtos = new Produto[50];
    private int quantidadeProdutos = 0;
    private double precoTotal;
    private Date dataPedido = new Date();

    public PedidoApp(){}
    
    public PedidoApp(String codigoProduto, String metodoPagamento, Endereco enderecoEntrega, ClienteAPP cliente,
            Produto[] produtos, int quantidadeProdutos, double precoTotal, Date dataPedido) {
        this.codigoProduto = codigoProduto;
        this.metodoPagamento = metodoPagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.cliente = cliente;
        this.produtos = produtos;
        this.quantidadeProdutos = quantidadeProdutos;
        this.precoTotal = precoTotal;
        this.dataPedido = dataPedido;
    }
    public String getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public String getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public ClienteAPP getCliente() {
        return cliente;
    }
    public void setCliente(ClienteAPP cliente) {
        this.cliente = cliente;
    }
    public Produto[] getProdutos() {
        return produtos;
    }
    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }
    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }
    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }
    public double getPrecoTotal() {
        return precoTotal;
    }
    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    public Date getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    @Override
    public String toString() {
        return "PedidoApp [codigoProduto=" + codigoProduto + ", metodoPagamento=" + metodoPagamento
                + ", enderecoEntrega=" + enderecoEntrega + ", cliente=" + cliente.toString() + ", produtos="
                + Arrays.toString(produtos) + ", quantidadeProdutos=" + quantidadeProdutos + ", precoTotal="
                + precoTotal + ", dataPedido=" + dataPedido + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoApp other = (PedidoApp) obj;
        if (codigoProduto == null) {
            if (other.codigoProduto != null)
                return false;
        } else if (!codigoProduto.equals(other.codigoProduto))
            return false;
        return true;
    }
}
