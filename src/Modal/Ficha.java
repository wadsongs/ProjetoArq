package Modal;

public class Ficha {
    private String nome;
    private int ficha_id;
    private int usuario_id;

    public Ficha(int ficha_id,int usuario_id) {

        this.ficha_id = ficha_id;
        this.usuario_id = usuario_id;
    }

    public int getFicha_id() {
        return ficha_id;
    }

    public void setFicha_id(int ficha_id) {
        this.ficha_id = ficha_id;
    }


    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
