package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.match.activity.MatchFilterTimeCardActivity;
import com.cupidapp.live.match.activity.NormalRewardCardActivity;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TaskRewardUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class v0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        String queryParameter = uri.getQueryParameter("type");
        String queryParameter2 = uri.getQueryParameter(DBDefinition.TASK_ID);
        String queryParameter3 = uri.getQueryParameter("taskType");
        if (queryParameter2 != null) {
            if (kotlin.jvm.internal.s.d(queryParameter, "filterReward")) {
                MatchFilterTimeCardActivity.f16512u.a(context, queryParameter2, queryParameter3);
            } else {
                NormalRewardCardActivity.f16539u.a(context, queryParameter2, queryParameter3);
            }
        }
    }
}
