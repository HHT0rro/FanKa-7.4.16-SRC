package com.android.internal.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.app.LocaleStore;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IllformedLocaleException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LocaleStore {
    private static final int TIER_LANGUAGE = 1;
    private static final int TIER_NUMBERING = 3;
    private static final int TIER_REGION = 2;
    private static final HashMap<String, LocaleInfo> sLocaleCache = new HashMap<>();
    private static final String TAG = LocaleStore.class.getSimpleName();
    private static boolean sFullyInitialized = false;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LocaleInfo implements Serializable {
        public static final int SUGGESTION_TYPE_CFG = 2;
        public static final int SUGGESTION_TYPE_CURRENT = 4;
        public static final int SUGGESTION_TYPE_IME_LANGUAGE = 32;
        public static final int SUGGESTION_TYPE_NONE = 0;
        public static final int SUGGESTION_TYPE_OTHER_APP_LANGUAGE = 16;
        public static final int SUGGESTION_TYPE_SIM = 1;
        public static final int SUGGESTION_TYPE_SYSTEM_AVAILABLE_LANGUAGE = 64;
        public static final int SUGGESTION_TYPE_SYSTEM_LANGUAGE = 8;
        private String mFullCountryNameNative;
        private String mFullNameNative;
        private boolean mHasNumberingSystems;
        private final String mId;
        private boolean mIsChecked;
        private boolean mIsPseudo;
        private boolean mIsTranslated;
        private String mLangScriptKey;
        private final Locale mLocale;
        private final Locale mParent;
        public int mSuggestionFlags;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public @interface SuggestionType {
        }

        private LocaleInfo(Locale locale) {
            this.mLocale = locale;
            this.mId = locale.toLanguageTag();
            this.mParent = getParent(locale);
            this.mHasNumberingSystems = false;
            this.mIsChecked = false;
            this.mSuggestionFlags = 0;
            this.mIsTranslated = false;
            this.mIsPseudo = false;
        }

        private LocaleInfo(String localeId) {
            this(Locale.forLanguageTag(localeId));
        }

        private LocaleInfo(LocaleInfo localeInfo) {
            this.mLocale = localeInfo.getLocale();
            this.mId = localeInfo.getId();
            this.mParent = localeInfo.getParent();
            this.mHasNumberingSystems = localeInfo.mHasNumberingSystems;
            this.mIsChecked = localeInfo.getChecked();
            this.mSuggestionFlags = localeInfo.mSuggestionFlags;
            this.mIsTranslated = localeInfo.isTranslated();
            this.mIsPseudo = localeInfo.mIsPseudo;
        }

        private static Locale getParent(Locale locale) {
            if (locale.getCountry().isEmpty()) {
                return null;
            }
            return new Locale.Builder().setLocale(locale).setRegion("").setExtension('u', "").build();
        }

        public boolean hasNumberingSystems() {
            return this.mHasNumberingSystems;
        }

        public String toString() {
            return this.mId;
        }

        public Locale getLocale() {
            return this.mLocale;
        }

        public Locale getParent() {
            return this.mParent;
        }

        public String getId() {
            return this.mId;
        }

        public boolean isTranslated() {
            return this.mIsTranslated;
        }

        public void setTranslated(boolean isTranslated) {
            this.mIsTranslated = isTranslated;
        }

        public boolean isSuggested() {
            return this.mIsTranslated && this.mSuggestionFlags != 0;
        }

        public boolean isSuggestionOfType(int suggestionMask) {
            return this.mIsTranslated && (this.mSuggestionFlags & suggestionMask) == suggestionMask;
        }

        public void extendSuggestionOfType(int suggestionMask) {
            if (!this.mIsTranslated) {
                return;
            }
            this.mSuggestionFlags |= suggestionMask;
        }

        public String getFullNameNative() {
            if (this.mFullNameNative == null) {
                Locale locale = this.mLocale.stripExtensions();
                this.mFullNameNative = LocaleHelper.getDisplayName(locale, locale, true);
            }
            return this.mFullNameNative;
        }

        public String getFullCountryNameNative() {
            if (this.mFullCountryNameNative == null) {
                Locale locale = this.mLocale;
                this.mFullCountryNameNative = LocaleHelper.getDisplayCountry(locale, locale);
            }
            return this.mFullCountryNameNative;
        }

        String getFullCountryNameInUiLanguage() {
            return LocaleHelper.getDisplayCountry(this.mLocale);
        }

        public String getFullNameInUiLanguage() {
            Locale locale = this.mLocale.stripExtensions();
            return LocaleHelper.getDisplayName(locale, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getLangScriptKey() {
            String languageTag;
            if (this.mLangScriptKey == null) {
                Locale baseLocale = new Locale.Builder().setLocale(this.mLocale).setExtension('u', "").build();
                Locale parentWithScript = getParent(LocaleHelper.addLikelySubtags(baseLocale));
                if (parentWithScript == null) {
                    languageTag = this.mLocale.toLanguageTag();
                } else {
                    languageTag = parentWithScript.toLanguageTag();
                }
                this.mLangScriptKey = languageTag;
            }
            return this.mLangScriptKey;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getLabel(boolean countryMode) {
            if (countryMode) {
                return getFullCountryNameNative();
            }
            return getFullNameNative();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getNumberingSystem() {
            Locale locale = this.mLocale;
            return LocaleHelper.getDisplayNumberingSystemKeyValue(locale, locale);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getContentDescription(boolean countryMode) {
            if (countryMode) {
                return getFullCountryNameInUiLanguage();
            }
            return getFullNameInUiLanguage();
        }

        public boolean getChecked() {
            return this.mIsChecked;
        }

        public void setChecked(boolean checked) {
            this.mIsChecked = checked;
        }

        public boolean isAppCurrentLocale() {
            return (this.mSuggestionFlags & 4) > 0;
        }

        public boolean isSystemLocale() {
            return (this.mSuggestionFlags & 8) > 0;
        }

        public boolean isInCurrentSystemLocales() {
            return (this.mSuggestionFlags & 64) > 0;
        }
    }

    private static Set<String> getSimCountries(Context context) {
        Set<String> result = new HashSet<>();
        TelephonyManager tm = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        if (tm != null) {
            String iso = tm.getSimCountryIso().toUpperCase(Locale.US);
            if (!iso.isEmpty()) {
                result.add(iso);
            }
            String iso2 = tm.getNetworkCountryIso().toUpperCase(Locale.US);
            if (!iso2.isEmpty()) {
                result.add(iso2);
            }
        }
        return result;
    }

    public static void updateSimCountries(Context context) {
        Set<String> simCountries = getSimCountries(context);
        for (LocaleInfo li : sLocaleCache.values()) {
            if (simCountries.contains(li.getLocale().getCountry())) {
                li.mSuggestionFlags |= 1;
            }
        }
    }

    public static LocaleInfo getAppActivatedLocaleInfo(Context context, String appPackageName, boolean isAppSelected) {
        LocaleList localeList;
        if (appPackageName == null) {
            return null;
        }
        LocaleManager localeManager = (LocaleManager) context.getSystemService(LocaleManager.class);
        if (localeManager == null) {
            localeList = null;
        } else {
            try {
                localeList = localeManager.getApplicationLocales(appPackageName);
            } catch (IllegalArgumentException e2) {
                Log.d(TAG, "IllegalArgumentException ", e2);
            }
        }
        Locale locale = localeList == null ? null : localeList.get(0);
        if (locale != null) {
            LocaleInfo cacheInfo = getLocaleInfo(locale, sLocaleCache);
            LocaleInfo localeInfo = new LocaleInfo(cacheInfo);
            if (isAppSelected) {
                localeInfo.mSuggestionFlags |= 4;
            } else {
                localeInfo.mSuggestionFlags |= 16;
            }
            return localeInfo;
        }
        return null;
    }

    public static Set<LocaleInfo> transformImeLanguageTagToLocaleInfo(List<InputMethodSubtype> list) {
        Set<LocaleInfo> imeLocales = new HashSet<>();
        for (InputMethodSubtype subtype : list) {
            Locale locale = Locale.forLanguageTag(subtype.getLanguageTag());
            LocaleInfo cacheInfo = getLocaleInfo(locale, sLocaleCache);
            LocaleInfo localeInfo = new LocaleInfo(cacheInfo);
            localeInfo.mSuggestionFlags |= 32;
            imeLocales.add(localeInfo);
        }
        return imeLocales;
    }

    public static Set<LocaleInfo> getSystemCurrentLocales() {
        Set<LocaleInfo> localeList = new HashSet<>();
        LocaleList systemLangList = LocaleList.getDefault();
        for (int i10 = 0; i10 < systemLangList.size(); i10++) {
            Locale sysLocale = getLocaleWithOnlyNumberingSystem(systemLangList.get(i10));
            LocaleInfo cacheInfo = getLocaleInfo(sysLocale, sLocaleCache);
            LocaleInfo localeInfo = new LocaleInfo(cacheInfo);
            localeInfo.mSuggestionFlags |= 64;
            localeList.add(localeInfo);
        }
        return localeList;
    }

    public static LocaleInfo getSystemDefaultLocaleInfo(boolean hasAppLanguage) {
        LocaleInfo systemDefaultInfo = new LocaleInfo("");
        systemDefaultInfo.mSuggestionFlags |= 8;
        if (hasAppLanguage) {
            systemDefaultInfo.mSuggestionFlags |= 4;
        }
        systemDefaultInfo.mIsTranslated = true;
        return systemDefaultInfo;
    }

    private static void addSuggestedLocalesForRegion(Locale locale) {
        if (locale == null) {
            return;
        }
        String country = locale.getCountry();
        if (country.isEmpty()) {
            return;
        }
        for (LocaleInfo li : sLocaleCache.values()) {
            if (country.equals(li.getLocale().getCountry())) {
                li.mSuggestionFlags |= 1;
            }
        }
    }

    public static void fillCache(Context context) {
        if (sFullyInitialized) {
            return;
        }
        Set<String> simCountries = getSimCountries(context);
        boolean isInDeveloperMode = Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        Set<Locale> numberSystemLocaleList = new HashSet<>();
        for (String localeId : LocalePicker.getSupportedLocales(context)) {
            if (Locale.forLanguageTag(localeId).getUnicodeLocaleType("nu") != null) {
                numberSystemLocaleList.add(Locale.forLanguageTag(localeId));
            }
        }
        String[] supportedLocales = LocalePicker.getSupportedLocales(context);
        int length = supportedLocales.length;
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                String localeId2 = supportedLocales[i10];
                if (localeId2.isEmpty()) {
                    throw new IllformedLocaleException("Bad locale entry in locale_config.xml");
                }
                final LocaleInfo li = new LocaleInfo(localeId2);
                if (LocaleList.isPseudoLocale(li.getLocale())) {
                    if (!isInDeveloperMode) {
                        i10++;
                    } else {
                        li.setTranslated(true);
                        li.mIsPseudo = true;
                        li.mSuggestionFlags |= 1;
                    }
                }
                if (simCountries.contains(li.getLocale().getCountry())) {
                    li.mSuggestionFlags |= 1;
                }
                numberSystemLocaleList.forEach(new Consumer() { // from class: com.android.internal.app.LocaleStore$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        LocaleStore.lambda$fillCache$0(LocaleStore.LocaleInfo.this, (Locale) obj);
                    }
                });
                HashMap<String, LocaleInfo> hashMap = sLocaleCache;
                hashMap.put(li.getId(), li);
                Locale parent = li.getParent();
                if (parent != null) {
                    String parentId = parent.toLanguageTag();
                    if (!hashMap.containsKey(parentId)) {
                        hashMap.put(parentId, new LocaleInfo(parent));
                    }
                }
                i10++;
            } else {
                HashSet<String> localizedLocales = new HashSet<>();
                for (String str : LocalePicker.getSystemAssetLocales()) {
                    LocaleInfo li2 = new LocaleInfo(str);
                    String country = li2.getLocale().getCountry();
                    if (!country.isEmpty()) {
                        LocaleInfo cachedLocale = null;
                        HashMap<String, LocaleInfo> hashMap2 = sLocaleCache;
                        if (hashMap2.containsKey(li2.getId())) {
                            LocaleInfo cachedLocale2 = hashMap2.get(li2.getId());
                            cachedLocale = cachedLocale2;
                        } else {
                            String langScriptCtry = li2.getLangScriptKey() + "-" + country;
                            if (hashMap2.containsKey(langScriptCtry)) {
                                LocaleInfo cachedLocale3 = hashMap2.get(langScriptCtry);
                                cachedLocale = cachedLocale3;
                            }
                        }
                        if (cachedLocale != null) {
                            cachedLocale.mSuggestionFlags |= 2;
                        }
                    }
                    localizedLocales.add(li2.getLangScriptKey());
                }
                for (LocaleInfo li3 : sLocaleCache.values()) {
                    li3.setTranslated(localizedLocales.contains(li3.getLangScriptKey()));
                }
                addSuggestedLocalesForRegion(Locale.getDefault());
                sFullyInitialized = true;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$fillCache$0(LocaleInfo li, Locale l10) {
        if (li.getLocale().stripExtensions().equals(l10.stripExtensions())) {
            li.mHasNumberingSystems = true;
        }
    }

    private static boolean isShallIgnore(Set<String> ignorables, final LocaleInfo li, boolean translatedOnly) {
        if (ignorables.stream().anyMatch(new Predicate() { // from class: com.android.internal.app.LocaleStore$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = Locale.forLanguageTag((String) obj).stripExtensions().equals(LocaleStore.LocaleInfo.this.getLocale().stripExtensions());
                return equals;
            }
        })) {
            return true;
        }
        if (li.mIsPseudo) {
            return false;
        }
        return (translatedOnly && !li.isTranslated()) || li.getParent() == null;
    }

    private static int getLocaleTier(LocaleInfo parent) {
        if (parent == null) {
            return 1;
        }
        if (parent.getLocale().getCountry().isEmpty()) {
            return 2;
        }
        return 3;
    }

    public static Set<LocaleInfo> getLevelLocales(Context context, Set<String> ignorables, LocaleInfo parent, boolean translatedOnly) {
        return getLevelLocales(context, ignorables, parent, translatedOnly, null);
    }

    public static Set<LocaleInfo> getLevelLocales(Context context, Set<String> ignorables, LocaleInfo parent, boolean translatedOnly, LocaleList explicitLocales) {
        HashMap<String, LocaleInfo> supportedLcoaleInfos;
        if (context != null) {
            fillCache(context);
        }
        if (explicitLocales == null) {
            supportedLcoaleInfos = sLocaleCache;
        } else {
            supportedLcoaleInfos = convertExplicitLocales(explicitLocales, sLocaleCache.values());
        }
        return getTierLocales(ignorables, parent, translatedOnly, supportedLcoaleInfos);
    }

    private static Set<LocaleInfo> getTierLocales(Set<String> ignorables, LocaleInfo parent, boolean translatedOnly, HashMap<String, LocaleInfo> supportedLocaleInfos) {
        boolean hasTargetParent = parent != null;
        String parentId = hasTargetParent ? parent.getId() : null;
        HashSet<LocaleInfo> result = new HashSet<>();
        for (LocaleInfo li : supportedLocaleInfos.values()) {
            if (!isShallIgnore(ignorables, li, translatedOnly)) {
                switch (getLocaleTier(parent)) {
                    case 1:
                        if (li.isSuggestionOfType(1)) {
                            result.add(li);
                            break;
                        } else {
                            Locale locale = li.getParent();
                            LocaleInfo localeInfo = getLocaleInfo(locale, supportedLocaleInfos);
                            addLocaleInfoToMap(locale, localeInfo, supportedLocaleInfos);
                            result.add(localeInfo);
                            break;
                        }
                    case 2:
                        if (parentId.equals(li.getParent().toLanguageTag())) {
                            Locale locale2 = li.getLocale().stripExtensions();
                            LocaleInfo localeInfo2 = getLocaleInfo(locale2, supportedLocaleInfos);
                            addLocaleInfoToMap(locale2, localeInfo2, supportedLocaleInfos);
                            result.add(localeInfo2);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (parent.getLocale().stripExtensions().equals(li.getLocale().stripExtensions())) {
                            result.add(li);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return result;
    }

    public static HashMap<String, LocaleInfo> convertExplicitLocales(LocaleList explicitLocales, Collection<LocaleInfo> localeinfo) {
        LocaleList localeList = matchLocaleFromSupportedLocaleList(explicitLocales, localeinfo);
        HashMap<String, LocaleInfo> localeInfos = new HashMap<>();
        for (int i10 = 0; i10 < localeList.size(); i10++) {
            Locale locale = localeList.get(i10);
            if (locale.toString().isEmpty()) {
                throw new IllformedLocaleException("Bad locale entry");
            }
            LocaleInfo li = new LocaleInfo(locale);
            if (!localeInfos.containsKey(li.getId())) {
                localeInfos.put(li.getId(), li);
                Locale parent = li.getParent();
                if (parent != null) {
                    String parentId = parent.toLanguageTag();
                    if (!localeInfos.containsKey(parentId)) {
                        localeInfos.put(parentId, new LocaleInfo(parent));
                    }
                }
            }
        }
        return localeInfos;
    }

    private static LocaleList matchLocaleFromSupportedLocaleList(LocaleList explicitLocales, Collection<LocaleInfo> localeInfos) {
        if (localeInfos == null) {
            return explicitLocales;
        }
        Locale[] resultLocales = new Locale[explicitLocales.size()];
        for (int i10 = 0; i10 < explicitLocales.size(); i10++) {
            Locale locale = explicitLocales.get(i10);
            if (!TextUtils.isEmpty(locale.getCountry())) {
                Iterator<LocaleInfo> iterator2 = localeInfos.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    LocaleInfo localeInfo = iterator2.next();
                    if (LocaleList.matchesLanguageAndScript(locale, localeInfo.getLocale()) && TextUtils.equals(locale.getCountry(), localeInfo.getLocale().getCountry())) {
                        resultLocales[i10] = localeInfo.getLocale();
                        break;
                    }
                }
            }
            if (resultLocales[i10] == null) {
                resultLocales[i10] = locale;
            }
        }
        return new LocaleList(resultLocales);
    }

    public static LocaleInfo getLocaleInfo(Locale locale) {
        HashMap<String, LocaleInfo> hashMap = sLocaleCache;
        LocaleInfo localeInfo = getLocaleInfo(locale, hashMap);
        addLocaleInfoToMap(locale, localeInfo, hashMap);
        return localeInfo;
    }

    private static LocaleInfo getLocaleInfo(Locale locale, HashMap<String, LocaleInfo> localeInfos) {
        String id2 = locale.toLanguageTag();
        if (!localeInfos.containsKey(id2)) {
            Locale filteredLocale = getLocaleWithOnlyNumberingSystem(locale);
            if (localeInfos.containsKey(filteredLocale.toLanguageTag())) {
                LocaleInfo result = new LocaleInfo(locale);
                LocaleInfo localeInfo = localeInfos.get(filteredLocale.toLanguageTag());
                result.mIsPseudo = localeInfo.mIsPseudo;
                result.mIsTranslated = localeInfo.mIsTranslated;
                result.mHasNumberingSystems = localeInfo.mHasNumberingSystems;
                result.mSuggestionFlags = localeInfo.mSuggestionFlags;
                return result;
            }
            LocaleInfo result2 = new LocaleInfo(locale);
            return result2;
        }
        LocaleInfo result3 = localeInfos.get(id2);
        return result3;
    }

    private static Locale getLocaleWithOnlyNumberingSystem(Locale locale) {
        return new Locale.Builder().setLocale(locale.stripExtensions()).setUnicodeLocaleKeyword("nu", locale.getUnicodeLocaleType("nu")).build();
    }

    private static void addLocaleInfoToMap(Locale locale, LocaleInfo localeInfo, HashMap<String, LocaleInfo> map) {
        if (!map.containsKey(locale.toLanguageTag())) {
            Locale localeWithNumberingSystem = getLocaleWithOnlyNumberingSystem(locale);
            if (!map.containsKey(localeWithNumberingSystem.toLanguageTag())) {
                map.put(locale.toLanguageTag(), localeInfo);
            }
        }
    }

    public static LocaleInfo fromLocale(Locale locale) {
        return new LocaleInfo(locale);
    }
}
