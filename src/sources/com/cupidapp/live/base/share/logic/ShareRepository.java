package com.cupidapp.live.base.share.logic;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.BaseShareItemModel;
import com.cupidapp.live.base.share.model.CustomShareItemModel;
import com.cupidapp.live.base.share.model.FKShareItemModel;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.web.model.ClubActivityInfoModel;
import com.cupidapp.live.vip.model.VipType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: ShareRepository.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareRepository {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<ShareBaseType, FKShareItemModel> f12259a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Map<ShareOperateType, CustomShareItemModel> f12260b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Map<ShareOperateType, FKShareItemModel> f12261c;

    /* compiled from: ShareRepository.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12262a;

        static {
            int[] iArr = new int[ShareOperateType.values().length];
            try {
                iArr[ShareOperateType.CLUB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f12262a = iArr;
        }
    }

    public ShareRepository() {
        SharePlatform sharePlatform = SharePlatform.Wechat;
        SharePlatform sharePlatform2 = SharePlatform.WechatMoments;
        SharePlatform sharePlatform3 = SharePlatform.QQ;
        SharePlatform sharePlatform4 = SharePlatform.QZone;
        SharePlatform sharePlatform5 = SharePlatform.Weibo;
        SharePlatform sharePlatform6 = SharePlatform.Copylink;
        this.f12259a = i0.h(new Pair(sharePlatform, new FKShareItemModel(sharePlatform, R$string.wechat_friend, R$mipmap.icon_wechat, false, null, 24, null)), new Pair(sharePlatform2, new FKShareItemModel(sharePlatform2, R$string.wechat_timeline, R$mipmap.icon_wechat_timeline, false, null, 24, null)), new Pair(sharePlatform3, new FKShareItemModel(sharePlatform3, R$string.qq, R$mipmap.icon_qq, false, null, 24, null)), new Pair(sharePlatform4, new FKShareItemModel(sharePlatform4, R$string.qq_zone, R$mipmap.icon_qqzone, false, null, 24, null)), new Pair(sharePlatform5, new FKShareItemModel(sharePlatform5, R$string.weibo, R$mipmap.icon_xinlang_weibo, false, null, 24, null)), new Pair(sharePlatform6, new FKShareItemModel(sharePlatform6, R$string.copy_link, R$mipmap.icon_copylink, false, null, 24, null)));
        ShareOperateType shareOperateType = ShareOperateType.CLUB;
        this.f12260b = i0.h(new Pair(shareOperateType, new CustomShareItemModel(shareOperateType, null, 2, null)));
        ShareOperateType shareOperateType2 = ShareOperateType.FEED_SPREAD;
        g gVar = g.f52734a;
        Boolean n12 = gVar.n1();
        Boolean bool = Boolean.TRUE;
        ShareOperateType shareOperateType3 = ShareOperateType.FEED_TOP;
        VipType vipType = VipType.NORMAL;
        ShareOperateType shareOperateType4 = ShareOperateType.FEED_CANCEL_TOP;
        ShareOperateType shareOperateType5 = ShareOperateType.FOCUS;
        ShareOperateType shareOperateType6 = ShareOperateType.UN_FOCUS;
        ShareOperateType shareOperateType7 = ShareOperateType.CLOSE_FRIEND;
        ShareOperateType shareOperateType8 = ShareOperateType.UN_CLOSE_FRIEND;
        ShareOperateType shareOperateType9 = ShareOperateType.UN_PRIVATE;
        ShareOperateType shareOperateType10 = ShareOperateType.PRIVATE;
        ShareOperateType shareOperateType11 = ShareOperateType.DISLIKE_U;
        ShareOperateType shareOperateType12 = ShareOperateType.DISINTEREST;
        ShareOperateType shareOperateType13 = ShareOperateType.DONT_LOOK_HIM;
        ShareOperateType shareOperateType14 = ShareOperateType.LOOK_HIM;
        ShareOperateType shareOperateType15 = ShareOperateType.DOWNLOAD_IMAGE;
        ShareOperateType shareOperateType16 = ShareOperateType.DELETE;
        ShareOperateType shareOperateType17 = ShareOperateType.BLACK;
        ShareOperateType shareOperateType18 = ShareOperateType.CANCEL_BLACK;
        ShareOperateType shareOperateType19 = ShareOperateType.REPORT;
        ShareOperateType shareOperateType20 = ShareOperateType.REDUCE_RECOMMEND;
        this.f12261c = i0.h(new Pair(shareOperateType2, new FKShareItemModel(shareOperateType2, R$string.to_feed_spread, R$mipmap.icon_spread_feed, s.d(n12, bool), null, 16, null)), new Pair(shareOperateType3, new FKShareItemModel(shareOperateType3, R$string.set_top, R$mipmap.ic_share_feed_top, false, vipType, 8, null)), new Pair(shareOperateType4, new FKShareItemModel(shareOperateType4, R$string.cancel_top, R$mipmap.ic_share_feed_cancel_top, false, vipType, 8, null)), new Pair(shareOperateType5, new FKShareItemModel(shareOperateType5, R$string.set_focus, R$mipmap.icon_focus, s.d(gVar.m1(), bool), null, 16, null)), new Pair(shareOperateType6, new FKShareItemModel(shareOperateType6, R$string.set_unfocus, R$mipmap.icon_unfocus, false, null, 24, null)), new Pair(shareOperateType7, new FKShareItemModel(shareOperateType7, R$string.set_close_friend, R$mipmap.icon_close_friend, false, null, 24, null)), new Pair(shareOperateType8, new FKShareItemModel(shareOperateType8, R$string.un_close_friend, R$mipmap.icon_un_close_friend, false, null, 24, null)), new Pair(shareOperateType9, new FKShareItemModel(shareOperateType9, R$string.all_can_see, R$mipmap.ic_unlock, false, null, 24, null)), new Pair(shareOperateType10, new FKShareItemModel(shareOperateType10, R$string.see_myself, R$mipmap.icon_lock, false, null, 24, null)), new Pair(shareOperateType11, new FKShareItemModel(shareOperateType11, R$string.cancel_follow, R$mipmap.icon_unlike, false, null, 24, null)), new Pair(shareOperateType12, new FKShareItemModel(shareOperateType12, R$string.no_interest, R$mipmap.icon_no_interest, false, null, 24, null)), new Pair(shareOperateType13, new FKShareItemModel(shareOperateType13, R$string.dont_look_him, R$mipmap.icon_dont_look_him, false, null, 24, null)), new Pair(shareOperateType14, new FKShareItemModel(shareOperateType14, R$string.look_him, R$mipmap.icon_look_him, false, null, 24, null)), new Pair(shareOperateType15, new FKShareItemModel(shareOperateType15, R$string.save_img_local, R$mipmap.icon_save_image, false, null, 24, null)), new Pair(shareOperateType16, new FKShareItemModel(shareOperateType16, R$string.delete, R$mipmap.icon_delete, false, null, 24, null)), new Pair(shareOperateType17, new FKShareItemModel(shareOperateType17, R$string.add_to_blacklist, R$mipmap.icon_black_member, false, null, 24, null)), new Pair(shareOperateType18, new FKShareItemModel(shareOperateType18, R$string.remove_blacklist, R$mipmap.icon_remove_black, false, null, 24, null)), new Pair(shareOperateType19, new FKShareItemModel(shareOperateType19, R$string.report, R$mipmap.icon_report, false, null, 24, null)), new Pair(shareOperateType20, new FKShareItemModel(shareOperateType20, R$string.reduce_recommend_to_me, R$mipmap.icon_reduce_rcmd, false, null, 24, null)));
    }

    @NotNull
    public final Collection<BaseShareItemModel> a(@Nullable Map<ShareOperateType, ? extends Object> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ShareOperateType, CustomShareItemModel> entry : this.f12260b.entrySet()) {
            if (map != null && map.containsKey(entry.getKey())) {
                d(entry.getKey(), map.get(entry.getKey()));
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    @NotNull
    public final Collection<FKShareItemModel> b(@Nullable List<? extends ShareOperateType> list) {
        Map<ShareOperateType, FKShareItemModel> map = this.f12261c;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<ShareOperateType, FKShareItemModel> entry : map.entrySet()) {
            if (list != null && list.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.values();
    }

    @NotNull
    public final Collection<FKShareItemModel> c(@Nullable List<? extends SharePlatform> list) {
        if (list != null) {
            Iterator<? extends SharePlatform> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                this.f12259a.remove(iterator2.next());
            }
        }
        return this.f12259a.values();
    }

    public final void d(ShareOperateType shareOperateType, Object obj) {
        CustomShareItemModel customShareItemModel;
        if (a.f12262a[shareOperateType.ordinal()] != 1 || (customShareItemModel = this.f12260b.get(shareOperateType)) == null) {
            return;
        }
        customShareItemModel.setClubActivityInfo(obj instanceof ClubActivityInfoModel ? (ClubActivityInfoModel) obj : null);
    }

    public final void e(@NotNull SharePlatform type, @NotNull ShareBuilder shareBuilder, @NotNull SensorPosition sensorPosition) {
        s.i(type, "type");
        s.i(shareBuilder, "shareBuilder");
        s.i(sensorPosition, "sensorPosition");
        com.cupidapp.live.base.share.helper.d.f12255a.o(type, shareBuilder, sensorPosition);
    }
}
