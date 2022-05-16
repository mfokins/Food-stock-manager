package com.example.foodstockmanager.ui.products;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodstockmanager.R;
import com.example.foodstockmanager.product.Product;
import com.example.foodstockmanager.databinding.FragmentProductBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyProductRecyclerViewAdapter extends RecyclerView.Adapter<MyProductRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private final ArrayList<Product> products;
    ProductViewModel productViewModel;
    NavController navController;
    public static final String INGREDIENT = "ingredient";


    public MyProductRecyclerViewAdapter(Context context, ProductViewModel productViewModel, ArrayList<Product> products) {
        this.products = products;
        this.context = context;
        this.productViewModel = productViewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //+1 used because count starts from zero
        holder.productPositionView.setText(position + 1 + ":");
        holder.productImageView.setImageDrawable(context.getDrawable(context.getResources().getIdentifier(products.get(position).getType(), "drawable", context.getPackageName())));
        holder.productNameView.setText(products.get(position).getName());
        holder.expiryView.setText("Expires: " + (new SimpleDateFormat("dd-MM-yyyy").format((products.get(position).getExpiryDate()))));
        holder.searchButton.setOnClickListener(product -> {
            Bundle temp = new Bundle();
            temp.putString(INGREDIENT, products.get(position).getName());
            navController = Navigation.findNavController(holder.itemView);
            navController.navigate(R.id.navigation_recipes, temp);
        });
        holder.removeButton.setOnClickListener(product -> {
            productViewModel.delete(products.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView productPositionView;
        public ImageView productImageView;
        public final TextView productNameView;
        public final TextView expiryView;
        public final ImageButton searchButton;
        public final ImageButton removeButton;


        public ViewHolder(FragmentProductBinding binding) {
            super(binding.getRoot());
            productPositionView = binding.productNumber;
            productImageView = binding.productIcon;
            productNameView = binding.productName;
            expiryView = binding.content;
            searchButton = binding.findRecipesButton;
            removeButton = binding.removeProductButton;
        }
    }
}