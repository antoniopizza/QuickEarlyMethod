package controller.documentManagement;

import controller.quickEarlyMethod.QuickEarlyController;
import model.documentManagement.UseCase;
import model.quickEarlyMethod.QuickEarlyMethod;
import view.documentManagement.TableView;
import view.quickEarlyMethod.QuickEarlyView;

import java.io.IOException;
import java.util.ArrayList;

public class UseCaseController {


    //private ArrayList<String> mainScenario = null;
    //private ArrayList<String> errorScenarios = null;
    private TableView tableView = null;
    private UseCase useCase = null;

    private QuickEarlyMethod quickEarlyMethod = null;
    private QuickEarlyView quickEarlyView= null;
    private QuickEarlyController quickEarlyController = null;

    //private XWPFTable useCase = null;

    public UseCaseController(UseCase useCase, TableView tableView) {
        this.useCase = useCase;
        this.tableView = tableView;
    }



    public UseCase getUseCase() {
        return useCase;
    }

    public String getUseCaseName() {
        return useCase.getUseCaseName();
    }

    public String getActors() {

        System.out.println("-- Actors");
        return useCase.getActors();
    }

    public String getPrecondition() {

        System.out.println("-- Pre-condition");
        return useCase.getPreConditions();
    }

    public String getExtensionPoint() {

        System.out.println("-- Extension Point");
        return useCase.getExtensionPoint(); }

    public String getGeneralizationOf() {

        System.out.println("-- Generalization");
        return useCase.getGeneralizationOf(); }

    public ArrayList<String> getMainScenario() {
        System.out.println("-- Main Scenario");
        return useCase.getMainScenario(); }

    public ArrayList<String> getErrorScenarios() {
        System.out.println("Error scenario");
        return useCase.getErrorScenarios(); }

    public void setUseCaseName(String useCaseName) {
        useCase.setUseCaseName(useCaseName);
    }
    public void printUseCase() { tableView.printData("Use Case", useCase.getUseCaseName()); }


    public void printActors() { tableView.printData("Actors", useCase.getActors()); }

    public void printPreconditions() { tableView.printData("Preconditions", useCase.getPreConditions()); }

    public void printExtensionPoint() { tableView.printData("Extension Point", useCase.getExtensionPoint()); }

    public void printGeneralizationOf() { tableView.printData("Generalization Of", useCase.getGeneralizationOf()); }

    //CODICE DA RICONTROLLARE
    /*public void printMainScenario() {
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
    }*/

    /*public void getCFp() throws IOException {
        this.quickEarlyMethod = new QuickEarlyMethod();
        this.quickEarlyView = new QuickEarlyView();
        this.quickEarlyController = new QuickEarlyController(quickEarlyMethod, quickEarlyView);

        System.out.println("Estrapolo:");
        this.quickEarlyController.sizeCFp(useCase);


    }*/

}
