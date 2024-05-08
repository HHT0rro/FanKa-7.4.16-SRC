package com.cupidapp.live.consult.model;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCommentModel implements Serializable {

    @NotNull
    private final String itemId;

    @Nullable
    private final String message;

    @Nullable
    private final String reportData;

    @Nullable
    private final String senderName;

    @Nullable
    private final String type;

    @Nullable
    private final User user;

    public ConsultCommentModel(@Nullable User user, @Nullable String str, @NotNull String itemId, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.i(itemId, "itemId");
        this.user = user;
        this.senderName = str;
        this.itemId = itemId;
        this.message = str2;
        this.reportData = str3;
        this.type = str4;
    }

    public static /* synthetic */ ConsultCommentModel copy$default(ConsultCommentModel consultCommentModel, User user, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = consultCommentModel.user;
        }
        if ((i10 & 2) != 0) {
            str = consultCommentModel.senderName;
        }
        String str6 = str;
        if ((i10 & 4) != 0) {
            str2 = consultCommentModel.itemId;
        }
        String str7 = str2;
        if ((i10 & 8) != 0) {
            str3 = consultCommentModel.message;
        }
        String str8 = str3;
        if ((i10 & 16) != 0) {
            str4 = consultCommentModel.reportData;
        }
        String str9 = str4;
        if ((i10 & 32) != 0) {
            str5 = consultCommentModel.type;
        }
        return consultCommentModel.copy(user, str6, str7, str8, str9, str5);
    }

    @Nullable
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.senderName;
    }

    @NotNull
    public final String component3() {
        return this.itemId;
    }

    @Nullable
    public final String component4() {
        return this.message;
    }

    @Nullable
    public final String component5() {
        return this.reportData;
    }

    @Nullable
    public final String component6() {
        return this.type;
    }

    @NotNull
    public final ConsultCommentModel copy(@Nullable User user, @Nullable String str, @NotNull String itemId, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.i(itemId, "itemId");
        return new ConsultCommentModel(user, str, itemId, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultCommentModel)) {
            return false;
        }
        ConsultCommentModel consultCommentModel = (ConsultCommentModel) obj;
        return s.d(this.user, consultCommentModel.user) && s.d(this.senderName, consultCommentModel.senderName) && s.d(this.itemId, consultCommentModel.itemId) && s.d(this.message, consultCommentModel.message) && s.d(this.reportData, consultCommentModel.reportData) && s.d(this.type, consultCommentModel.type);
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getSenderName() {
        return this.senderName;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        String str = this.senderName;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.itemId.hashCode()) * 31;
        String str2 = this.message;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reportData;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "ConsultCommentModel(user=" + ((Object) user) + ", senderName=" + this.senderName + ", itemId=" + this.itemId + ", message=" + this.message + ", reportData=" + this.reportData + ", type=" + this.type + ")";
    }
}
