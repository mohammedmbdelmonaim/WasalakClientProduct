package com.unicom.wasalakclientproduct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.ImageSliderLayoutItemBinding;
import com.unicom.wasalakclientproduct.model.guest.SliderData;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    LayoutInflater layoutInflater;
    private List<SliderData> mSliderItems = new ArrayList<>();


    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void renewItems(List<SliderData> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

//    public void deleteItem(int position) {
//        this.mSliderItems.remove(position);
//        notifyDataSetChanged();
//    }
//
//    public void addItem(SliderItem sliderItem) {
//        this.mSliderItems.add(sliderItem);
//        notifyDataSetChanged();
//    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ImageSliderLayoutItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.image_slider_layout_item, parent, false);
        return new SliderAdapter.SliderAdapterVH(binding);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        SliderData sliderItem = mSliderItems.get(position);
        viewHolder.binding.setSlider(sliderItem);
        viewHolder.binding.executePendingBindings();
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        private final ImageSliderLayoutItemBinding binding;

        public SliderAdapterVH(final ImageSliderLayoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}