package com.google.android.gms.tasks;

import androidx.annotation.Nullable;
import p7.f;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(f<?> fVar) {
        String str;
        if (!fVar.h()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception e2 = fVar.e();
        if (e2 != null) {
            str = "failure";
        } else if (fVar.i()) {
            String valueOf = String.valueOf(fVar.f());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
            sb2.append("result ");
            sb2.append(valueOf);
            str = sb2.toString();
        } else {
            str = fVar.g() ? "cancellation" : "unknown issue";
        }
        String valueOf2 = String.valueOf(str);
        return new DuplicateTaskCompletionException(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), e2);
    }
}
