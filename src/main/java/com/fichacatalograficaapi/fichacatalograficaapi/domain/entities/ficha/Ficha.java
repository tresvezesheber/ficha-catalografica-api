package com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha;

public class Ficha {
    private String autor;

    private String titulo;

    private String subtitulo;

    private String cidade;

    private String ano;

    private String numeroPaginaPre;

    private String numeroPaginaTotal;

    private boolean ilustracao;

    private boolean bibliografia;

    private boolean anexo;

    private MonografiaTitulacao monografiaTitulacao;

    private String instituicao;

    private String curso;

    private String orientador;

    private String coorientador;

    private String palavrasChave;

    public String getNumeroPaginaTotal() {
        return numeroPaginaTotal;
    }

    public void setNumeroPaginaTotal(String numeroPaginaTotal) {
        this.numeroPaginaTotal = numeroPaginaTotal;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNumeroPaginaPre() {
        return numeroPaginaPre;
    }

    public void setNumeroPaginaPre(String numeroPaginaPre) {
        this.numeroPaginaPre = numeroPaginaPre;
    }

    public boolean isIlustracao() {
        return ilustracao;
    }

    public void setIlustracao(boolean ilustracao) {
        this.ilustracao = ilustracao;
    }

    public boolean isBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(boolean bibliografia) {
        this.bibliografia = bibliografia;
    }

    public boolean isAnexo() {
        return anexo;
    }

    public void setAnexo(boolean anexo) {
        this.anexo = anexo;
    }

    public MonografiaTitulacao getMonografiaTitulacao() {
        return monografiaTitulacao;
    }

    public void setMonografiaTitulacao(MonografiaTitulacao monografiaTitulacao) {
        this.monografiaTitulacao = monografiaTitulacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getCoorientador() {
        return coorientador;
    }

    public void setCoorientador(String coorientador) {
        this.coorientador = coorientador;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
}
