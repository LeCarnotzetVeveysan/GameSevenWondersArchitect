package application;

public class AppData {

    private static int prefWidth;
    private static int prefHeight;

    public AppData() {
        prefWidth = 600;
        prefHeight = 400;
    }

    public static int getPrefWidth(){
        return prefWidth;
    }

    public static int getPrefHeight(){
        return prefHeight;
    }

}
