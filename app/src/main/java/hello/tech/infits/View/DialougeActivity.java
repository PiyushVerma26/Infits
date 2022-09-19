package hello.tech.infits.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import hello.tech.infits.Fragments.ReferAchievementsFragments;
import hello.tech.infits.databinding.ActivityDialougeBinding;

public class DialougeActivity extends AppCompatActivity {
ActivityDialougeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityDialougeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.btnFrag.setOnClickListener(v -> {
            DialogFragment fragment=new ReferAchievementsFragments();
            fragment.show(getSupportFragmentManager(),"Custom Fragment");
        });
    }
}