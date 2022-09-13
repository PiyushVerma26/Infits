package hello.tech.infits.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import hello.tech.infits.R;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {

    private final Context context;
    private final Integer[] images={R.drawable.one,R.drawable.two,R.drawable.three};

    public PagerAdapter(Context context)
    {
        this.context=context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.slide,null);
        ImageView imageView=view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        ViewPager viewPager=(ViewPager) container;
        viewPager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager=(ViewPager) container;
        View view=(View) object;
        viewPager.removeView(view);
    }
}
