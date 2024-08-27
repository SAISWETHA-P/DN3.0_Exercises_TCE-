public class FactoryMethodPattern {

    // Document interface
    public interface Document {
        void open();
        void close();
    }

    // WordDocument class
    public static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Word Document");
        }

        @Override
        public void close() {
            System.out.println("Closing Word Document");
        }
    }

    // PdfDocument class
    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening PDF Document");
        }

        @Override
        public void close() {
            System.out.println("Closing PDF Document");
        }
    }

    // ExcelDocument class
    public static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Excel Document");
        }

        @Override
        public void close() {
            System.out.println("Closing Excel Document");
        }
    }

    // DocumentFactory abstract class
    public static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // WordDocumentFactory class
    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    // PdfDocumentFactory class
    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    // ExcelDocumentFactory class
    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Test the Factory Method Implementation
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}
