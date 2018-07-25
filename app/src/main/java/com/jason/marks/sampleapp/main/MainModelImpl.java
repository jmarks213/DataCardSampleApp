package com.jason.marks.sampleapp.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.jason.marks.sampleapp.AccountActivity;
import com.jason.marks.sampleapp.BuildActivity;
import com.jason.marks.sampleapp.OtherActivity;
import com.jason.marks.sampleapp.R;
import com.jason.marks.sampleapp.datacard.DataCardElementOne;
import com.jason.marks.sampleapp.datacard.DataCardModel;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by Jason Marks on 7/22/2018.
 *
 *  The data Model for the .main package
 */

public class MainModelImpl implements MainContract.MainModel {

    // an application context
    private Context context;

    MainModelImpl(Context context) {
        this.context = context;
    }

    @Override
    public void reinitialize(Context context) {
        this.context = context;
    }

    /**
     *  Called when the onStop() is called in {@link MainPresenterImpl}
     */
    @Override
    public void onStop() {
        context = null;
    }

    /**
     *  Returns seed data for a demo to {@link MainPresenterImpl}
     *
     * @return a collection of {@link DataCardModel}
     */
    @Override
    public List<DataCardModel> getMainCards() {

        // REST or local db calls

        // for demo
        List<DataCardModel> toReturn = new ArrayList<>();

        DataCardModel card1 = new DataCardModel("Card 1", null);
        card1.setUsingOptionPanelOne(true,
                context.getResources().getDrawable(R.drawable.ic_android_teal_a400_48dp),
                "Displaying only option panel one.",
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, OtherActivity.class);
                        context.startActivity(intent);
                    }
                }));


        DataCardModel card2 = new DataCardModel("Card 2", null);
        card2.setUsingOptionPanelTwo(
                true,
                "Option panel two",
                "Displaying only option panel two.",
                null);

        DataCardModel card3 = new DataCardModel("Card 3", null);
        card3.setUsingOptionPanelOne(
                true,
                context.getResources().getDrawable(R.drawable.ic_android_teal_a400_48dp),
                "Multiple option panels displayed",
                null);
        card3.setUsingOptionPanelTwo(
                true,
                "A title",
                "Option panel one and two displayed",
                null);

        DataCardModel card4 = new DataCardModel("Card4", null);

        List<DataCardElementOne> cardElementsListOne = new ArrayList<>();
        cardElementsListOne.add(new DataCardElementOne(
                context.getResources().getDrawable(R.drawable.ic_account_circle_black_24dp),
                "Account icon",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, AccountActivity.class);
                        context.startActivity(intent);
                    }
                }));
        cardElementsListOne.add(new DataCardElementOne(
                context.getResources().getDrawable(R.drawable.ic_build_black_24dp),
                "Build icon",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, BuildActivity.class);
                        context.startActivity(intent);
                    }
                }));
        cardElementsListOne.add(new DataCardElementOne(
                context.getResources().getDrawable(R.drawable.ic_flag_black_24dp),
                "Flag icon",
                null));

        card4.setOptionElementsListOneEnabled(
                true,
                cardElementsListOne);

        DataCardModel card5 = new DataCardModel("Card 5", null);
        card5.setUsingOptionPanelOne(
                true,
                context.getResources().getDrawable(R.drawable.ic_android_teal_a400_48dp),
                "All three option panels are used.",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, OtherActivity.class);
                        context.startActivity(intent);
                    }
                });
        card5.setUsingOptionPanelTwo(
                true,
                "Option Panel",
                "two",
                null);
        card5.setOptionElementsListOneEnabled(
                true,
                cardElementsListOne);

        toReturn.add(card1);
        toReturn.add(card2);
        toReturn.add(card3);
        toReturn.add(card4);
        toReturn.add(card5);

        return toReturn;
    }
}
