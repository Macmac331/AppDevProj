package com.example.finalappdevproj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import java.util.Random;

public class GuessingGame extends Fragment {

    private EditText userGuess;
    private Button button;
    private TextView txt;
    private int generatedNumber;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generatedNumber = generateNumber();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guessing_game, container, false);
        userGuess = view.findViewById(R.id.userGuess);
        button = view.findViewById(R.id.btnGuess);
        txt = view.findViewById(R.id.correctNumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessHandler();
            }
        });
        return view;
    }

    public int generateNumber(){
        Random random = new Random();
        return random.nextInt(99);
    }
    public void guessHandler() {
        String userGuessText = userGuess.getText().toString();

        if (!userGuessText.isEmpty()) {
            int userGuessNumber = Integer.parseInt(userGuessText);

            if (userGuessNumber == generatedNumber) {
                txt.setText("Congratualation you got the answer "+ generatedNumber);
                Toast.makeText(getContext(), "Congratulations!", Toast.LENGTH_SHORT).show();
            } else if (userGuessNumber > generatedNumber) {
                Toast.makeText(getContext(), "Try Lower!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Try Higher!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Please enter a guess!", Toast.LENGTH_SHORT).show();
        }
    }
}