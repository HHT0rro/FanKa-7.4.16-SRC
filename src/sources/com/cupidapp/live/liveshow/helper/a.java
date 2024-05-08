package com.cupidapp.live.liveshow.helper;

import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.push.FKPushMessageModel;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import d4.b;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f15073a = new a();

    public final boolean a() {
        boolean z10 = FKLiveUtil.f14913a.b() != null;
        IVoiceEngine a10 = b.f48611a.a();
        return z10 || (a10 != null && a10.b());
    }

    public final boolean b(@Nullable FKPushMessageModel fKPushMessageModel) {
        if (!s.d(fKPushMessageModel != null ? fKPushMessageModel.getPushMessageType() : null, FKPushType.LiveShowStart.getType())) {
            if (!s.d(fKPushMessageModel != null ? fKPushMessageModel.getPushMessageType() : null, FKPushType.VoiceRoomStart.getType())) {
                return false;
            }
        }
        return true;
    }
}
