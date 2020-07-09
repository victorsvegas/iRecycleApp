package com.example.recycleapp.ui.iteminfo;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.recycleapp.Databse.RecycleDatabase;
import com.example.recycleapp.R;
import com.example.recycleapp.ui.plast.PlastViewModel;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ItemInfoFragment extends Fragment {

    private ItemInfoViewModel itemInfoViewModel;

    RecycleDatabase db;
    TextView name, description;
    TextView category, disposal;
    ArrayList itemList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       itemInfoViewModel =
                ViewModelProviders.of(this).get(ItemInfoViewModel.class);
        View root = inflater.inflate(R.layout.item_info_fragment, container, false);

        name = root.findViewById(R.id.text_itemName);
        description = root.findViewById(R.id.text_itemDescription);
        category = root.findViewById(R.id.text_itemCategory);
        disposal = root.findViewById(R.id.text_itemDisposal);

        db = new RecycleDatabase(getActivity());
        db.getReadableDatabase();

        // Recives the id of clicked item in list
        Bundle bundle = getArguments();
        String itemsID = bundle.getString("clickedID");

        // Gets item with the recieved id from the database
        Cursor item = db.getItems(itemsID);
        item.moveToFirst();

        String a = item.getString(1);
        String b = item.getString(2);
        String c = item.getString(3);
        String d = item.getString(4);

        itemList = new ArrayList<>();

        itemList.add(a);
        itemList.add(b);
        itemList.add(c);
        itemList.add(d);

        DisplayItem(itemList);
        return root;
    }

    public void DisplayItem(ArrayList item)
    {
        if (item.size() != 0)
        {
            name.setText(item.get(0).toString());
            description.setText(item.get(1).toString());
            category.setText(item.get(2).toString());
            disposal.setText(item.get(3).toString());
        }
        else
        {
            toastMessage("No item found!");
        }
    }
    private void toastMessage(String message)
    {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
