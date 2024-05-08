package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushSettingResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushSafeEditResult {

    @Nullable
    private Long pushEndTime;
    private boolean pushSafeMode;

    @Nullable
    private Long pushStartTime;

    public NewPushSafeEditResult(boolean z10, @Nullable Long l10, @Nullable Long l11) {
        this.pushSafeMode = z10;
        this.pushStartTime = l10;
        this.pushEndTime = l11;
    }

    public static /* synthetic */ NewPushSafeEditResult copy$default(NewPushSafeEditResult newPushSafeEditResult, boolean z10, Long l10, Long l11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = newPushSafeEditResult.pushSafeMode;
        }
        if ((i10 & 2) != 0) {
            l10 = newPushSafeEditResult.pushStartTime;
        }
        if ((i10 & 4) != 0) {
            l11 = newPushSafeEditResult.pushEndTime;
        }
        return newPushSafeEditResult.copy(z10, l10, l11);
    }

    public final boolean component1() {
        return this.pushSafeMode;
    }

    @Nullable
    public final Long component2() {
        return this.pushStartTime;
    }

    @Nullable
    public final Long component3() {
        return this.pushEndTime;
    }

    @NotNull
    public final NewPushSafeEditResult copy(boolean z10, @Nullable Long l10, @Nullable Long l11) {
        return new NewPushSafeEditResult(z10, l10, l11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewPushSafeEditResult)) {
            return false;
        }
        NewPushSafeEditResult newPushSafeEditResult = (NewPushSafeEditResult) obj;
        return this.pushSafeMode == newPushSafeEditResult.pushSafeMode && s.d(this.pushStartTime, newPushSafeEditResult.pushStartTime) && s.d(this.pushEndTime, newPushSafeEditResult.pushEndTime);
    }

    @Nullable
    public final Long getPushEndTime() {
        return this.pushEndTime;
    }

    public final boolean getPushSafeMode() {
        return this.pushSafeMode;
    }

    @Nullable
    public final Long getPushStartTime() {
        return this.pushStartTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.pushSafeMode;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        Long l10 = this.pushStartTime;
        int hashCode = (i10 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.pushEndTime;
        return hashCode + (l11 != null ? l11.hashCode() : 0);
    }

    public final void setPushEndTime(@Nullable Long l10) {
        this.pushEndTime = l10;
    }

    public final void setPushSafeMode(boolean z10) {
        this.pushSafeMode = z10;
    }

    public final void setPushStartTime(@Nullable Long l10) {
        this.pushStartTime = l10;
    }

    @NotNull
    public String toString() {
        return "NewPushSafeEditResult(pushSafeMode=" + this.pushSafeMode + ", pushStartTime=" + ((Object) this.pushStartTime) + ", pushEndTime=" + ((Object) this.pushEndTime) + ")";
    }

    public /* synthetic */ NewPushSafeEditResult(boolean z10, Long l10, Long l11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : l11);
    }
}
