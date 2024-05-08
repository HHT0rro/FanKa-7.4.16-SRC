package com.cupidapp.live.match.view;

import androidx.annotation.ColorInt;
import java.io.Serializable;
import javax.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFKProfileLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TipUiModel implements Serializable {

    @Resource
    private final int bgDrawable;

    @NotNull
    private final String content;
    private final int txtColor;

    public TipUiModel(@NotNull String content, int i10, @ColorInt int i11) {
        kotlin.jvm.internal.s.i(content, "content");
        this.content = content;
        this.bgDrawable = i10;
        this.txtColor = i11;
    }

    public static /* synthetic */ TipUiModel copy$default(TipUiModel tipUiModel, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = tipUiModel.content;
        }
        if ((i12 & 2) != 0) {
            i10 = tipUiModel.bgDrawable;
        }
        if ((i12 & 4) != 0) {
            i11 = tipUiModel.txtColor;
        }
        return tipUiModel.copy(str, i10, i11);
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.bgDrawable;
    }

    public final int component3() {
        return this.txtColor;
    }

    @NotNull
    public final TipUiModel copy(@NotNull String content, int i10, @ColorInt int i11) {
        kotlin.jvm.internal.s.i(content, "content");
        return new TipUiModel(content, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TipUiModel)) {
            return false;
        }
        TipUiModel tipUiModel = (TipUiModel) obj;
        return kotlin.jvm.internal.s.d(this.content, tipUiModel.content) && this.bgDrawable == tipUiModel.bgDrawable && this.txtColor == tipUiModel.txtColor;
    }

    public final int getBgDrawable() {
        return this.bgDrawable;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getTxtColor() {
        return this.txtColor;
    }

    public int hashCode() {
        return (((this.content.hashCode() * 31) + this.bgDrawable) * 31) + this.txtColor;
    }

    @NotNull
    public String toString() {
        return "TipUiModel(content=" + this.content + ", bgDrawable=" + this.bgDrawable + ", txtColor=" + this.txtColor + ")";
    }
}
