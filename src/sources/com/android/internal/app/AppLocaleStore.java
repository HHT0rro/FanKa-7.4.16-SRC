package com.android.internal.app;

import android.app.LocaleConfig;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.LocaleList;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AppLocaleStore {
    private static final String TAG = AppLocaleStore.class.getSimpleName();

    public static AppLocaleResult getAppSupportedLocales(Context context, String packageName) {
        LocaleConfig localeConfig = null;
        AppLocaleResult.LocaleStatus localeStatus = AppLocaleResult.LocaleStatus.UNKNOWN_FAILURE;
        HashSet<Locale> appSupportedLocales = new HashSet<>();
        HashSet<Locale> assetLocale = getAssetLocales(context, packageName);
        boolean shouldFilterNotMatchingLocale = false;
        try {
            localeConfig = new LocaleConfig(context.createPackageContext(packageName, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w(TAG, "Can not found the package name : " + packageName + " / " + ((Object) e2));
        }
        if (localeConfig != null) {
            if (localeConfig.getStatus() == 0) {
                LocaleList packageLocaleList = localeConfig.getSupportedLocales();
                if (!hasInstallerInfo(context, packageName) && isSystemApp(context, packageName)) {
                    shouldFilterNotMatchingLocale = true;
                }
                Log.d(TAG, "filterNonMatchingLocale. , shouldFilterNotMatchingLocale: " + shouldFilterNotMatchingLocale + ", assetLocale size: " + assetLocale.size() + ", packageLocaleList size: " + packageLocaleList.size());
                for (int i10 = 0; i10 < packageLocaleList.size(); i10++) {
                    appSupportedLocales.add(packageLocaleList.get(i10));
                }
                if (shouldFilterNotMatchingLocale) {
                    appSupportedLocales = filterNotMatchingLocale(appSupportedLocales, assetLocale);
                }
                localeStatus = appSupportedLocales.size() > 0 ? AppLocaleResult.LocaleStatus.GET_SUPPORTED_LANGUAGE_FROM_LOCAL_CONFIG : AppLocaleResult.LocaleStatus.NO_SUPPORTED_LANGUAGE_IN_APP;
            } else if (localeConfig.getStatus() == 1) {
                if (assetLocale.size() > 0) {
                    localeStatus = AppLocaleResult.LocaleStatus.GET_SUPPORTED_LANGUAGE_FROM_ASSET;
                    appSupportedLocales = assetLocale;
                } else {
                    localeStatus = AppLocaleResult.LocaleStatus.ASSET_LOCALE_IS_EMPTY;
                }
            }
        }
        Log.d(TAG, "getAppSupportedLocales(). package: " + packageName + ", status: " + ((Object) localeStatus) + ", appSupportedLocales:" + appSupportedLocales.size());
        return new AppLocaleResult(localeStatus, appSupportedLocales);
    }

    private static HashSet<Locale> getAssetLocales(Context context, String packageName) {
        HashSet<Locale> result = new HashSet<>();
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] locales = packageManager.getResourcesForApplication(packageManager.getPackageInfo(packageName, 131072).applicationInfo).getAssets().getNonSystemLocales();
            if (locales == null) {
                Log.i(TAG, "[" + packageName + "] locales are null.");
            } else if (locales.length <= 0) {
                Log.i(TAG, "[" + packageName + "] locales length is 0.");
            } else {
                for (String language : locales) {
                    result.add(Locale.forLanguageTag(language));
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w(TAG, "Can not found the package name : " + packageName + " / " + ((Object) e2));
        }
        return result;
    }

    private static HashSet<Locale> filterNotMatchingLocale(HashSet<Locale> appSupportedLocales, final HashSet<Locale> assetLocale) {
        return (HashSet) appSupportedLocales.stream().filter(new Predicate() { // from class: com.android.internal.app.AppLocaleStore$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean matchLanguageInSet;
                matchLanguageInSet = AppLocaleStore.matchLanguageInSet((Locale) obj, HashSet.this);
                return matchLanguageInSet;
            }
        }).collect(Collectors.toCollection(new Supplier() { // from class: com.android.internal.app.AppLocaleStore$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new HashSet();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean matchLanguageInSet(Locale locale, HashSet<Locale> localesSet) {
        if (localesSet.contains(locale)) {
            return true;
        }
        Iterator<Locale> iterator2 = localesSet.iterator2();
        while (iterator2.hasNext()) {
            Locale l10 = iterator2.next();
            if (LocaleList.matchesLanguageAndScript(l10, locale)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasInstallerInfo(Context context, String packageName) {
        try {
            InstallSourceInfo installSourceInfo = context.getPackageManager().getInstallSourceInfo(packageName);
            return installSourceInfo != null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w(TAG, "Installer info not found for: " + packageName);
            return false;
        }
    }

    private static boolean isSystemApp(Context context, String packageName) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfoAsUser(packageName, 0, context.getUserId());
            return applicationInfo.isSystemApp();
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w(TAG, "Application info not found for: " + packageName);
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class AppLocaleResult {
        public HashSet<Locale> mAppSupportedLocales;
        LocaleStatus mLocaleStatus;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public enum LocaleStatus {
            UNKNOWN_FAILURE,
            NO_SUPPORTED_LANGUAGE_IN_APP,
            ASSET_LOCALE_IS_EMPTY,
            GET_SUPPORTED_LANGUAGE_FROM_LOCAL_CONFIG,
            GET_SUPPORTED_LANGUAGE_FROM_ASSET
        }

        public AppLocaleResult(LocaleStatus localeStatus, HashSet<Locale> appSupportedLocales) {
            this.mLocaleStatus = localeStatus;
            this.mAppSupportedLocales = appSupportedLocales;
        }
    }
}
