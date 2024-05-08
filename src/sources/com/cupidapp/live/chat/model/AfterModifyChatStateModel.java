package com.cupidapp.live.chat.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatStateFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AfterModifyChatStateModel {

    @Nullable
    private final String message;

    @Nullable
    private final Boolean reload;

    public AfterModifyChatStateModel(@Nullable Boolean bool, @Nullable String str) {
        this.reload = bool;
        this.message = str;
    }

    public static /* synthetic */ AfterModifyChatStateModel copy$default(AfterModifyChatStateModel afterModifyChatStateModel, Boolean bool, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = afterModifyChatStateModel.reload;
        }
        if ((i10 & 2) != 0) {
            str = afterModifyChatStateModel.message;
        }
        return afterModifyChatStateModel.copy(bool, str);
    }

    @Nullable
    public final Boolean component1() {
        return this.reload;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final AfterModifyChatStateModel copy(@Nullable Boolean bool, @Nullable String str) {
        return new AfterModifyChatStateModel(bool, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AfterModifyChatStateModel)) {
            return false;
        }
        AfterModifyChatStateModel afterModifyChatStateModel = (AfterModifyChatStateModel) obj;
        return s.d(this.reload, afterModifyChatStateModel.reload) && s.d(this.message, afterModifyChatStateModel.message);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getReload() {
        return this.reload;
    }

    public int hashCode() {
        Boolean bool = this.reload;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.message;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Boolean bool = this.reload;
        return "AfterModifyChatStateModel(reload=" + ((Object) bool) + ", message=" + this.message + ")";
    }
}
