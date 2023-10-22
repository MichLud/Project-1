package css.cis3334.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import css.cis3334.project.databinding.FragmentSelectionBinding;

public class FragmentSelection extends Fragment {

    private FragmentSelectionBinding binding;
    private MainViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // Use the shared ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentSelectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textViewCurrentSelection = binding.textViewCurrentSelection;
        final Button buttonNewCharacter = binding.buttonNewCharacter;
        final Button buttonSelectCharacter = binding.buttonSelectCharacter;

        viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}