package com.google.android.gms.common.api;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.gms.common.internal.h;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BooleanResult implements Result {
    private final Status zaa;
    private final boolean zab;

    public BooleanResult(@RecentlyNonNull Status status, @RecentlyNonNull boolean z10) {
        this.zaa = (Status) h.i(status, "Status must not be null");
        this.zab = z10;
    }

    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zaa.equals(booleanResult.zaa) && this.zab == booleanResult.zab;
    }

    @Override // com.google.android.gms.common.api.Result
    @RecentlyNonNull
    public Status getStatus() {
        return this.zaa;
    }

    @RecentlyNonNull
    public boolean getValue() {
        return this.zab;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return ((this.zaa.hashCode() + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31) + (this.zab ? 1 : 0);
    }
}
