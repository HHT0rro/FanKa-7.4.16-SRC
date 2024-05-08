package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity;
import java.net.URLDecoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedClassifyDetailListJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class q implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tag");
        SensorPosition b4 = b(uri.getQueryParameter("source"));
        if (queryParameter != null) {
            String tagName = URLDecoder.decode(uri.getQueryParameter("tagName"), "UTF-8");
            String queryParameter2 = uri.getQueryParameter("tab");
            FeedClassifyDetailListActivity.a aVar = FeedClassifyDetailListActivity.f14021x;
            kotlin.jvm.internal.s.h(tagName, "tagName");
            aVar.a(context, queryParameter, tagName, queryParameter2, new FeedSensorContext(SensorPosition.FindPageCategory, b4, null, SensorScene.RecommendFeed));
        }
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
