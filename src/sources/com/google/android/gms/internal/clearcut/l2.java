package com.google.android.gms.internal.clearcut;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l2 extends com.google.android.gms.common.api.b<Object> implements t6.b {
    public l2(@NonNull Context context) {
        super(context, (com.google.android.gms.common.api.a<a.d>) com.google.android.gms.clearcut.a.f23310p, (a.d) null, (com.google.android.gms.common.api.internal.l) new com.google.android.gms.common.api.internal.a());
    }

    public static t6.b l(@NonNull Context context) {
        return new l2(context);
    }

    @Override // t6.b
    public final PendingResult<Status> a(zze zzeVar) {
        return e(new z4(zzeVar, c()));
    }
}
