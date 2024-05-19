package com.factory.reportservice.doc.generator.transaction;

import com.aspose.pdf.*;
import com.factory.reportservice.doc.view.UserView;

import java.io.IOException;
import java.time.LocalDateTime;

public class TransactionGeneratorImpl extends TransactionGenerator {
    public TransactionGeneratorImpl(IDocument document, UserView userView) {
        super(document, userView);
    }

    @Override
    public void generateDoc() throws IOException {
        IDocument document = super.getDocument();
        UserView userView = super.getUserView();
        PageCollection pages = document.getPages();
        Paragraphs paragraph1 = pages.add()
                .getParagraphs()
                .add(new TextFragment(
                userView.firstName() + " " +
                userView.lastName() + " " +
                userView.screenName() + " " +
                LocalDateTime.now());


                new TextFragment(userView.firstName() +
                userView.lastName() +
                userView.screenName()));
    }
}
