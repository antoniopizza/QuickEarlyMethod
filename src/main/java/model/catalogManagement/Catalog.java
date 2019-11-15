package model.catalogManagement;

import java.io.*;

public class Catalog {

    private FileInputStream inputStreamFile = null;
    private ObjectInputStream inputStreamObject = null;
    public Catalog() {
    }


    public ObjectInputStream getCatalogErrorMessage() throws IOException {

        inputStreamFile = new FileInputStream("ErrorMessageCatalog.txt");
        inputStreamObject = new ObjectInputStream(inputStreamFile);

        return inputStreamObject;
    }

}
