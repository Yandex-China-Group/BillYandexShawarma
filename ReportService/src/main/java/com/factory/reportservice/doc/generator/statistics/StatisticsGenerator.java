package com.factory.reportservice.doc.generator.statistics;

import com.aspose.pdf.IDocument;
import com.factory.reportservice.doc.PDFGeneration;

abstract public class StatisticsGenerator extends PDFGeneration {
    public StatisticsGenerator(IDocument document) {
        super(document);
    }
}
