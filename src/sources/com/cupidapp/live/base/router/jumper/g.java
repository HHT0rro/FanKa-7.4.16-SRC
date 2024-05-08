package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.club.activity.ClubListActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubListJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("listType");
        int i10 = 0;
        if (queryParameter != null) {
            int hashCode = queryParameter.hashCode();
            if (hashCode != -1655966961) {
                if (hashCode == 98629247) {
                    queryParameter.equals("group");
                }
            } else if (queryParameter.equals("activity")) {
                i10 = 1;
            }
        }
        ClubListActivity.f13485s.a(context, i10, SensorPosition.Web);
    }
}
