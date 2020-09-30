package com.fichacatalograficaapi.fichacatalograficaapi.model;

import javax.persistence.*;

@Entity
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;

    private String titulo;

    private String subtitulo;

    private String ano;

    private String numeroPaginaPre;

    private String numeroPaginaTotal;

    private boolean ilustracao;

    private boolean bibliografia;

    private boolean anexo;

    @Transient
    private Titulacao titulacao;

    @Transient
    private Instituicao instituicao;

    @Transient
    private Curso curso;

    private String orientador;

    private String coorientador;

    private String palavrasChave;


    public Ficha() {

    }

    public Ficha(String autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
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
