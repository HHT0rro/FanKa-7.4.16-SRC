package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private Set<String> aFR = new HashSet();
    private Set<String> aFS = new HashSet();

    public final synchronized String[] HI() {
        Set<String> set;
        set = this.aFR;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] Hw() {
        Set<String> set;
        set = this.aFS;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aFR.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.aFS.add(str2);
                }
            }
        }
    }
}
