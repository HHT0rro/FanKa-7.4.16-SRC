package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.model.ConsultLiveCategory;
import com.cupidapp.live.track.group.EnterConsultRoomSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PreviewVoiceRoomJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class o implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        boolean z10;
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null || com.cupidapp.live.liveshow.helper.a.f15073a.a()) {
            return;
        }
        String queryParameter = uri.getQueryParameter("roomId");
        String queryParameter2 = uri.getQueryParameter("type");
        ConsultLiveCategory[] values = ConsultLiveCategory.values();
        int length = values.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            } else {
                if (kotlin.jvm.internal.s.d(values[i10].getValue(), queryParameter2)) {
                    z10 = true;
                    break;
                }
                i10++;
            }
        }
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        if ((queryParameter2 == null || queryParameter2.length() == 0) || !z10) {
            return;
        }
        ConsultViewerActivity.f13732x.a(context, new ConsultViewerActivity.Config(queryParameter, queryParameter2, SensorPosition.Web.getValue(), EnterConsultRoomSource.Web.getSource(), null, 16, null));
    }
}
