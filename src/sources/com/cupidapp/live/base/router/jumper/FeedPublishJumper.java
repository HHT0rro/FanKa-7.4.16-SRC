package com.cupidapp.live.base.router.jumper;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.activity.MediaPickerActivity;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.model.MediaPickerActivityModel;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import java.net.URLDecoder;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedPublishJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedPublishJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        String queryParameter = uri.getQueryParameter("source");
        String queryParameter2 = uri.getQueryParameter("tagId");
        String queryParameter3 = uri.getQueryParameter("tagName");
        String queryParameter4 = uri.getQueryParameter("title");
        HashTagSimpleModel hashTagSimpleModel = (queryParameter2 == null || queryParameter3 == null) ? null : new HashTagSimpleModel(queryParameter2, queryParameter3);
        SensorPosition b4 = b(queryParameter);
        MediaType mediaType = MediaType.ALL;
        CameraStartPosition cameraStartPosition = CameraStartPosition.FeedPublish;
        try {
            queryParameter4 = URLDecoder.decode(queryParameter4, "utf-8");
        } catch (Exception unused) {
        }
        final MediaPickerActivityModel mediaPickerActivityModel = new MediaPickerActivityModel(hashTagSimpleModel, false, -1, mediaType, null, null, null, queryParameter4, b4, cameraStartPosition, 114, null);
        if (context == null || !(context instanceof FragmentActivity)) {
            return;
        }
        FKRxPermissionAlertDialog.f12016a.m(context, new xb.b((FragmentActivity) context), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.FeedPublishJumper$jump$1$1
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
                MediaPickerActivity.A.a((Activity) context, mediaPickerActivityModel);
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
