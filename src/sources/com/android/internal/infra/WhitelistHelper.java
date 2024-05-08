package com.android.internal.infra;

import android.content.ComponentName;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WhitelistHelper {
    private static final String TAG = "WhitelistHelper";
    private ArrayMap<String, ArraySet<ComponentName>> mWhitelistedPackages;

    public void setWhitelist(ArraySet<String> packageNames, ArraySet<ComponentName> components) {
        this.mWhitelistedPackages = null;
        if (packageNames == null && components == null) {
            return;
        }
        if ((packageNames != null && packageNames.isEmpty()) || (components != null && components.isEmpty())) {
            throw new IllegalArgumentException("Packages or Components cannot be empty.");
        }
        this.mWhitelistedPackages = new ArrayMap<>();
        if (packageNames != null) {
            for (int i10 = 0; i10 < packageNames.size(); i10++) {
                this.mWhitelistedPackages.put(packageNames.valueAt(i10), null);
            }
        }
        if (components != null) {
            for (int i11 = 0; i11 < components.size(); i11++) {
                ComponentName component = components.valueAt(i11);
                if (component == null) {
                    Log.w(TAG, "setWhitelist(): component is null");
                } else {
                    String packageName = component.getPackageName();
                    ArraySet<ComponentName> set = this.mWhitelistedPackages.get(packageName);
                    if (set == null) {
                        set = new ArraySet<>();
                        this.mWhitelistedPackages.put(packageName, set);
                    }
                    set.add(component);
                }
            }
        }
    }

    public void setWhitelist(List<String> packageNames, List<ComponentName> components) {
        ArraySet<String> packageNamesSet;
        ArraySet<ComponentName> componentsSet = null;
        if (packageNames == null) {
            packageNamesSet = null;
        } else {
            packageNamesSet = new ArraySet<>(packageNames);
        }
        if (components != null) {
            componentsSet = new ArraySet<>(components);
        }
        setWhitelist(packageNamesSet, componentsSet);
    }

    public boolean isWhitelisted(String packageName) {
        Objects.requireNonNull(packageName);
        ArrayMap<String, ArraySet<ComponentName>> arrayMap = this.mWhitelistedPackages;
        return arrayMap != null && arrayMap.containsKey(packageName) && this.mWhitelistedPackages.get(packageName) == null;
    }

    public boolean isWhitelisted(ComponentName componentName) {
        Objects.requireNonNull(componentName);
        String packageName = componentName.getPackageName();
        ArraySet<ComponentName> whitelistedComponents = getWhitelistedComponents(packageName);
        if (whitelistedComponents != null) {
            return whitelistedComponents.contains(componentName);
        }
        return isWhitelisted(packageName);
    }

    public ArraySet<ComponentName> getWhitelistedComponents(String packageName) {
        Objects.requireNonNull(packageName);
        ArrayMap<String, ArraySet<ComponentName>> arrayMap = this.mWhitelistedPackages;
        if (arrayMap == null) {
            return null;
        }
        return arrayMap.get(packageName);
    }

    public ArraySet<String> getWhitelistedPackages() {
        if (this.mWhitelistedPackages == null) {
            return null;
        }
        return new ArraySet<>(this.mWhitelistedPackages.keySet());
    }

    public String toString() {
        return "WhitelistHelper[" + ((Object) this.mWhitelistedPackages) + ']';
    }

    public void dump(String prefix, String message, PrintWriter pw) {
        ArrayMap<String, ArraySet<ComponentName>> arrayMap = this.mWhitelistedPackages;
        if (arrayMap == null || arrayMap.size() == 0) {
            pw.print(prefix);
            pw.print(message);
            pw.println(": (no whitelisted packages)");
            return;
        }
        String prefix2 = prefix + "  ";
        int size = this.mWhitelistedPackages.size();
        pw.print(prefix);
        pw.print(message);
        pw.print(": ");
        pw.print(size);
        pw.println(" packages");
        for (int i10 = 0; i10 < this.mWhitelistedPackages.size(); i10++) {
            String packageName = this.mWhitelistedPackages.keyAt(i10);
            ArraySet<ComponentName> components = this.mWhitelistedPackages.valueAt(i10);
            pw.print(prefix2);
            pw.print(i10);
            pw.print(".");
            pw.print(packageName);
            pw.print(": ");
            if (components == null) {
                pw.println("(whole package)");
            } else {
                pw.print("[");
                pw.print(components.valueAt(0));
                for (int j10 = 1; j10 < components.size(); j10++) {
                    pw.print(", ");
                    pw.print(components.valueAt(j10));
                }
                pw.println("]");
            }
        }
    }
}
