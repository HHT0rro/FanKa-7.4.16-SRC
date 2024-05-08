package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AppDialogModel {
    private final boolean reTabChange;

    @NotNull
    private final String scene;

    @NotNull
    private final String windowType;

    public AppDialogModel(@NotNull String scene, @NotNull String windowType, boolean z10) {
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        this.scene = scene;
        this.windowType = windowType;
        this.reTabChange = z10;
    }

    @Nullable
    public final RateScene getRateScene() {
        String str = this.scene;
        RateScene rateScene = RateScene.LeaveMessageDetail;
        if (s.d(str, rateScene.getScene())) {
            return rateScene;
        }
        RateScene rateScene2 = RateScene.FeedPraise;
        if (s.d(str, rateScene2.getScene())) {
            return rateScene2;
        }
        RateScene rateScene3 = RateScene.LeaveNotify;
        if (s.d(str, rateScene3.getScene())) {
            return rateScene3;
        }
        RateScene rateScene4 = RateScene.LeaveNearbyFollow;
        if (s.d(str, rateScene4.getScene())) {
            return rateScene4;
        }
        RateScene rateScene5 = RateScene.PublishNewFeed;
        if (s.d(str, rateScene5.getScene())) {
            return rateScene5;
        }
        return null;
    }

    public final boolean getReTabChange() {
        return this.reTabChange;
    }

    @NotNull
    public final String getScene() {
        return this.scene;
    }

    @NotNull
    public final String getWindowType() {
        return this.windowType;
    }

    public /* synthetic */ AppDialogModel(String str, String str2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? false : z10);
    }
}
