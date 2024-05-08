package com.cupidapp.live.visitors.model;

import b2.a;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RenewViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RenewViewModel {
    private final long validDate;

    public RenewViewModel(long j10) {
        this.validDate = j10;
    }

    public static /* synthetic */ RenewViewModel copy$default(RenewViewModel renewViewModel, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = renewViewModel.validDate;
        }
        return renewViewModel.copy(j10);
    }

    public final long component1() {
        return this.validDate;
    }

    @NotNull
    public final RenewViewModel copy(long j10) {
        return new RenewViewModel(j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RenewViewModel) && this.validDate == ((RenewViewModel) obj).validDate;
    }

    public final long getValidDate() {
        return this.validDate;
    }

    public int hashCode() {
        return a.a(this.validDate);
    }

    @NotNull
    public String toString() {
        return "RenewViewModel(validDate=" + this.validDate + ")";
    }
}
