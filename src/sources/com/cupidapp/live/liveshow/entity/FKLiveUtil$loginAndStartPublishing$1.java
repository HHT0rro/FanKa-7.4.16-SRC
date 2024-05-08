package com.cupidapp.live.liveshow.entity;

import android.view.View;
import com.cupidapp.live.liveshow.entity.j;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: FKLiveUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveUtil$loginAndStartPublishing$1 extends Lambda implements Function2<Boolean, Boolean, p> {
    public final /* synthetic */ LiveShowModel $liveShowModel;
    public final /* synthetic */ d $publisherCallback;
    public final /* synthetic */ View $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveUtil$loginAndStartPublishing$1(d dVar, LiveShowModel liveShowModel, View view) {
        super(2);
        this.$publisherCallback = dVar;
        this.$liveShowModel = liveShowModel;
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(View view, LiveShowModel liveShowModel, int i10, ZegoStreamInfo[] zegoStreamInfoArr) {
        s.i(view, "$view");
        s.i(liveShowModel, "$liveShowModel");
        if (i10 == 0) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "登陆房间成功 p0: " + i10 + "  p1 " + ((Object) zegoStreamInfoArr));
            j c4 = j.a.c(j.f14922f, null, 1, null);
            if (c4 != null) {
                c4.h(true);
                r2.i.f53231b.G(true);
                c4.B(new ZegoAvConfig(3));
                FKLiveUtil.f14913a.r(p1.g.f52734a.T());
                c4.P(view);
                c4.Q(liveShowModel.getStreamId(), "", 2);
                c4.H(1);
                c4.y();
                c4.z(false);
                c4.i(true);
                return;
            }
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "登陆房间失败 p0: " + i10 + "  p1 " + ((Object) zegoStreamInfoArr));
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool, Boolean bool2) {
        invoke(bool.booleanValue(), bool2.booleanValue());
        return p.f51048a;
    }

    public final void invoke(boolean z10, boolean z11) {
        j.a aVar = j.f14922f;
        j c4 = j.a.c(aVar, null, 1, null);
        if (c4 != null) {
            c4.J(this.$publisherCallback);
        }
        j c10 = j.a.c(aVar, null, 1, null);
        if (c10 != null) {
            String itemId = this.$liveShowModel.getItemId();
            final View view = this.$view;
            final LiveShowModel liveShowModel = this.$liveShowModel;
            c10.p(itemId, 1, new IZegoLoginCompletionCallback() { // from class: com.cupidapp.live.liveshow.entity.f
                @Override // com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback
                public final void onLoginCompletion(int i10, ZegoStreamInfo[] zegoStreamInfoArr) {
                    FKLiveUtil$loginAndStartPublishing$1.invoke$lambda$1(View.this, liveShowModel, i10, zegoStreamInfoArr);
                }
            });
        }
    }
}
