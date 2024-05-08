package com.google.firebase;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.h;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FirebaseException extends Exception {
    @Deprecated
    public FirebaseException() {
    }

    public FirebaseException(@RecentlyNonNull String str) {
        super(h.f(str, "Detail message must not be empty"));
    }

    public FirebaseException(@RecentlyNonNull String str, @RecentlyNonNull Throwable th) {
        super(h.f(str, "Detail message must not be empty"), th);
    }
}
