package com.fichacatalograficaapi.fichacatalograficaapi.service;

import com.fichacatalograficaapi.fichacatalograficaapi.model.Ficha;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CriadorFichaPdf {

    public void criarFichaPdf(Ficha ficha, String outputFileName) {
        try (PDDocument documento = new PDDocument()) {
            PDPage pagina = new PDPage(PDRectangle.A4);
            documento.addPage(pagina);

            try (PDPageContentStream contentStream = new PDPageContentStream(documento, pagina)) {
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.beginText();

                contentStream.newLineAtOffset(25, 700);
                contentStream.showText("autor: " + ficha.getAutor());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("titulo: " + ficha.getTitulo());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("subtitulo: " + ficha.getSubtitulo());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("ano: " + ficha.getAno());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("numeroPaginaPre: " + ficha.getNumeroPaginaPre());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("numeroPaginaTotal: " + ficha.getNumeroPaginaTotal());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("ilustracao: " + ficha.isIlustracao());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("bibliografia: " + ficha.isBibliografia());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("anexo: " + ficha.isAnexo());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("monografiaTitulacao: " + ficha.getMonografiaTitulacao());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("instituicao: " + ficha.getInstituicao());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("curso: " + ficha.getCurso());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("orientador: " + ficha.getOrientador());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("coorientador: " + ficha.getCoorientador());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("palavrasChave: " + ficha.getPalavrasChave());

                contentStream.endText();

                contentStream.setLineWidth(1f); // Define a largura da linha
                contentStream.addRect(144, 180, 360, 144); // Desenha um retângulo
                contentStream.stroke(); // Aplica o traço


                contentStream.close();
            }

            documento.save(outputFileName);
            documento.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}