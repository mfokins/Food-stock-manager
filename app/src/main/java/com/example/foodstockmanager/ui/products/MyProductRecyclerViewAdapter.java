package com.example.foodstockmanager.ui.products;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodstockmanager.product.Product;
import com.example.foodstockmanager.databinding.FragmentProductBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyProductRecyclerViewAdapter extends RecyclerView.Adapter<MyProductRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private final ArrayList<Product> products;
    private View.OnClickListener onClickListener;
    ProductViewModel productViewModel;


    public MyProductRecyclerViewAdapter(Context context, ProductViewModel productViewModel, ArrayList<Product> products) {
        this.products = products;
        this.context = context;
        this.productViewModel = productViewModel;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mIdView.setText(position+1+":");
        holder.mImageView.setImageDrawable(context.getDrawable(context.getResources().getIdentifier(products.get(position).getType(), "drawable", context.getPackageName())));
        holder.mNameView.setText(products.get(position).getName());
        holder.mContentView.setText("Expires: "+(new SimpleDateFormat("dd-MM-yyyy").format((products.get(position).getExpiryDate()))));
        holder.mRemoveButton.setOnClickListener(product ->{
            productViewModel.delete(products.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public ImageView mImageView;
        public final TextView mNameView;
        public final TextView mContentView;
        public  final ImageButton mRemoveButton;


        public ViewHolder(FragmentProductBinding binding) {
            super(binding.getRoot());
            mIdView = binding.productNumber;
            mImageView = binding.productIcon;
            mNameView = binding.productName;
            mContentView = binding.content;
            mRemoveButton = binding.removeProductButton;
        }
    }
}