package com.fichacatalograficaapi.fichacatalograficaapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O campo autor não pode ser vazio.")
    private String autor;

    @NotEmpty(message = "O campo título não pode ser vazio.")
    private String titulo;

    @NotEmpty(message = "O campo subtítulo não pode ser vazio.")
    private String subtitulo;

    @NotNull(message = "O campo ano deve ser preenchido.")
    private String ano;

    @NotNull(message = "O campo número de páginas pré-textual deve ser preenchido.")
    private String numeroPaginaPre;

    @NotNull(message = "O campo número total de páginas deve ser preenchido.")
    private String numeroPaginaTotal;

    @NotNull(message = "O ilustração ano deve ser preenchido.")
    private boolean ilustracao;

    @NotNull(message = "O campo bibliografia deve ser preenchido.")
    private boolean bibliografia;

    @NotNull(message = "O campo anexo deve ser preenchido.")
    private boolean anexo;

    @ManyToOne
    @NotNull(message = "O campo titulação deve ser preenchido.")
    private Titulacao titulacao;

    @ManyToOne
    @NotNull(message = "O campo instituição deve ser preenchido.")
    private Instituicao instituicao;

    @ManyToOne
    @NotNull(message = "O campo curso deve ser preenchido.")
    private Curso curso;

    @NotEmpty(message = "O campo orientador deve ser preenchido.")
    private String orientador;

    @NotEmpty(message = "O campo coorientador deve ser preenchido.")
    private String coorientador;

    @NotEmpty(message = "O campo palavras chave deve ser preenchido.")
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
