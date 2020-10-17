package logic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.merkrin.androidfragmenthomework.R;

import java.util.ArrayList;
import java.util.List;

public class NumberItemAdapter extends RecyclerView.Adapter<NumberItemAdapter.NumberViewHolder> {
    private List<NumberItem> numberItemList = new ArrayList<>();

    public void setItems(int maximalNumber) {
        int lastItem = 0;

        if (numberItemList.size() != 0)
            lastItem = numberItemList.get(numberItemList.size() - 1).getNumber();

        for (int i = lastItem + 1; i <= maximalNumber; i++)
            numberItemList.add(new NumberItem(i));

        notifyDataSetChanged();
    }

    public List<NumberItem> getNumberItemList() {
        return numberItemList;
    }

    public void addItem(NumberItem numberItem) {
        numberItemList.add(numberItem);
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
    }

    @Override
    public int getItemCount() {
        return numberItemList.size();
    }

    static class NumberViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ConstraintLayout itemLayout;

        NumberViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }

        void bind(NumberItem numberItem) {
            textView.setText(numberItem.toString());
            textView.setTextColor(numberItem.getColor());
        }
    }
}
