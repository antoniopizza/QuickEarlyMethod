package controller.catalogManagement;

import model.catalogManagement.Catalog;
import view.catalogManagemt.CatalogView;

import java.io.IOException;
import java.io.ObjectInputStream;

public class CatalogControl {

    private Catalog catalog = null;
    private CatalogView catalogView = null;
    private ObjectInputStream objectInputStream = null;

    public CatalogControl(Catalog catalog, CatalogView catalogView) {
        this.catalog = catalog;
        this.catalogView = catalogView;
    }

    public void addCatalogErrorMessage(String sinomimo) throws IOException {
        objectInputStream = catalog.getCatalogErrorMessage();
    }
}
