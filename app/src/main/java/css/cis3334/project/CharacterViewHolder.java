package css.cis3334.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    TextView textViewCharacterDescription;

    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewCharacterDescription = itemView.findViewById(R.id.textViewCharacterDescription);
    }
}
