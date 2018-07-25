package com.jason.marks.sampleapp.main;

import android.content.Context;

import com.jason.marks.sampleapp.datacard.DataCardModel;

import java.util.List;

/**
 *  Created by Jason Marks on 7/21/2018.
 *
 *  A contract class to be used only by classes in the .main package. Contains the MVP interfaces.
 */

public class MainContract {

    /**
     *  The data Model methods required by the Presenter
     */
    interface MainModel {
        /**
         *  Give the data model a chance to shutdown elegantly
         */
        void onStop();

        /**
         * @return the {@link DataCardModel} objects to display in {@link MainActivity}
         */
        List<DataCardModel> getMainCards();

        /**
         *  Reinitialize context when restarting
         */
        void reinitialize(Context context);
    }

    /**
     *  The fragment View methods required by the Presenter
     */
    interface MainFragmentView {

        /**
         * @param mainCards a {@link List} of {@link DataCardModel} that the fragment view displays
         */
        void addCards(List<DataCardModel> mainCards);
    }

    /**
     *  The current implementation does not require any modification to the activity view.
     */
    interface MainActivityView {

    }

    /**
     *  Presenter methods that need to be implemented for the View
     */
    interface MainPresenter {

        /**
         * Reset the MainFragmentViewImpl and Context when restarting
         */
        void reinitialize(MainFragmentView mainFragmentView, Context context);
        /**
         *  Give the Presenter a chance to shutdown elegantly
         */
        void onStop();
    }
}
