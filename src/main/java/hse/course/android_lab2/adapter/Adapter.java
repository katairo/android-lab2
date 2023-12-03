package hse.course.android_lab2.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hse.course.android_lab2.R;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<String> products;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final EditText product;
        private final Button removeButton;
        private final Button saveChangesButton;

        public ViewHolder(View view) {
            super(view);
            product = (EditText) view.findViewById(R.id.product);
            removeButton = (Button) view.findViewById(R.id.removeButton);
            saveChangesButton = (Button) view.findViewById(R.id.saveChangesButton);
        }

        public TextView getProduct() {
            return product;
        }

        public Button getRemoveButton() {
            return removeButton;
        }

        public Button getSaveChangesButton() {
            return saveChangesButton;
        }
    }

    public Adapter(List<String> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getProduct().setText(products.get(position));
        holder.getRemoveButton().setOnClickListener(v -> remove(position));
        holder.getSaveChangesButton().setOnClickListener(v -> saveChanges(holder.getProduct().getText().toString(), position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addNewProduct(String productName) {
        if (productName == null || productName.isEmpty()) {
            return;
        }
        products.add(productName);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void saveChanges(String productName, int position) {
        products.set(position, productName);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void remove(int position) {
        products.remove(position);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clear() {
        products.clear();
        notifyDataSetChanged();
    }
}