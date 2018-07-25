package com.jason.marks.sampleapp.datacard;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;

/**
 *  Created by Jason Marks on 7/22/2018.
 *
 *  An immutable object that represents a UI component of {@link DataCardModel}
 */

public class DataCardElementOne {

    private Drawable mElementImage;
    private String mElementText;
    private View.OnClickListener mOnClickListener;

    public DataCardElementOne(
            @Nullable Drawable elementImage,
            @Nullable String elementText,
            @Nullable View.OnClickListener mOnClickListener) {
        this.mElementImage = elementImage;
        this.mElementText = elementText;
        this.mOnClickListener = mOnClickListener;
    }

    Drawable getElementImage() {
        return mElementImage;
    }

    String getElementText() {
        return mElementText;
    }

    View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }
}
