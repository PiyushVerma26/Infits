package hello.tech.infits.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import hello.tech.infits.Adapters.PagerAdapter;
import hello.tech.infits.R;

public class StartActvity extends AppCompatActivity {
    ViewPager viewPager;
    DotsIndicator dot1;
    PagerAdapter adapter;
    TextView log;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_actvity);
        viewPager=findViewById(R.id.viewPager);
        dot1=findViewById(R.id.dot1);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        adapter=new PagerAdapter(this);
        viewPager.setAdapter(adapter);
        dot1.setViewPager(viewPager);
        log=findViewById(R.id.log);
        btn=findViewById(R.id.btn);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActvity.this,LoginActivity.class));
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActvity.this,RegisterActivity.class));
                finish();
            }
        });

    }
}