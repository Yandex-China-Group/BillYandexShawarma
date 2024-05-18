package com.factory.reportservice.doc;

import com.aspose.pdf.IDocument;
import com.aspose.pdf.SaveFormat;
import lombok.Getter;

import java.io.IOException;
import java.io.OutputStream;

@Getter
abstract public class PDFGeneration {
    private final IDocument document;

    public PDFGeneration(IDocument document) {
        this.document = document;
    }

    abstract public void generateDoc() throws IOException;

    public void saveDoc(OutputStream os) throws IOException {
        getDocument().save(os, SaveFormat.Pdf);
    }
}
