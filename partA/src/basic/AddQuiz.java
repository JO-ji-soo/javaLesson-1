package object;

public class AddQuiz {
    private int data1;
    private int data2;
    private int userAnswer;

    public int getData1() {
        return data1;
    }
    public int getData2() {
        return data2;
    }
    public int getUserAnswer() {
        return userAnswer;
    }
    
    public AddQuiz(int data1, int data2){
        this.data1 = data1;
        this.data2 = data2;
    }
    public boolean isRight(int userAnswer){
        return (getData1()+getData2()) == getUserAnswer();

    }
    public char isRight(){
        return getUserAnswer()==(getData1()+getData2())? 'o':'x';
    }

    public void setUserAnswer(int userAnswer){
        this.userAnswer = userAnswer;
    }



    





}
