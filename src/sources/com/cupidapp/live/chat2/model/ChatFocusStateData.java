package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatFocusStateData {

    @Nullable
    private final Integer errorCode;

    @Nullable
    private final String errorMsg;
    private final boolean focus;
    private final boolean success;

    @NotNull
    private final String userId;

    public ChatFocusStateData(boolean z10, boolean z11, @NotNull String userId, @Nullable Integer num, @Nullable String str) {
        s.i(userId, "userId");
        this.success = z10;
        this.focus = z11;
        this.userId = userId;
        this.errorCode = num;
        this.errorMsg = str;
    }

    public static /* synthetic */ ChatFocusStateData copy$default(ChatFocusStateData chatFocusStateData, boolean z10, boolean z11, String str, Integer num, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = chatFocusStateData.success;
        }
        if ((i10 & 2) != 0) {
            z11 = chatFocusStateData.focus;
        }
        boolean z12 = z11;
        if ((i10 & 4) != 0) {
            str = chatFocusStateData.userId;
        }
        String str3 = str;
        if ((i10 & 8) != 0) {
            num = chatFocusStateData.errorCode;
        }
        Integer num2 = num;
        if ((i10 & 16) != 0) {
            str2 = chatFocusStateData.errorMsg;
        }
        return chatFocusStateData.copy(z10, z12, str3, num2, str2);
    }

    public final boolean component1() {
        return this.success;
    }

    public final boolean component2() {
        return this.focus;
    }

    @NotNull
    public final String component3() {
        return this.userId;
    }

    @Nullable
    public final Integer component4() {
        return this.errorCode;
    }

    @Nullable
    public final String component5() {
        return this.errorMsg;
    }

    @NotNull
    public final ChatFocusStateData copy(boolean z10, boolean z11, @NotNull String userId, @Nullable Integer num, @Nullable String str) {
        s.i(userId, "userId");
        return new ChatFocusStateData(z10, z11, userId, num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatFocusStateData)) {
            return false;
        }
        ChatFocusStateData chatFocusStateData = (ChatFocusStateData) obj;
        return this.success == chatFocusStateData.success && this.focus == chatFocusStateData.focus && s.d(this.userId, chatFocusStateData.userId) && s.d(this.errorCode, chatFocusStateData.errorCode) && s.d(this.errorMsg, chatFocusStateData.errorMsg);
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final boolean getFocus() {
        return this.focus;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z10 = this.success;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.focus;
        int hashCode = (((i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31) + this.userId.hashCode()) * 31;
        Integer num = this.errorCode;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.errorMsg;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        boolean z10 = this.success;
        boolean z11 = this.focus;
        String str = this.userId;
        Integer num = this.errorCode;
        return "ChatFocusStateData(success=" + z10 + ", focus=" + z11 + ", userId=" + str + ", errorCode=" + ((Object) num) + ", errorMsg=" + this.errorMsg + ")";
    }

    public /* synthetic */ ChatFocusStateData(boolean z10, boolean z11, String str, Integer num, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, z11, str, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str2);
    }
}
