package com.example.recycleapp.ui.community;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.recycleapp.R;

public class CommunityFragment extends Fragment {

    private CommunityViewModel communityViewModel;

    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        communityViewModel =
                ViewModelProviders.of(this).get(CommunityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_community, container, false);

        btn1 = (Button) root.findViewById(R.id.btn1);
        btn2 = (Button) root.findViewById(R.id.btn2);
        btn3 = (Button) root.findViewById(R.id.btn3);
        btn4 = (Button) root.findViewById(R.id.btn4);
        btn5 = (Button) root.findViewById(R.id.btn5);
        btn6 = (Button) root.findViewById(R.id.btn6);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/EnvDefenseFund")));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/thenatureconservancy")));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/NRDC")));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/americanrivers")));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/4ocean/?hl=sv")));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/trustforpublicland/?hl=sv")));
            }
        });

        return root;
    }
}