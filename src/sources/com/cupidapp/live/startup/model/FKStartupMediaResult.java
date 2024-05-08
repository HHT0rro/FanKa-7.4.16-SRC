package com.cupidapp.live.startup.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupMediaResult {

    @Nullable
    private final FKStartupMediaModel splashAdNew;

    public FKStartupMediaResult(@Nullable FKStartupMediaModel fKStartupMediaModel) {
        this.splashAdNew = fKStartupMediaModel;
    }

    public static /* synthetic */ FKStartupMediaResult copy$default(FKStartupMediaResult fKStartupMediaResult, FKStartupMediaModel fKStartupMediaModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKStartupMediaModel = fKStartupMediaResult.splashAdNew;
        }
        return fKStartupMediaResult.copy(fKStartupMediaModel);
    }

    @Nullable
    public final FKStartupMediaModel component1() {
        return this.splashAdNew;
    }

    @NotNull
    public final FKStartupMediaResult copy(@Nullable FKStartupMediaModel fKStartupMediaModel) {
        return new FKStartupMediaResult(fKStartupMediaModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKStartupMediaResult) && s.d(this.splashAdNew, ((FKStartupMediaResult) obj).splashAdNew);
    }

    @Nullable
    public final FKStartupMediaModel getSplashAdNew() {
        return this.splashAdNew;
    }

    public int hashCode() {
        FKStartupMediaModel fKStartupMediaModel = this.splashAdNew;
        if (fKStartupMediaModel == null) {
            return 0;
        }
        return fKStartupMediaModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKStartupMediaResult(splashAdNew=" + ((Object) this.splashAdNew) + ")";
    }
}
