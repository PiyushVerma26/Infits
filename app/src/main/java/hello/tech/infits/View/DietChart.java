package hello.tech.infits.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import hello.tech.infits.Fragments.DietBreakfastFragment;
import hello.tech.infits.R;
import hello.tech.infits.databinding.ActivityDietChartBinding;

public class DietChart extends AppCompatActivity {
    ActivityDietChartBinding binding;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDietChartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.breakfast.setOnClickListener(v -> {
            fragment = new DietBreakfastFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment);
        });

    }
}