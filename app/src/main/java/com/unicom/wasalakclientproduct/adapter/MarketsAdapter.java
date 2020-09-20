package com.unicom.wasalakclientproduct.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.RecyclerViewMarketRowBinding;
import com.unicom.wasalakclientproduct.model.user.MarketsModel;

import javax.inject.Inject;

public class MarketsAdapter extends ListAdapter<MarketsModel.Result, MarketsAdapter.MarketsViewHolder> {
    private ClickListener clickListener;
    LayoutInflater layoutInflater;

    @Inject
    protected MarketsAdapter(@NonNull DiffUtil.ItemCallback<MarketsModel.Result> diffCallback) {
        super(diffCallback);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MarketsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        RecyclerViewMarketRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_view_market_row, parent, false);
        return new MarketsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketsViewHolder holder, int position) {
        MarketsModel.Result market = getItem(position);
        holder.binding.setMarket(market);
        holder.binding.executePendingBindings();
    }

    class MarketsViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerViewMarketRowBinding binding;

        public MarketsViewHolder(final RecyclerViewMarketRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.marketConstraint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.clickMarket(getAdapterPosition());
                }
            });
        }

    }

    public interface ClickListener {
        void clickMarket(int position);
    }
}
