package com.example.recycleapp.ui.metal;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.recycleapp.Databse.RecycleDatabase;
import com.example.recycleapp.R;
import com.example.recycleapp.ui.iteminfo.ItemInfoFragment;

import java.util.ArrayList;

public class MetalFragment extends Fragment {

    private MetalViewModel metalViewModel;

    private ListView listItems;
    private RecycleDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        metalViewModel =
                ViewModelProviders.of(this).get(MetalViewModel.class);
        View root = inflater.inflate(R.layout.metal_fragment, container, false);


        listItems = (ListView) root.findViewById(R.id.listMetal);
        db = new RecycleDatabase(getActivity());

        showList();

        return root;
    }
    public void showList()
    {
        // Get data and bind to list
        Cursor data = db.getAllMetal();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext())
        {
            listData.add(data.getString(0));
        }
        ListAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listData);
        listItems.setAdapter(adapter);

        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                db = new RecycleDatabase(getActivity());
                String name = adapterView.getItemAtPosition(i).toString();

                //Getting data from the right item
                String itemID = db.getItemsId(name);
                Cursor item = db.getItems(itemID);
                item.moveToFirst();

                //Sending the itemID via bundle to ItemsInfo
                Bundle bundle = new Bundle();
                bundle.putString("clickedID", itemID);

                // Sends bundle to ItemsInfoFragment
                ItemInfoFragment itemsInfoFragment = new ItemInfoFragment();
                itemsInfoFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, itemsInfoFragment).commit();
            }
        });
    }
}
