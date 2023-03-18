package dados;
public class PedidoApp {
    private String codigoPedido,metodoPagamento;
    private Endereco enderecoEntrega;
    private ClienteAPP cliente;
    private Produto [] pedidosProdutos = new Produto[50];
    private int quantidadeProdutos = 0;
    private double precoTotal;

    public PedidoApp(){}
    
    public PedidoApp(String codigoPedido, String metodoPagamento, Endereco enderecoEntrega, ClienteAPP cliente,
            Produto[] pedidosProdutos, int quantidadeProdutos, double precoTotal) {
        this.codigoPedido = codigoPedido;
        this.metodoPagamento = metodoPagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.cliente = cliente;
        this.pedidosProdutos = pedidosProdutos;
        this.quantidadeProdutos = quantidadeProdutos;
        this.precoTotal = precoTotal;
    }
    public String getCodigoPedido() {
        return this.codigoPedido;
    }
    public void setCodigoProduto(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    public String getMetodoPagamento() {
        return this.metodoPagamento;
    }
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    public Endereco getEnderecoEntrega() {
        return this.enderecoEntrega;
    }
    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public ClienteAPP getCliente() {
        return this.cliente;
    }
    public void setCliente(ClienteAPP cliente) {
        this.cliente = cliente;
    }
    public Produto[] getpedidosProdutos() {
        return pedidosProdutos;
    }
    public void setpedidosProdutos(Produto pedidosProdutos) {
        if(this.quantidadeProdutos < 50){
            this.pedidosProdutos[quantidadeProdutos] = pedidosProdutos;
            quantidadeProdutos ++;
        }
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
    /*public LocalDate getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }*/
    @Override
    public String toString() {
        String pedidoString = "";
        pedidoString +="PedidoApp [codigoProduto=" + this.codigoPedido + ", metodoPagamento=" + this.metodoPagamento
                + ", enderecoEntrega=" + this.enderecoEntrega + ", cliente=" + this.cliente.toString() + ", quantidadeProdutos=" + this.quantidadeProdutos;
        for(int i = 0;i<this.quantidadeProdutos;i++){
            pedidoString += this.pedidosProdutos[i].toString();
            pedidoString += "\n";
        }
        return pedidoString;
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
        if (codigoPedido == null) {
            if (other.codigoPedido != null)
                return false;
        } else if (!codigoPedido.equals(other.codigoPedido))
            return false;
        return true;
    }
}
