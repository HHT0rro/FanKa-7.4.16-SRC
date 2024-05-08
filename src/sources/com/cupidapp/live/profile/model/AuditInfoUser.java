package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AuditInfoUser implements Serializable {

    @Nullable
    private final ImageModel avatar;

    @Nullable
    private final String username;

    public AuditInfoUser(@Nullable String str, @Nullable ImageModel imageModel) {
        this.username = str;
        this.avatar = imageModel;
    }

    public static /* synthetic */ AuditInfoUser copy$default(AuditInfoUser auditInfoUser, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = auditInfoUser.username;
        }
        if ((i10 & 2) != 0) {
            imageModel = auditInfoUser.avatar;
        }
        return auditInfoUser.copy(str, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.username;
    }

    @Nullable
    public final ImageModel component2() {
        return this.avatar;
    }

    @NotNull
    public final AuditInfoUser copy(@Nullable String str, @Nullable ImageModel imageModel) {
        return new AuditInfoUser(str, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuditInfoUser)) {
            return false;
        }
        AuditInfoUser auditInfoUser = (AuditInfoUser) obj;
        return s.d(this.username, auditInfoUser.username) && s.d(this.avatar, auditInfoUser.avatar);
    }

    @Nullable
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.username;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.avatar;
        return hashCode + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AuditInfoUser(username=" + this.username + ", avatar=" + ((Object) this.avatar) + ")";
    }
}
