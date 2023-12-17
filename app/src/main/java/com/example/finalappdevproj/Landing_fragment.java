package com.example.finalappdevproj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Landing_fragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_landing_fragment, container, false);
        TextView textView = view.findViewById(R.id.userText);
        String userName = getArguments() != null ? getArguments().getString("USER_NAME") : null;
        String welcomeText = getString(R.string.default_welcome_message);

        if (userName != null) {
            welcomeText = getString(R.string.welcome_message, userName);
        }

        textView.setText(welcomeText);

        return view;
    }
}