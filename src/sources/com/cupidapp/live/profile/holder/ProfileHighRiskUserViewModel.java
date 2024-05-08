package com.cupidapp.live.profile.holder;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileHighRiskUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileHighRiskUserViewModel {
    private final boolean highRisk;

    @Nullable
    private final String highRiskNotice;

    public ProfileHighRiskUserViewModel() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public ProfileHighRiskUserViewModel(boolean z10, @Nullable String str) {
        this.highRisk = z10;
        this.highRiskNotice = str;
    }

    public final boolean getHighRisk() {
        return this.highRisk;
    }

    @Nullable
    public final String getHighRiskNotice() {
        return this.highRiskNotice;
    }

    public /* synthetic */ ProfileHighRiskUserViewModel(boolean z10, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : str);
    }
}
