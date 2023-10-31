package css.cis3334.project;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class FragmentInformation extends AppCompatActivity {

    private MainViewModel viewModel;
    public Character selectedCharacter;
    private EditText editTextCharacterName, editTextCharacterClass;
    private EditText editTextCharacterStrength, editTextCharacterDexterity;
    private EditText editTextCharacterConstitution, editTextCharacterIntelligence;
    private EditText editTextCharacterWisdom, editTextCharacterCharisma;
    private Button buttonSaveInfoChanges, buttonReturn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_information);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        selectedCharacter = (Character) getIntent().getSerializableExtra("selectedCharacter");

        editTextCharacterName = findViewById(R.id.editTextCharacterName);
        editTextCharacterClass = findViewById(R.id.editTextCharacterClass);
        editTextCharacterStrength = findViewById(R.id.editTextCharacterStrength);
        editTextCharacterDexterity = findViewById(R.id.editTextCharacterDexterity);
        editTextCharacterConstitution = findViewById(R.id.editTextCharacterConstitution);
        editTextCharacterIntelligence = findViewById(R.id.editTextCharacterIntelligence);
        editTextCharacterWisdom = findViewById(R.id.editTextCharacterWisdom);
        editTextCharacterCharisma = findViewById(R.id.editTextCharacterCharisma);


        loadData();
        setupSaveButton();
        setupReturnButton();
    }

    private void setupReturnButton() {
        buttonReturn = findViewById(R.id.buttonReturnFromInfo);

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334" , "Return button Pressed");
                finish();
            }
        });
    }

    private void loadData() {
        editTextCharacterName.setText(selectedCharacter.name);
        editTextCharacterClass.setText(selectedCharacter.characterClass);
        editTextCharacterStrength.setText(selectedCharacter.attributes.get(0).toString());
        editTextCharacterDexterity.setText(selectedCharacter.attributes.get(1).toString());
        editTextCharacterConstitution.setText(selectedCharacter.attributes.get(2).toString());
        editTextCharacterIntelligence.setText(selectedCharacter.attributes.get(3).toString());
        editTextCharacterWisdom.setText(selectedCharacter.attributes.get(4).toString());
        editTextCharacterCharisma.setText(selectedCharacter.attributes.get(5).toString());

    }

    private void setupSaveButton() {
        buttonSaveInfoChanges = findViewById(R.id.buttonSaveInfoChanges);

        buttonSaveInfoChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Save Button Pressed");
                Character update = new Character(selectedCharacter.name, selectedCharacter.characterClass);
                update.spells = selectedCharacter.spells;
                update.name = editTextCharacterName.getText().toString();
                update.characterClass = editTextCharacterClass.getText().toString();
                update.attributes.set(0,Integer.parseInt((editTextCharacterStrength.getText().toString())));
                update.attributes.set(1,Integer.parseInt((editTextCharacterDexterity.getText().toString())));
                update.attributes.set(2,Integer.parseInt((editTextCharacterConstitution.getText().toString())));
                update.attributes.set(3,Integer.parseInt((editTextCharacterIntelligence.getText().toString())));
                update.attributes.set(4,Integer.parseInt((editTextCharacterWisdom.getText().toString())));
                update.attributes.set(5,Integer.parseInt((editTextCharacterCharisma.getText().toString())));
                viewModel.deleteCharacter(selectedCharacter);
                viewModel.addCharacter(update);
            }
        });
    }

}