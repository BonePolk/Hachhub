package ru.bonepolk.ctf.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.bonepolk.ctf.Adapters.TournamentsAdapter;
import ru.bonepolk.ctf.R;
import ru.bonepolk.ctf.Utils.Callbacks;

public class PTournaments extends Fragment {
    TournamentsAdapter tournamentsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p_tournaments, container, false);
        tournamentsAdapter = new TournamentsAdapter(Callbacks.TouranmentsDiffCallback);

        return view;
    }
}