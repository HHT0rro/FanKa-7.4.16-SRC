package com.cupidapp.live.base.recyclerview.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFooterViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKFooterViewModel {
    private final int bgColor;
    private int height;
    private boolean showProgress;
    private boolean showText;

    @Nullable
    private String text;
    private int textColor;

    public FKFooterViewModel() {
        this(false, false, null, 0, 0, 0, 63, null);
    }

    public FKFooterViewModel(boolean z10, boolean z11, @Nullable String str, int i10, int i11, int i12) {
        this.showProgress = z10;
        this.showText = z11;
        this.text = str;
        this.textColor = i10;
        this.height = i11;
        this.bgColor = i12;
    }

    public static /* synthetic */ void modifyParam$default(FKFooterViewModel fKFooterViewModel, boolean z10, boolean z11, String str, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyParam");
        }
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            str = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -15066598;
        }
        fKFooterViewModel.modifyParam(z10, z11, str, i10);
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getShowProgress() {
        return this.showProgress;
    }

    public boolean getShowText() {
        return this.showText;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public final void modifyParam(boolean z10, boolean z11, @Nullable String str, int i10) {
        setShowProgress(z10);
        setShowText(z11);
        setText(str);
        setTextColor(i10);
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setShowProgress(boolean z10) {
        this.showProgress = z10;
    }

    public void setShowText(boolean z10) {
        this.showText = z10;
    }

    public void setText(@Nullable String str) {
        this.text = str;
    }

    public void setTextColor(int i10) {
        this.textColor = i10;
    }

    public /* synthetic */ FKFooterViewModel(boolean z10, boolean z11, String str, int i10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? true : z10, (i13 & 2) != 0 ? false : z11, (i13 & 4) != 0 ? "" : str, (i13 & 8) != 0 ? -15066598 : i10, (i13 & 16) != 0 ? 80 : i11, (i13 & 32) == 0 ? i12 : 0);
    }
}
