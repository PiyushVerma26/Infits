package hello.tech.infits.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import hello.tech.infits.Fragments.BreakfastFragmnet;
import hello.tech.infits.Fragments.LaunchFragment;
import hello.tech.infits.R;
import hello.tech.infits.databinding.ActivityTrackerBinding;


public class Tracker extends AppCompatActivity {
    ActivityTrackerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTrackerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String date= dateFormat.format(new Date());
        binding.dateYear.setText(date);


        binding.breakfast.setOnClickListener(v -> {
          BreakfastFragmnet fragment=new BreakfastFragmnet();
          getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment). commit();
        });
        binding.launch.setOnClickListener(v -> {
            LaunchFragment fragment=new LaunchFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment). commit();
        });
    }
}