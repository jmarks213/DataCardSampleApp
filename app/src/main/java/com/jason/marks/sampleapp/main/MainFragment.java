package com.jason.marks.sampleapp.main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jason.marks.sampleapp.R;
import com.jason.marks.sampleapp.datacard.DataCardAdapter;
import com.jason.marks.sampleapp.datacard.DataCardModel;

import java.util.List;

/**
 *  Created by Jason Marks on 7/22/2018.
 *
 *  A fragment to replace the content frame in {@link MainActivity}.  Displays a collection of
 *  {@link DataCardModel} using a {@link RecyclerView}. The recycler view uses a
 *  {@link GridLayoutManager} and {@link DataCardAdapter}.
 */

public class MainFragment extends Fragment implements MainContract.MainFragmentView {

    public static final String MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG";

    private MainPresenterImpl mMainPresenter;
    private MainContract.MainActivityView activityViewCallback;

    private RecyclerView mRecylerView;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecylerView = view.findViewById(R.id.main_recycler_view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (mMainPresenter == null) {
            mMainPresenter = new MainPresenterImpl(
                    this, getActivity().getApplicationContext());
        } else {
            mMainPresenter.reinitialize(
                    this, getActivity().getApplicationContext());
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mMainPresenter != null) {
            mMainPresenter.onStop();
        }
    }

    /**
     * @param mainCards a {@link List} of {@link DataCardModel} that the fragment view displays
     */
    @Override
    public void addCards(List<DataCardModel> mainCards) {

        GridLayoutManager gridLayoutManager;

        /**
         *  In portrait span 1 column in landscape span 2
         */
        if (getActivity().getResources().getConfiguration()
                .orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridLayoutManager = new GridLayoutManager(
                    getContext(), 2, GridLayoutManager.VERTICAL, false);
        } else {
            gridLayoutManager = new GridLayoutManager(
                    getContext(), 1, GridLayoutManager.VERTICAL, false);
        }

        if (mRecylerView != null) {
            mRecylerView.setLayoutManager(gridLayoutManager);
            mRecylerView.setAdapter(new DataCardAdapter(mainCards, getActivity()));
            mRecylerView.scrollToPosition(0);
        }

    }

    public void setActivityViewCallback(MainContract.MainActivityView activityViewCallback) {
        this.activityViewCallback = activityViewCallback;
    }
}
