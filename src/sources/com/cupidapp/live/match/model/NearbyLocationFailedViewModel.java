package com.cupidapp.live.match.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyLocationFailedViewModel {

    @Nullable
    private final Integer errorCode;

    public NearbyLocationFailedViewModel(@Nullable Integer num) {
        this.errorCode = num;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }
}
