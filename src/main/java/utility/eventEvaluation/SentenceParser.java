package utility.eventEvaluation;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SentenceParser {
    private InputStream inputStream = null;
    private ParserModel parserModel = null;
    private Parser parser = null;
    private String sentence = null;
    private Parse topParse[] = null;

    public SentenceParser( String sentence) throws IOException {
        this.inputStream = new FileInputStream("src/openNLP/en-parser-chunking.bin");
        this.parserModel = new ParserModel(inputStream);
        this.parser = ParserFactory.create(parserModel);
        this.sentence = sentence;
        this.topParse = ParserTool.parseLine(sentence, parser, 1);
    }

    public int isDisplayMessage() {
        Parse p = topParse[0];
        int sizeNP = p.getChildren()[0].getChildren()[1].getChildren()[1].getChildCount();

        //System.out.println("----"+p.getChildren()[0].getChildren()[1].getChildren()[1].getType());
        //System.out.println("----"+p.getChildren()[0].getChildren()[1].getChildren()[1].getChildren()[sizeNP-1].toString());
        //System.out.println((p.getChildren()[0].getChildren()[1].getChildren()[1].getChildren()[sizeNP-1].toString().equalsIgnoreCase("message.")));
        if (p.getChildren()[0].getChildren()[1].getChildren()[1].getType().equals("NP") && (p.getChildren()[0].getChildren()[1].getChildren()[1].getChildren()[sizeNP-1].toString().equals("message") || p.getChildren()[0].getChildren()[1].getChildren()[1].getChildren()[sizeNP-1].toString().equals("message."))) {

            return 1;
        } else if (p.getChildren()[0].getChildren()[1].getChildren()[1].getType().equals("NP") && !(p.getChildren()[0].getChildren()[1].getChildren()[1].getChildren()[sizeNP-1].toString().equals("message") || p.getChildren()[0].getChildren()[1].getChildren()[1].getChildren()[sizeNP-1].toString().equals("message.")))
            return 2;
        else
            return 3;
    }

    public boolean isSystemPromptsVerify() {
        Parse p = topParse[0];

        if (p.getChildren()[0].getChildren()[1].getChildren()[1].getType().equals("NP"))
            return true;
        else
            return false;
    }

    public boolean isActorConfirms() {
        Parse p = topParse[0];

        if (p.getChildren()[0].getChildren()[1].getChildren()[1].getType().equals("NP"))
            return true;
        else
            return false;
    }

}
