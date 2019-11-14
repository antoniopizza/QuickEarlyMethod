package model.documentManagement;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<XWPFTable> tables = null;
    private String pathName = null;
    private XWPFDocument doc = null;
    private FileInputStream in = null;
    private File file = null;
    private ArrayList<String> mainScenario = null;
    private ArrayList<String> errorScenarios = null;

    public Table(String pathName) throws IOException {

        this.pathName =  pathName;
        this.file = new File(pathName);
        this.in = new FileInputStream(file);
        this.doc = new XWPFDocument(in);
        this.tables = doc.getTables();
    }

    public Table(XWPFDocument doc) {
        this.doc = doc;
        this.tables = doc.getTables();
    }

    public List<XWPFTable> getTables() {
        return this.tables;
    }

    public String getUseCase() {
        return tables.get(0).getRow(0).getCell(1).getText();
    }

    public String getActors() {
        return tables.get(0).getRow(1).getCell(1).getText();
    }

    public String getPrecondition() {
        return tables.get(0).getRow(2).getCell(1).getText();
    }

    public String getExtensionPoint() {
        return tables.get(0).getRow(3).getCell(1).getText();
    }

    public String getGeneralizationOf() {
        return tables.get(0).getRow(4).getCell(1).getText();
    }

    public ArrayList<String> getMainScenario() {

        mainScenario = new ArrayList<String>();
        int numberOfItem = tables.get(0).getRow(6).getCell(0).getParagraphs().size();
        XWPFParagraph paragraph = tables.get(0).getRow(6).getCell(0).getParagraphArray(1);

        for (int i=0; i<numberOfItem; i++) {
            mainScenario.add(tables.get(0).getRow(6).getCell(0).getParagraphArray(i).getText());
            //System.out.println(i+1 +" - "+tables.get(0).getRow(6).getCell(0).getParagraphArray(i).getText());
        }

        return mainScenario;
    }

    public ArrayList<String> getErrorScenarios() {

        errorScenarios = new ArrayList<String>();
        int sizeScenario = tables.get(0).getRows().size();

        for(int i=8; i<sizeScenario; i=i+2) {
            errorScenarios.add(tables.get(0).getRow(i).getCell(1).getText());
        }

        return errorScenarios;
    }

}
