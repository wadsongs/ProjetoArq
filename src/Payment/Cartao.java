package Payment;

public class Cartao implements Pagamento{
    @Override
    public void pagamentoCartao() {
        System.out.println("Payment.Pagamento Payment.Cartao realizado!");
    }

    @Override
    public void pagamentoPix() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
