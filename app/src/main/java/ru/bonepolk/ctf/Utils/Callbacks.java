package ru.bonepolk.ctf.Utils;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ru.bonepolk.ctf.Utils.JsonClasses.Tournament;

public class Callbacks {
    public static DiffUtil.ItemCallback<Tournament> TouranmentsDiffCallback = new DiffUtil.ItemCallback<Tournament>() {

        @Override
        public boolean areItemsTheSame(@NonNull Tournament oldItem, @NonNull Tournament newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tournament oldItem, @NonNull Tournament newItem) {
            return false;
        }
    };
}
