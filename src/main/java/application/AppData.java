package application;

public class AppData {

    private static int prefWidth;
    private static int prefHeight;
    private static String language;

    public AppData() {
        prefWidth = 600;
        prefHeight = 400;
        language = "english";
    }

    public static void setPrefWidth(int input){
        prefWidth = input;
    }
    public static int getPrefWidth(){
        return prefWidth;
    }
    public static void setPrefHeight(int input){
        prefHeight = input;
    }
    public static int getPrefHeight(){
        return prefHeight;
    }

    public static void setLanguage(String inputLanguage){
        language = inputLanguage;
    }

}
