package hello.tech.infits.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hello.tech.infits.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {
    ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityAboutBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


    }
}