package com.cupidapp.live.push;

import com.cupidapp.live.club.model.ClubNewMessageConnectorMessageModel;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.FollowAnchorModel;
import com.cupidapp.live.maskparty.model.MaskPartyRecommendModel;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKGRPCMessageWatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b {
    void a(@NotNull FollowAnchorModel followAnchorModel);

    void b();

    void c(@NotNull ClubNewMessageConnectorMessageModel clubNewMessageConnectorMessageModel);

    void d(@NotNull MaskPartyRecommendModel maskPartyRecommendModel);

    void e(@NotNull FKPushModel fKPushModel);

    void f(@NotNull FKLiveHornModel fKLiveHornModel);
}
