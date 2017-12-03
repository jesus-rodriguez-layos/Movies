package com.jrdev9.movies.app.presentation.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ItemVisitable> viewModels;
    private TypeViewModelFactory typeViewModelFactory;

    @Inject
    public BaseAdapter(TypeViewModelFactory typeViewModelFactory) {
        this.viewModels = new ArrayList<>();
        this.typeViewModelFactory = typeViewModelFactory;
    }

    @Override
    public int getItemViewType(int position) {
        return viewModels.get(position).type(typeViewModelFactory);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(viewType, parent, false);
        return typeViewModelFactory.holder(view, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(viewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }

    public void setItems(List<ItemVisitable> viewModels) {
        this.viewModels = viewModels;
        notifyDataSetChanged();
    }

    public void addItems(List<ItemVisitable> viewModels) {
        this.viewModels.addAll(viewModels);
        notifyDataSetChanged();
    }

    public void updateItem(int position, ItemVisitable item) {
        viewModels.set(position, item);
        notifyItemChanged(position, item);
    }
}
