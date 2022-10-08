package com.example.teamupboard.ui.person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.teamupboard.R;
import com.example.teamupboard.databinding.FragmentPersonBinding;


public class PersonFragment extends Fragment {
    private View view;

    private FragmentPersonBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_person,container,false);
        WebView webView = view.findViewById(R.id.person_web);
        webView.loadUrl("http://192.168.1.8:5173/Published");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}