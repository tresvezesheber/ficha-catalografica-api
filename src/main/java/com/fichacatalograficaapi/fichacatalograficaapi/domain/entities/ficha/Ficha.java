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

    public Ficha(String autor, String titulo, String subtitulo, String cidade, String ano, String numeroPaginaPre, String numeroPaginaTotal, boolean ilustracao, boolean bibliografia, boolean anexo, MonografiaTitulacao monografiaTitulacao, String instituicao, String curso, String orientador, String coorientador, String palavrasChave) {
        this.autor = autor;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.cidade = cidade;
        this.ano = ano;
        this.numeroPaginaPre = numeroPaginaPre;
        this.numeroPaginaTotal = numeroPaginaTotal;
        this.ilustracao = ilustracao;
        this.bibliografia = bibliografia;
        this.anexo = anexo;
        this.monografiaTitulacao = monografiaTitulacao;
        this.instituicao = instituicao;
        this.curso = curso;
        this.orientador = orientador;
        this.coorientador = coorientador;
        this.palavrasChave = palavrasChave;
    }

    public void verificaSeEstaVazio(String campo) {
        verificaSeEstaNulo(campo);
        if (campo.isEmpty()) {
            throw new IllegalArgumentException(campo + " não pode estar vazio");
        }
    }

    public void verificaSeEstaNulo(Object campo) {
        if (campo == null) {
            throw new IllegalArgumentException(campo + " não pode estar nulo");
        }
    }

    public void verificarNumeroMinimoDePalavrasChave(int quantidade) {
        if (this.palavrasChave.split(",").length < quantidade) {
            throw new IllegalArgumentException("O campo palavras chave deve conter no mínimo " + quantidade + " palavras chave");
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        verificaSeEstaVazio(autor);
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        verificaSeEstaVazio(titulo);
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
        verificaSeEstaVazio(cidade);
        this.cidade = cidade;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        verificaSeEstaVazio(ano);
        this.ano = ano;
    }

    public String getNumeroPaginaPre() {
        return numeroPaginaPre;
    }

    public void setNumeroPaginaPre(String numeroPaginaPre) {
        verificaSeEstaVazio(numeroPaginaPre);
        this.numeroPaginaPre = numeroPaginaPre;
    }

    public String getNumeroPaginaTotal() {
        return numeroPaginaTotal;
    }

    public void setNumeroPaginaTotal(String numeroPaginaTotal) {
        verificaSeEstaVazio(numeroPaginaTotal);
        this.numeroPaginaTotal = numeroPaginaTotal;
    }

    public boolean isIlustracao() {
        return ilustracao;
    }

    public void setIlustracao(boolean ilustracao) {
        verificaSeEstaNulo(ilustracao);
        this.ilustracao = ilustracao;
    }

    public boolean isBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(boolean bibliografia) {
        verificaSeEstaNulo(bibliografia);
        this.bibliografia = bibliografia;
    }

    public boolean isAnexo() {
        return anexo;
    }

    public void setAnexo(boolean anexo) {
        verificaSeEstaNulo(anexo);
        this.anexo = anexo;
    }

    public MonografiaTitulacao getMonografiaTitulacao() {
        return monografiaTitulacao;
    }

    public void setMonografiaTitulacao(MonografiaTitulacao monografiaTitulacao) {
        verificaSeEstaNulo(monografiaTitulacao);
        this.monografiaTitulacao = monografiaTitulacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        verificaSeEstaVazio(instituicao);
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        verificaSeEstaVazio(curso);
        this.curso = curso;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        verificaSeEstaVazio(orientador);
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
        verificaSeEstaVazio(palavrasChave);
        verificarNumeroMinimoDePalavrasChave(3);
        this.palavrasChave = palavrasChave;
    }
}
