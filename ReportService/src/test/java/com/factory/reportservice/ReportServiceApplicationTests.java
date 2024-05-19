package com.factory.reportservice;

import com.aspose.pdf.Document;
import com.aspose.pdf.IDocument;
import com.factory.reportservice.doc.PDFGeneration;
import com.factory.reportservice.doc.generator.transaction.TransactionGeneratorImpl;
import com.factory.reportservice.doc.view.BillView;
import com.factory.reportservice.doc.view.TransactionView;
import com.factory.reportservice.doc.view.UserView;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
class ReportServiceApplicationTests {

	@Test
	void contextLoads() throws IOException {
		Document document = new Document();
		Set<BillView> bills = new HashSet<>(3);
		Set<TransactionView> transactionsRubl = new HashSet<>();
		for (long i = 0; i < 100; i++) {
			transactionsRubl.add(new TransactionView(i, new Date(100), "Развлечения", "Покупка"));
		}
		Set<TransactionView> transactionsBucks = new HashSet<>();
		for (long i = 0; i < 100; i++) {
			transactionsBucks.add(new TransactionView(i, new Date(100), "Развлечения", "Покупка"));
		}
		bills.add(new BillView("Рублевый счет", "Счет на котором лежат рубли", transactionsRubl));
		bills.add(new BillView("Долларовый счет", "Счет на котором лежат баксы", transactionsBucks));
		UserView userView = new UserView("brodep","Denis", "Vasilev", bills);
		PDFGeneration pdfGeneration = new TransactionGeneratorImpl(document, userView);
		pdfGeneration.generateDoc();
		pdfGeneration.saveDoc(Files.newOutputStream(Path.of("./" + UUID.randomUUID() + ".pdf")));
	}

}