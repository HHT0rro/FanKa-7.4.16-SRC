package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatOptionsModel {

    @NotNull
    private final String optionId;
    private boolean selectable;
    private boolean selected;

    @NotNull
    private final String text;

    @Nullable
    private final String url;

    public SurveyChatOptionsModel(@NotNull String optionId, @NotNull String text, @Nullable String str, boolean z10, boolean z11) {
        s.i(optionId, "optionId");
        s.i(text, "text");
        this.optionId = optionId;
        this.text = text;
        this.url = str;
        this.selected = z10;
        this.selectable = z11;
    }

    public static /* synthetic */ SurveyChatOptionsModel copy$default(SurveyChatOptionsModel surveyChatOptionsModel, String str, String str2, String str3, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = surveyChatOptionsModel.optionId;
        }
        if ((i10 & 2) != 0) {
            str2 = surveyChatOptionsModel.text;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            str3 = surveyChatOptionsModel.url;
        }
        String str5 = str3;
        if ((i10 & 8) != 0) {
            z10 = surveyChatOptionsModel.selected;
        }
        boolean z12 = z10;
        if ((i10 & 16) != 0) {
            z11 = surveyChatOptionsModel.selectable;
        }
        return surveyChatOptionsModel.copy(str, str4, str5, z12, z11);
    }

    @NotNull
    public final String component1() {
        return this.optionId;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    public final boolean component4() {
        return this.selected;
    }

    public final boolean component5() {
        return this.selectable;
    }

    @NotNull
    public final SurveyChatOptionsModel copy(@NotNull String optionId, @NotNull String text, @Nullable String str, boolean z10, boolean z11) {
        s.i(optionId, "optionId");
        s.i(text, "text");
        return new SurveyChatOptionsModel(optionId, text, str, z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurveyChatOptionsModel)) {
            return false;
        }
        SurveyChatOptionsModel surveyChatOptionsModel = (SurveyChatOptionsModel) obj;
        return s.d(this.optionId, surveyChatOptionsModel.optionId) && s.d(this.text, surveyChatOptionsModel.text) && s.d(this.url, surveyChatOptionsModel.url) && this.selected == surveyChatOptionsModel.selected && this.selectable == surveyChatOptionsModel.selectable;
    }

    @NotNull
    public final String getOptionId() {
        return this.optionId;
    }

    public final boolean getSelectable() {
        return this.selectable;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.optionId.hashCode() * 31) + this.text.hashCode()) * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.selected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        boolean z11 = this.selectable;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setSelectable(boolean z10) {
        this.selectable = z10;
    }

    public final void setSelected(boolean z10) {
        this.selected = z10;
    }

    @NotNull
    public String toString() {
        return "SurveyChatOptionsModel(optionId=" + this.optionId + ", text=" + this.text + ", url=" + this.url + ", selected=" + this.selected + ", selectable=" + this.selectable + ")";
    }
}
