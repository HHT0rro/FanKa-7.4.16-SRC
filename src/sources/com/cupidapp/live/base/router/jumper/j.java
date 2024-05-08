package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity;
import com.cupidapp.live.profile.model.LookOtherPraiseBundleData;
import com.huawei.openalliance.ad.constant.as;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EditFriendPraiseJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter(as.f32242q);
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("fromShare", false);
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        LookOtherFriendPraiseActivity.f17633v.a(context, new LookOtherPraiseBundleData(queryParameter, booleanQueryParameter, SensorPosition.Web));
    }
}
