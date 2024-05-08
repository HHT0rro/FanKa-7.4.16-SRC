package com.android.internal.app;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.internal.app.LocaleStore;
import java.util.Locale;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BilingualSuggestedLocaleAdapter extends SuggestedLocaleAdapter {
    private final Locale mSecondaryLocale;
    private final int mSecondaryLocaleTextDir;
    private LocaleStore.LocaleInfo mSelectedLocaleInfo;
    private final boolean mShowSelection;

    public BilingualSuggestedLocaleAdapter(Set<LocaleStore.LocaleInfo> localeOptions, boolean countryMode, Locale secondaryLocale) {
        this(localeOptions, countryMode, secondaryLocale, false);
    }

    public BilingualSuggestedLocaleAdapter(Set<LocaleStore.LocaleInfo> localeOptions, boolean countryMode, Locale secondaryLocale, boolean showLastSelected) {
        super(localeOptions, countryMode);
        this.mSecondaryLocale = secondaryLocale;
        if (TextUtils.getLayoutDirectionFromLocale(secondaryLocale) == 1) {
            this.mSecondaryLocaleTextDir = 4;
        } else {
            this.mSecondaryLocaleTextDir = 3;
        }
        this.mShowSelection = showLastSelected;
    }

    @Override // com.android.internal.app.SuggestedLocaleAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null && this.mInflater == null) {
            this.mInflater = LayoutInflater.from(parent.getContext());
        }
        int itemType = getItemViewType(position);
        switch (itemType) {
            case 0:
            case 1:
                if (!(convertView instanceof TextView)) {
                    convertView = this.mInflater.inflate(17367195, parent, false);
                }
                TextView textView = (TextView) convertView;
                if (itemType == 0) {
                    setHeaderText(textView, 17040633, 17041485);
                } else {
                    setHeaderText(textView, 17040631, 17041484);
                }
                return convertView;
            default:
                if (!(convertView instanceof ViewGroup)) {
                    convertView = this.mInflater.inflate(17367194, parent, false);
                }
                LocaleStore.LocaleInfo item = (LocaleStore.LocaleInfo) getItem(position);
                if (this.mShowSelection) {
                    setItemState(isSelectedLocaleInfo(item), convertView);
                }
                setLocaleToListItem(convertView, item);
                return convertView;
        }
    }

    public void setSelectedLocaleInfo(LocaleStore.LocaleInfo info) {
        this.mSelectedLocaleInfo = info;
        notifyDataSetChanged();
    }

    public LocaleStore.LocaleInfo getSelectedLocaleInfo() {
        return this.mSelectedLocaleInfo;
    }

    private boolean isSelectedLocaleInfo(LocaleStore.LocaleInfo item) {
        return (item == null || this.mSelectedLocaleInfo == null || !item.getId().equals(this.mSelectedLocaleInfo.getId())) ? false : true;
    }

    private void setItemState(boolean selected, View itemView) {
        RelativeLayout background = (RelativeLayout) itemView;
        ImageView indicator = (ImageView) itemView.findViewById(16909132);
        TextView textNative = (TextView) itemView.findViewById(16909206);
        TextView textSecondary = (TextView) itemView.findViewById(16909208);
        if (indicator == null || textNative == null || textSecondary == null) {
            return;
        }
        textNative.setSelected(selected);
        textSecondary.setSelected(selected);
        if (selected) {
            background.setBackgroundResource(17303022);
            indicator.setVisibility(0);
        } else {
            background.setBackgroundResource(0);
            indicator.setVisibility(8);
        }
    }

    private void setHeaderText(TextView textView, int languageStringResourceId, int regionStringResourceId) {
        if (this.mCountryMode) {
            setTextTo(textView, regionStringResourceId);
        } else {
            setTextTo(textView, languageStringResourceId);
        }
    }

    private void setLocaleToListItem(View itemView, LocaleStore.LocaleInfo localeInfo) {
        int i10;
        if (localeInfo == null) {
            throw new NullPointerException("Cannot set locale, locale info is null.");
        }
        TextView textNative = (TextView) itemView.findViewById(16909206);
        textNative.setText(localeInfo.getLabel(this.mCountryMode));
        textNative.setTextLocale(localeInfo.getLocale());
        textNative.setContentDescription(localeInfo.getContentDescription(this.mCountryMode));
        TextView textSecondary = (TextView) itemView.findViewById(16909208);
        textSecondary.setText(localeInfo.getLocale().getDisplayLanguage(this.mSecondaryLocale));
        textSecondary.setTextDirection(this.mSecondaryLocaleTextDir);
        if (this.mCountryMode) {
            int layoutDir = TextUtils.getLayoutDirectionFromLocale(localeInfo.getParent());
            itemView.setLayoutDirection(layoutDir);
            if (layoutDir == 1) {
                i10 = 4;
            } else {
                i10 = 3;
            }
            textNative.setTextDirection(i10);
        }
    }
}
