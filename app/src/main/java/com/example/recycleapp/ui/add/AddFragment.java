package com.example.recycleapp.ui.add;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycleapp.Databse.Items;
import com.example.recycleapp.Databse.Items;
import com.example.recycleapp.Databse.RecycleDatabase;
import com.example.recycleapp.R;
import com.example.recycleapp.ui.house.HouseFragment;
import com.google.android.material.textfield.TextInputLayout;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;

    AppCompatSpinner inputSpinnerDisposal, inputSpinnerCategory;
    private EditText itemName, itemDescription;
    private Button btnAddItem;

    private RecycleDatabase db;
    private Items items;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel =
                ViewModelProviders.of(this).get(AddViewModel.class);
        View root = inflater.inflate(R.layout.add_fragment, container, false);

        itemName = (EditText) root.findViewById(R.id.NameText);
        itemDescription = (EditText) root.findViewById(R.id.DescriptionText);
        btnAddItem = (Button) root.findViewById(R.id.btnAddItem);

        items = new Items();
        db = new RecycleDatabase(getActivity());

        btnAddItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    AddItem();
            }
        });

        // Spinners
        inputSpinnerCategory = root.findViewById(R.id.spinnerCategory);
        String[] itemsCat = new String[]{"Household", "Plastics", "Electronics" , "Paper / Cardboard", "Metal"};
        ArrayAdapter<String> adapterCat = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, itemsCat);
        inputSpinnerCategory.setAdapter(adapterCat);

        inputSpinnerDisposal = root.findViewById(R.id.spinnerDisposal);
        String[] itemsDis = new String[]{"Dispose in general waste bin", "Dispose on a Recycling station", "Dispose in garden waste bin" , "Dispose at a specific place"};
        ArrayAdapter<String> adapterDis = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, itemsDis);
        inputSpinnerDisposal.setAdapter(adapterDis);
        return root;
    }

    public void AddItem()
    {
        // Sends items to the database through the setters in the class Items
        items.setName(itemName.getText().toString().trim());
        items.setDescription(itemDescription.getText().toString().trim());
        items.setCategory(inputSpinnerCategory.getSelectedItem().toString().trim());
        items.setDisposal(inputSpinnerDisposal.getSelectedItem().toString().trim());
        db.addItem(items);

        toastMessage("Data succesfully saved!");

        // Takes user back to the HouseFragment
        HouseFragment houseFragment = new HouseFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment, houseFragment).commit();
    }

    public void toastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}
