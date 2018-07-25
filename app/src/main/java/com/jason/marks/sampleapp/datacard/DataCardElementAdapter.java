package com.jason.marks.sampleapp.datacard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jason.marks.sampleapp.R;

import java.util.List;

/**
 * Created by Jason Marks on 7/22/2018.
 *
 *  A customer {@link RecyclerView.Adapter} to display a collection of {@link DataCardElementOne}
 */

public class DataCardElementAdapter extends RecyclerView.Adapter<DataCardElementAdapter.ViewHolder> {

    private List<DataCardElementOne> cardElementModels;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView elementImage;
        TextView elementText;
        View viewHandle;

        ViewHolder(View itemView) {
            super(itemView);

            viewHandle = itemView;
            elementImage = itemView.findViewById(R.id.image_view_data_card_element);
            elementText = itemView.findViewById(R.id.text_view_data_card_element);
        }
    }

    DataCardElementAdapter(List<DataCardElementOne> cardModels) {
        this.cardElementModels = cardModels;
    }

    @Override
    public DataCardElementAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        DataCardElementAdapter.ViewHolder viewHolder = new DataCardElementAdapter.ViewHolder(
                inflater.inflate(R.layout.item_data_element_main, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataCardElementAdapter.ViewHolder holder, int position) {
        DataCardElementOne curElement = cardElementModels.get(position);

        holder.elementImage.setImageDrawable(curElement.getElementImage());
        holder.elementText.setText(curElement.getElementText());
        holder.viewHandle.setOnClickListener(curElement.getOnClickListener());
    }

    @Override
    public int getItemCount() {
        return cardElementModels.size();
    }
}
