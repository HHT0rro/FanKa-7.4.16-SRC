package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExposureDoneModel extends AppDialogModel {

    @NotNull
    private final String exposure;

    @NotNull
    private final String nearbyExposure;

    @NotNull
    private final String newFans;

    @NotNull
    private final String newVisitors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposureDoneModel(@NotNull String scene, @NotNull String windowType, @NotNull String exposure, @NotNull String newVisitors, @NotNull String newFans, @NotNull String nearbyExposure) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(exposure, "exposure");
        s.i(newVisitors, "newVisitors");
        s.i(newFans, "newFans");
        s.i(nearbyExposure, "nearbyExposure");
        this.exposure = exposure;
        this.newVisitors = newVisitors;
        this.newFans = newFans;
        this.nearbyExposure = nearbyExposure;
    }

    @NotNull
    public final String getExposure() {
        return this.exposure;
    }

    @NotNull
    public final String getNearbyExposure() {
        return this.nearbyExposure;
    }

    @NotNull
    public final String getNewFans() {
        return this.newFans;
    }

    @NotNull
    public final String getNewVisitors() {
        return this.newVisitors;
    }
}
