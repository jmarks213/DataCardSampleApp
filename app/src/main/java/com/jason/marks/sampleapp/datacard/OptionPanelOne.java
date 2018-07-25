package com.jason.marks.sampleapp.datacard;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 *  Created by Jason Marks on 7/22/2018.
 *
 *  An immutable object that represents a UI component of {@link DataCardModel}
 */

public class OptionPanelOne {
    private Drawable mOptionPanelOneImage;
    private String mOptionPanelOneText;
    private View.OnClickListener mOnClickListener;

    OptionPanelOne(Drawable optionPanelOneImage, String optionPanelOneText,
                          View.OnClickListener mOnClickListener) {
        this.mOptionPanelOneImage = optionPanelOneImage;
        this.mOptionPanelOneText = optionPanelOneText;
        this.mOnClickListener = mOnClickListener;
    }

    Drawable getOptionPanelOneImage() {
        return mOptionPanelOneImage;
    }

    String getOptionPanelOneText() {
        return mOptionPanelOneText;
    }

    View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }
}
