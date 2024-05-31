package com.fichacatalograficaapi.fichacatalograficaapi.domain.entities.ficha;

public class Ficha {
    private String autor;

    private String titulo;

    private String subtitulo;

    private String cidade;

    private String ano;

    private String numeroPaginaPre;

    private String numeroPaginaTotal;

    private Boolean ilustracao;

    private Boolean bibliografia;

    private Boolean anexo;

    private MonografiaTitulacao monografiaTitulacao;

    private String instituicao;

    private String curso;

    private String orientador;

    private String coorientador;

    private String palavrasChave;

    public Ficha(String autor, String titulo, String subtitulo, String cidade, String ano, String numeroPaginaPre, String numeroPaginaTotal, Boolean ilustracao, Boolean bibliografia, Boolean anexo, MonografiaTitulacao monografiaTitulacao, String instituicao, String curso, String orientador, String coorientador, String palavrasChave) {
        this.autor = verificaSeEstaVazio(autor);
        this.titulo = verificaSeEstaVazio(titulo);
        this.subtitulo = subtitulo;
        this.cidade = verificaSeEstaVazio(cidade);
        this.ano = verificaSeEstaVazio(ano);
        this.numeroPaginaPre = verificaSeEstaVazio(numeroPaginaPre);
        this.numeroPaginaTotal = verificaSeEstaVazio(numeroPaginaTotal);
        this.ilustracao = (Boolean) verificaSeEstaNulo(ilustracao);
        this.bibliografia = (Boolean) verificaSeEstaNulo(bibliografia);
        this.anexo = (Boolean) verificaSeEstaNulo(anexo);
        this.monografiaTitulacao = (MonografiaTitulacao) verificaSeEstaNulo(monografiaTitulacao);
        this.instituicao = verificaSeEstaVazio(instituicao);
        this.curso = verificaSeEstaVazio(curso);
        this.orientador = verificaSeEstaVazio(orientador);
        this.coorientador = coorientador;
        this.palavrasChave = verificarNumeroMinimoDePalavrasChave(palavrasChave, 3);
    }

    public String verificaSeEstaVazio(String campo) {
        verificaSeEstaNulo(campo);
        if (campo.isEmpty()) {
            throw new IllegalArgumentException(campo + " não pode estar vazio");
        }
        return campo;
    }

    public Object verificaSeEstaNulo(Object campo) {
        if (campo == null) {
            throw new IllegalArgumentException(campo + " não pode estar nulo");
        }
        return campo;
    }

    public String verificarNumeroMinimoDePalavrasChave(String palavrasChave, int quantidade) {
        if (palavrasChave.split(",").length < quantidade) {
            throw new IllegalArgumentException("O campo palavras chave deve conter no mínimo " + quantidade + " palavras chave");
        }
        return palavrasChave;
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

    public String getNumeroPaginaTotal() {
        return numeroPaginaTotal;
    }

    public void setNumeroPaginaTotal(String numeroPaginaTotal) {
        this.numeroPaginaTotal = numeroPaginaTotal;
    }

    public Boolean getIlustracao() {
        return ilustracao;
    }

    public void setIlustracao(Boolean ilustracao) {
        this.ilustracao = ilustracao;
    }

    public Boolean getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(Boolean bibliografia) {
        this.bibliografia = bibliografia;
    }

    public Boolean getAnexo() {
        return anexo;
    }

    public void setAnexo(Boolean anexo) {
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
