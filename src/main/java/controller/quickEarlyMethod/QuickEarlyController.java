package controller.quickEarlyMethod;

import model.documentManagement.UseCase;
import model.quickEarlyMethod.QuickEarlyMethod;
import opennlp.tools.postag.POSSample;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import utility.eventEvaluation.SentenceParser;
import view.quickEarlyMethod.QuickEarlyView;

import java.io.IOException;

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
        boolean flag = false;

        System.out.println("-- Main Scenario");
        for(String flowEvent : quickEarlyMethod.getUseCase().getMainScenario()) {
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
        }

        System.out.println("-- Error Scenario");
        //System.out.println(flag);
        if (!flag)
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
