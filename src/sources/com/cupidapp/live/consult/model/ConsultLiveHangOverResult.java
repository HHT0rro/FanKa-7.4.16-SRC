package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultLiveHangOverResult {

    @Nullable
    private final ConsultLiveModel info;
    private final boolean suspend;

    public ConsultLiveHangOverResult(boolean z10, @Nullable ConsultLiveModel consultLiveModel) {
        this.suspend = z10;
        this.info = consultLiveModel;
    }

    public static /* synthetic */ ConsultLiveHangOverResult copy$default(ConsultLiveHangOverResult consultLiveHangOverResult, boolean z10, ConsultLiveModel consultLiveModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = consultLiveHangOverResult.suspend;
        }
        if ((i10 & 2) != 0) {
            consultLiveModel = consultLiveHangOverResult.info;
        }
        return consultLiveHangOverResult.copy(z10, consultLiveModel);
    }

    public final boolean component1() {
        return this.suspend;
    }

    @Nullable
    public final ConsultLiveModel component2() {
        return this.info;
    }

    @NotNull
    public final ConsultLiveHangOverResult copy(boolean z10, @Nullable ConsultLiveModel consultLiveModel) {
        return new ConsultLiveHangOverResult(z10, consultLiveModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultLiveHangOverResult)) {
            return false;
        }
        ConsultLiveHangOverResult consultLiveHangOverResult = (ConsultLiveHangOverResult) obj;
        return this.suspend == consultLiveHangOverResult.suspend && s.d(this.info, consultLiveHangOverResult.info);
    }

    @Nullable
    public final ConsultLiveModel getInfo() {
        return this.info;
    }

    public final boolean getSuspend() {
        return this.suspend;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.suspend;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        ConsultLiveModel consultLiveModel = this.info;
        return i10 + (consultLiveModel == null ? 0 : consultLiveModel.hashCode());
    }

    @NotNull
    public String toString() {
        return "ConsultLiveHangOverResult(suspend=" + this.suspend + ", info=" + ((Object) this.info) + ")";
    }
}
