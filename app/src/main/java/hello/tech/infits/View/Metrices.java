package hello.tech.infits.View;

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
    }
}