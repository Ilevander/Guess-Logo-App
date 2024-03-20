package com.example.guess_logo;

public class Questions {
    private String mQuestions[] ={
            "Guess the Logo ?",
            "You Can Guess the Logo ?",
            "Can you this one?",
            "Guess the Logo ?",
            "Guess the Logo ?",
            "Can you this one?",
            "Guess the Logo ?",
            "Guess the Logo ?",
            "Can you this one?",
            "Guess the Logo ?",
    };
    
    private String mChoice[] [] = {
            {"Android","IOS","Both"},
            {"Mozilla","Chrome","Brave"},
            {"Hp","Dell","ThinKPad"},
            {"GitLab","Github","SourceForge "},
            {"Flutter","React-Native","Xamarin"},
            {"Yahoo Mail","Gmail","Zoho Mail"},
            {"BackBox","Security Onion","Kali-Linux"},
            {"NVIDIA Corporation","Intel","IBM Corporation"},
            {"C#","JavaScript","Java"},
            {"Kotlin","Dart","Swift"},
            {"Outlook","Other","Gmail"},
            {"Xiaomi","OPPO","Oraimo"},
            {"CryEngine","Unity","Amazon Lumberyard"},
    };
    
    private String mImages[] = {
            "q1", //Android image
            "q2", //Chrome image
            "q3", //Dell image
            "q5", //Github image
            "q6", //Flutter image
            "q7", //Gmail image
            "q8", //Kali Linux image
            "q9", //Intel image
            "q10", //Java image
            "q11", //Kotlin image
            "q12", //Microsoft image
            "q13", //Nvidia image
            "q14", //Opera image
            "q15", //Outlook image
            "mic", //Xiaomi image
            "unt", //Unity
    };

    private String mQuestionsType[] = {
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
    };

    private String mCorrecrtAnswers[] = {
            "Android",
            "Chrome",
            "Dell",
            "Github",
            "Flutter",
            "Gmail",
            "Kali Linux",
            "Intel",
            "Java",
            "Kotlin",
            "Microsoft",
            "Nvidia",
            "Opera",
            "Outlook",
            "Xiaomi",
            "Unity",
    };

    //Getters and Setters:
    public String getmQuestions(int q) {
        String questions = mQuestions[q];
        return questions;
    }

    public String[] getmChoice(int q) {
        String[] choice = mChoice[q];
        return choice;
    }

    public String getmImages(int q) {
        String img = mImages[q];
        return img;
    }

    public String getType(int q) {
        String type = mQuestionsType[q];
        return type;
    }

    public int getLenght(){
        return mQuestions.length;
    }

    public String getmCorrecrtAnswers(int q) {
        String correct = mCorrecrtAnswers[q];
        return correct;
    }
}
