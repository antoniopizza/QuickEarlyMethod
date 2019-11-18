package controller.documentManagement;

import controller.quickEarlyMethod.QuickEarlyController;
import model.documentManagement.Table;
import model.quickEarlyMethod.QuickEarlyMethod;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import view.documentManagement.TableView;
import view.quickEarlyMethod.QuickEarlyView;

import java.io.IOException;
import java.util.ArrayList;

public class TableController {


    private ArrayList<String> mainScenario = null;
    private ArrayList<String> errorScenarios = null;
    private TableView tableView = null;
    private Table table = null;
    private QuickEarlyMethod quickEarlyMethod = null;
    private QuickEarlyView quickEarlyView= null;
    private QuickEarlyController quickEarlyController = null;
    private XWPFTable useCase = null;

    public TableController(Table table, TableView tableView) {
        this.table = table;
        this.tableView = tableView;
    }

    public void getUsaCase() { useCase = table.getUseCase();}

    public String getUseCaseName() {
        return table.getUseCaseName();
    }

    public String getActors() {

        System.out.println("-- Actors");
        return table.getActors();
    }

    public String getPrecondition() {

        System.out.println("-- Pre-condition");
        return table.getPreConditions();
    }

    public String getExtensionPoint() {

        System.out.println("-- Extension Point");
        return table.getExtensionPoint(); }

    public String getGeneralizationOf() {

        System.out.println("-- Generalization");
        return table.getGeneralizationOf(); }

    public ArrayList<String> getMainScenario() {
        System.out.println("-- Main Scenario");
        return table.getMainScenario(); }

    public ArrayList<String> getErrorScenarios() {
        System.out.println("Error scenario");
        return table.getErrorScenarios(); }

    public void setUseCaseName() {
        table.setUseCaseName(useCase.getRow(0).getCell(1).getText());
    }
    public void printUseCase() { tableView.printData("Use Case", table.getUseCaseName()); }


    public void printActors() { tableView.printData("Actors", table.getActors()); }

    public void printPreconditions() { tableView.printData("Preconditions", table.getPreConditions()); }

    public void printExtensionPoint() { tableView.printData("Extension Point", table.getExtensionPoint()); }

    public void printGeneralizationOf() { tableView.printData("Generalization Of", table.getGeneralizationOf()); }

    public void printMainScenario() {
        mainScenario = new ArrayList<String>();
        int sizeMainScenario = table.getUseCase().getRow(6).getCell(0).getParagraphs().size();
        XWPFParagraph paragraph = table.getUseCase().getRow(6).getCell(0).getParagraphArray(1);

        System.out.println("Main Scenarios");
        for (int i = 0; i<sizeMainScenario; i++) {
            tableView.printData(i+"", table.getUseCase().getRow(6).getCell(0).getParagraphArray(i).getText());
        }
    }

    public void printErrorScernarios() {
        errorScenarios = new ArrayList<String>();

        System.out.println("Error Scenarios");
        for(int i = 8; i< (table.getUseCase().getRows().size()); i=i+2) {
            tableView.printData(i+"", table.getUseCase().getRow(i).getCell(1).getText());
        }
    }

    public void getCFp() throws IOException {
        this.quickEarlyMethod = new QuickEarlyMethod();
        this.quickEarlyView = new QuickEarlyView();
        this.quickEarlyController = new QuickEarlyController(quickEarlyMethod, quickEarlyView);

        System.out.println("Estrapolo:");
        this.quickEarlyController.sizeCFp(table.getPreConditions(), table.getExtensionPoint(), table.getGeneralizationOf(), table.getMainScenario(), table.getErrorScenarios());


    }

}
