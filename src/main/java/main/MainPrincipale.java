package main;

import controller.documentManagement.DocumentController;
import controller.quickEarlyMethod.QuickEarlyController;
import model.documentManagement.Document;
import model.quickEarlyMethod.QuickEarlyMethod;
import view.documentManagement.DocumentView;
import view.quickEarlyMethod.QuickEarlyView;

import javax.print.Doc;
import java.io.IOException;

public class MainPrincipale {
    public static void main(String[] args) throws IOException {

        String pathName2 = "enquireSchedule.docx";
        String pathName3 = "deleteSchedule.docx";
        String pathName1 = "closeRegistration.docx";

        System.out.println("----- CloseRegistration.docx -----");
        System.out.println("\n");

        Document document1 = new Document(pathName1);
        DocumentView documentView1 = new DocumentView();
        DocumentController documentController1 = new DocumentController(document1, documentView1);

        QuickEarlyMethod quickEarlyMethod1 = new QuickEarlyMethod();
        quickEarlyMethod1.initializeUseCase(documentController1.getUseCase());
        QuickEarlyView quickEarlyView1 = new QuickEarlyView();
        QuickEarlyController quickEarlyController1 = new QuickEarlyController(quickEarlyMethod1, quickEarlyView1);

        System.out.println("Eseguo la misurazione");
        quickEarlyController1.sizeCFp();

        //documentController1.getUseCase();
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("----- EnquireSchedule.docx -----");
        System.out.println("\n");

        Document document2 = new Document(pathName2);
        DocumentView documentView2 = new DocumentView();
        DocumentController documentController2 = new DocumentController(document2, documentView2);

        QuickEarlyMethod quickEarlyMethod2 = new QuickEarlyMethod();
        quickEarlyMethod2.initializeUseCase(documentController2.getUseCase());
        QuickEarlyView quickEarlyView2 = new QuickEarlyView();
        QuickEarlyController quickEarlyController2 = new QuickEarlyController(quickEarlyMethod2, quickEarlyView2);

        System.out.println("Eseguo la misurazione");
        quickEarlyController2.sizeCFp();

        //documentController2.getUseCase();
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("----- DeleteSchedule.docx -----");
        System.out.println("\n");

        Document document3 = new Document(pathName3);
        DocumentView documentView3 = new DocumentView();
        DocumentController documentController3 = new DocumentController(document3, documentView3);

        QuickEarlyMethod quickEarlyMethod3 = new QuickEarlyMethod();
        quickEarlyMethod3.initializeUseCase(documentController3.getUseCase());
        QuickEarlyView quickEarlyView3 = new QuickEarlyView();
        QuickEarlyController quickEarlyController3 = new QuickEarlyController(quickEarlyMethod3, quickEarlyView3);

        System.out.println("Eseguo la misurazione");
        quickEarlyController3.sizeCFp();

        //documentController3.getUseCase();
        System.out.println("\n");
        System.out.println("\n");

    }
}
