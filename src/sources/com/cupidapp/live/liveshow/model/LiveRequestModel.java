package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveRequestModel {

    @Nullable
    private final String connectType;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f15101id;

    @Nullable
    private final User user;

    public LiveRequestModel(@Nullable User user, @Nullable String str, @Nullable String str2) {
        this.user = user;
        this.f15101id = str;
        this.connectType = str2;
    }

    public static /* synthetic */ LiveRequestModel copy$default(LiveRequestModel liveRequestModel, User user, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = liveRequestModel.user;
        }
        if ((i10 & 2) != 0) {
            str = liveRequestModel.f15101id;
        }
        if ((i10 & 4) != 0) {
            str2 = liveRequestModel.connectType;
        }
        return liveRequestModel.copy(user, str, str2);
    }

    @Nullable
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.f15101id;
    }

    @Nullable
    public final String component3() {
        return this.connectType;
    }

    @NotNull
    public final LiveRequestModel copy(@Nullable User user, @Nullable String str, @Nullable String str2) {
        return new LiveRequestModel(user, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveRequestModel)) {
            return false;
        }
        LiveRequestModel liveRequestModel = (LiveRequestModel) obj;
        return s.d(this.user, liveRequestModel.user) && s.d(this.f15101id, liveRequestModel.f15101id) && s.d(this.connectType, liveRequestModel.connectType);
    }

    @Nullable
    public final String getConnectType() {
        return this.connectType;
    }

    @Nullable
    public final String getId() {
        return this.f15101id;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        String str = this.f15101id;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.connectType;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "LiveRequestModel(user=" + ((Object) user) + ", id=" + this.f15101id + ", connectType=" + this.connectType + ")";
    }
}
