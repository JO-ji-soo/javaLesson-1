package object;

import java.util.Scanner;

public class AddQuizMain { 
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int correctCount = 0; //맞은 문제 개수를 저장하는 변수
    int questions =10; //문제수
    int start = 11; 
    int end = 99;

    AddQuiz[] AQ = new AddQuiz[questions];
    System.out.println("덧셈" + questions + "문제 퀴즈를 시작합니다.");

    for (int i =0;i< questions; i++){
        int data1 = (int)(Math.random()*(end-start+1))+start;
        int data2 = (int)(Math.random()*(end-start+1))+start;

        AQ[i]= new AddQuiz(data1, data2);
        
        AddQuiz A1 = AQ[i];
        System.out.println(String.format("%d문제 %d+%d=?", (i+1),A1.getData1(),A1.getData2()));
        System.out.println("답을 입력하세요. >>>");
        int temp = sc.nextInt();
        A1.setUserAnswer(temp);

        if(A1.isRight(temp)){
            correctCount++;
        }
    }
        System.out.println("\n ::::::채 점 중 입 니 다.:::::::");
        System.out.println(String.format("%s %4s %3s %3s", "문제","제출답","정답","채점"));

    for (int i = 0; i < questions; i++){
        AddQuiz A1 = AQ[i];
        System.out.println(String.format("%d 번 %4d+%d / %-4d / %-4d %3c" , (i+1),A1.getData1(),A1.getData2(),A1.getUserAnswer(),(A1.getData1() + A1.getData2()),(A1.isRight())));


    }

    System.out.println("맞은 문제 개수 :" + correctCount);
    }
    
}
