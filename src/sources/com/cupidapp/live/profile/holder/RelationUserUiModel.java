package com.cupidapp.live.profile.holder;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RelationUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RelationUserUiModel {

    @Nullable
    private final ImageModel avatarImage;

    @Nullable
    private final String lastOnline;

    @Nullable
    private final String location;
    private final boolean match;

    @Nullable
    private final String name;

    @NotNull
    private final RelationType relationType;
    private final boolean secret;

    @Nullable
    private final String summaryInfo;

    @NotNull
    private final User user;

    @NotNull
    private final String userId;

    public RelationUserUiModel(@NotNull User user, @NotNull String userId, @Nullable ImageModel imageModel, @Nullable String str, boolean z10, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11, @NotNull RelationType relationType) {
        s.i(user, "user");
        s.i(userId, "userId");
        s.i(relationType, "relationType");
        this.user = user;
        this.userId = userId;
        this.avatarImage = imageModel;
        this.name = str;
        this.match = z10;
        this.summaryInfo = str2;
        this.location = str3;
        this.lastOnline = str4;
        this.secret = z11;
        this.relationType = relationType;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getLastOnline() {
        return this.lastOnline;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    public final boolean getMatch() {
        return this.match;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final RelationType getRelationType() {
        return this.relationType;
    }

    public final boolean getSecret() {
        return this.secret;
    }

    @Nullable
    public final String getSummaryInfo() {
        return this.summaryInfo;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public /* synthetic */ RelationUserUiModel(User user, String str, ImageModel imageModel, String str2, boolean z10, String str3, String str4, String str5, boolean z11, RelationType relationType, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, imageModel, str2, (i10 & 16) != 0 ? false : z10, str3, str4, str5, (i10 & 256) != 0 ? false : z11, (i10 & 512) != 0 ? RelationType.Matched : relationType);
    }
}
