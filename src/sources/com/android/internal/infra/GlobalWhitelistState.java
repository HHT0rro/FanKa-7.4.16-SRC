package com.android.internal.infra;

import android.content.ComponentName;
import android.util.ArraySet;
import android.util.SparseArray;
import java.io.PrintWriter;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GlobalWhitelistState {
    protected final Object mGlobalWhitelistStateLock = new Object();
    protected SparseArray<WhitelistHelper> mWhitelisterHelpers;

    public void setWhitelist(int userId, List<String> packageNames, List<ComponentName> components) {
        synchronized (this.mGlobalWhitelistStateLock) {
            if (this.mWhitelisterHelpers == null) {
                this.mWhitelisterHelpers = new SparseArray<>(1);
            }
            WhitelistHelper helper = this.mWhitelisterHelpers.get(userId);
            if (helper == null) {
                helper = new WhitelistHelper();
                this.mWhitelisterHelpers.put(userId, helper);
            }
            helper.setWhitelist(packageNames, components);
        }
    }

    public boolean isWhitelisted(int userId, String packageName) {
        synchronized (this.mGlobalWhitelistStateLock) {
            SparseArray<WhitelistHelper> sparseArray = this.mWhitelisterHelpers;
            boolean z10 = false;
            if (sparseArray == null) {
                return false;
            }
            WhitelistHelper helper = sparseArray.get(userId);
            if (helper != null) {
                z10 = helper.isWhitelisted(packageName);
            }
            return z10;
        }
    }

    public boolean isWhitelisted(int userId, ComponentName componentName) {
        synchronized (this.mGlobalWhitelistStateLock) {
            SparseArray<WhitelistHelper> sparseArray = this.mWhitelisterHelpers;
            boolean z10 = false;
            if (sparseArray == null) {
                return false;
            }
            WhitelistHelper helper = sparseArray.get(userId);
            if (helper != null) {
                z10 = helper.isWhitelisted(componentName);
            }
            return z10;
        }
    }

    public ArraySet<ComponentName> getWhitelistedComponents(int userId, String packageName) {
        synchronized (this.mGlobalWhitelistStateLock) {
            SparseArray<WhitelistHelper> sparseArray = this.mWhitelisterHelpers;
            ArraySet<ComponentName> arraySet = null;
            if (sparseArray == null) {
                return null;
            }
            WhitelistHelper helper = sparseArray.get(userId);
            if (helper != null) {
                arraySet = helper.getWhitelistedComponents(packageName);
            }
            return arraySet;
        }
    }

    public ArraySet<String> getWhitelistedPackages(int userId) {
        synchronized (this.mGlobalWhitelistStateLock) {
            SparseArray<WhitelistHelper> sparseArray = this.mWhitelisterHelpers;
            ArraySet<String> arraySet = null;
            if (sparseArray == null) {
                return null;
            }
            WhitelistHelper helper = sparseArray.get(userId);
            if (helper != null) {
                arraySet = helper.getWhitelistedPackages();
            }
            return arraySet;
        }
    }

    public void resetWhitelist(int userId) {
        synchronized (this.mGlobalWhitelistStateLock) {
            SparseArray<WhitelistHelper> sparseArray = this.mWhitelisterHelpers;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(userId);
            if (this.mWhitelisterHelpers.size() == 0) {
                this.mWhitelisterHelpers = null;
            }
        }
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("State: ");
        synchronized (this.mGlobalWhitelistStateLock) {
            SparseArray<WhitelistHelper> sparseArray = this.mWhitelisterHelpers;
            if (sparseArray == null) {
                pw.println("empty");
                return;
            }
            pw.print(sparseArray.size());
            pw.println(" services");
            String prefix2 = prefix + "  ";
            for (int i10 = 0; i10 < this.mWhitelisterHelpers.size(); i10++) {
                int userId = this.mWhitelisterHelpers.keyAt(i10);
                WhitelistHelper helper = this.mWhitelisterHelpers.valueAt(i10);
                helper.dump(prefix2, "Whitelist for userId " + userId, pw);
            }
        }
    }
}
