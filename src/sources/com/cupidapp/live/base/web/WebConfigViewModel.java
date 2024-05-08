package com.cupidapp.live.base.web;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebConfigViewModel implements Serializable {
    private final boolean agreeUrlConfigStatusBar;

    @NotNull
    private final SensorPosition currentFragmentPageName;
    private final boolean isShowCloseIcon;
    private final boolean onResumeLoad;
    private boolean showAlohaShareButton;
    private final boolean showLoadingProgressBar;
    private final boolean showTitleBar;

    public WebConfigViewModel() {
        this(false, false, false, false, false, null, false, 127, null);
    }

    public WebConfigViewModel(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, @NotNull SensorPosition currentFragmentPageName, boolean z15) {
        s.i(currentFragmentPageName, "currentFragmentPageName");
        this.showTitleBar = z10;
        this.showAlohaShareButton = z11;
        this.isShowCloseIcon = z12;
        this.showLoadingProgressBar = z13;
        this.agreeUrlConfigStatusBar = z14;
        this.currentFragmentPageName = currentFragmentPageName;
        this.onResumeLoad = z15;
    }

    public static /* synthetic */ WebConfigViewModel copy$default(WebConfigViewModel webConfigViewModel, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, SensorPosition sensorPosition, boolean z15, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = webConfigViewModel.showTitleBar;
        }
        if ((i10 & 2) != 0) {
            z11 = webConfigViewModel.showAlohaShareButton;
        }
        boolean z16 = z11;
        if ((i10 & 4) != 0) {
            z12 = webConfigViewModel.isShowCloseIcon;
        }
        boolean z17 = z12;
        if ((i10 & 8) != 0) {
            z13 = webConfigViewModel.showLoadingProgressBar;
        }
        boolean z18 = z13;
        if ((i10 & 16) != 0) {
            z14 = webConfigViewModel.agreeUrlConfigStatusBar;
        }
        boolean z19 = z14;
        if ((i10 & 32) != 0) {
            sensorPosition = webConfigViewModel.currentFragmentPageName;
        }
        SensorPosition sensorPosition2 = sensorPosition;
        if ((i10 & 64) != 0) {
            z15 = webConfigViewModel.onResumeLoad;
        }
        return webConfigViewModel.copy(z10, z16, z17, z18, z19, sensorPosition2, z15);
    }

    public final boolean component1() {
        return this.showTitleBar;
    }

    public final boolean component2() {
        return this.showAlohaShareButton;
    }

    public final boolean component3() {
        return this.isShowCloseIcon;
    }

    public final boolean component4() {
        return this.showLoadingProgressBar;
    }

    public final boolean component5() {
        return this.agreeUrlConfigStatusBar;
    }

    @NotNull
    public final SensorPosition component6() {
        return this.currentFragmentPageName;
    }

    public final boolean component7() {
        return this.onResumeLoad;
    }

    @NotNull
    public final WebConfigViewModel copy(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, @NotNull SensorPosition currentFragmentPageName, boolean z15) {
        s.i(currentFragmentPageName, "currentFragmentPageName");
        return new WebConfigViewModel(z10, z11, z12, z13, z14, currentFragmentPageName, z15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebConfigViewModel)) {
            return false;
        }
        WebConfigViewModel webConfigViewModel = (WebConfigViewModel) obj;
        return this.showTitleBar == webConfigViewModel.showTitleBar && this.showAlohaShareButton == webConfigViewModel.showAlohaShareButton && this.isShowCloseIcon == webConfigViewModel.isShowCloseIcon && this.showLoadingProgressBar == webConfigViewModel.showLoadingProgressBar && this.agreeUrlConfigStatusBar == webConfigViewModel.agreeUrlConfigStatusBar && this.currentFragmentPageName == webConfigViewModel.currentFragmentPageName && this.onResumeLoad == webConfigViewModel.onResumeLoad;
    }

    public final boolean getAgreeUrlConfigStatusBar() {
        return this.agreeUrlConfigStatusBar;
    }

    @NotNull
    public final SensorPosition getCurrentFragmentPageName() {
        return this.currentFragmentPageName;
    }

    public final boolean getOnResumeLoad() {
        return this.onResumeLoad;
    }

    public final boolean getShowAlohaShareButton() {
        return this.showAlohaShareButton;
    }

    public final boolean getShowLoadingProgressBar() {
        return this.showLoadingProgressBar;
    }

    public final boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.showTitleBar;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        ?? r22 = this.showAlohaShareButton;
        int i11 = r22;
        if (r22 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        ?? r23 = this.isShowCloseIcon;
        int i13 = r23;
        if (r23 != 0) {
            i13 = 1;
        }
        int i14 = (i12 + i13) * 31;
        ?? r24 = this.showLoadingProgressBar;
        int i15 = r24;
        if (r24 != 0) {
            i15 = 1;
        }
        int i16 = (i14 + i15) * 31;
        ?? r25 = this.agreeUrlConfigStatusBar;
        int i17 = r25;
        if (r25 != 0) {
            i17 = 1;
        }
        int hashCode = (((i16 + i17) * 31) + this.currentFragmentPageName.hashCode()) * 31;
        boolean z11 = this.onResumeLoad;
        return hashCode + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isShowCloseIcon() {
        return this.isShowCloseIcon;
    }

    public final void setShowAlohaShareButton(boolean z10) {
        this.showAlohaShareButton = z10;
    }

    @NotNull
    public String toString() {
        boolean z10 = this.showTitleBar;
        boolean z11 = this.showAlohaShareButton;
        boolean z12 = this.isShowCloseIcon;
        boolean z13 = this.showLoadingProgressBar;
        boolean z14 = this.agreeUrlConfigStatusBar;
        SensorPosition sensorPosition = this.currentFragmentPageName;
        return "WebConfigViewModel(showTitleBar=" + z10 + ", showAlohaShareButton=" + z11 + ", isShowCloseIcon=" + z12 + ", showLoadingProgressBar=" + z13 + ", agreeUrlConfigStatusBar=" + z14 + ", currentFragmentPageName=" + ((Object) sensorPosition) + ", onResumeLoad=" + this.onResumeLoad + ")";
    }

    public /* synthetic */ WebConfigViewModel(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, SensorPosition sensorPosition, boolean z15, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? true : z13, (i10 & 16) == 0 ? z14 : true, (i10 & 32) != 0 ? SensorPosition.Unknown : sensorPosition, (i10 & 64) != 0 ? false : z15);
    }
}
