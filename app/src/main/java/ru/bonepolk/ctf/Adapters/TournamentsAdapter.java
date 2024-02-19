package ru.bonepolk.ctf.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.Collections;
import java.util.List;

import ru.bonepolk.ctf.R;
import ru.bonepolk.ctf.Utils.JsonClasses.Tournament;
import ru.bonepolk.ctf.ViewHolders.TournamentViewHolder;

public class TournamentsAdapter extends ListAdapter<Tournament, TournamentViewHolder> {

    public TournamentsAdapter(DiffUtil.ItemCallback<Tournament> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TournamentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TournamentViewHolder holder, int position) {

    }
}