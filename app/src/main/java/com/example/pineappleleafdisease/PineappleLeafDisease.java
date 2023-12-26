// Muhammad Najmi bin Hasnol Mizam (2020853514)
package com.example.pineappleleafdisease;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class PineappleLeafDisease extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pineapple_leaf_disease);

        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBoarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,paperOnboardingFragment);
        fragmentTransaction.commit();
    }
    //for slide or paper looking like book page FB85FF
    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {
        PaperOnboardingPage page1 = new PaperOnboardingPage("Leaf Spot", getString(R.string.leafspot),
                Color.parseColor("#8FE659"), R.drawable.whitespot, R.drawable.bacteria);
        PaperOnboardingPage page2 = new PaperOnboardingPage("Mealybug Wilt", getString(R.string.mealybugwilt),
                Color.parseColor("#FBB041"), R.drawable.mealybugwiltpic, R.drawable.bacteria);
        PaperOnboardingPage page3 = new PaperOnboardingPage("Pink Disease", getString(R.string.pinkDisease),
                Color.parseColor("#FB85FF"), R.drawable.pinkdisease, R.drawable.bacteria);
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(page1);
        elements.add(page2);
        elements.add(page3);
        return elements;
    }

}


