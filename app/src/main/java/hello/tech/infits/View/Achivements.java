package hello.tech.infits.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hello.tech.infits.databinding.ActivityAchivementsBinding;

public class Achivements extends AppCompatActivity {
ActivityAchivementsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityAchivementsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.AchievementsRecycle.setHasFixedSize(true);
    }
}