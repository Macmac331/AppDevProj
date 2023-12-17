package com.example.finalappdevproj;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar tlb = findViewById(R.id.toolbar);
        setSupportActionBar(tlb);
        if (savedInstanceState == null) replaceFragment(new Landing_fragment());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.missionvision) {
            replaceFragment(new MissionVision());
            return true;
        } else if (item.getItemId() == R.id.guess) {
            replaceFragment(new GuessingGame());
            return true;
        }else if (item.getItemId() == R.id.exit){
            finish();
        }
        else if (item.getItemId() == R.id.home){
            replaceFragment((new Landing_fragment()));
        }
        return super.onOptionsItemSelected(item);
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}