package com.android.internal.app;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.app.LocaleHelper;
import com.android.internal.app.LocaleStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SuggestedLocaleAdapter extends BaseAdapter implements Filterable {
    protected static final int APP_LANGUAGE_PICKER_TYPE_COUNT = 5;
    protected static final int MIN_REGIONS_FOR_SUGGESTIONS = 6;
    protected static final int SYSTEM_LANGUAGE_TYPE_COUNT = 3;
    protected static final int SYSTEM_LANGUAGE_WITHOUT_HEADER_TYPE_COUNT = 1;
    protected static final int TYPE_CURRENT_LOCALE = 4;
    protected static final int TYPE_HEADER_ALL_OTHERS = 1;
    protected static final int TYPE_HEADER_SUGGESTED = 0;
    protected static final int TYPE_LOCALE = 2;
    protected static final int TYPE_SYSTEM_LANGUAGE_FOR_APP_LANGUAGE_PICKER = 3;
    protected Context mContextOverride;
    protected final boolean mCountryMode;
    protected Locale mDisplayLocale;
    private boolean mHasSpecificAppPackageName;
    protected LayoutInflater mInflater;
    protected boolean mIsNumberingMode;
    protected ArrayList<LocaleStore.LocaleInfo> mLocaleOptions;
    protected ArrayList<LocaleStore.LocaleInfo> mOriginalLocaleOptions;
    protected int mSuggestionCount;

    public SuggestedLocaleAdapter(Set<LocaleStore.LocaleInfo> localeOptions, boolean countryMode) {
        this(localeOptions, countryMode, false);
    }

    public SuggestedLocaleAdapter(Set<LocaleStore.LocaleInfo> localeOptions, boolean countryMode, boolean hasSpecificAppPackageName) {
        this.mDisplayLocale = null;
        this.mContextOverride = null;
        this.mCountryMode = countryMode;
        this.mLocaleOptions = new ArrayList<>(localeOptions.size());
        this.mHasSpecificAppPackageName = hasSpecificAppPackageName;
        for (LocaleStore.LocaleInfo li : localeOptions) {
            if (li.isSuggested()) {
                this.mSuggestionCount++;
            }
            this.mLocaleOptions.add(li);
        }
    }

    public void setNumberingSystemMode(boolean isNumberSystemMode) {
        this.mIsNumberingMode = isNumberSystemMode;
    }

    public boolean getIsForNumberingSystem() {
        return this.mIsNumberingMode;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return getItemViewType(position) == 2 || getItemViewType(position) == 3 || getItemViewType(position) == 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        if (!showHeaders()) {
            LocaleStore.LocaleInfo item = (LocaleStore.LocaleInfo) getItem(position);
            if (item.isSystemLocale()) {
                return 3;
            }
            return item.isAppCurrentLocale() ? 4 : 2;
        }
        if (position == 0) {
            return 0;
        }
        if (position == this.mSuggestionCount + 1) {
            return 1;
        }
        LocaleStore.LocaleInfo item2 = (LocaleStore.LocaleInfo) getItem(position);
        if (item2 == null) {
            throw new NullPointerException("Non header locale cannot be null");
        }
        if (item2.isSystemLocale()) {
            return 3;
        }
        return item2.isAppCurrentLocale() ? 4 : 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.mHasSpecificAppPackageName && showHeaders()) {
            return 5;
        }
        if (showHeaders()) {
            return 3;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (showHeaders()) {
            return this.mLocaleOptions.size() + 2;
        }
        return this.mLocaleOptions.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (isHeaderPosition(position)) {
            return null;
        }
        int offset = 0;
        if (showHeaders()) {
            offset = position > this.mSuggestionCount ? -2 : -1;
        }
        return this.mLocaleOptions.get(position + offset);
    }

    private boolean isHeaderPosition(int position) {
        return showHeaders() && (position == 0 || position == this.mSuggestionCount + 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public void setDisplayLocale(Context context, Locale locale) {
        if (locale == null) {
            this.mDisplayLocale = null;
            this.mContextOverride = null;
        } else if (!locale.equals(this.mDisplayLocale)) {
            this.mDisplayLocale = locale;
            Configuration configOverride = new Configuration();
            configOverride.setLocale(locale);
            this.mContextOverride = context.createConfigurationContext(configOverride);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextTo(TextView textView, int resId) {
        Context context = this.mContextOverride;
        if (context == null) {
            textView.setText(resId);
        } else {
            textView.setText(context.getText(resId));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView title;
        if (convertView == null && this.mInflater == null) {
            this.mInflater = LayoutInflater.from(parent.getContext());
        }
        int itemType = getItemViewType(position);
        View itemView = getNewViewIfNeeded(convertView, parent, itemType, position);
        switch (itemType) {
            case 0:
            case 1:
                TextView textView = (TextView) itemView;
                if (itemType == 0) {
                    if (this.mCountryMode && !this.mIsNumberingMode) {
                        setTextTo(textView, 17040630);
                    } else {
                        setTextTo(textView, 17040632);
                    }
                } else if (this.mCountryMode && !this.mIsNumberingMode) {
                    setTextTo(textView, 17041484);
                } else {
                    setTextTo(textView, 17040631);
                }
                Locale locale = this.mDisplayLocale;
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                textView.setTextLocale(locale);
                return itemView;
            case 2:
            default:
                updateTextView(itemView, (TextView) itemView.findViewById(16909205), position);
                return itemView;
            case 3:
                LocaleStore.LocaleInfo info = (LocaleStore.LocaleInfo) getItem(position);
                if (info == null) {
                    throw new NullPointerException("Non header locale cannot be null.");
                }
                if (info.isAppCurrentLocale()) {
                    title = (TextView) itemView.findViewById(16909185);
                } else {
                    title = (TextView) itemView.findViewById(16909205);
                }
                title.setText(R.string.system_locale_title);
                return itemView;
            case 4:
                updateTextView(itemView, (TextView) itemView.findViewById(16909185), position);
                return itemView;
        }
    }

    private View getNewViewIfNeeded(View convertView, ViewGroup parent, int itemType, int position) {
        switch (itemType) {
            case 0:
            case 1:
                boolean shouldReuseView = convertView instanceof TextView;
                boolean shouldReuseView2 = shouldReuseView && convertView.findViewById(16909184) != null;
                if (shouldReuseView2) {
                    return convertView;
                }
                View updatedView = this.mInflater.inflate(17367197, parent, false);
                return updatedView;
            case 2:
            default:
                boolean shouldReuseView3 = (convertView instanceof TextView) && convertView.findViewById(16909205) != null;
                if (shouldReuseView3) {
                    return convertView;
                }
                View updatedView2 = this.mInflater.inflate(17367196, parent, false);
                return updatedView2;
            case 3:
                if (((LocaleStore.LocaleInfo) getItem(position)).isAppCurrentLocale()) {
                    boolean shouldReuseView4 = (convertView instanceof LinearLayout) && convertView.findViewById(16909185) != null;
                    if (shouldReuseView4) {
                        return convertView;
                    }
                    View updatedView3 = this.mInflater.inflate(17367097, parent, false);
                    addStateDescriptionIntoCurrentLocaleItem(updatedView3);
                    return updatedView3;
                }
                boolean shouldReuseView5 = (convertView instanceof TextView) && convertView.findViewById(16909205) != null;
                if (shouldReuseView5) {
                    return convertView;
                }
                View updatedView4 = this.mInflater.inflate(17367196, parent, false);
                return updatedView4;
            case 4:
                boolean shouldReuseView6 = (convertView instanceof LinearLayout) && convertView.findViewById(16909185) != null;
                if (shouldReuseView6) {
                    return convertView;
                }
                View updatedView5 = this.mInflater.inflate(17367097, parent, false);
                addStateDescriptionIntoCurrentLocaleItem(updatedView5);
                return updatedView5;
        }
    }

    protected boolean showHeaders() {
        int i10;
        return ((this.mCountryMode && this.mLocaleOptions.size() < 6) || (i10 = this.mSuggestionCount) == 0 || i10 == this.mLocaleOptions.size()) ? false : true;
    }

    public void sort(LocaleHelper.LocaleInfoComparator comp) {
        Collections.sort(this.mLocaleOptions, comp);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    class FilterByNativeAndUiNames extends Filter {
        FilterByNativeAndUiNames() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence prefix) {
            Filter.FilterResults results = new Filter.FilterResults();
            if (SuggestedLocaleAdapter.this.mOriginalLocaleOptions == null) {
                SuggestedLocaleAdapter.this.mOriginalLocaleOptions = new ArrayList<>(SuggestedLocaleAdapter.this.mLocaleOptions);
            }
            ArrayList<LocaleStore.LocaleInfo> values = new ArrayList<>(SuggestedLocaleAdapter.this.mOriginalLocaleOptions);
            if (prefix == null || prefix.length() == 0) {
                results.values = values;
                results.count = values.size();
            } else {
                Locale locale = Locale.getDefault();
                String prefixString = LocaleHelper.normalizeForSearch(prefix.toString(), locale);
                int count = values.size();
                ArrayList<LocaleStore.LocaleInfo> newValues = new ArrayList<>();
                for (int i10 = 0; i10 < count; i10++) {
                    LocaleStore.LocaleInfo value = values.get(i10);
                    String nameToCheck = LocaleHelper.normalizeForSearch(value.getFullNameInUiLanguage(), locale);
                    String nativeNameToCheck = LocaleHelper.normalizeForSearch(value.getFullNameNative(), locale);
                    if (wordMatches(nativeNameToCheck, prefixString) || wordMatches(nameToCheck, prefixString)) {
                        newValues.add(value);
                    }
                }
                results.values = newValues;
                results.count = newValues.size();
            }
            return results;
        }

        boolean wordMatches(String valueText, String prefixString) {
            if (valueText.startsWith(prefixString)) {
                return true;
            }
            String[] words = valueText.split(" ");
            for (String word : words) {
                if (word.startsWith(prefixString)) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
            SuggestedLocaleAdapter.this.mLocaleOptions = (ArrayList) results.values;
            SuggestedLocaleAdapter.this.mSuggestionCount = 0;
            Iterator<LocaleStore.LocaleInfo> iterator2 = SuggestedLocaleAdapter.this.mLocaleOptions.iterator2();
            while (iterator2.hasNext()) {
                LocaleStore.LocaleInfo li = iterator2.next();
                if (li.isSuggested()) {
                    SuggestedLocaleAdapter.this.mSuggestionCount++;
                }
            }
            if (results.count > 0) {
                SuggestedLocaleAdapter.this.notifyDataSetChanged();
            } else {
                SuggestedLocaleAdapter.this.notifyDataSetInvalidated();
            }
        }
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new FilterByNativeAndUiNames();
    }

    private void updateTextView(View convertView, TextView text, int position) {
        int i10;
        LocaleStore.LocaleInfo item = (LocaleStore.LocaleInfo) getItem(position);
        text.setText(this.mIsNumberingMode ? item.getNumberingSystem() : item.getLabel(this.mCountryMode));
        text.setTextLocale(item.getLocale());
        text.setContentDescription(this.mIsNumberingMode ? item.getNumberingSystem() : item.getContentDescription(this.mCountryMode));
        if (this.mCountryMode) {
            int layoutDir = TextUtils.getLayoutDirectionFromLocale(item.getParent());
            convertView.setLayoutDirection(layoutDir);
            if (layoutDir == 1) {
                i10 = 4;
            } else {
                i10 = 3;
            }
            text.setTextDirection(i10);
        }
    }

    private void addStateDescriptionIntoCurrentLocaleItem(View root) {
        String description = root.getContext().getResources().getString(17039840);
        root.setStateDescription(description);
    }
}
