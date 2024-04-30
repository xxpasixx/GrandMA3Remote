package de.pamlights.grandMA3Remote.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import de.pamlights.grandMA3Remote.R;
import de.pamlights.grandMA3Remote.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    private SharedPreferences sharedPreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (getActivity() == null) {
            return root;
        }

        sharedPreferences = getActivity().getSharedPreferences("GrandMA3_Remote", Context.MODE_PRIVATE);


        String ipAddress = sharedPreferences.getString("grandmaIP", "");
        String port = "" + sharedPreferences.getInt("grandmaPort", 8000);

        binding.grandmaIpEditText.setText(ipAddress);
        binding.grandmaPortEditText.setText(port);

        Button submitButton = root.findViewById(R.id.submit);

        submitButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String grandmaIP = String.valueOf(binding.grandmaIpEditText.getText());
            int grandmaPort = Integer.parseInt(String.valueOf(binding.grandmaPortEditText.getText()));

            editor.putString("grandmaIP", grandmaIP);
            editor.putInt("grandmaPort", grandmaPort);

            editor.apply();


            Toast.makeText(root.getContext(), "Saved", Toast.LENGTH_SHORT).show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}