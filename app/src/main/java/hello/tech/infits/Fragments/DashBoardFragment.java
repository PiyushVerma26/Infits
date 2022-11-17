package hello.tech.infits.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import hello.tech.infits.View.Metrices;
import hello.tech.infits.databinding.FragmentDashBoardBinding;

public class DashBoardFragment extends Fragment {
 FragmentDashBoardBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentDashBoardBinding.inflate(getLayoutInflater());

       binding.metrices.setOnClickListener(v -> startActivity(new Intent(getContext(), Metrices.class)));
        return binding.getRoot();
    }
}