package com.example.recycleapp.ui.settings;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.recycleapp.R;

import java.util.List;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;
    private Button btnFeedback;
    private SwitchCompat switchNotifications, switchMute, switchOption3, switchOption4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        btnFeedback = (Button) root.findViewById(R.id.btnFeedback);

        // switches
        switchNotifications = (SwitchCompat) root.findViewById(R.id.switchNotifications);
        switchMute = (SwitchCompat) root.findViewById(R.id.switchMute);
        switchOption3 = (SwitchCompat) root.findViewById(R.id.switchOption3);
        switchOption4 = (SwitchCompat) root.findViewById(R.id.switchOption4);

        // check current state of a Switch (true or false).
        final Boolean switchState = switchNotifications.isChecked();

        switchNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (switchNotifications.isChecked())
                {
                    toastMessage("Notifications on");
                    // add settings functions here
                }
                else
                    {
                        toastMessage("Notifications off");
                        // add settings functions here
                    }
            }
        });

        switchMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (switchMute.isChecked())
                {
                    toastMessage("Sound on");
                    // add settings functions here
                }
                else
                {
                    toastMessage("Sound off");
                    // add settings functions here
                }
            }
        });

        switchOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (switchOption3.isChecked())
                {
                    toastMessage("On");
                    // add settings functions here
                }
                else
                {
                    toastMessage("Off");
                    // add settings functions here
                }
            }
        });

        switchOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (switchOption4.isChecked())
                {
                    toastMessage("On");
                    // add settings functions here
                }
                else
                {
                    toastMessage("Off");
                    // add settings functions here
                }
            }
        });


        btnFeedback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                shareToGmail();
            }
        });

        return root;
    }

    public void shareToGmail() {

            Intent intent = new Intent(Intent.ACTION_SEND);
            String[] emails_in_to={"viggen97gitarr@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, emails_in_to );
            intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
            intent.putExtra(Intent.EXTRA_TEXT, "I want to make a complaint! :(");
            intent.putExtra(Intent.EXTRA_CC,"svegasvictor@gmail.com");
            intent.setType("text/html");
            intent.setPackage("com.google.android.gm");
            startActivity(intent);
    }

    public void toastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}