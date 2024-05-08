package com.cupidapp.live.feed.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitCreateTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CreateTextUiModel {

    @NotNull
    private final PostLimitTextBgType bgType;

    @NotNull
    private final PostLimitTextFontType fontType;
    private final int gravity;
    private final float size;

    @NotNull
    private final String text;

    @Nullable
    private PostLimitDragTextLayout textLayout;

    public CreateTextUiModel(@Nullable PostLimitDragTextLayout postLimitDragTextLayout, @NotNull String text, @NotNull PostLimitTextFontType fontType, @NotNull PostLimitTextBgType bgType, float f10, int i10) {
        kotlin.jvm.internal.s.i(text, "text");
        kotlin.jvm.internal.s.i(fontType, "fontType");
        kotlin.jvm.internal.s.i(bgType, "bgType");
        this.textLayout = postLimitDragTextLayout;
        this.text = text;
        this.fontType = fontType;
        this.bgType = bgType;
        this.size = f10;
        this.gravity = i10;
    }

    public static /* synthetic */ CreateTextUiModel copy$default(CreateTextUiModel createTextUiModel, PostLimitDragTextLayout postLimitDragTextLayout, String str, PostLimitTextFontType postLimitTextFontType, PostLimitTextBgType postLimitTextBgType, float f10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            postLimitDragTextLayout = createTextUiModel.textLayout;
        }
        if ((i11 & 2) != 0) {
            str = createTextUiModel.text;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            postLimitTextFontType = createTextUiModel.fontType;
        }
        PostLimitTextFontType postLimitTextFontType2 = postLimitTextFontType;
        if ((i11 & 8) != 0) {
            postLimitTextBgType = createTextUiModel.bgType;
        }
        PostLimitTextBgType postLimitTextBgType2 = postLimitTextBgType;
        if ((i11 & 16) != 0) {
            f10 = createTextUiModel.size;
        }
        float f11 = f10;
        if ((i11 & 32) != 0) {
            i10 = createTextUiModel.gravity;
        }
        return createTextUiModel.copy(postLimitDragTextLayout, str2, postLimitTextFontType2, postLimitTextBgType2, f11, i10);
    }

    @Nullable
    public final PostLimitDragTextLayout component1() {
        return this.textLayout;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final PostLimitTextFontType component3() {
        return this.fontType;
    }

    @NotNull
    public final PostLimitTextBgType component4() {
        return this.bgType;
    }

    public final float component5() {
        return this.size;
    }

    public final int component6() {
        return this.gravity;
    }

    @NotNull
    public final CreateTextUiModel copy(@Nullable PostLimitDragTextLayout postLimitDragTextLayout, @NotNull String text, @NotNull PostLimitTextFontType fontType, @NotNull PostLimitTextBgType bgType, float f10, int i10) {
        kotlin.jvm.internal.s.i(text, "text");
        kotlin.jvm.internal.s.i(fontType, "fontType");
        kotlin.jvm.internal.s.i(bgType, "bgType");
        return new CreateTextUiModel(postLimitDragTextLayout, text, fontType, bgType, f10, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateTextUiModel)) {
            return false;
        }
        CreateTextUiModel createTextUiModel = (CreateTextUiModel) obj;
        return kotlin.jvm.internal.s.d(this.textLayout, createTextUiModel.textLayout) && kotlin.jvm.internal.s.d(this.text, createTextUiModel.text) && this.fontType == createTextUiModel.fontType && this.bgType == createTextUiModel.bgType && Float.compare(this.size, createTextUiModel.size) == 0 && this.gravity == createTextUiModel.gravity;
    }

    @NotNull
    public final PostLimitTextBgType getBgType() {
        return this.bgType;
    }

    @NotNull
    public final PostLimitTextFontType getFontType() {
        return this.fontType;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final float getSize() {
        return this.size;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final PostLimitDragTextLayout getTextLayout() {
        return this.textLayout;
    }

    public int hashCode() {
        PostLimitDragTextLayout postLimitDragTextLayout = this.textLayout;
        return ((((((((((postLimitDragTextLayout == null ? 0 : postLimitDragTextLayout.hashCode()) * 31) + this.text.hashCode()) * 31) + this.fontType.hashCode()) * 31) + this.bgType.hashCode()) * 31) + Float.floatToIntBits(this.size)) * 31) + this.gravity;
    }

    public final void setTextLayout(@Nullable PostLimitDragTextLayout postLimitDragTextLayout) {
        this.textLayout = postLimitDragTextLayout;
    }

    @NotNull
    public String toString() {
        PostLimitDragTextLayout postLimitDragTextLayout = this.textLayout;
        String str = this.text;
        PostLimitTextFontType postLimitTextFontType = this.fontType;
        PostLimitTextBgType postLimitTextBgType = this.bgType;
        return "CreateTextUiModel(textLayout=" + ((Object) postLimitDragTextLayout) + ", text=" + str + ", fontType=" + ((Object) postLimitTextFontType) + ", bgType=" + ((Object) postLimitTextBgType) + ", size=" + this.size + ", gravity=" + this.gravity + ")";
    }

    public /* synthetic */ CreateTextUiModel(PostLimitDragTextLayout postLimitDragTextLayout, String str, PostLimitTextFontType postLimitTextFontType, PostLimitTextBgType postLimitTextBgType, float f10, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(postLimitDragTextLayout, str, postLimitTextFontType, postLimitTextBgType, (i11 & 16) != 0 ? 20.0f : f10, (i11 & 32) != 0 ? 17 : i10);
    }
}
