package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.model.UserRankModel;
import com.cupidapp.live.visitors.activity.VisitorWithRecordActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class y0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        Boolean visitorEnable;
        kotlin.jvm.internal.s.i(uri, "uri");
        String queryParameter = uri.getQueryParameter("source");
        String queryParameter2 = uri.getQueryParameter("entranceContent");
        j1.o oVar = j1.o.f50242a;
        UserRankModel c4 = p1.g.f52734a.F1().c();
        oVar.b((c4 == null || (visitorEnable = c4.getVisitorEnable()) == null) ? false : visitorEnable.booleanValue(), queryParameter, queryParameter2);
        VisitorWithRecordActivity.f18904t.a(context, b(queryParameter).getValue());
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
