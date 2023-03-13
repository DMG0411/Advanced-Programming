package HomeWork;

import java.util.Date;
import java.util.Map;

public class Designer extends Person{

    private String[] knowingTools; //specific property of class

    public Designer(String name, Date birthDate, boolean married, String[] knowingTools) {
        super(name, birthDate, married);
        this.knowingTools = knowingTools;
    }

    public String[] getKnowingTools() {
        return knowingTools;
    }

    public void setKnowingTools(String[] knowingTools) {
        this.knowingTools = knowingTools;
    }
}
