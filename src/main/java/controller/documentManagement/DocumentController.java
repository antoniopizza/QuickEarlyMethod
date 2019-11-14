package controller.documentManagement;

import model.documentManagement.Document;
import model.documentManagement.Table;
import view.documentManagement.DocumentView;
import view.documentManagement.TableView;

import java.io.IOException;


public class DocumentController {

    private Document document = null;
    private DocumentView documentView = null;
    private Table table = null;
    private TableView tableView = null;
    private TableController tableController = null;

    public DocumentController(Document document, DocumentView documentView) {
        this.document = document;
        this.documentView = documentView;
    }

    public void getUseCase() throws IOException {
        this.table = new Table(document.getDocument());
        this.tableView = new TableView();
        this.tableController = new TableController(this.table, this.tableView);

        tableController.getCFp();
    }

}
