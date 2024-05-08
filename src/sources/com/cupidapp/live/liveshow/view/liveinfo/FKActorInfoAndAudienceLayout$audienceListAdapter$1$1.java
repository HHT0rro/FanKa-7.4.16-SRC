package com.cupidapp.live.liveshow.view.liveinfo;

import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.liveshow.adapter.LiveSeatItemModel;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKActorInfoAndAudienceLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKActorInfoAndAudienceLayout$audienceListAdapter$1$1 extends Lambda implements Function1<Object, p> {
    public static final FKActorInfoAndAudienceLayout$audienceListAdapter$1$1 INSTANCE = new FKActorInfoAndAudienceLayout$audienceListAdapter$1$1();

    public FKActorInfoAndAudienceLayout$audienceListAdapter$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Object obj) {
        invoke2(obj);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Object obj) {
        if (obj instanceof LiveSeatItemModel) {
            LiveSeatItemModel liveSeatItemModel = (LiveSeatItemModel) obj;
            GroupSocialLog.f18708a.u(SensorScene.Live.getValue(), liveSeatItemModel.getUserId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
            EventBus.c().l(new ShowLiveMiniProfileViewModel(liveSeatItemModel.getUserId(), SensorsLogMatch.AlohaGetPosition.AudienceList, null, false, false, false, 60, null));
        }
    }
}
