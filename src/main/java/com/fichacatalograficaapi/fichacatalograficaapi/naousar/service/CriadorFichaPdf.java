package com.fichacatalograficaapi.fichacatalograficaapi.naousar.service;

import com.fichacatalograficaapi.fichacatalograficaapi.naousar.model.Ficha;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriadorFichaPdf {

    public void criarFichaPdf(Ficha ficha, String outputFileName) {
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            doc.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(doc, page)) {
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 10);

                float margin = 72;
                float yInicio = 300;
                float larguraDoRetangulo = 360;
                float yPosicao = yInicio;
                float bottomMargin = 72;
                int totalDeLinhas = 0;

                String linhaNomeDoAutor = formatarNome(ficha.getAutor());
                String linhaTituloNomeDoAutorCidadeAno = ficha.getTitulo() + " / " + ficha.getAutor() + ". - " + ficha.getCidade() + ": " + ficha.getAno() + ".";
                String linhaPaginacao = ficha.getNumeroPaginaPre() + ", " + ficha.getNumeroPaginaTotal() + " f. : il. ; 29,7 cm.";
                String linhaOrientadores = "Orientandor: " + ficha.getOrientador() + ". Coorientador: " + ficha.getCoorientador() + ".";
                String linhaTese = ficha.getMonografiaTitulacao().getDescricao() + " - " + ficha.getInstituicao() + ", " + ficha.getAno() + ".";
                String linhaIlustracoesBibliografiaAnexo = "Inclui Ilustrações, Bibliografias e Material Anexo.";
                String linhaPalavrasChaveOutros = formatarPalavrasChave(ficha.getPalavrasChave()) + ". I. " + formatarNome(ficha.getOrientador()) + ". II. " + formatarNome(ficha.getCoorientador()) + ". III. " + ficha.getCidade() + ". IV. " + ficha.getAno() + ".";

                List<String> linhas = new ArrayList<>();
                List<List<String>> linhasTratadas = new ArrayList<>();
                linhas.add(linhaNomeDoAutor);
                linhas.add(linhaTituloNomeDoAutorCidadeAno);
                linhas.add(linhaPaginacao);
                linhas.add(linhaOrientadores);
                linhas.add(linhaTese);
                linhas.add(linhaIlustracoesBibliografiaAnexo);
                linhas.add(linhaPalavrasChaveOutros);

                for (String linha : linhas) {
                    linhasTratadas.add(dividirEmLinhas(linha, 70));
                }

                for (List<String> linha : linhasTratadas) {
                    for (String l : linha) {
                        totalDeLinhas += linha.size();
                    }
                }

                contentStream.setLineWidth(1f);
                contentStream.addRect(margin, yPosicao - totalDeLinhas * 12, larguraDoRetangulo, totalDeLinhas * 12 + 12);
                contentStream.stroke();

                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 40, yPosicao - 4);
                for (int i = 0; i < linhasTratadas.size(); i++) {
                    List<String> linha = linhasTratadas.get(i);
                    for (String l : linha) {
                        contentStream.showText(l);
                        yPosicao -= 12;
                        contentStream.newLineAtOffset(0, -12);
                    }
                    if (i == 2 || i == 5) {
                        yPosicao -= 12; // Adiciona um espaço de linha em branco
                        contentStream.newLineAtOffset(0, -12);
                    }
                }
                contentStream.endText();
            }

            doc.save(outputFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> dividirEmLinhas(String texto, int tamanhoDaLinha) {
        List<String> linhas = new ArrayList<>();
        String[] palavras = texto.split(" ");
        StringBuilder linha = new StringBuilder();

        for (String palavra : palavras) {
            if (linha.length() + palavra.length() < tamanhoDaLinha) {
                linha.append(palavra).append(" ");
            } else {
                linhas.add(linha.toString());
                linha = new StringBuilder(palavra).append(" ");
            }
        }

        if (linha.length() > 0) {
            linhas.add(linha.toString());
        }
        return linhas;
    }

    public String formatarNome(String nome) {
        String[] partesDoNome = nome.split(" ");
        String ultimoNome = partesDoNome[partesDoNome.length - 1];
        return ultimoNome + ", " + nome;
    }

    public String formatarPalavrasChave(String palavrasChave) {
        String[] palavras = palavrasChave.split(",");
        StringBuilder palavrasChaveFormatadas = new StringBuilder();
        for (int i = 0; i < palavras.length; i++) {
            palavrasChaveFormatadas.append(i + 1).append(". ").append(palavras[i].trim()).append(". ");
        }
        return palavrasChaveFormatadas.toString();
    }
}