package com.cupidapp.live.chat.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatStateFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStateModel {

    @Nullable
    private String pop;
    private boolean show;

    @Nullable
    private Integer status;

    public ChatStateModel(@Nullable Integer num, @Nullable String str, boolean z10) {
        this.status = num;
        this.pop = str;
        this.show = z10;
    }

    public static /* synthetic */ ChatStateModel copy$default(ChatStateModel chatStateModel, Integer num, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = chatStateModel.status;
        }
        if ((i10 & 2) != 0) {
            str = chatStateModel.pop;
        }
        if ((i10 & 4) != 0) {
            z10 = chatStateModel.show;
        }
        return chatStateModel.copy(num, str, z10);
    }

    @Nullable
    public final Integer component1() {
        return this.status;
    }

    @Nullable
    public final String component2() {
        return this.pop;
    }

    public final boolean component3() {
        return this.show;
    }

    @NotNull
    public final ChatStateModel copy(@Nullable Integer num, @Nullable String str, boolean z10) {
        return new ChatStateModel(num, str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatStateModel)) {
            return false;
        }
        ChatStateModel chatStateModel = (ChatStateModel) obj;
        return s.d(this.status, chatStateModel.status) && s.d(this.pop, chatStateModel.pop) && this.show == chatStateModel.show;
    }

    @Nullable
    public final String getPop() {
        return this.pop;
    }

    public final boolean getShow() {
        return this.show;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.status;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.pop;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z10 = this.show;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    public final void setPop(@Nullable String str) {
        this.pop = str;
    }

    public final void setShow(boolean z10) {
        this.show = z10;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    @NotNull
    public String toString() {
        Integer num = this.status;
        return "ChatStateModel(status=" + ((Object) num) + ", pop=" + this.pop + ", show=" + this.show + ")";
    }
}
