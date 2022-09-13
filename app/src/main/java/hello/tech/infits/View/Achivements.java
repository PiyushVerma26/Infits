package hello.tech.infits.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import hello.tech.infits.Adapters.AchievementsAdapter;
import hello.tech.infits.Modals.AchievementsModal;
import hello.tech.infits.databinding.ActivityAchivementsBinding;

public class Achivements extends AppCompatActivity {
    ActivityAchivementsBinding binding;
    AchievementsAdapter adapter;
    ArrayList<AchievementsModal> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAchivementsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        list = new ArrayList<>();
        adapter = new AchievementsAdapter(list, this);

        binding.AchievementsRecycle.setHasFixedSize(true);
        binding.AchievementsRecycle.setHasFixedSize(true);
        binding.AchievementsRecycle.setAdapter(adapter);
        binding.AchievementsRecycle.setLayoutManager(new LinearLayoutManager(this));

        list.add(new AchievementsModal("25", "5/10", "50"));
        list.add(new AchievementsModal("50", "5/10", "50"));
        list.add(new AchievementsModal("50", "5/10", "50"));
        list.add(new AchievementsModal("65", "5/10", "50"));
        list.add(new AchievementsModal("75", "5/10", "50"));
        list.add(new AchievementsModal("85", "5/10", "50"));
        list.add(new AchievementsModal("95", "5/10", "50"));
        list.add(new AchievementsModal("100", "5/10", "50"));
        list.add(new AchievementsModal("150", "5/10", "50"));
    }
}