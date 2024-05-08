package com.android.internal.app;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import com.android.internal.R;
import com.android.internal.app.LocaleHelper;
import com.android.internal.app.LocaleStore;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LocalePickerWithRegion extends ListFragment implements SearchView.OnQueryTextListener {
    private static final String PARENT_FRAGMENT_NAME = "localeListEditor";
    private static final String TAG = LocalePickerWithRegion.class.getSimpleName();
    private SuggestedLocaleAdapter mAdapter;
    private LocaleSelectedListener mListener;
    private Set<LocaleStore.LocaleInfo> mLocaleList;
    private LocaleCollectorBase mLocalePickerCollector;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private LocaleStore.LocaleInfo mParentLocale;
    private boolean mTranslatedOnly = false;
    private SearchView mSearchView = null;
    private CharSequence mPreviousSearch = null;
    private boolean mPreviousSearchHadFocus = false;
    private int mFirstVisiblePosition = 0;
    private int mTopDistance = 0;
    private CharSequence mTitle = null;
    private boolean mIsNumberingSystem = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface LocaleCollectorBase {
        HashSet<String> getIgnoredLocaleList(boolean z10);

        Set<LocaleStore.LocaleInfo> getSupportedLocaleList(LocaleStore.LocaleInfo localeInfo, boolean z10, boolean z11);

        boolean hasSpecificPackageName();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface LocaleSelectedListener {
        void onLocaleSelected(LocaleStore.LocaleInfo localeInfo);
    }

    private static LocalePickerWithRegion createNumberingSystemPicker(LocaleSelectedListener listener, LocaleStore.LocaleInfo parent, boolean translatedOnly, MenuItem.OnActionExpandListener onActionExpandListener, LocaleCollectorBase localePickerCollector) {
        LocalePickerWithRegion localePicker = new LocalePickerWithRegion();
        localePicker.setOnActionExpandListener(onActionExpandListener);
        localePicker.setIsNumberingSystem(true);
        boolean shouldShowTheList = localePicker.setListener(listener, parent, translatedOnly, localePickerCollector);
        if (shouldShowTheList) {
            return localePicker;
        }
        return null;
    }

    private static LocalePickerWithRegion createCountryPicker(LocaleSelectedListener listener, LocaleStore.LocaleInfo parent, boolean translatedOnly, MenuItem.OnActionExpandListener onActionExpandListener, LocaleCollectorBase localePickerCollector) {
        LocalePickerWithRegion localePicker = new LocalePickerWithRegion();
        localePicker.setOnActionExpandListener(onActionExpandListener);
        boolean shouldShowTheList = localePicker.setListener(listener, parent, translatedOnly, localePickerCollector);
        if (shouldShowTheList) {
            return localePicker;
        }
        return null;
    }

    public static LocalePickerWithRegion createLanguagePicker(Context context, LocaleSelectedListener listener, boolean translatedOnly) {
        return createLanguagePicker(context, listener, translatedOnly, null, null, null);
    }

    public static LocalePickerWithRegion createLanguagePicker(Context context, LocaleSelectedListener listener, boolean translatedOnly, LocaleList explicitLocales) {
        return createLanguagePicker(context, listener, translatedOnly, explicitLocales, null, null);
    }

    public static LocalePickerWithRegion createLanguagePicker(Context context, LocaleSelectedListener listener, boolean translatedOnly, LocaleList explicitLocales, String appPackageName, MenuItem.OnActionExpandListener onActionExpandListener) {
        LocaleCollectorBase localePickerController;
        if (TextUtils.isEmpty(appPackageName)) {
            localePickerController = new SystemLocaleCollector(context, explicitLocales);
        } else {
            localePickerController = new AppLocaleCollector(context, appPackageName);
        }
        LocalePickerWithRegion localePicker = new LocalePickerWithRegion();
        localePicker.setOnActionExpandListener(onActionExpandListener);
        localePicker.setListener(listener, null, translatedOnly, localePickerController);
        return localePicker;
    }

    private void setIsNumberingSystem(boolean isNumberingSystem) {
        this.mIsNumberingSystem = isNumberingSystem;
    }

    private boolean setListener(LocaleSelectedListener listener, LocaleStore.LocaleInfo parent, boolean translatedOnly, LocaleCollectorBase localePickerController) {
        boolean z10;
        this.mParentLocale = parent;
        this.mListener = listener;
        this.mTranslatedOnly = translatedOnly;
        this.mLocalePickerCollector = localePickerController;
        setRetainInstance(true);
        if (parent != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Set<LocaleStore.LocaleInfo> supportedLocaleList = localePickerController.getSupportedLocaleList(parent, translatedOnly, z10);
        this.mLocaleList = supportedLocaleList;
        if (parent == null || listener == null || supportedLocaleList.size() != 1) {
            return true;
        }
        listener.onLocaleSelected(this.mLocaleList.iterator2().next());
        return false;
    }

    private void returnToParentFrame() {
        getFragmentManager().popBackStack(PARENT_FRAGMENT_NAME, 1);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (this.mLocaleList == null) {
            returnToParentFrame();
            return;
        }
        this.mTitle = getActivity().getTitle();
        LocaleStore.LocaleInfo localeInfo = this.mParentLocale;
        boolean countryMode = localeInfo != null;
        Locale sortingLocale = countryMode ? localeInfo.getLocale() : Locale.getDefault();
        LocaleCollectorBase localeCollectorBase = this.mLocalePickerCollector;
        boolean hasSpecificPackageName = localeCollectorBase != null && localeCollectorBase.hasSpecificPackageName();
        SuggestedLocaleAdapter suggestedLocaleAdapter = new SuggestedLocaleAdapter(this.mLocaleList, countryMode, hasSpecificPackageName);
        this.mAdapter = suggestedLocaleAdapter;
        suggestedLocaleAdapter.setNumberingSystemMode(this.mIsNumberingSystem);
        LocaleHelper.LocaleInfoComparator comp = new LocaleHelper.LocaleInfoComparator(sortingLocale, countryMode);
        this.mAdapter.sort(comp);
        setListAdapter(this.mAdapter);
    }

    @Override // android.app.ListFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setNestedScrollingEnabled(true);
        getListView().setDivider(null);
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id2 = menuItem.getItemId();
        switch (id2) {
            case 16908332:
                getFragmentManager().popBackStack();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mParentLocale != null) {
            getActivity().setTitle(this.mParentLocale.getFullNameNative());
        } else {
            getActivity().setTitle(this.mTitle);
        }
        getListView().requestFocus();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            this.mPreviousSearchHadFocus = searchView.hasFocus();
            this.mPreviousSearch = this.mSearchView.getQuery();
        } else {
            this.mPreviousSearchHadFocus = false;
            this.mPreviousSearch = null;
        }
        ListView list = getListView();
        View firstChild = list.getChildAt(0);
        this.mFirstVisiblePosition = list.getFirstVisiblePosition();
        this.mTopDistance = firstChild != null ? firstChild.getTop() - list.getPaddingTop() : 0;
    }

    @Override // android.app.ListFragment
    public void onListItemClick(ListView parent, View v2, int position, long id2) {
        LocalePickerWithRegion selector;
        LocaleStore.LocaleInfo locale = (LocaleStore.LocaleInfo) parent.getAdapter().getItem(position);
        boolean isSystemLocale = locale.isSystemLocale();
        boolean isRegionLocale = locale.getParent() != null;
        boolean mayHaveDifferentNumberingSystem = locale.hasNumberingSystems();
        if (isSystemLocale || locale.isSuggested() || ((isRegionLocale && !mayHaveDifferentNumberingSystem) || this.mIsNumberingSystem)) {
            LocaleSelectedListener localeSelectedListener = this.mListener;
            if (localeSelectedListener != null) {
                localeSelectedListener.onLocaleSelected(locale);
            }
            returnToParentFrame();
            return;
        }
        if (mayHaveDifferentNumberingSystem) {
            selector = createNumberingSystemPicker(this.mListener, locale, this.mTranslatedOnly, this.mOnActionExpandListener, this.mLocalePickerCollector);
        } else {
            selector = createCountryPicker(this.mListener, locale, this.mTranslatedOnly, this.mOnActionExpandListener, this.mLocalePickerCollector);
        }
        if (selector != null) {
            getFragmentManager().beginTransaction().setTransition(4097).replace(getId(), selector).addToBackStack(null).commit();
        } else {
            returnToParentFrame();
        }
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (this.mParentLocale == null) {
            inflater.inflate(18087936, menu);
            MenuItem searchMenuItem = menu.findItem(16909207);
            MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
            if (onActionExpandListener != null) {
                searchMenuItem.setOnActionExpandListener(onActionExpandListener);
            }
            SearchView searchView = (SearchView) searchMenuItem.getActionView();
            this.mSearchView = searchView;
            searchView.setQueryHint(getText(R.string.search_language_hint));
            this.mSearchView.setOnQueryTextListener(this);
            if (!TextUtils.isEmpty(this.mPreviousSearch)) {
                searchMenuItem.expandActionView();
                this.mSearchView.setIconified(false);
                this.mSearchView.setActivated(true);
                if (this.mPreviousSearchHadFocus) {
                    this.mSearchView.requestFocus();
                }
                this.mSearchView.setQuery(this.mPreviousSearch, true);
            } else {
                this.mSearchView.setQuery(null, false);
            }
            getListView().setSelectionFromTop(this.mFirstVisiblePosition, this.mTopDistance);
        }
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String newText) {
        SuggestedLocaleAdapter suggestedLocaleAdapter = this.mAdapter;
        if (suggestedLocaleAdapter != null) {
            suggestedLocaleAdapter.getFilter().filter(newText);
            return false;
        }
        return false;
    }

    public void setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
    }
}
