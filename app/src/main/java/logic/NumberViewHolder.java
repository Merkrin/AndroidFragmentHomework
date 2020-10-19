package logic;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.merkrin.androidfragmenthomework.R;
import com.merkrin.androidfragmenthomework.userInterface.BigNumberFragment;
import com.merkrin.androidfragmenthomework.userInterface.MainActivity;

public class NumberViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;
    private Context context;

    NumberViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
    }

    void bind(NumberItem numberItem) {
        textView.setText(numberItem.toString());
        textView.setTextColor(numberItem.getColor());

        itemView.setOnClickListener(view -> {
            BigNumberFragment bigNumberFragment = new BigNumberFragment();
            bigNumberFragment.initializeNumber(numberItem);

            ((MainActivity)context).setFragment(bigNumberFragment);
        });
    }

    void setContext(Context context){
        this.context = context;
    }
}