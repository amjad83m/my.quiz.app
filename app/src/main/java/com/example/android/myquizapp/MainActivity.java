package com.example.android.myquizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean takeQuiz = false;
    int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enableDisableSubmit(View view) {
        CheckBox takeQuizCheckBox = (CheckBox) findViewById(R.id.take_quiz_checkbox);
        if (takeQuizCheckBox.isChecked()) {
            takeQuiz = true;
        } else {
            takeQuiz = false;
        }
    }

    public void submitQuiz(View view) {
        if (!takeQuiz) {
            showToastMessage(getString(R.string.takeQuizVerification), Toast.LENGTH_SHORT);
        } else {
            EditText fullNameField = (EditText) findViewById(R.id.full_name_field);
            String fullName = fullNameField.getText().toString();

            String scoreMessage = getString(R.string.participant, fullName);
            scoreMessage += " " + getString(R.string.score_summary, quizScore * 2);

            showToastMessage(scoreMessage, Toast.LENGTH_LONG);
        }
    }

    private void showToastMessage(CharSequence message, int duration) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public void answerRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.q1_a3_radio:
                if (checked) quizScore += 1;
                break;
            case R.id.q2_a1_radio:
                if (checked) quizScore += 1;
                break;
            case R.id.q3_a3_radio:
                if (checked) quizScore += 1;
                break;
            case R.id.q4_a4_radio:
                if (checked) quizScore += 1;
                break;
            case R.id.q5_a4_radio:
                if (checked) quizScore += 1;
                break;
            default:
                quizScore += 0;
        }
    }
}
