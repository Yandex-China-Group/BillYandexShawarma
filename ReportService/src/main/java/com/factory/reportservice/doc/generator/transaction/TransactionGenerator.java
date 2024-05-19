package com.factory.reportservice.doc.generator.transaction;

import com.aspose.pdf.IDocument;
import com.factory.reportservice.doc.PDFGeneration;
import com.factory.reportservice.doc.view.UserView;
import lombok.Getter;

@Getter
abstract public class TransactionGenerator extends PDFGeneration {
    private final UserView userView;

    public TransactionGenerator(IDocument document, UserView userView) {
        super(document);
        this.userView = userView;
    }
}
