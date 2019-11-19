package main;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

import java.io.*;
import java.util.ArrayList;

public class MainProva {
    public static void main(String[] args) throws IOException {
/*

        InputStream inputStream = new FileInputStream("src/openNLP/en-parser-chunking.bin");
        ParserModel model = new ParserModel(inputStream);

        Parser parser = ParserFactory.create(model);

        String sentence = "The system displays a error message";
        Parse topParse[] = ParserTool.parseLine(sentence, parser, 1);
*/

        /*for (Parse p : topParse)
            p.show();*/

        /*FileWriter w = new FileWriter("ErrorMessageCatalog.txt");
        BufferedWriter bb = new BufferedWriter(w);
        bb.write("displays \n");
        bb.write("shows \n");
        bb.write("ciao \n");
        bb.flush();*/

        ArrayList<String> sentence = new ArrayList<String>();
        sentence.add("");


        ArrayList<String> array = new ArrayList<String>();
        FileReader f = new FileReader("ErrorMessageCatalog.txt");
        BufferedReader b = new BufferedReader(f);
        String s;
        while (true) {
            s = b.readLine();
            array.add(s);
            if(s==null)
                break;
            //System.out.println(s);
        }

        for (String a : array)
            System.out.println(a);
    }
}
