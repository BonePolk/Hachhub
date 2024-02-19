package ru.bonepolk.ctf.Adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import ru.bonepolk.ctf.Fragments.PTournaments;
import ru.bonepolk.ctf.Fragments.Trainer;

public class ParticipantStateAdapter extends FragmentStateAdapter {
    public ParticipantStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new PTournaments();
        }
        return new Trainer();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
