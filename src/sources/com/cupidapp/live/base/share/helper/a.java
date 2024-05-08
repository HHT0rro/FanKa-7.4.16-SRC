package com.cupidapp.live.base.share.helper;

import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: AssembleShareOperateHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f12253a = new a();

    @NotNull
    public final List<SharePlatform> a(@NotNull User user) {
        s.i(user, "user");
        ArrayList arrayList = new ArrayList();
        if (user.getLocked() || user.getHasPrivacy()) {
            arrayList.add(SharePlatform.Copylink);
        }
        return arrayList;
    }

    @NotNull
    public final List<ShareOperateType> b(@NotNull User user) {
        ConstantsUrlModel urlModel;
        s.i(user, "user");
        ArrayList arrayList = new ArrayList();
        ConstantsResult q10 = g.f52734a.q();
        if ((q10 == null || (urlModel = q10.getUrlModel()) == null || !urlModel.showFeedSpread()) ? false : true) {
            arrayList.add(ShareOperateType.FEED_SPREAD);
        }
        if (user.getMe()) {
            return arrayList;
        }
        if (user.getBlock()) {
            arrayList.add(ShareOperateType.CANCEL_BLACK);
        } else if (!user.getLocked() && !s.d(user.getOfficialAccount(), Boolean.TRUE)) {
            arrayList.add(ShareOperateType.BLACK);
        }
        boolean z10 = (user.getLocked() || user.getHasPrivacy()) ? false : true;
        if (!user.getBlock()) {
            if (user.getFocus()) {
                arrayList.add(ShareOperateType.UN_FOCUS);
            } else if (z10) {
                arrayList.add(ShareOperateType.FOCUS);
            }
        }
        if (user.getCloseFriend()) {
            arrayList.add(ShareOperateType.UN_CLOSE_FRIEND);
        } else if (z10 && user.getMatch() && user.getAloha()) {
            arrayList.add(ShareOperateType.CLOSE_FRIEND);
        }
        if (user.getAloha()) {
            if (user.getSkipReceiveFeed()) {
                arrayList.add(ShareOperateType.LOOK_HIM);
            } else if (z10 && !s.d(user.getOfficialAccount(), Boolean.TRUE)) {
                arrayList.add(ShareOperateType.DONT_LOOK_HIM);
            }
        }
        if (user.getAloha()) {
            arrayList.add(ShareOperateType.DISLIKE_U);
        }
        if (!user.getLocked() && !s.d(user.getOfficialAccount(), Boolean.TRUE)) {
            arrayList.add(ShareOperateType.REPORT);
        }
        return arrayList;
    }

    public final boolean c(@NotNull User user) {
        s.i(user, "user");
        return !user.getLocked() || user.getBlock() || user.getFocus() || user.getSkipReceiveFeed() || user.getAloha();
    }
}
