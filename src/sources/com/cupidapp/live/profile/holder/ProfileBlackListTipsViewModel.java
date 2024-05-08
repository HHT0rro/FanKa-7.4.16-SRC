package com.cupidapp.live.profile.holder;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProfileBlackListTipsViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileBlackListTipsViewModel {
    private final boolean block;

    public ProfileBlackListTipsViewModel() {
        this(false, 1, null);
    }

    public ProfileBlackListTipsViewModel(boolean z10) {
        this.block = z10;
    }

    public final boolean getBlock() {
        return this.block;
    }

    public /* synthetic */ ProfileBlackListTipsViewModel(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
