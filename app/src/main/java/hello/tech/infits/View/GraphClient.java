package hello.tech.infits.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hello.tech.infits.Fragments.Steps;
import hello.tech.infits.Fragments.calorieFragment;
import hello.tech.infits.Fragments.heartFragment;
import hello.tech.infits.Fragments.sleepFragment;
import hello.tech.infits.Fragments.waterFragment;
import hello.tech.infits.Fragments.weightFragment;
import hello.tech.infits.R;
import hello.tech.infits.databinding.ActivityGraphClientBinding;


public class GraphClient extends AppCompatActivity {
    ActivityGraphClientBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGraphClientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Steps
        binding.steps.setOnClickListener(
                v -> {
                    binding.steps.setBackgroundResource(R.drawable.img_17);
                    binding.water.setBackgroundResource(R.drawable.img_14);
                    binding.sleep.setBackgroundResource(R.drawable.img_20);
                    binding.weightTrack.setBackgroundResource(R.drawable.img_22);
                    binding.calorieTrack.setBackgroundResource(R.drawable.img_24);
                    binding.heartRate.setBackgroundResource(R.drawable.img_19);
                    Steps fragment = new Steps();
                    getSupportFragmentManager().beginTransaction().replace(R.id.clientFragments, fragment).commit();
                });


//        water
        binding.water.setOnClickListener(v -> {
            binding.water.setBackgroundResource(R.drawable.img_15);
            binding.steps.setBackgroundResource(R.drawable.img_16);
            binding.sleep.setBackgroundResource(R.drawable.img_20);
            binding.weightTrack.setBackgroundResource(R.drawable.img_22);
            binding.calorieTrack.setBackgroundResource(R.drawable.img_24);
            binding.heartRate.setBackgroundResource(R.drawable.img_19);
            waterFragment waterfragment = new waterFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.clientFragments, waterfragment).commit();
        });


//       calorie
        binding.calorieTrack.setOnClickListener(v -> {
            binding.water.setBackgroundResource(R.drawable.img_14);
            binding.steps.setBackgroundResource(R.drawable.img_16);
            binding.sleep.setBackgroundResource(R.drawable.img_20);
            binding.weightTrack.setBackgroundResource(R.drawable.img_22);
            binding.calorieTrack.setBackgroundResource(R.drawable.img_25);
            binding.heartRate.setBackgroundResource(R.drawable.img_19);
            calorieFragment calorie = new calorieFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.clientFragments, calorie).commit();
        });
//        Sleep
        binding.sleep.setOnClickListener(v -> {
            binding.water.setBackgroundResource(R.drawable.img_14);
            binding.steps.setBackgroundResource(R.drawable.img_16);
            binding.sleep.setBackgroundResource(R.drawable.img_21);
            binding.weightTrack.setBackgroundResource(R.drawable.img_22);
            binding.calorieTrack.setBackgroundResource(R.drawable.img_24);
            binding.heartRate.setBackgroundResource(R.drawable.img_19);
            sleepFragment sleep = new sleepFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.clientFragments, sleep).commit();
        });
//        Weight
        binding.weightTrack.setOnClickListener(v -> {
            binding.water.setBackgroundResource(R.drawable.img_14);
            binding.steps.setBackgroundResource(R.drawable.img_16);
            binding.sleep.setBackgroundResource(R.drawable.img_20);
            binding.weightTrack.setBackgroundResource(R.drawable.img_23);
            binding.calorieTrack.setBackgroundResource(R.drawable.img_24);
            binding.heartRate.setBackgroundResource(R.drawable.img_19);
            weightFragment weight = new weightFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.clientFragments, weight).commit();
        });
// heartRate
        binding.heartRate.setOnClickListener(v -> {
            binding.water.setBackgroundResource(R.drawable.img_14);
            binding.steps.setBackgroundResource(R.drawable.img_16);
            binding.sleep.setBackgroundResource(R.drawable.img_20);
            binding.weightTrack.setBackgroundResource(R.drawable.img_22);
            binding.calorieTrack.setBackgroundResource(R.drawable.img_24);
            binding.heartRate.setBackgroundResource(R.drawable.img_18);
            heartFragment heart = new heartFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.clientFragments, heart).commit();
        });

    }
}