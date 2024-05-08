package com.cupidapp.live.base.web;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebStyleViewModel implements Serializable {
    private final boolean isShowCloseIcon;

    @Nullable
    private final List<Float> location;

    @NotNull
    private final WebStyleEnum webStyle;

    public WebStyleViewModel() {
        this(null, false, null, 7, null);
    }

    public WebStyleViewModel(@NotNull WebStyleEnum webStyle, boolean z10, @Nullable List<Float> list) {
        s.i(webStyle, "webStyle");
        this.webStyle = webStyle;
        this.isShowCloseIcon = z10;
        this.location = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebStyleViewModel copy$default(WebStyleViewModel webStyleViewModel, WebStyleEnum webStyleEnum, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            webStyleEnum = webStyleViewModel.webStyle;
        }
        if ((i10 & 2) != 0) {
            z10 = webStyleViewModel.isShowCloseIcon;
        }
        if ((i10 & 4) != 0) {
            list = webStyleViewModel.location;
        }
        return webStyleViewModel.copy(webStyleEnum, z10, list);
    }

    @NotNull
    public final WebStyleEnum component1() {
        return this.webStyle;
    }

    public final boolean component2() {
        return this.isShowCloseIcon;
    }

    @Nullable
    public final List<Float> component3() {
        return this.location;
    }

    @NotNull
    public final WebStyleViewModel copy(@NotNull WebStyleEnum webStyle, boolean z10, @Nullable List<Float> list) {
        s.i(webStyle, "webStyle");
        return new WebStyleViewModel(webStyle, z10, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebStyleViewModel)) {
            return false;
        }
        WebStyleViewModel webStyleViewModel = (WebStyleViewModel) obj;
        return this.webStyle == webStyleViewModel.webStyle && this.isShowCloseIcon == webStyleViewModel.isShowCloseIcon && s.d(this.location, webStyleViewModel.location);
    }

    @Nullable
    public final List<Float> getLocation() {
        return this.location;
    }

    @NotNull
    public final WebStyleEnum getWebStyle() {
        return this.webStyle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.webStyle.hashCode() * 31;
        boolean z10 = this.isShowCloseIcon;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        List<Float> list = this.location;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public final boolean isShowCloseIcon() {
        return this.isShowCloseIcon;
    }

    @NotNull
    public String toString() {
        WebStyleEnum webStyleEnum = this.webStyle;
        return "WebStyleViewModel(webStyle=" + ((Object) webStyleEnum) + ", isShowCloseIcon=" + this.isShowCloseIcon + ", location=" + ((Object) this.location) + ")";
    }

    public /* synthetic */ WebStyleViewModel(WebStyleEnum webStyleEnum, boolean z10, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? WebStyleEnum.RightToLeftStyle : webStyleEnum, (i10 & 2) != 0 ? true : z10, (i10 & 4) != 0 ? null : list);
    }
}
