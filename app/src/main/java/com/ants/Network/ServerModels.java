package com.ants.Network;

import java.util.Date;

public class ServerModels {

    public class GetUserResult {
        public String first_name;
        public String last_name;
        public String user_type;
    }

    public class Patient {
        public String email;
        public String firstName;
        public String lastName;
    }

    public class Caregiver {
        public String email;
        public String firstName;
        public String lastName;
    }

    public class Question {
        public String question;
        public Date timestamp;
    }

    public class Answer {
        public String answer;
        public Date timestamp;
    }

    /*------------------------------ Request Models ------------------------------*/
}

class GetUserParam {
    public String Username;
    public String Password;
}

class PostPatientParam
{
    public String Username;
    public String FirstName;
    public String LastName;
    public String Gender;
    public Date dateOfBirth;
    public Date dateOfDiagnosis;
}

class PostCaregiverParam
{
    public String Username;
    public String FirstName;
    public String LastName;
    public String Gender;
    public Date dateOfBirth;
    public Date dateOfDiagnosis;
}

class PostAnswerParam
{
    public String answer;
    public Date timestamp;
}

class PostQuestionParam
{
    public String answer;
    public Date timestamp;
}
