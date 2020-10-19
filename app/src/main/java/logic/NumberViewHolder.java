package logic;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.merkrin.androidfragmenthomework.R;
import com.merkrin.androidfragmenthomework.userInterface.BigNumberFragment;
import com.merkrin.androidfragmenthomework.userInterface.MainActivity;

/**
 * Number view holder class.
 */
public class NumberViewHolder extends RecyclerView.ViewHolder {
    // Text view to show number.
    private final TextView textView;
    // Context of the recycler view.
    private Context context;

    /**
     * Constructor of the class.
     *
     * @param itemView View of the fragment.
     */
    NumberViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
    }

    /**
     * Recycler view item binding method.
     *
     * @param numberItem NumberItem to bind and show.
     */
    void bind(NumberItem numberItem) {
        // Set text view for the number item showing.
        textView.setText(numberItem.toString());
        textView.setTextColor(numberItem.getColor());

        // Set onClickListener for the number item.
        itemView.setOnClickListener(view -> {
            BigNumberFragment bigNumberFragment = new BigNumberFragment();
            bigNumberFragment.initializeNumber(numberItem);

            ((MainActivity) context).setFragment(bigNumberFragment);
        });
    }

    /**
     * Context setter.
     *
     * @param context Context of the recycler view.
     */
    void setContext(Context context) {
        this.context = context;
    }
}