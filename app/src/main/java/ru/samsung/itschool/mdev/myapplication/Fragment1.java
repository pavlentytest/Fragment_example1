package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


public class Fragment1 extends Fragment  {

    View view;
    String val;
    public static final String KEY = "tag";
    Button btn3,btn4;

    OnFragment1DataListener fListener;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragment1DataListener) {
            fListener = (OnFragment1DataListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragment1DataListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            val = getArguments().getString(KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_1, container, false);
        btn3 = view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     Snackbar.make(view.findViewById(R.id.fr1root),val,Snackbar.LENGTH_LONG).show();

                fListener.onFragment1DataListener("something back!!!");
            }
        });


        return view;

    }

    public interface OnFragment1DataListener {
        void onFragment1DataListener(String str);
    }

}