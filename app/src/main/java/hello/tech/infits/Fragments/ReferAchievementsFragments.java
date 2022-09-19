package hello.tech.infits.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import hello.tech.infits.R;

public class ReferAchievementsFragments extends DialogFragment {
    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setStyle(STYLE_NO_TITLE, androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
        return inflater.inflate(R.layout.refer_achievements,null);
    }
}