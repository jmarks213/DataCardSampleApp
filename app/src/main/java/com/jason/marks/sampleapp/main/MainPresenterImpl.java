package com.jason.marks.sampleapp.main;

import android.content.Context;

import com.jason.marks.sampleapp.datacard.DataCardModel;

/**
 *  Created by Jason Marks on 7/21/2018.
 *
 *  The Presenter for the .main package.
 */

public class MainPresenterImpl implements MainContract.MainPresenter {

    private MainContract.MainFragmentView mMainFragmentView;
    private MainContract.MainModel mMainModel;

    /**
     * @param mainFragmentView the main fragment View implementation
     * @param context an application context; no UI usages!
     */
    MainPresenterImpl(MainContract.MainFragmentView mainFragmentView, Context context) {
        this.mMainFragmentView = mainFragmentView;
        this.mMainModel = new MainModelImpl(context);

        addDataCards();
    }

    @Override
    public void reinitialize(MainContract.MainFragmentView mainFragmentView, Context context) {
        this.mMainFragmentView = mainFragmentView;
        mMainModel.reinitialize(context);
    }

    /**
     *  Retrieve a collection of {@link DataCardModel} to add
     *  to the {@link com.jason.marks.sampleapp.main.MainContract.MainFragmentView}
     */
    private void addDataCards() {
        mMainFragmentView.addCards(mMainModel.getMainCards());
    }

    /**
     *  Called when the onStop() is called in {@link MainFragment}
     */
    @Override
    public void onStop() {
        if (mMainModel != null) {
            mMainModel.onStop();
        }
    }
}
