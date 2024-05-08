package com.nirvana.tools.crash;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class StackAnalyzer {
    private List<SdkInfo> filterSdks;
    private int packageCount = 0;
    private static final Pattern PATTERN = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*[.])+(?!java)([a-zA-Z_][a-zA-Z0-9_]+)");
    private static final Pattern NPL_PATTERN = Pattern.compile("(java.lang.NullPointerException: Attempt to invoke virtual method 'void )([a-zA-Z_][a-zA-Z0-9_]*[.])+(?!java)([a-zA-Z_][a-zA-Z0-9_]+)");

    private boolean isClassInPackages(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && !list.isEmpty()) {
            for (String str2 : list) {
                if (str.startsWith(str2) || str2.startsWith(str) || str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isIgnoreException(String str, List<String> list) {
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (Pattern.compile(iterator2.next()).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private boolean isSdkNullPointerException(String str, List<String> list) {
        if (!str.contains("java.lang.NullPointerException")) {
            return false;
        }
        Matcher matcher = NPL_PATTERN.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        String group = matcher.group();
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (group.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private LinkedHashSet<String> parseCrashClasses(String str) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String[] split = str.split("\tat");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                Matcher matcher = PATTERN.matcher(str2);
                while (matcher.find()) {
                    String group = matcher.group();
                    if (!TextUtils.isEmpty(group)) {
                        String substring = group.substring(0, group.lastIndexOf("."));
                        if (substring.contains(".")) {
                            linkedHashSet.add(substring);
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public SdkInfo checkJavaCrashInSdk(String str) {
        for (SdkInfo sdkInfo : this.filterSdks) {
            if (isJavaCrashInSdk(str, sdkInfo.getPackageNames(), sdkInfo.getSdkInterfaces(), sdkInfo.getIgnoreInterfaces())) {
                return sdkInfo;
            }
        }
        return null;
    }

    public SdkInfo checkNativeCrashInSdk(String str) {
        for (SdkInfo sdkInfo : this.filterSdks) {
            if (isNativeCrashInSdk(str, sdkInfo.getNativeLibraries())) {
                return sdkInfo;
            }
        }
        return null;
    }

    public void initAddSdkConfig(SdkInfo sdkInfo) {
        if (this.filterSdks == null) {
            this.filterSdks = new ArrayList();
        }
        this.filterSdks.add(sdkInfo);
        this.packageCount += (sdkInfo.getPackageNames() == null || sdkInfo.getPackageNames().isEmpty()) ? 0 : sdkInfo.getPackageNames().size();
    }

    public boolean isJavaCrashInSdk(String str, List<String> list, List<String> list2, List<String> list3) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str) || isSdkNullPointerException(str, list2)) {
            return false;
        }
        if (list3 != null && !list3.isEmpty() && isIgnoreException(str, list3)) {
            return false;
        }
        Iterator<String> it = parseCrashClasses(str).iterator2();
        while (it.hasNext()) {
            if (isClassInPackages(it.next(), list)) {
                return true;
            }
        }
        return false;
    }

    public boolean isJavaCrashInSdk(Throwable th, List<String> list, List<String> list2, List<String> list3) {
        return isJavaCrashInSdk(Log.getStackTraceString(th), list, list2, list3);
    }

    public boolean isNativeCrashInSdk(String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (str.contains(iterator2.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
