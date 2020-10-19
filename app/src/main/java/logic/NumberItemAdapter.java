package logic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merkrin.androidfragmenthomework.R;

import java.util.ArrayList;
import java.util.List;

/**
 * NumberItem adapter class.
 */
public class NumberItemAdapter extends RecyclerView.Adapter<NumberViewHolder> {
    // List of numbers to be shown.
    private final List<NumberItem> numberItemList = new ArrayList<>();
    // Context of the adapter's recycler view.
    private final Context context;

    /**
     * Constructor of the class.
     *
     * @param context Context of the adapter's recycler view.
     */
    public NumberItemAdapter(Context context) {
        this.context = context;
    }

    /**
     * Set items in the list.
     *
     * @param maximalNumber Maximal number in the list.
     */
    public void setItems(int maximalNumber) {
        int lastItem = 0;

        // If the list already contains any numbers we only have to add a next one.
        if (numberItemList.size() != 0)
            lastItem = numberItemList.get(numberItemList.size() - 1).getNumber();

        for (int i = lastItem + 1; i <= maximalNumber; i++)
            numberItemList.add(new NumberItem(i));

        notifyDataSetChanged();
    }

    /**
     * Method that implements all the logic of view holder creation.
     *
     * @param parent   Container instance of all the parent views.
     * @param viewType Type of the view.
     * @return NumberViewHolder instance.
     */
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new NumberViewHolder(view);
    }

    /**
     * Method that implements all the logic of view holder binding.
     *
     * @param holder   Current view holder.
     * @param position Position of an item.
     */
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(numberItemList.get(position));
        holder.setContext(context);
    }

    /**
     * Item amount getter.
     *
     * @return Amount of items in the list.
     */
    @Override
    public int getItemCount() {
        return numberItemList.size();
    }
}
