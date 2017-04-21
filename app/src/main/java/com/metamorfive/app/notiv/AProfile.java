package com.metamorfive.app.notiv;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AProfile extends AppCompatActivity implements FProfile.IListener,FPosts.IListener {

    private int mNo;
    private TextView tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_profile_view);

        mNo = 1;
        changePage(mNo);
    }

    @Override
    public void toPostsPage(){
        changeFragment(2);
    }

    @Override
    public void toProfilePage(){
        changeFragment(1);
    }

    private void changePage(int no){
        changeFragment(no);
    }

    private void changeFragment(int no){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = null;

        switch (no){
            case 1 : fragment = new FProfile(); break;
            case 2 : fragment = new FPosts(); break;
        }

        fm.beginTransaction().replace(R.id.container,fragment).commitNow();
    }
}
