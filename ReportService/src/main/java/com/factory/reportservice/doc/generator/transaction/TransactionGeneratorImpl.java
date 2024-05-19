package com.factory.reportservice.doc.generator.transaction;

import com.aspose.pdf.IDocument;
import com.factory.reportservice.doc.view.UserView;

import java.io.IOException;

public class TransactionGeneratorImpl extends TransactionGenerator {
    public TransactionGeneratorImpl(IDocument document, UserView userView) {
        super(document, userView);
    }

    @Override
    public void generateDoc() throws IOException {
    }
}
