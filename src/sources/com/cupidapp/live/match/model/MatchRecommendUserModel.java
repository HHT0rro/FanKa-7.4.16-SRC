package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchRecommendUserModel extends MatchRecommendModel {

    @Nullable
    private final ImageModel alohaGetIcon;
    private final boolean alohaGetTipView;

    @Nullable
    private final Boolean avatarWindowTipShow;
    private final boolean fakeTipView;
    private final boolean isOfficial;

    @Nullable
    private final LiveShowModel liveShow;

    @Nullable
    private final List<MatchCardItemModel> multiAvatars;

    @NotNull
    private final User user;

    public /* synthetic */ MatchRecommendUserModel(boolean z10, ImageModel imageModel, boolean z11, User user, Boolean bool, List list, boolean z12, LiveShowModel liveShowModel, String str, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, imageModel, (i10 & 4) != 0 ? false : z11, user, (i10 & 16) != 0 ? null : bool, (i10 & 32) != 0 ? null : list, (i10 & 64) != 0 ? false : z12, liveShowModel, str, (i10 & 512) != 0 ? null : map);
    }

    @Nullable
    public final ImageModel getAlohaGetIcon() {
        return this.alohaGetIcon;
    }

    public final boolean getAlohaGetTipView() {
        return this.alohaGetTipView;
    }

    @Nullable
    public final Boolean getAvatarWindowTipShow() {
        return this.avatarWindowTipShow;
    }

    public final boolean getFakeTipView() {
        return this.fakeTipView;
    }

    @Nullable
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    @Nullable
    public final List<MatchCardItemModel> getMultiAvatars() {
        return this.multiAvatars;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public final boolean isOfficial() {
        return this.isOfficial;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchRecommendUserModel(boolean z10, @Nullable ImageModel imageModel, boolean z11, @NotNull User user, @Nullable Boolean bool, @Nullable List<MatchCardItemModel> list, boolean z12, @Nullable LiveShowModel liveShowModel, @NotNull String type, @Nullable Map<String, ? extends Object> map) {
        super(type, map);
        s.i(user, "user");
        s.i(type, "type");
        this.alohaGetTipView = z10;
        this.alohaGetIcon = imageModel;
        this.fakeTipView = z11;
        this.user = user;
        this.avatarWindowTipShow = bool;
        this.multiAvatars = list;
        this.isOfficial = z12;
        this.liveShow = liveShowModel;
    }
}
