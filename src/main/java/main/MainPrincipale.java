package main;

import controller.documentManagement.DocumentController;
import model.documentManagement.Document;
import view.documentManagement.DocumentView;

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
        System.out.println("Eseguo la misurazione");
        documentController1.getUseCase();
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("----- EnquireSchedule.docx -----");
        System.out.println("\n");
        Document document2 = new Document(pathName2);
        DocumentView documentView2 = new DocumentView();
        DocumentController documentController2 = new DocumentController(document2, documentView2);
        System.out.println("Eseguo la misurazione");
        documentController2.getUseCase();
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("----- DeleteSchedule.docx -----");
        System.out.println("\n");
        Document document3 = new Document(pathName3);
        DocumentView documentView3 = new DocumentView();
        DocumentController documentController3 = new DocumentController(document3, documentView3);
        System.out.println("Eseguo la misurazione");
        documentController3.getUseCase();
        System.out.println("\n");
        System.out.println("\n");

    }
}
