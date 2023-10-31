package css.cis3334.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private Button buttonNewCharacter, buttonAttributes, buttonSpells;
    private Spinner spinnerCurrentlySelected;
    private RecyclerView recyclerViewCharacterList;
    private CharacterAdapter characterAdapter;
    private Character selectedCharacter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCharacterList = findViewById(R.id.recyclerViewCharacterList);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        characterAdapter = new CharacterAdapter(mainViewModel);
        recyclerViewCharacterList.setAdapter(characterAdapter);
        recyclerViewCharacterList.setLayoutManager(new LinearLayoutManager(this));


        setupButtonNew();
        setupButtonAttributes();
        setupButtonSpells();
        setupLiveDataObserver();

    }

    private void setupSpinnerCurrentlySelected(List<Character> newList) {
        spinnerCurrentlySelected = findViewById(R.id.spinnerCurrentlySelected);
        ArrayAdapter<Character> adapter = new ArrayAdapter<Character>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, newList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCurrentlySelected.setAdapter(adapter);

        spinnerCurrentlySelected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCharacter = (Character) spinnerCurrentlySelected.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupLiveDataObserver() {
        mainViewModel.getAllCharacters().observe(this, new Observer<List<Character>>() {

            @Override
            public void onChanged(List<Character> characters) {
                Log.d("CIS 3334", "MainActivity -- LiveData Observer -- Number of Characters Changed");
                Log.d("CIS 3334", "MainActivity -- LiveData Observer -- Number of heartrates = " + characters.size());

                characterAdapter.updateCharacter(characters);
                setupSpinnerCurrentlySelected(characters);
                characterAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setupButtonNew() {
        buttonNewCharacter = findViewById(R.id.buttonNewCharacter);

        buttonNewCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "MainActivity -- buttonNewCharacter -- buttonNewCharacter Pressed");
                mainViewModel.addCharacter(new Character());
            }
        });
    }

    private void setupButtonAttributes() {
        buttonAttributes = findViewById(R.id.buttonAttributes);

        buttonAttributes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentInformation.class);
                intent.putExtra("selectedCharacter", selectedCharacter);

                startActivity(intent);
            }
        });
    }

    private void setupButtonSpells() {
        buttonSpells = findViewById(R.id.buttonSpells);

        buttonSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentSpells.class);
                intent.putExtra("selectedCharacter", selectedCharacter);

                startActivity(intent);
            }
        });
    }




}