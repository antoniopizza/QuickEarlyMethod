package controller.documentManagement;

import model.documentManagement.Document;
import model.documentManagement.UseCase;
import view.documentManagement.DocumentView;
import view.documentManagement.TableView;

import java.io.IOException;


public class DocumentController {

    private Document document = null;
    private DocumentView documentView = null;
    private UseCase useCase = null;
    private TableView tableView = null;
    private UseCaseController useCaseController = null;

    public DocumentController(Document document, DocumentView documentView) throws IOException {
        this.document = document;
        this.documentView = documentView;
        initializeUseCase();
    }

    public UseCase getUseCase() {
        return useCaseController.getUseCase();
    }

    public void initializeUseCase() throws IOException {
        this.useCase = new UseCase(document.getDocument());
        this.tableView = new TableView();
        this.useCaseController = new UseCaseController(this.useCase, this.tableView);

        //tableController.getCFp();
    }

}
