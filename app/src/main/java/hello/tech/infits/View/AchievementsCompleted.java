package hello.tech.infits.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hello.tech.infits.databinding.ActivityAchievementsCompletedBinding;

public class AchievementsCompleted extends AppCompatActivity {
ActivityAchievementsCompletedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding =ActivityAchievementsCompletedBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

    }
}