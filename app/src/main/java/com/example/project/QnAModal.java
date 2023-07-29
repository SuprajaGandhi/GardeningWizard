package com.example.project;


public class QnAModal {

    private String Question;
    private int id;
    private String AddedDate;
    private String UserName;

    // creating getter and setter methods
    public String getQuestion() { return Question; }

    public void setQuestion(String question)
    {
        this.Question = question;
    }

    public String getAddedDate() { return AddedDate; }

    public void setAddedDate(String addedDate)
    {
        this.AddedDate = addedDate;
    }

    public String getUserName() { return UserName; }

    public void setUserName(String username)
    {
        this.UserName = username;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public QnAModal(String question,
                       String addedDate,
                       String userName)
    {
        this.Question = question;
        this.AddedDate = addedDate;
        this.UserName = userName;
    }
}
