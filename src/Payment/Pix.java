package Payment;

public class Pix implements Pagamento{
    @Override
    public void pagamentoCartao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pagamentoPix() {
        System.out.println("Payment.Pagamento Payment.Pix realizado!");
    }
}
