package br.com.mvcomida.encomenda.model;

public enum Comida {
    SALGADO("Salgado"), CAFE("Café"), CHA("Chá"), SUCO("Suco"), BOLO("Bolo"), PAO("Pão"), PRESUNTO("Presunto"), QUEIJO("Queijo"), MANTEIGA("Manteiga");

    private final String descricao;

    Comida(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
