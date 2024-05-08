package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.hashtag.detail.HashTagMainActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagMainJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class t implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("newhashname");
        String path = uri.getPath();
        String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
        if (A == null || A.length() == 0) {
            return;
        }
        SensorPosition sensorPosition = SensorPosition.HashtagHot;
        SensorPosition sensorPosition2 = SensorPosition.Unknown;
        HashTagMainActivity.A.a(context, A, queryParameter, new FeedSensorContext(sensorPosition, sensorPosition2, sensorPosition2, SensorScene.Hashtag));
    }
}