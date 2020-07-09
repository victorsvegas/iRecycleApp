package com.example.recycleapp.ui.recycle;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.recycleapp.R;
import com.example.recycleapp.ui.add.AddFragment;
import com.example.recycleapp.ui.elec.ElecFragment;
import com.example.recycleapp.ui.house.HouseFragment;
import com.example.recycleapp.ui.metal.MetalFragment;
import com.example.recycleapp.ui.paper.PaperFragment;
import com.example.recycleapp.ui.plast.PlastFragment;

import java.util.ArrayList;

public class RecycleFragment extends Fragment {

    private RecycleViewModel recycleViewModel;

    private Button btnHouse, btnPlast, btnElec, btnPaper, btnMetal, btnAdd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recycleViewModel =
                ViewModelProviders.of(this).get(RecycleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recycle, container, false);

        btnHouse = (Button) root.findViewById(R.id.btnHousehold);
        btnPlast = (Button) root.findViewById(R.id.btnPlastics);
        btnElec = (Button) root.findViewById(R.id.btnElectronics);
        btnPaper = (Button) root.findViewById(R.id.btnPaper);
        btnMetal = (Button) root.findViewById(R.id.btnMetal);
        btnAdd = (Button) root.findViewById(R.id.btnAdd);

        btnHouse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                HouseFragment houseFragment = new HouseFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, houseFragment).commit();
            }
        });

        btnPlast.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PlastFragment plastFragment = new PlastFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, plastFragment).commit();
            }
        });

        btnElec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ElecFragment elecFragment = new ElecFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, elecFragment).commit();
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PaperFragment paperFragment = new PaperFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, paperFragment).commit();
            }
        });

        btnMetal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MetalFragment metalFragment = new MetalFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, metalFragment).commit();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AddFragment addFragment = new AddFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, addFragment).commit();
            }
        });

        return root;
    }
}