package com.ukom.kasaadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.ukom.kasaadmin.adapter.SliderAdapter;
import com.ukom.kasaadmin.databinding.ActivityMainBinding;
import com.ukom.kasaadmin.event.EventFragment;
import com.ukom.kasaadmin.home.HomeFragment;
import com.ukom.kasaadmin.karya.KaryaFragment;
import com.ukom.kasaadmin.model.SliderItem;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;
    private MeowBottomNavigation meowBottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        getSupportActionBar().hide();
        meow();

    }

    public void meow(){
        meowBottomNavigation = bind.meownav;

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_menu_book_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_newspaper_24));

        meowBottomNavigation.show(2, true);
        meowBottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1 :
                        replace(new KaryaFragment());
                        break;
                    case 2:
                        replace(new HomeFragment());
                        break;
                    case 3 :
                        replace(new EventFragment());
                        break;
                }
                return null;
            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(Integer.valueOf(R.id.framelayout), fragment).commit();
    }




}