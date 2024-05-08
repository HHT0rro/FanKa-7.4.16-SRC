package com.android.internal.app;

import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.IActivityManager;
import android.app.ListFragment;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.RemoteException;
import android.provider.Settings;
import android.sysprop.LocalizationProperties;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import sun.util.locale.LanguageTag;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LocalePicker extends ListFragment {
    private static final boolean DEBUG = false;
    private static final String TAG = "LocalePicker";
    private static final String[] pseudoLocales = {"en-XA", "ar-XB"};
    LocaleSelectionListener mListener;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface LocaleSelectionListener {
        void onLocaleSelected(Locale locale);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LocaleInfo implements Comparable<LocaleInfo> {
        static final Collator sCollator = Collator.getInstance();
        String label;
        final Locale locale;

        public LocaleInfo(String label, Locale locale) {
            this.label = label;
            this.locale = locale;
        }

        public String getLabel() {
            return this.label;
        }

        public Locale getLocale() {
            return this.locale;
        }

        public String toString() {
            return this.label;
        }

        @Override // java.lang.Comparable
        public int compareTo(LocaleInfo another) {
            return sCollator.compare(this.label, another.label);
        }
    }

    public static String[] getSystemAssetLocales() {
        return Resources.getSystem().getAssets().getLocales();
    }

    public static String[] getSupportedLocales(Context context) {
        if (context == null) {
            return new String[0];
        }
        String[] allLocales = context.getResources().getStringArray(R.array.supported_locales);
        Predicate<String> localeFilter = getLocaleFilter();
        if (localeFilter == null) {
            return allLocales;
        }
        List<String> result = new ArrayList<>(allLocales.length);
        for (String locale : allLocales) {
            if (localeFilter.test(locale)) {
                result.add(locale);
            }
        }
        int localeCount = result.size();
        return localeCount == allLocales.length ? allLocales : (String[]) result.toArray(new String[localeCount]);
    }

    private static Predicate<String> getLocaleFilter() {
        try {
            return (Predicate) LocalizationProperties.locale_filter().map(new Function() { // from class: com.android.internal.app.LocalePicker$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Predicate asPredicate;
                    asPredicate = Pattern.compile((String) obj).asPredicate();
                    return asPredicate;
                }
            }).orElse(null);
        } catch (SecurityException e2) {
            Log.e(TAG, "Failed to read locale filter.", e2);
            return null;
        } catch (PatternSyntaxException e10) {
            Log.e(TAG, "Bad locale filter format (\"" + e10.getPattern() + "\"), skipping.");
            return null;
        }
    }

    public static List<LocaleInfo> getAllAssetLocales(Context context, boolean isInDeveloperMode) {
        Resources resources = context.getResources();
        String[] locales = getSystemAssetLocales();
        List<String> localeList = new ArrayList<>(locales.length);
        Collections.addAll(localeList, locales);
        Collections.sort(localeList);
        String[] specialLocaleCodes = resources.getStringArray(R.array.special_locale_codes);
        String[] specialLocaleNames = resources.getStringArray(R.array.special_locale_names);
        ArrayList<LocaleInfo> localeInfos = new ArrayList<>(localeList.size());
        for (String locale : localeList) {
            Locale l10 = Locale.forLanguageTag(locale.replace('_', '-'));
            if (l10 != null && !LanguageTag.UNDETERMINED.equals(l10.getLanguage()) && !l10.getLanguage().isEmpty() && !l10.getCountry().isEmpty() && (isInDeveloperMode || !LocaleList.isPseudoLocale(l10))) {
                if (localeInfos.isEmpty()) {
                    localeInfos.add(new LocaleInfo(toTitleCase(l10.getDisplayLanguage(l10)), l10));
                } else {
                    LocaleInfo previous = localeInfos.get(localeInfos.size() - 1);
                    if (previous.locale.getLanguage().equals(l10.getLanguage()) && !previous.locale.getLanguage().equals("zz")) {
                        previous.label = toTitleCase(getDisplayName(previous.locale, specialLocaleCodes, specialLocaleNames));
                        localeInfos.add(new LocaleInfo(toTitleCase(getDisplayName(l10, specialLocaleCodes, specialLocaleNames)), l10));
                    } else {
                        String displayName = toTitleCase(l10.getDisplayLanguage(l10));
                        localeInfos.add(new LocaleInfo(displayName, l10));
                    }
                }
            }
        }
        Collections.sort(localeInfos);
        return localeInfos;
    }

    public static ArrayAdapter<LocaleInfo> constructAdapter(Context context) {
        return constructAdapter(context, 17367206, 16909205);
    }

    public static ArrayAdapter<LocaleInfo> constructAdapter(Context context, final int layoutId, final int fieldId) {
        boolean isInDeveloperMode = Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        List<LocaleInfo> localeInfos = getAllAssetLocales(context, isInDeveloperMode);
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        return new ArrayAdapter<LocaleInfo>(context, layoutId, fieldId, localeInfos) { // from class: com.android.internal.app.LocalePicker.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                View view;
                TextView text;
                if (convertView == null) {
                    view = inflater.inflate(layoutId, parent, false);
                    text = (TextView) view.findViewById(fieldId);
                    view.setTag(text);
                } else {
                    view = convertView;
                    text = (TextView) view.getTag();
                }
                LocaleInfo item = getItem(position);
                text.setText(item.toString());
                text.setTextLocale(item.getLocale());
                return view;
            }
        };
    }

    private static String toTitleCase(String s2) {
        if (s2.length() == 0) {
            return s2;
        }
        return Character.toUpperCase(s2.charAt(0)) + s2.substring(1);
    }

    private static String getDisplayName(Locale l10, String[] specialLocaleCodes, String[] specialLocaleNames) {
        String code = l10.toString();
        for (int i10 = 0; i10 < specialLocaleCodes.length; i10++) {
            if (specialLocaleCodes[i10].equals(code)) {
                return specialLocaleNames[i10];
            }
        }
        return l10.getDisplayName(l10);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<LocaleInfo> adapter = constructAdapter(getActivity());
        setListAdapter(adapter);
    }

    public void setLocaleSelectionListener(LocaleSelectionListener listener) {
        this.mListener = listener;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        getListView().requestFocus();
    }

    @Override // android.app.ListFragment
    public void onListItemClick(ListView l10, View v2, int position, long id2) {
        if (this.mListener != null) {
            Locale locale = ((LocaleInfo) getListAdapter().getItem(position)).locale;
            this.mListener.onLocaleSelected(locale);
        }
    }

    public static void updateLocale(Locale locale) {
        updateLocales(new LocaleList(locale));
    }

    public static void updateLocales(LocaleList locales) {
        if (locales != null) {
            locales = removeExcludedLocales(locales);
        }
        try {
            IActivityManager am = ActivityManager.getService();
            Configuration config = new Configuration();
            config.setLocales(locales);
            config.userSetLocale = true;
            am.updatePersistentConfigurationWithAttribution(config, ActivityThread.currentOpPackageName(), (String) null);
            BackupManager.dataChanged("com.android.providers.settings");
        } catch (RemoteException e2) {
        }
    }

    private static LocaleList removeExcludedLocales(LocaleList locales) {
        Predicate<String> localeFilter = getLocaleFilter();
        if (localeFilter == null) {
            return locales;
        }
        int localeCount = locales.size();
        ArrayList<Locale> filteredLocales = new ArrayList<>(localeCount);
        for (int i10 = 0; i10 < localeCount; i10++) {
            Locale locale = locales.get(i10);
            if (localeFilter.test(locale.toString())) {
                filteredLocales.add(locale);
            }
        }
        int i11 = filteredLocales.size();
        return localeCount == i11 ? locales : new LocaleList((Locale[]) filteredLocales.toArray(new Locale[0]));
    }

    public static LocaleList getLocales() {
        try {
            return ActivityManager.getService().getConfiguration().getLocales();
        } catch (RemoteException e2) {
            return LocaleList.getDefault();
        }
    }
}
