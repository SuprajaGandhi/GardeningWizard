package com.example.project;


import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class QuestionAnswerActivity extends AppCompatActivity implements AskQuestionFragment.OnQuestionPostedListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    private DBHandler dbHandler;
    private ArrayList<QnAModal> qnaModalArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        dbHandler = new DBHandler(QuestionAnswerActivity.this);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Ask a Question"));
        tabLayout.addTab(tabLayout.newTab().setText("Answer a Question"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final CustomPagerAdapter adapter = new CustomPagerAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) { // Assuming the "Answer a Question" tab is at position 1
                    updateQuestionsFragmentWithLatestQuestion();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        qnaModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(QuestionAnswerActivity.this);

    }
    public void onQuestionPosted(String question) {
        String addDate="07/21/2023";
        String userName="John";
        dbHandler.addNewQuestion(question, addDate, userName);
        EditText questionEditText = findViewById(R.id.WriteQuestion);

        questionEditText.setText("");

    }

    private void updateQuestionsFragmentWithLatestQuestion() {
        qnaModalArrayList = dbHandler.readCourses();
        if (!qnaModalArrayList.isEmpty()) {
            String latestQuestion = qnaModalArrayList.get(qnaModalArrayList.size() - 1).getQuestion();
            ViewQuestionsFragment viewQuestionsFragment = (ViewQuestionsFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewPager + ":" + 1);
            if (viewQuestionsFragment != null) {
                viewQuestionsFragment.updateQuestions(latestQuestion);
            }
        }
    }

}