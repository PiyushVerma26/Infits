package hello.tech.infits.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hello.tech.infits.databinding.ActivityMetricesBinding;

public class Metrices extends AppCompatActivity {
    ActivityMetricesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMetricesBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.stepsLayout.setOnClickListener(v -> startActivity(new Intent(Metrices.this, GraphClient.class)));
        binding.heartLayout.setOnClickListener(v -> startActivity(new Intent(Metrices.this, GraphClient.class)));
        binding.sleepLayout.setOnClickListener(v -> startActivity(new Intent(Metrices.this, GraphClient.class)));
        binding.waterLayout.setOnClickListener(v -> startActivity(new Intent(Metrices.this, GraphClient.class)));
        binding.calorieLayout.setOnClickListener(v -> startActivity(new Intent(Metrices.this, GraphClient.class)));
        binding.weightLayout.setOnClickListener(v -> startActivity(new Intent(Metrices.this, GraphClient.class)));
    }
}