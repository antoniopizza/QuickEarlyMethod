package main;

import controller.documentManagement.DocumentController;
import controller.quickEarlyMethod.QuickEarlyController;
import model.documentManagement.Document;
import model.quickEarlyMethod.QuickEarlyMethod;

import view.documentManagement.DocumentView;
import view.quickEarlyMethod.QuickEarlyView;

import javax.print.Doc;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainPrincipale {
    public static void main(String[] args) throws IOException {

        FileWriter w = new FileWriter("4 input.txt");
        BufferedWriter b = new BufferedWriter(w);

        System.out.println("Seleziona il metodo da utilizare:");
        System.out.println("    1 - NLP ");
        System.out.println("    2 - noNLP ");
        Scanner scanner = new Scanner(System.in);
        int metodo = scanner.nextInt();

            String pathName2 = "enquireSchedule.docx";
            String pathName3 = "deleteSchedule.docx";
            String pathName1 = "closeRegistration.docx";
            String pathName4 = "addRegistration.docx";




        if (metodo == 1) {

            long inizio = System.currentTimeMillis();

            //1500 casi d'uso
            for (int i = 0; i < 550; i++) {

                //System.out.println("----- CloseRegistration.docx -----");
                //System.out.println("\n");

                Document document1 = new Document(pathName1);
                DocumentView documentView1 = new DocumentView();
                DocumentController documentController1 = new DocumentController(document1, documentView1);

                QuickEarlyMethod quickEarlyMethod1 = new QuickEarlyMethod();
                quickEarlyMethod1.initializeUseCase(documentController1.getUseCase());
                QuickEarlyView quickEarlyView1 = new QuickEarlyView();
                QuickEarlyController quickEarlyController1 = new QuickEarlyController(quickEarlyMethod1, quickEarlyView1);

                //System.out.println("Eseguo la misurazione");
                quickEarlyController1.sizeCFp();

                //System.out.println("\n");
                //System.out.println("\n");


                //System.out.println("----- EnquireSchedule.docx -----");
                //System.out.println("\n");

                Document document2 = new Document(pathName2);
                DocumentView documentView2 = new DocumentView();
                DocumentController documentController2 = new DocumentController(document2, documentView2);

                quickEarlyMethod1.initCFp();
                quickEarlyMethod1.initializeUseCase(documentController2.getUseCase());

                //System.out.println("Eseguo la misurazione");
                quickEarlyController1.sizeCFp();

                //System.out.println("\n");
                //System.out.println("\n");

                //System.out.println("----- DeleteSchedule.docx -----");
                //System.out.println("\n");

                Document document3 = new Document(pathName3);
                DocumentView documentView3 = new DocumentView();
                DocumentController documentController3 = new DocumentController(document3, documentView3);

                quickEarlyMethod1.initCFp();
                quickEarlyMethod1.initializeUseCase(documentController3.getUseCase());

                //System.out.println("Eseguo la misurazione");
                quickEarlyController1.sizeCFp();

                //System.out.println("\n");
                //System.out.println("\n");

                //System.out.println("----- NewRegistration.docx -----");
                //System.out.println("\n");

                Document document4 = new Document(pathName4);
                DocumentView documentView4 = new DocumentView();
                DocumentController documentController4 = new DocumentController(document4, documentView4);
                quickEarlyMethod1.initCFp();
                quickEarlyMethod1.initializeUseCase(documentController4.getUseCase());

                //System.out.println("Eseguo la misurazione");
                quickEarlyController1.sizeCFp();

                //System.out.println("\n");
                //System.out.println("\n");


            }

            long fine = System.currentTimeMillis();
            long time = (fine - inizio);


            System.out.println("-------- durata metodo NLP  " + time + " ms ");

        } else if(metodo == 2){

            long inizio = System.currentTimeMillis();

            for (int i = 0; i < 550; i++) {

                //System.out.println("----- CloseRegistration.docx -----");
                //System.out.println("\n");

                Document document1 = new Document(pathName1);
                DocumentView documentView1 = new DocumentView();
                DocumentController documentController1 = new DocumentController(document1, documentView1);

                QuickEarlyMethod quickEarlyMethod1 = new QuickEarlyMethod("");
                quickEarlyMethod1.initializeUseCase(documentController1.getUseCase());
                QuickEarlyView quickEarlyView1 = new QuickEarlyView();
                QuickEarlyController quickEarlyController1 = new QuickEarlyController(quickEarlyMethod1, quickEarlyView1);

                //System.out.println("Eseguo la misurazione");
                quickEarlyController1.sizeCFpNoNLP();

                //System.out.println("\n");
                //System.out.println("\n");

                //System.out.println("----- EnquireSchedule.docx -----");
                //System.out.println("\n");

                Document document2 = new Document(pathName2);
                DocumentView documentView2 = new DocumentView();
                DocumentController documentController2 = new DocumentController(document2, documentView2);
                quickEarlyMethod1.initCFp();
                quickEarlyMethod1.initializeUseCase(documentController2.getUseCase());
                quickEarlyController1.sizeCFpNoNLP();


                //System.out.println("\n");
                //System.out.println("\n");

                //System.out.println("----- DeleteSchedule.docx -----");
                //System.out.println("\n");

                Document document3 = new Document(pathName3);
                DocumentView documentView3 = new DocumentView();
                DocumentController documentController3 = new DocumentController(document3, documentView3);
                quickEarlyMethod1.initCFp();
                quickEarlyMethod1.initializeUseCase(documentController3.getUseCase());
                quickEarlyController1.sizeCFpNoNLP();


                //System.out.println("\n");
                //System.out.println("\n");

                //System.out.println("----- NewSchedule.docx -----");
                //System.out.println("\n");

                Document document4 = new Document(pathName4);
                DocumentView documentView4 = new DocumentView();
                DocumentController documentController4 = new DocumentController(document4, documentView4);
                quickEarlyMethod1.initCFp();
                quickEarlyMethod1.initializeUseCase(documentController4.getUseCase());
                quickEarlyController1.sizeCFpNoNLP();

                //System.out.println("\n");
                //System.out.println("\n");

            }
            long fine = System.currentTimeMillis();
            long time = (fine - inizio);

            System.out.println("------- durata metodo  " + time + " ms ");
        }



    }
}
