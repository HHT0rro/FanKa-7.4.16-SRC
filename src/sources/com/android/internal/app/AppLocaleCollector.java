package com.android.internal.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.app.AppLocaleStore;
import com.android.internal.app.LocalePickerWithRegion;
import com.android.internal.app.LocaleStore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AppLocaleCollector implements LocalePickerWithRegion.LocaleCollectorBase {
    private static final boolean ENABLED = true;
    private static final String PROP_APP_LANGUAGE_SUGGESTION = "android.app.language.suggestion.enhanced";
    private static final String TAG = AppLocaleCollector.class.getSimpleName();
    private Set<LocaleStore.LocaleInfo> mAllAppActiveLocales;
    private LocaleStore.LocaleInfo mAppCurrentLocale;
    private final String mAppPackageName;
    private final Context mContext;
    private Set<LocaleStore.LocaleInfo> mImeLocales;

    public AppLocaleCollector(Context context, String appPackageName) {
        this.mContext = context;
        this.mAppPackageName = appPackageName;
    }

    public LocaleStore.LocaleInfo getAppCurrentLocale() {
        return LocaleStore.getAppActivatedLocaleInfo(this.mContext, this.mAppPackageName, true);
    }

    public Set<LocaleStore.LocaleInfo> getAllAppActiveLocales() {
        PackageManager pm = this.mContext.getPackageManager();
        LocaleManager lm = (LocaleManager) this.mContext.getSystemService(LocaleManager.class);
        final HashSet<LocaleStore.LocaleInfo> result = new HashSet<>();
        if (pm != null && lm != null) {
            HashMap<String, LocaleStore.LocaleInfo> map = new HashMap<>();
            for (ApplicationInfo appInfo : pm.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(0L))) {
                LocaleStore.LocaleInfo localeInfo = LocaleStore.getAppActivatedLocaleInfo(this.mContext, appInfo.packageName, false);
                if (localeInfo != null && localeInfo.getLocale().getCountry().length() > 0) {
                    map.put(localeInfo.getId(), localeInfo);
                }
            }
            map.forEach(new BiConsumer() { // from class: com.android.internal.app.AppLocaleCollector$$ExternalSyntheticLambda2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    HashSet.this.add((LocaleStore.LocaleInfo) obj2);
                }
            });
        }
        return result;
    }

    public Set<LocaleStore.LocaleInfo> getActiveImeLocales() {
        InputMethodInfo activeIme;
        Set<LocaleStore.LocaleInfo> activeImeLocales = null;
        InputMethodManager imm = (InputMethodManager) this.mContext.getSystemService(InputMethodManager.class);
        if (imm != null && (activeIme = getActiveIme(imm)) != null) {
            activeImeLocales = LocaleStore.transformImeLanguageTagToLocaleInfo(imm.getEnabledInputMethodSubtypeList(activeIme, true));
        }
        if (activeImeLocales == null) {
            return Set.of();
        }
        return (Set) activeImeLocales.stream().filter(new Predicate() { // from class: com.android.internal.app.AppLocaleCollector$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AppLocaleCollector.lambda$getActiveImeLocales$1((LocaleStore.LocaleInfo) obj);
            }
        }).collect(Collectors.toSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getActiveImeLocales$1(LocaleStore.LocaleInfo info) {
        return info.getLocale().getCountry().length() > 0;
    }

    private InputMethodInfo getActiveIme(InputMethodManager imm) {
        InputMethodInfo activeIme = null;
        List<InputMethodInfo> infoList = imm.getEnabledInputMethodList();
        String imeId = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "default_input_method", this.mContext.getUserId());
        if (infoList != null && imeId != null) {
            for (InputMethodInfo method : infoList) {
                if (method.getId().equals(imeId)) {
                    activeIme = method;
                }
            }
        }
        return activeIme;
    }

    public AppLocaleStore.AppLocaleResult getAppSupportedLocales() {
        return AppLocaleStore.getAppSupportedLocales(this.mContext, this.mAppPackageName);
    }

    public Set<LocaleStore.LocaleInfo> getSystemSupportedLocale(Set<String> langTagsToIgnore, LocaleStore.LocaleInfo parent, boolean translatedOnly) {
        return LocaleStore.getLevelLocales(this.mContext, langTagsToIgnore, parent, translatedOnly);
    }

    public Set<LocaleStore.LocaleInfo> getSystemCurrentLocales() {
        Set<LocaleStore.LocaleInfo> sysLocales = LocaleStore.getSystemCurrentLocales();
        return (Set) sysLocales.stream().filter(new Predicate() { // from class: com.android.internal.app.AppLocaleCollector$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AppLocaleCollector.lambda$getSystemCurrentLocales$2((LocaleStore.LocaleInfo) obj);
            }
        }).collect(Collectors.toSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getSystemCurrentLocales$2(LocaleStore.LocaleInfo info) {
        return info.getLocale().getCountry().length() > 0;
    }

    @Override // com.android.internal.app.LocalePickerWithRegion.LocaleCollectorBase
    public HashSet<String> getIgnoredLocaleList(boolean translatedOnly) {
        final HashSet<String> langTagsToIgnore = new HashSet<>();
        LocaleStore.LocaleInfo localeInfo = this.mAppCurrentLocale;
        if (localeInfo != null) {
            langTagsToIgnore.add(localeInfo.getLocale().toLanguageTag());
        }
        if (SystemProperties.getBoolean(PROP_APP_LANGUAGE_SUGGESTION, true)) {
            this.mAllAppActiveLocales.forEach(new Consumer() { // from class: com.android.internal.app.AppLocaleCollector$$ExternalSyntheticLambda4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    HashSet.this.add(((LocaleStore.LocaleInfo) obj).getLocale().toLanguageTag());
                }
            });
            this.mImeLocales.forEach(new Consumer() { // from class: com.android.internal.app.AppLocaleCollector$$ExternalSyntheticLambda5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    HashSet.this.add(((LocaleStore.LocaleInfo) obj).getLocale().toLanguageTag());
                }
            });
        }
        LocaleList systemLangList = LocaleList.getDefault();
        for (int i10 = 0; i10 < systemLangList.size(); i10++) {
            langTagsToIgnore.add(systemLangList.get(i10).toLanguageTag());
        }
        return langTagsToIgnore;
    }

    @Override // com.android.internal.app.LocalePickerWithRegion.LocaleCollectorBase
    public Set<LocaleStore.LocaleInfo> getSupportedLocaleList(LocaleStore.LocaleInfo parent, boolean translatedOnly, boolean isForCountryMode) {
        if (this.mAppCurrentLocale == null) {
            this.mAppCurrentLocale = getAppCurrentLocale();
        }
        if (this.mAllAppActiveLocales == null) {
            this.mAllAppActiveLocales = getAllAppActiveLocales();
        }
        if (this.mImeLocales == null) {
            this.mImeLocales = getActiveImeLocales();
        }
        AppLocaleStore.AppLocaleResult result = getAppSupportedLocales();
        Set<String> langTagsToIgnore = getIgnoredLocaleList(translatedOnly);
        Set<LocaleStore.LocaleInfo> appLocaleList = new HashSet<>();
        boolean shouldShowList = result.mLocaleStatus == AppLocaleStore.AppLocaleResult.LocaleStatus.GET_SUPPORTED_LANGUAGE_FROM_LOCAL_CONFIG || result.mLocaleStatus == AppLocaleStore.AppLocaleResult.LocaleStatus.GET_SUPPORTED_LANGUAGE_FROM_ASSET;
        Set<LocaleStore.LocaleInfo> systemLocaleList = isForCountryMode ? getSystemSupportedLocale(langTagsToIgnore, parent, translatedOnly) : getSystemSupportedLocale(langTagsToIgnore, null, translatedOnly);
        LocaleStore.LocaleInfo localeInfo = this.mAppCurrentLocale;
        if (localeInfo != null && !isForCountryMode) {
            appLocaleList.add(localeInfo);
        }
        if (!isForCountryMode) {
            Set<LocaleStore.LocaleInfo> localeInfoSet = filterSupportedLocales(getSystemCurrentLocales(), result.mAppSupportedLocales);
            for (LocaleStore.LocaleInfo localeInfo2 : localeInfoSet) {
                boolean isCurrentLocale = this.mAppCurrentLocale != null && localeInfo2.getLocale().equals(this.mAppCurrentLocale.getLocale());
                boolean existsInApp = addSystemSuggestionFlag(localeInfo2, this.mAllAppActiveLocales);
                boolean existsInIme = addSystemSuggestionFlag(localeInfo2, this.mImeLocales);
                if (!isCurrentLocale && !existsInApp && !existsInIme) {
                    appLocaleList.add(localeInfo2);
                }
            }
        }
        Set<LocaleStore.LocaleInfo> suggestedSet = null;
        if (shouldShowList) {
            appLocaleList.addAll(filterSupportedLocales(systemLocaleList, result.mAppSupportedLocales));
            suggestedSet = getSuggestedLocales(appLocaleList);
        }
        if (!isForCountryMode && SystemProperties.getBoolean(PROP_APP_LANGUAGE_SUGGESTION, true)) {
            Set<LocaleStore.LocaleInfo> localeSet = filterSupportedLocales(this.mAllAppActiveLocales, result.mAppSupportedLocales);
            if (suggestedSet != null) {
                localeSet = addImeSuggestionFlag(filterSameLanguageAndCountry(localeSet, suggestedSet));
            }
            appLocaleList.addAll(localeSet);
            suggestedSet.addAll(localeSet);
            Set<LocaleStore.LocaleInfo> localeSet2 = filterSupportedLocales(this.mImeLocales, result.mAppSupportedLocales);
            if (suggestedSet != null) {
                localeSet2 = filterSameLanguageAndCountry(localeSet2, suggestedSet);
            }
            appLocaleList.addAll(localeSet2);
            suggestedSet.addAll(localeSet2);
        }
        if (!isForCountryMode && shouldShowList) {
            appLocaleList.add(LocaleStore.getSystemDefaultLocaleInfo(this.mAppCurrentLocale == null));
        }
        if (Build.isDebuggable()) {
            Log.d(TAG, "App locale list: " + ((Object) appLocaleList));
        }
        return appLocaleList;
    }

    @Override // com.android.internal.app.LocalePickerWithRegion.LocaleCollectorBase
    public boolean hasSpecificPackageName() {
        return true;
    }

    private Set<LocaleStore.LocaleInfo> getSuggestedLocales(Set<LocaleStore.LocaleInfo> localeSet) {
        return (Set) localeSet.stream().filter(new Predicate() { // from class: com.android.internal.app.AppLocaleCollector$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean isSuggested;
                isSuggested = ((LocaleStore.LocaleInfo) obj).isSuggested();
                return isSuggested;
            }
        }).collect(Collectors.toSet());
    }

    private boolean addSystemSuggestionFlag(LocaleStore.LocaleInfo localeInfo, Set<LocaleStore.LocaleInfo> appLocaleSet) {
        for (LocaleStore.LocaleInfo info : appLocaleSet) {
            if (info.getLocale().equals(localeInfo.getLocale())) {
                info.extendSuggestionOfType(64);
                return true;
            }
        }
        return false;
    }

    private Set<LocaleStore.LocaleInfo> addImeSuggestionFlag(Set<LocaleStore.LocaleInfo> localeSet) {
        for (LocaleStore.LocaleInfo localeInfo : localeSet) {
            for (LocaleStore.LocaleInfo imeLocale : this.mImeLocales) {
                if (imeLocale.getLocale().equals(localeInfo.getLocale())) {
                    localeInfo.extendSuggestionOfType(32);
                }
            }
        }
        return localeSet;
    }

    private Set<LocaleStore.LocaleInfo> filterSameLanguageAndCountry(Set<LocaleStore.LocaleInfo> newLocaleList, Set<LocaleStore.LocaleInfo> existingLocaleList) {
        Set<LocaleStore.LocaleInfo> result = new HashSet<>(newLocaleList.size());
        for (LocaleStore.LocaleInfo appLocaleInfo : newLocaleList) {
            boolean same = false;
            Locale appLocale = appLocaleInfo.getLocale();
            Iterator<LocaleStore.LocaleInfo> iterator2 = existingLocaleList.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                LocaleStore.LocaleInfo localeInfo = iterator2.next();
                Locale suggested = localeInfo.getLocale();
                if (appLocale.getLanguage().equals(suggested.getLanguage()) && appLocale.getCountry().equals(suggested.getCountry())) {
                    same = true;
                    break;
                }
            }
            if (!same) {
                result.add(appLocaleInfo);
            }
        }
        return result;
    }

    private Set<LocaleStore.LocaleInfo> filterSupportedLocales(Set<LocaleStore.LocaleInfo> suggestedLocales, HashSet<Locale> appSupportedLocales) {
        Set<LocaleStore.LocaleInfo> filteredList = new HashSet<>();
        for (LocaleStore.LocaleInfo li : suggestedLocales) {
            if (appSupportedLocales.contains(li.getLocale())) {
                filteredList.add(li);
            } else {
                Iterator<Locale> iterator2 = appSupportedLocales.iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        Locale l10 = iterator2.next();
                        if (LocaleList.matchesLanguageAndScript(li.getLocale(), l10)) {
                            filteredList.add(li);
                            break;
                        }
                    }
                }
            }
        }
        return filteredList;
    }
}
