package com.fichacatalograficaapi.fichacatalograficaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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

    @NotEmpty(message = "O campo ano deve ser preenchido.")
    private String ano;

    @NotEmpty(message = "O campo número de páginas pré-textual deve ser preenchido.")
    private String numeroPaginaPre;

    @NotEmpty(message = "O campo número total de páginas deve ser preenchido.")
    private String numeroPaginaTotal;

    @NotNull(message = "O ilustração ano deve ser preenchido.")
    private boolean ilustracao;

    @NotNull(message = "O campo bibliografia deve ser preenchido.")
    private boolean bibliografia;

    @NotNull(message = "O campo anexo deve ser preenchido.")
    private boolean anexo;

    @NotNull(message = "O campo monografia/titulação deve ser preenchido.")
    private MonografiaTitulacao monografiaTitulacao;

    @NotEmpty(message = "O campo instituição deve ser preenchido.")
    private String instituicao;

    @NotEmpty(message = "O campo curso deve ser preenchido.")
    private String curso;

    @NotEmpty(message = "O campo orientador deve ser preenchido.")
    private String orientador;

    @NotEmpty(message = "O campo coorientador deve ser preenchido.")
    private String coorientador;

    @NotEmpty(message = "O campo palavras chave deve ser preenchido.")
    private String palavrasChave;

    public Ficha() {
    }

    public Ficha(String autor, String titulo, String subtitulo, String ano, String numeroPaginaPre, String numeroPaginaTotal, boolean ilustracao, boolean bibliografia, boolean anexo, MonografiaTitulacao monografiaTitulacao, String instituicao, String curso, String orientador, String coorientador, String palavrasChave) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
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
