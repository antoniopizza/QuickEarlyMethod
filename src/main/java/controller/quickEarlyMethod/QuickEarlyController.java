package controller.quickEarlyMethod;

import model.documentManagement.UseCase;
import model.quickEarlyMethod.QuickEarlyMethod;
import opennlp.tools.postag.POSSample;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import utility.eventEvaluation.SentenceParser;
import view.quickEarlyMethod.QuickEarlyView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class QuickEarlyController {

    private QuickEarlyMethod quickEarlyMethod = null;
    private QuickEarlyView quickEarlyView = null;
    private XWPFTable table = null;

    public QuickEarlyController(QuickEarlyMethod quickEarlyMethod, QuickEarlyView quickEarlyView) {
        this.quickEarlyMethod = quickEarlyMethod;
        this.quickEarlyView = quickEarlyView;
    }

    public String[] getSenteces() {
        return quickEarlyMethod.getSentences();
    }

    public void setSentences(String[] phrase) {
        quickEarlyMethod.setSentences(phrase);
    }

    public String[] getToken() {
        return quickEarlyMethod.getToken();
    }

    public String[] getTags() {
        return quickEarlyMethod.getTags();
    }

   /* public void sizeCFp(Table useCase) {
        int prec = (useCase.getPreConditions().equals("N/A")) ? 0 : 0;
    }*/

    public void sizeCFp() throws IOException {
        System.out.println("Conteggio:");
        System.out.println("-- Precondition");
        int prec = (quickEarlyMethod.getUseCase().getPreConditions().equals("N/A")) ? 0 : 0;
        System.out.println("-- Extension Point");
        int exten = (quickEarlyMethod.getUseCase().getExtensionPoint().equals("N/A")) ? 0 : 1;
        System.out.println("-- Generalization");
        int gen = (quickEarlyMethod.getUseCase().getGeneralizationOf().equals("N/A")) ? 0 : 1;
        int main = 0; //da verificare
        int err = 0; //da verificare
        boolean flagDisplay = false;

        System.out.println("-- Main Scenario");
        for(String flowEvent : quickEarlyMethod.getUseCase().getMainScenario()) {
            main++;
            String sentences[] = quickEarlyMethod.getDetectorME().sentDetect(flowEvent);
            WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
            String tokens[] = whitespaceTokenizer.tokenize(sentences[0]);
            String tags[] = quickEarlyMethod.getTaggerME().tag(tokens);

            POSSample sample = new POSSample(tokens, tags);

            /*if(sample.getSentence()[0].equals("Include") || sample.getSentence()[2].equals("displays") ) {
                //System.out.println("ci sono");
                if (sample.getSentence()[2].equals("displays") && !flag) {
                    flag = true;
                    main++;
                }
            } else
                main++;*/

            //System.out.println(sample.getSentence()[2]);

           /* //IF FUNZIONANTE inizio
           if(!sample.getSentence()[0].equals("Include") && !sample.getSentence()[2].equals("displays") && !sample.getSentence()[2].equals("prompts") && !sample.getSentence()[2].equals("confirms")) {
               main++;
               //System.out.println("not include non displays");
           } else if(sample.getSentence()[2].equals("displays")) {
               //System.out.println("displays");
               SentenceParser sentenceParser = new SentenceParser(flowEvent);
               if(sentenceParser.isDisplayMessage() == 1 && !flag) {
                   main++;
                   flag = true;
               } else if(sentenceParser.isDisplayMessage() == 2)
                   main++;
               else if (sentenceParser.isDisplayMessage() == 3)
                   main++;
           } else if(sample.getSentence()[2].equals("prompts")) {
               //System.out.println("prompts");
               SentenceParser sentenceParser = new SentenceParser(flowEvent);
               if (!sentenceParser.isSystemPromptsVerify())
                   main++;
           } else if (sample.getSentence()[2].equals("confirms")) {
               //System.out.println("confirms");
               SentenceParser sentenceParser = new SentenceParser(flowEvent);
               if (!sentenceParser.isActorConfirms())
                   main++;
           }
           //IF FUNZIONANTE fine*/


           boolean flag = false;

            //PROVA IF PROVA IF PROVA IF PROVA IF PROVA IF PROVA IF PROVA IF PROVA IF PROVA IF
            ArrayList<String>  errorCatalog = new ArrayList<String>();
            FileReader errorFileReader = new FileReader("ErrorMessageCatalog.txt");
            BufferedReader errorBufferRead = new BufferedReader(errorFileReader);

            ArrayList<String>  promptCatalog = new ArrayList<String>();
            FileReader promptFileReader = new FileReader("PromptMessageCatalog.txt");
            BufferedReader promptBufferRead = new BufferedReader(promptFileReader);

            ArrayList<String> confirmCatalog = new ArrayList<String>();
            FileReader confirmReader = new FileReader("ConfirmMessageCatalog.txt");
            BufferedReader confirmBufferRead = new BufferedReader(confirmReader);

            String errorString;
            while(true){
                errorString = errorBufferRead.readLine();
                errorCatalog.add(errorString);
                if(errorString == null) {
                    break;
                }
            }

            String promptString;
            while(true){
                promptString = promptBufferRead.readLine();
                promptCatalog.add(promptString);
                if(promptString == null) {
                    break;
                }
            }

            String confirmString;
            while (true) {
                confirmString = confirmBufferRead.readLine();
                confirmCatalog.add(confirmString);
                if(confirmString == null) {
                    break;
                }
            }


            if(sample.getSentence()[0].equals("Include")) {
                main--;
                flag = true;
            }

            if (!flag && !flagDisplay){
                for(String a : errorCatalog) {
                    if(sample.getSentence()[2].equals(a) && (sample.getSentence()[4].equals("error") || sample.getSentence()[4].equals("notification")) ) {
                        //main--;
                        flag = true;
                        flagDisplay = true;
                        break;
                    }
                }
            }


            if(!flag) {
                for (String b : promptCatalog) {
                    if (sample.getSentence()[2].equals(b)) {
                        main--;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) {
                for (String a : confirmCatalog) {
                    if(sample.getSentence()[2].equals(a)) {
                        main--;
                        break;
                    }
                }
            }

        }



        System.out.println("-- Error Scenario");
        //System.out.println(flag);
        if (!flagDisplay)
            err++;

        System.out.println("----- VALORI VARIABILI -----");
        System.out.println("precondition = " + prec);
        System.out.println("extension = " + exten);
        System.out.println("generalization = " + gen);
        System.out.println("main = " + main);
        System.out.println("error = " + err);

        /*for (String errorFlow : errorScenarios) {
            String sentences[] = quickEarlyMethod.getDetectorME().sentDetect(errorFlow);
            WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
            String tokens[] = whitespaceTokenizer.tokenize(sentences[0]);
            String tags[] = quickEarlyMethod.getTaggerME().tag(tokens);

            POSSample sample = new POSSample(tokens, tags);
            //for (int i = 0; i<tags.length; i++) {
                if(!(sample.getTags()[0].equals("Include")) && !(sample.getSentence()[2].equals("displays"))) {
                    System.out.println(sample.getSentence()[2]);
                    err++;
                }
            //}
        }*/


        int cfp = prec + exten + gen + main + err;



        quickEarlyMethod.setCFp(cfp);

        System.out.println("La size funzionale in termini CFp è " + cfp);
    }
}
