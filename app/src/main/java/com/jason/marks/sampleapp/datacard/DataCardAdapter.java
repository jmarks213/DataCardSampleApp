package com.jason.marks.sampleapp.datacard;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jason.marks.sampleapp.R;

import java.util.List;

/**
 *  Created by Jason Marks on 7/22/2018.
 *
 *  A custom {@link RecyclerView.Adapter} to display a collection of {@link DataCardModel} objects.
 *
 */

public class DataCardAdapter extends RecyclerView.Adapter<DataCardAdapter.ViewHolder> {

    private List<DataCardModel> dataCardModels;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder {

        View viewHandle;

        TextView dataCardTitle;

        RelativeLayout optionPanelOneRelativeLayout;
        ImageView optionPanelOneImageView;
        TextView optionPanelOneTextView;

        RelativeLayout optionPanelTwoRelativeLayout;
        TextView optionPanelTwoTextHeader;
        TextView optionPanelTwoTextBody;

        RecyclerView elementsRecyclerView;

        ViewHolder(View itemView) {
            super(itemView);
            viewHandle = itemView;

            dataCardTitle = itemView.findViewById(
                    R.id.text_view_data_card_main_title);

            optionPanelOneRelativeLayout = itemView.findViewById(
                    R.id.relative_layout_data_card_main_option_panel_one);
            optionPanelOneImageView = itemView.findViewById(
                    R.id.image_view_data_card_main_option_panel_one);
            optionPanelOneTextView = itemView.findViewById(
                    R.id.text_view_data_card_main_option_panel_one);

            optionPanelTwoRelativeLayout = itemView.findViewById(
                    R.id.relative_layout_data_card_main_option_panel_two);
            optionPanelTwoTextHeader = itemView.findViewById(
                    R.id.text_view_data_card_main_option_panel_two_title);
            optionPanelTwoTextBody = itemView.findViewById(
                    R.id.text_view_data_card_main_option_panel_two_body);

            elementsRecyclerView = itemView.findViewById(
                    R.id.recycler_view_data_card_main_element_list);
        }
    }

    public DataCardAdapter(List<DataCardModel> cardModels, Context context) {
        this.dataCardModels = cardModels;
        this.mContext = context;
    }

    @Override
    public DataCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ViewHolder viewHolder = new ViewHolder(
                inflater.inflate(R.layout.item_data_card_main, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataCardAdapter.ViewHolder holder, int position) {
        DataCardModel curDataCardModel = dataCardModels.get(position);
        // always apply the default OnClickListener and then child OnClickListeners
        View.OnClickListener defaultOnClickListener = curDataCardModel.getOnClickListener();

        // unset any other data card OnClickListener and apply curDataCardModel's default OnClickListener
        holder.viewHandle.setOnClickListener(null);
        if (curDataCardModel.getOnClickListener() != null) {
            holder.viewHandle.setOnClickListener(defaultOnClickListener);
        }

        holder.dataCardTitle.setText(curDataCardModel.getCardDatatitle() != null ? curDataCardModel.getCardDatatitle() : "");

        if (curDataCardModel.isOptionPanelOneEnabled()) {
            OptionPanelOne panelOneData = curDataCardModel.getOptionPanelOne();

            /*  apply the curDefaultOnClickListener to sync the view state with curDataCardModel and
                apply curDataCardModel.OptionPanelOne OnClickListener if it is relevant
              */
            holder.optionPanelOneRelativeLayout.setOnClickListener(defaultOnClickListener);
            if (panelOneData.getOnClickListener() != null) {
                holder.optionPanelOneRelativeLayout.setOnClickListener(
                        panelOneData.getOnClickListener());
            }

            holder.optionPanelOneImageView.setImageDrawable(panelOneData.getOptionPanelOneImage());
            holder.optionPanelOneTextView.setText(panelOneData.getOptionPanelOneText());
            holder.optionPanelOneRelativeLayout.setVisibility(View.VISIBLE);
        } else {
            holder.optionPanelOneRelativeLayout.setVisibility(View.GONE);
        }

        if (curDataCardModel.isOptionPanelTwoEnabled()) {
            OptionPanelTwo panelTwoData = curDataCardModel.getOptionPanelTwo();

            holder.optionPanelTwoRelativeLayout.setOnClickListener(defaultOnClickListener);
            if (panelTwoData.getOnClickListener() != null) {
                holder.optionPanelTwoRelativeLayout.setOnClickListener(
                        panelTwoData.getOnClickListener());
            }

            holder.optionPanelTwoTextHeader.setText(panelTwoData.getOptionPanelTwoTitle());
            holder.optionPanelTwoTextBody.setText(panelTwoData.getOptionPanelTwoBody());
            holder.optionPanelTwoRelativeLayout.setVisibility(View.VISIBLE);
        } else {
            holder.optionPanelTwoRelativeLayout.setVisibility(View.GONE);
        }

        if (curDataCardModel.isOptionElementsListOneEnabled()) {
            List<DataCardElementOne> optionElementsOne = curDataCardModel.getOptionElementsListOne();

            if (optionElementsOne != null && optionElementsOne.size() > 0) {
                holder.elementsRecyclerView.setHasFixedSize(true);
                holder.elementsRecyclerView.setAdapter(new DataCardElementAdapter(optionElementsOne));
                holder.elementsRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            }

            holder.elementsRecyclerView.setVisibility(View.VISIBLE);
        } else {
            holder.elementsRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataCardModels.size();
    }
}
