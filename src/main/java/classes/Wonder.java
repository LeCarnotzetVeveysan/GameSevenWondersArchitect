package classes;

public class Wonder {

    String wonderName;
    int wonderLevel;

    int numberOfStages = 5;

    boolean[] sameMaterials = new boolean[numberOfStages];
    int[] nbMaterials = new int[numberOfStages];

    int[] levelPoints = new int[numberOfStages];
    boolean[] levelAction = new boolean[numberOfStages];

    public String getWonderName() {
        return wonderName;
    }

    public int getWonderLevel() {
        return wonderLevel;
    }

    public void setWonderLevel(int wonderLevel) {
        this.wonderLevel = wonderLevel;
    }
}
