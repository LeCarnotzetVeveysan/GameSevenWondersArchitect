package application;

public class AppData {

    private static String language;
    private static int prefWidth;
    private static int prefHeight;
    private static int wonderLayoutSize;

    public AppData() {
        language = "EN";
        prefWidth = 500;
        prefHeight = 400;
        wonderLayoutSize = 350;
    }

    public static void setLanguage(String inputLanguage){
        language = inputLanguage;
    }

    public static String getLanguage() {
        return language;
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
    public static void setWonderLayoutSize(int input){
        wonderLayoutSize = input;
    }
    public static int getWonderLayoutSize(){
        return wonderLayoutSize;
    }



}
