package css.cis3334.project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;


public class FragmentSpells extends AppCompatActivity {

    private MainViewModel viewModel;
    private Character selectedCharacter;
    private EditText editTextLevelOne, editTextLevelTwo, editTextLevelThree;
    private Button buttonSaveSpellChanges, buttonReturnFromSpells;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_spells);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        selectedCharacter = (Character) getIntent().getSerializableExtra("selectedCharacter");

        editTextLevelOne = findViewById(R.id.editTextLevelOne);
        editTextLevelTwo = findViewById(R.id.editTextLevelTwo);
        editTextLevelThree = findViewById(R.id.editTextLevelThree);

        loadData();
        setupSaveButton();
        setupReturnButton();
    }

    private void loadData() {
        List<Spell> spellList = selectedCharacter.spells;
        editTextLevelOne.setText(spellList.get(0).toString());
        editTextLevelTwo.setText(spellList.get(1).toString());
        editTextLevelThree.setText(spellList.get(2).toString());
    }


    private void setupSaveButton() {
        buttonSaveSpellChanges = findViewById(R.id.buttonSaveSpellChanges);

        buttonSaveSpellChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Save Button Clicked");
                Character update = new Character(selectedCharacter.name, selectedCharacter.characterClass);
                update.spells = selectedCharacter.spells;
                ArrayList<Spell> spellList = update.spells;
                spellList.get(0).spellMax = Integer.parseInt(editTextLevelOne.getText().toString());
                spellList.get(1).spellMax = Integer.parseInt(editTextLevelTwo.getText().toString());
                spellList.get(2).spellMax = Integer.parseInt(editTextLevelThree.getText().toString());
                update.spells = spellList;
                viewModel.deleteCharacter(selectedCharacter);
                viewModel.addCharacter(update);
            }
        });
    }

    private void setupReturnButton() {
        buttonReturnFromSpells = findViewById(R.id.buttonReturnFromSpells);

        buttonReturnFromSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Return Button Clicked");
                finish();
            }
        });
    }
}