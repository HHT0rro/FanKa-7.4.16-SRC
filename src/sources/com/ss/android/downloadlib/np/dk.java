package com.ss.android.downloadlib.np;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface m<T> {
        T dk();
    }

    public static <T> T m(boolean z10, String str, @NonNull m<T> mVar) {
        try {
            return mVar.dk();
        } catch (Throwable th) {
            if (!(th instanceof com.ss.android.downloadlib.np.m)) {
                ej.m().m(z10, th, str);
                if (TextUtils.isEmpty(str)) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    public static <T> T m(m<T> mVar) {
        return (T) m(true, null, mVar);
    }

    public static void m(final Runnable runnable) {
        m(new m<Void>() { // from class: com.ss.android.downloadlib.np.dk.1
            @Override // com.ss.android.downloadlib.np.dk.m
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Void dk() {
                Runnable.this.run();
                return null;
            }
        });
    }
}
