package com.jason.marks.sampleapp.datacard;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.List;

/**
 *  Created by Jason Marks on 7/22/2018.
 *
 *  A data card is composed of several optional UI features.  Each data card should at least
 *  implement a title that displays at the top of the data card though it is not required to do so.
 *
 *  In the current implementation there are three different UI options: {@link OptionPanelOne},
 *  {@link OptionPanelTwo}, and a collection of {@link DataCardElementOne}.  They will populate the
 *  data card from top to bottom in that order if they are all enabled.
 *
 *  This class is intended to be used with {@link DataCardAdapter}
 */

public class DataCardModel {

    private String mCardDatatitle;
    /*  The default OnClickListener for the DataCardModel. Child UI Components can implement their own
        OnClickListeners which would take precedence over this one.
     */
    private View.OnClickListener mOnClickListener;

    private boolean isOptionPanelOneEnabled;
    private boolean isOptionPanelTwoEnabled;
    private boolean isOptionElementsListOneEnabled;

    private OptionPanelOne mOptionPanelOne;
    private OptionPanelTwo mOptionPanelTwo;
    private List<DataCardElementOne> mOptionElementsListOne;

    public DataCardModel(@Nullable String title, @Nullable View.OnClickListener onClickListener) {
        isOptionPanelOneEnabled = false;
        isOptionPanelTwoEnabled = false;
        isOptionElementsListOneEnabled = false;

        this.mCardDatatitle = title;
        this.mOnClickListener = onClickListener;
    }

    /**
     * @return the title of this {@link DataCardModel}
     */
    String getCardDatatitle() {
        return mCardDatatitle;
    }

    /**
     * @return the parent OnClickListener of this {@link DataCardModel}
     */
    View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    /**
     * @return is OptionPanelOne enabled true or false
     */
    boolean isOptionPanelOneEnabled() {
        return isOptionPanelOneEnabled;
    }

    /**
     *  If enabling OptionPanelOne the {@link OptionPanelOne} POJO that describes it is instantiated
     *  with the provided arguments. If OptionPanelOne is being disabled then
     *  mOptionPanelOne object is unset.
     *
     * @param isOptionPanelOneEnabled true to enable; false to disable
     * @param drawable an image that displays near the parent left edge
     * @param text the text that appears to the right on the image
     * @param onClickListener a onClickListener if the UI component needs an action
     */
    public void setUsingOptionPanelOne(boolean isOptionPanelOneEnabled,
                                       @Nullable Drawable drawable,
                                       @Nullable String text,
                                       @Nullable View.OnClickListener onClickListener) {

        this.isOptionPanelOneEnabled = isOptionPanelOneEnabled;

        if (isOptionPanelOneEnabled) {
            mOptionPanelOne = new OptionPanelOne(drawable, text, onClickListener);
        } else {
            mOptionPanelOne = null;
        }
    }

    /**
     * @return the {@link OptionPanelOne} object that describes this card
     */
    OptionPanelOne getOptionPanelOne() {
        return mOptionPanelOne;
    }

    /**
     * @return is OptionPanelTwo enabled true or false
     */
    boolean isOptionPanelTwoEnabled() {
        return isOptionPanelTwoEnabled;
    }

    /**
     *  If enabling OptionPanelOne the {@link OptionPanelTwo} POJO that describes it is instantiated
     *  with the provided arguments. If OptionPanelTwo is being disabled then
     *  mOptionPanelTwo object is unset.
     *
     * @param isOptionPanelTwoEnabled true to enable; false to disable
     * @param subHeader a header that appears under mCardDataTitle
     * @param bodyText body text that appears under the sub header
     * @param onClickListener an onClickListener if the UI component needs an action
     */
    public void setUsingOptionPanelTwo(boolean isOptionPanelTwoEnabled,
                                       @Nullable String subHeader,
                                       @Nullable String bodyText,
                                       @Nullable View.OnClickListener onClickListener) {

        this.isOptionPanelTwoEnabled = isOptionPanelTwoEnabled;

        if (isOptionPanelTwoEnabled) {
            mOptionPanelTwo = new OptionPanelTwo(subHeader, bodyText, onClickListener);
        } else {
            mOptionPanelTwo = null;
        }
    }

    /**
     * @return  the {@link OptionPanelTwo} object that describes this card
     */
    OptionPanelTwo getOptionPanelTwo() {
        return mOptionPanelTwo;
    }

    /**
     * @return is OptionElementsListOneEnabled true or false
     */
    boolean isOptionElementsListOneEnabled() {
        return isOptionElementsListOneEnabled;
    }

    /**
     *  If enabling OptionElementsListOne then pass in a collection of {@link DataCardElementOne}
     *  that should be displayed.
     *
     * @param optionElementsListOneEnabled true to enable ; false to disable
     * @param mOptionElementsListOne the list of DataCardElementOne to display
     */
    public void setOptionElementsListOneEnabled(boolean optionElementsListOneEnabled,
            @Nullable List<DataCardElementOne> mOptionElementsListOne) {

        this.isOptionElementsListOneEnabled = optionElementsListOneEnabled;

        if (optionElementsListOneEnabled) {
            this.mOptionElementsListOne = mOptionElementsListOne;
        } else {
            this.mOptionElementsListOne = null;
        }

    }

    /**
     * @return the collection of OptionElementsListOne objects to display
     */
    List<DataCardElementOne> getOptionElementsListOne() {
        return mOptionElementsListOne;
    }
}
