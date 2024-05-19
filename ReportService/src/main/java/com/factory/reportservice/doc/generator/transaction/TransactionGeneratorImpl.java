package com.factory.reportservice.doc.generator.transaction;

import com.aspose.pdf.*;
import com.aspose.pdf.internal.html.rendering.PageSetup;
import com.factory.reportservice.doc.view.BillView;
import com.factory.reportservice.doc.view.TransactionView;
import com.factory.reportservice.doc.view.UserView;

import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.aspose.pdf.CaretSymbol.Paragraph;

public class TransactionGeneratorImpl extends TransactionGenerator {
    public TransactionGeneratorImpl(IDocument document, UserView userView) {
        super(document, userView);
    }

    @Override
    public void generateDoc() throws IOException {
        IDocument document = super.getDocument();
        UserView userView = super.getUserView();
        Page page = document.getPages().add();
        page.getParagraphs()
                .add(new TextFragment(userView.firstName() + " " +
                        userView.lastName() + " " +
                        userView.screenName() + " " +
                        LocalDate.now()));
        for (BillView bill : userView.bills()) {
            page.getParagraphs().add(new TextFragment(bill.title() + " " + bill.note()));
            for (TransactionView transaction : bill.transactions()) {
                page.getParagraphs().add(new TextFragment(transaction.id() + " " +
                        transaction.transactionType() + " " +
                        transaction.paymentCategory() + " " +
                        transaction.createdAt()
                ));
            }
        }

    }
}
