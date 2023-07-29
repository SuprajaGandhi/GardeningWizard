package com.example.project;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class AskQuestionFragment extends Fragment{

    private Button postbutton;
    public AskQuestionFragment() {
        // Required empty public constructor
    }
    public interface OnQuestionPostedListener {
        void onQuestionPosted(String question);
    }

    private OnQuestionPostedListener questionPostedListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ask_question, container, false);

        Button postButton = rootView.findViewById(R.id.ansQuestion);

        // Set an OnClickListener for the Post button
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the postQuestion() method when the button is clicked
                postQuestion();
            }
        });
        return rootView;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            questionPostedListener = (OnQuestionPostedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnQuestionPostedListener");
        }
    }

    private void postQuestion() {
        EditText questionEditText = getView().findViewById(R.id.WriteQuestion);
        String question = questionEditText.getText().toString();

        // Pass the question to the QnA Activity
        questionPostedListener.onQuestionPosted(question);
    }


}
