package ru.bonepolk.ctf.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import ru.bonepolk.ctf.R;


public class Trainer extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trainer, container, false);

        WebView webView = view.findViewById(R.id.taskDesription);

        webView.loadUrl("http://185.185.70.255:8000/ctf/task/1");

        return view;
    }
}