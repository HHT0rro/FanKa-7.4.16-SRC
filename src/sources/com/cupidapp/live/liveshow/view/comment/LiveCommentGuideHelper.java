package com.cupidapp.live.liveshow.view.comment;

import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveCommentGuideItemModel;
import com.cupidapp.live.liveshow.model.LiveCommentGuideModel;
import com.cupidapp.live.liveshow.model.LiveCommentGuideType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.profile.model.User;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveCommentGuideHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentGuideHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LiveCommentGuideHelper f15387a = new LiveCommentGuideHelper();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Function1<? super LiveCommentGuideType, p> f15388b;

    /* renamed from: c, reason: collision with root package name */
    public static int f15389c;

    /* renamed from: d, reason: collision with root package name */
    public static int f15390d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static i f15391e;

    /* renamed from: f, reason: collision with root package name */
    public static int f15392f;

    @Nullable
    public final Function1<LiveCommentGuideType, p> c() {
        return f15388b;
    }

    public final int d() {
        return f15389c;
    }

    public final int e() {
        return f15390d;
    }

    public final void f() {
        i iVar = f15391e;
        if (iVar != null) {
            iVar.g();
        }
        f15391e = null;
        f15392f = 0;
        f15389c = 0;
        f15390d = 0;
    }

    public final void g(@Nullable Function1<? super LiveCommentGuideType, p> function1) {
        f15388b = function1;
    }

    public final void h(int i10) {
        f15389c = i10;
    }

    public final void i(int i10) {
        f15390d = i10;
    }

    public final void j(@Nullable final LiveCommentGuideModel liveCommentGuideModel) {
        Integer duration;
        Integer duration2;
        Integer duration3;
        Integer duration4;
        User user;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (((liveShowModel == null || (user = liveShowModel.getUser()) == null || !user.getMe()) ? false : true) || liveCommentGuideModel == null) {
            return;
        }
        LiveCommentGuideItemModel alohaCommentGuide = liveCommentGuideModel.getAlohaCommentGuide();
        final int intValue = (alohaCommentGuide == null || (duration4 = alohaCommentGuide.getDuration()) == null) ? 0 : duration4.intValue();
        LiveCommentGuideItemModel alohaAlertGuide = liveCommentGuideModel.getAlohaAlertGuide();
        final int intValue2 = (alohaAlertGuide == null || (duration3 = alohaAlertGuide.getDuration()) == null) ? 0 : duration3.intValue();
        LiveCommentGuideItemModel commentGuide = liveCommentGuideModel.getCommentGuide();
        final int intValue3 = (commentGuide == null || (duration2 = commentGuide.getDuration()) == null) ? 0 : duration2.intValue();
        LiveCommentGuideItemModel giftGuide = liveCommentGuideModel.getGiftGuide();
        final int intValue4 = (giftGuide == null || (duration = giftGuide.getDuration()) == null) ? 0 : duration.intValue();
        Integer num = (Integer) CollectionsKt___CollectionsKt.g0(s.m(Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3), Integer.valueOf(intValue4)));
        if (num == null || num.intValue() <= 0) {
            return;
        }
        i iVar = new i();
        f15391e = iVar;
        kotlin.jvm.internal.s.f(iVar);
        i.d(iVar, num, 1, null, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveCommentGuideHelper$startCountDown$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num2) {
                invoke(num2.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                int i11;
                int i12;
                int i13;
                LiveShowModel liveShowModel2;
                Function1<LiveCommentGuideType, p> c4;
                Function1<LiveCommentGuideType, p> c10;
                Function1<LiveCommentGuideType, p> c11;
                Function1<LiveCommentGuideType, p> c12;
                LiveCommentGuideHelper liveCommentGuideHelper = LiveCommentGuideHelper.f15387a;
                i11 = LiveCommentGuideHelper.f15392f;
                LiveCommentGuideHelper.f15392f = i11 + 1;
                j.a aVar = j.f12332a;
                i12 = LiveCommentGuideHelper.f15392f;
                aVar.a("LiveCommentGuideHelper", "time: " + i12);
                i13 = LiveCommentGuideHelper.f15392f;
                if (i13 == intValue) {
                    LiveShowModel liveShowModel3 = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                    if (liveShowModel3 != null) {
                        LiveCommentGuideModel liveCommentGuideModel2 = liveCommentGuideModel;
                        if (liveShowModel3.getUser().getAloha()) {
                            return;
                        }
                        LiveCommentGuideItemModel alohaCommentGuide2 = liveCommentGuideModel2.getAlohaCommentGuide();
                        Integer commentCount = alohaCommentGuide2 != null ? alohaCommentGuide2.getCommentCount() : null;
                        if ((commentCount == null || commentCount.intValue() == 0 || liveCommentGuideHelper.d() < commentCount.intValue()) && (c12 = liveCommentGuideHelper.c()) != null) {
                            c12.invoke(LiveCommentGuideType.AlohaType);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i13 == intValue2) {
                    LiveShowModel liveShowModel4 = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                    if (liveShowModel4 == null || liveShowModel4.getUser().getAloha() || (c11 = liveCommentGuideHelper.c()) == null) {
                        return;
                    }
                    c11.invoke(LiveCommentGuideType.AlohaAlertType);
                    return;
                }
                if (i13 == intValue3) {
                    if (FKLiveConstantsData.INSTANCE.getLiveShowModel() == null || liveCommentGuideHelper.d() != 0 || (c10 = liveCommentGuideHelper.c()) == null) {
                        return;
                    }
                    c10.invoke(LiveCommentGuideType.ChatType);
                    return;
                }
                if (i13 == intValue4 && (liveShowModel2 = FKLiveConstantsData.INSTANCE.getLiveShowModel()) != null && liveShowModel2.getUser().getAloha() && liveCommentGuideHelper.e() == 0 && (c4 = liveCommentGuideHelper.c()) != null) {
                    c4.invoke(LiveCommentGuideType.SendGiftType);
                }
            }
        }, 4, null);
    }
}
