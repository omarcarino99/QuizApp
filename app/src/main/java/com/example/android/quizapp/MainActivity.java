package com.example.android.quizapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int quizGrade = 0;

    private RadioButton answerOne;
    private EditText answerTwo;
    private RadioButton answerThree;
    private RadioButton answerFour;
    private RadioButton answerFive;
    private EditText answerSix;
    private RadioButton answerSeven;
    private CheckBox answerEight;
    private CheckBox answerEightSecondAnswer;
    private RadioButton answerNine;
    private RadioButton answerTen;

    private RadioGroup radioGroupOne;
    private RadioGroup radioGroupTwo;
    private RadioGroup radioGroupThree;
    private RadioGroup radioGroupFour;
    private RadioGroup radioGroupFive;
    private RadioGroup radioGroupSix;
    private RadioGroup radioGroupSeven;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerOne = (RadioButton)findViewById(R.id.question_one_answer_one);
        answerTwo = (EditText)findViewById(R.id.question_two_editText);
        answerThree = (RadioButton)findViewById(R.id.question_three_answer_two);
        answerFour = (RadioButton)findViewById(R.id.question_four_answer_one);
        answerFive = (RadioButton)findViewById(R.id.question_five_answer_three);
        answerSix = (EditText)findViewById(R.id.answer_six);
        answerSeven = (RadioButton)findViewById(R.id.question_seven_answer_three);
        answerEight = (CheckBox)findViewById(R.id.question_eight_answer_one);
        answerEightSecondAnswer = (CheckBox)findViewById(R.id.question_eight_answer_two);
        answerNine = (RadioButton)findViewById(R.id.question_nine_answer_one);
        answerTen = (RadioButton)findViewById(R.id.question_ten_answer_one);

        radioGroupOne = (RadioGroup)findViewById(R.id.radio_group_one);
        radioGroupTwo = (RadioGroup)findViewById(R.id.radio_group_two);
        radioGroupThree = (RadioGroup)findViewById(R.id.radio_group_three);
        radioGroupFour = (RadioGroup)findViewById(R.id.radio_group_four);
        radioGroupFive = (RadioGroup)findViewById(R.id.radio_group_five);
        radioGroupSix = (RadioGroup)findViewById(R.id.radio_group_six);
        radioGroupSeven = (RadioGroup)findViewById(R.id.radio_group_seven);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.resetMenuButton){
            clear(answerTwo,answerSix,answerEight,answerEightSecondAnswer,radioGroupOne,radioGroupTwo,radioGroupThree,radioGroupFour,radioGroupFive,radioGroupSix,radioGroupSeven);

        }

        return super.onOptionsItemSelected(item);
    }

    public void gradeQuiz(View view){


        String studentAnswer = answerTwo.getText().toString();
        String userAnswerQuestionSix = answerSix.getText().toString();

        if (answerOne.isChecked()){
            addPoint();
        }
        if (studentAnswer.contains("mike".toLowerCase())){
            addPoint();
        }
        if (answerThree.isChecked()){
            addPoint();
        }
        if (answerFour.isChecked()){
            addPoint();
        }
        if (answerFive.isChecked()){
            addPoint();
        }
        if (userAnswerQuestionSix.contains("Phoebe".toLowerCase())){
            addPoint();
        }
        if (answerSeven.isChecked()){
            addPoint();
        }
        if (answerEight.isChecked() && answerEightSecondAnswer.isChecked()){
            addPoint();
        }
        if (answerNine.isChecked()){
            addPoint();
        }
        if (answerTen.isChecked()){
            addPoint();
        }


        if (quizGrade <= 100){
            String finalQuizGrade = Integer.toString(quizGrade);
            Toast toast = Toast.makeText(this,"Your score is: " +finalQuizGrade,Toast.LENGTH_SHORT);
            toast.show();
            clear(answerTwo, answerSix, answerEight, answerEightSecondAnswer, radioGroupOne, radioGroupTwo,
                    radioGroupThree, radioGroupFour, radioGroupFive,radioGroupSix,radioGroupSeven);
            quizGrade = 0;
        }
        else{
            return;
        }
    }

    private void clear(EditText answerTwo, EditText answerSix, CheckBox answerEight, CheckBox answerEightSecondAnswer,
                       RadioGroup radioGroupOne, RadioGroup radioGroupTwo, RadioGroup radioGroupThree,
                       RadioGroup radioGroupFour, RadioGroup radioGroupFive,RadioGroup radioGroupSix,
                       RadioGroup radioGroupSeven) {

        CheckBox questionEightAnswerThree = (CheckBox)findViewById(R.id.question_eight_answer_three);

        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();
        radioGroupFour.clearCheck();
        radioGroupFive.clearCheck();
        radioGroupSix.clearCheck();
        radioGroupSeven.clearCheck();
        answerTwo.getText().clear();


        answerSix.getText().clear();
        if ( answerEight.isChecked()){
            answerEight.toggle();
        }
        if (answerEightSecondAnswer.isChecked()){
            answerEightSecondAnswer.toggle();
        }
        if (questionEightAnswerThree.isChecked()){
            questionEightAnswerThree.toggle();
        }

    }

    public int addPoint(){
        return quizGrade = quizGrade +10;
    }
}
