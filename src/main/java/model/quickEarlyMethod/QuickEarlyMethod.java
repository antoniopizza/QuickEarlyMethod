package model.quickEarlyMethod;

import model.documentManagement.UseCase;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class QuickEarlyMethod {

    private InputStream inputStreamPOS = null;
    private InputStream inputStreamSentence = null;
    private POSModel posModel = null;
    private POSTaggerME taggerME = null;
    private SentenceDetectorME detectorME = null;
    private SentenceModel sentenceModel = null;
    private String sentences[] = null;
    private String token[] = null;
    private String tags[] = null;
    private int CFp;
    private UseCase useCase = null;

    public QuickEarlyMethod() throws IOException {
        this.inputStreamPOS = new FileInputStream("src/openNLP/en-pos-maxent.bin");
        this.posModel = new POSModel(this.inputStreamPOS);
        this.taggerME = new POSTaggerME(this.posModel);

        this.inputStreamSentence = new FileInputStream("src/openNLP/en-sent.bin");
        this.sentenceModel = new SentenceModel(this.inputStreamSentence);
        this.detectorME = new SentenceDetectorME(sentenceModel);
        this.CFp = 0;
    }

    public String[] getSentences() { return sentences; };
    public void setSentences(String sentences[]) {
        this.sentences = sentences;
    }

    public String[] getToken() {    return this.token;  }
    public void setToken(String[] token) {
        this.token = token;
    }

    public String[] getTags() {    return this.tags;  }
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int getCFp() { return CFp;}
    public void setCFp(int CFp) {
        this.CFp = CFp;
    }

    public SentenceDetectorME getDetectorME() { return detectorME; }

    public POSTaggerME getTaggerME() { return taggerME; }

    public void initializeUseCase(UseCase useCase) {
        this.useCase = useCase;
    }

    public UseCase getUseCase() {
        return useCase;
    }


    /*public void getTag() {};

    private int CFp;
    private Table table = null;
    private TableView tableView = null;
    private TableController tableController = null;

    public QuickEarlyMethod() {
        CFp = 0;
    }

    public void openFile(String pathName) throws IOException {
        table = new Table(pathName);
        tableView = new TableView();
        tableController = new TableController(table, tableView);
    }

    public void estimateSize() {
        String preconditions = tableController.getPrecondition();
        String extensionPointOf = tableController.getExtensionPoint();
        String generalizationOf = tableController.getExtensionPoint();
        ArrayList<String> mainScenario = tableController.getMainScenario();
        ArrayList<String> errorScenario = tableController.getErrorScenarios();

        CFp = 3 + mainScenario.size() + errorScenario.size();
        System.out.println("La size funzionale in termini Cosmic Function Point è "+CFp);
    }*/
}
