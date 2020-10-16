package logic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merkrin.androidfragmenthomework.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumberItemAdapter extends RecyclerView.Adapter<NumberItemAdapter.NumberViewHolder> {
    private List<NumberItem> numberItemList = new ArrayList<>();

    public void setItems(Collection<NumberItem> numberItemCollection) {
        numberItemList.addAll(numberItemCollection);
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

        NumberViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }

        void bind(NumberItem numberItem) {
            textView.setText(numberItem.toString());
            textView.setTextColor(numberItem.getColor());
        }
    }
}
