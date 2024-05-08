package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.activity.ImagePasterActivity;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePasterJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImagePasterJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        final String queryParameter = uri.getQueryParameter("source");
        final String queryParameter2 = uri.getQueryParameter("title");
        String queryParameter3 = uri.getQueryParameter("tagId");
        String queryParameter4 = uri.getQueryParameter("tagName");
        HashTagSimpleModel hashTagSimpleModel = (queryParameter3 == null || queryParameter4 == null) ? null : new HashTagSimpleModel(queryParameter3, queryParameter4);
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            final HashTagSimpleModel hashTagSimpleModel2 = hashTagSimpleModel;
            FKRxPermissionAlertDialog.f12016a.m(fragmentActivity, new xb.b(fragmentActivity), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.ImagePasterJumper$jump$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SensorsLogFeed.f12208a.A(SensorScene.Feed, ImagePasterJumper.this.b(queryParameter), queryParameter2);
                    ImagePasterActivity.f17098v.a(context, queryParameter2, hashTagSimpleModel2);
                }
            }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
        }
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
