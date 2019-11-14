package view.documentManagement;

public class DocumentView {


    private String useCaseName = null;
    private String actors = null;
    private String preconditions = null;
    private String extensionPoint = null;
    private String generalizationOf = null;
    private String mainScenario = null;
    private String errorScenario = null;

    public DocumentView() {

    }

    public String getUseCaseName() {
        return useCaseName;
    }

    public String getActors() {
        return actors;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public String getExtensionPoint() {
        return extensionPoint;
    }

    public String getGeneralizationOf() {
        return generalizationOf;
    }

    public String getMainScenario() {
        return mainScenario;
    }

    public String getErrorScenario() {
        return errorScenario;
    }

    public void setUseCaseName(String useCaseName) {
        this.useCaseName = useCaseName;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }

    public void setExtensionPoint(String extensionPoint) {
        this.extensionPoint = extensionPoint;
    }

    public void setGeneralizationOf(String generalizationOf) {
        this.generalizationOf = generalizationOf;
    }

    public void setMainScenario(String mainScenario) {
        this.mainScenario = mainScenario;
    }

    public void setErrorScenario(String errorScenario) {
        this.errorScenario = errorScenario;
    }


}
