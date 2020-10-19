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

public class NumberItemAdapter extends RecyclerView.Adapter<NumberViewHolder> {
    private final List<NumberItem> numberItemList = new ArrayList<>();
    private final Context context;

    public NumberItemAdapter(Context context){
        this.context = context;
    }

    public void setItems(int maximalNumber) {
        int lastItem = 0;

        if (numberItemList.size() != 0)
            lastItem = numberItemList.get(numberItemList.size() - 1).getNumber();

        for (int i = lastItem + 1; i <= maximalNumber; i++)
            numberItemList.add(new NumberItem(i));

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new NumberViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(numberItemList.get(position));
        holder.setContext(context);
    }

    @Override
    public int getItemCount() {
        return numberItemList.size();
    }
}
