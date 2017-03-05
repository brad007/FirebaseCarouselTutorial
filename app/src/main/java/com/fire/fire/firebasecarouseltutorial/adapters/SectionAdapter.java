package com.fire.fire.firebasecarouseltutorial.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fire.fire.firebasecarouseltutorial.R;

import java.util.ArrayList;

/**
 * Created by brad on 2017/03/05.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private ArrayList mData;

    public SectionAdapter(ArrayList data) {
        mData = data;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_section_item,
                parent, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        holder.itemImage.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        else
            return mData.size();
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;

        public SectionViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }
}
