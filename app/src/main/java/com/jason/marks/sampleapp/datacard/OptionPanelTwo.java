package com.jason.marks.sampleapp.datacard;

import android.view.View;

/**
 *  Created by Jason Marks on 7/22/2018.
 *
 *  An immutable object that represents a UI component of {@link DataCardModel}
 */

public class OptionPanelTwo {
    private String mOptionPanelTwoTitle;
    private String mOptionPanelTwoBody;
    private View.OnClickListener mOnClickListener;

    OptionPanelTwo(String mOptionPanelTwoTitle, String mOptionPanelTwoBody,
                          View.OnClickListener mOnClickListener) {
        this.mOptionPanelTwoTitle = mOptionPanelTwoTitle;
        this.mOptionPanelTwoBody = mOptionPanelTwoBody;
        this.mOnClickListener = mOnClickListener;
    }

    String getOptionPanelTwoTitle() {
        return mOptionPanelTwoTitle;
    }

    String getOptionPanelTwoBody() {
        return mOptionPanelTwoBody;
    }

    View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }
}
