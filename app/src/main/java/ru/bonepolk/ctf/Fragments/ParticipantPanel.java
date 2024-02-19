package ru.bonepolk.ctf.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import ru.bonepolk.ctf.R;
import ru.bonepolk.ctf.Adapters.ParticipantStateAdapter;


public class ParticipantPanel extends Fragment {
    private TabLayout tabLayout;
    public ViewPager2 viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_participant_panel, container, false);

        tabLayout = (TabLayout) fragmentView.findViewById(R.id.participantTabs);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ParticipantStateAdapter participantStateAdapter = new ParticipantStateAdapter(fragmentManager, getLifecycle());
        viewPager = (ViewPager2) fragmentView.findViewById(R.id.participantVP);
        viewPager.setAdapter(participantStateAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return fragmentView;
    }
}