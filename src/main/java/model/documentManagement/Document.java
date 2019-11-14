package model.documentManagement;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Document {

    private XWPFDocument doc = null;
    private FileInputStream in = null;
    private File file = null;

    public Document(String pathName) throws IOException {
        this.file = new File(pathName);
        this.in = new FileInputStream(file);
        this.doc = new XWPFDocument(in);
    }

    public XWPFDocument getDocument() {
        return this.doc;
    }
}
