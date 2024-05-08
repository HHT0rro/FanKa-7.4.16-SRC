package com.cupidapp.live.chat.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatRecommendModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatRecommendModel {
    private final boolean alert;

    @Nullable
    private final List<User> list;

    @Nullable
    private final String message;

    @Nullable
    private final User user;

    public ChatRecommendModel(@Nullable User user, @Nullable List<User> list, boolean z10, @Nullable String str) {
        this.user = user;
        this.list = list;
        this.alert = z10;
        this.message = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatRecommendModel copy$default(ChatRecommendModel chatRecommendModel, User user, List list, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = chatRecommendModel.user;
        }
        if ((i10 & 2) != 0) {
            list = chatRecommendModel.list;
        }
        if ((i10 & 4) != 0) {
            z10 = chatRecommendModel.alert;
        }
        if ((i10 & 8) != 0) {
            str = chatRecommendModel.message;
        }
        return chatRecommendModel.copy(user, list, z10, str);
    }

    @Nullable
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final List<User> component2() {
        return this.list;
    }

    public final boolean component3() {
        return this.alert;
    }

    @Nullable
    public final String component4() {
        return this.message;
    }

    @NotNull
    public final ChatRecommendModel copy(@Nullable User user, @Nullable List<User> list, boolean z10, @Nullable String str) {
        return new ChatRecommendModel(user, list, z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatRecommendModel)) {
            return false;
        }
        ChatRecommendModel chatRecommendModel = (ChatRecommendModel) obj;
        return s.d(this.user, chatRecommendModel.user) && s.d(this.list, chatRecommendModel.list) && this.alert == chatRecommendModel.alert && s.d(this.message, chatRecommendModel.message);
    }

    public final boolean getAlert() {
        return this.alert;
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        List<User> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z10 = this.alert;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        String str = this.message;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        List<User> list = this.list;
        return "ChatRecommendModel(user=" + ((Object) user) + ", list=" + ((Object) list) + ", alert=" + this.alert + ", message=" + this.message + ")";
    }
}
