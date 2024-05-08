package com.cupidapp.live.chat2.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MiniTitleModel implements Serializable {

    @NotNull
    private final String miniText;

    @Nullable
    private final String miniTextColor;

    @NotNull
    private final String miniTitle;

    public MiniTitleModel(@NotNull String miniTitle, @NotNull String miniText, @Nullable String str) {
        s.i(miniTitle, "miniTitle");
        s.i(miniText, "miniText");
        this.miniTitle = miniTitle;
        this.miniText = miniText;
        this.miniTextColor = str;
    }

    public static /* synthetic */ MiniTitleModel copy$default(MiniTitleModel miniTitleModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = miniTitleModel.miniTitle;
        }
        if ((i10 & 2) != 0) {
            str2 = miniTitleModel.miniText;
        }
        if ((i10 & 4) != 0) {
            str3 = miniTitleModel.miniTextColor;
        }
        return miniTitleModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.miniTitle;
    }

    @NotNull
    public final String component2() {
        return this.miniText;
    }

    @Nullable
    public final String component3() {
        return this.miniTextColor;
    }

    @NotNull
    public final MiniTitleModel copy(@NotNull String miniTitle, @NotNull String miniText, @Nullable String str) {
        s.i(miniTitle, "miniTitle");
        s.i(miniText, "miniText");
        return new MiniTitleModel(miniTitle, miniText, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniTitleModel)) {
            return false;
        }
        MiniTitleModel miniTitleModel = (MiniTitleModel) obj;
        return s.d(this.miniTitle, miniTitleModel.miniTitle) && s.d(this.miniText, miniTitleModel.miniText) && s.d(this.miniTextColor, miniTitleModel.miniTextColor);
    }

    @NotNull
    public final String getMiniText() {
        return this.miniText;
    }

    @Nullable
    public final String getMiniTextColor() {
        return this.miniTextColor;
    }

    @NotNull
    public final String getMiniTitle() {
        return this.miniTitle;
    }

    public int hashCode() {
        int hashCode = ((this.miniTitle.hashCode() * 31) + this.miniText.hashCode()) * 31;
        String str = this.miniTextColor;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "MiniTitleModel(miniTitle=" + this.miniTitle + ", miniText=" + this.miniText + ", miniTextColor=" + this.miniTextColor + ")";
    }
}
