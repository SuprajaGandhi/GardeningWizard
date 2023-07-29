package com.example.project;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class ViewQuestionsFragment extends Fragment {
    private TextView questionsTextView;
    private Button btnAnswer;
    private EditText answerEditText;
    public ViewQuestionsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_questions, container, false);
        questionsTextView = view.findViewById(R.id.HaveQuestion);
        btnAnswer = view.findViewById(R.id.ansQuestion);
        answerEditText=view.findViewById(R.id.AnswerQuestion);

        // Set an OnClickListener for the button
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the onClickAnswer method when the button is clicked
                onClickAnswer(v);
            }
        });
        return view;
    }
    public void updateQuestions(String questions) {
        if (questionsTextView != null) {
            questionsTextView.setText(questions);
        }
    }
    public void onClickAnswer(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Response recorded");
        builder.setMessage("Saved!");
        builder.setPositiveButton("Close", (dialog, which) -> {
            answerEditText.setText("");
            dialog.dismiss();
        });

        // Show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
