package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.maskparty.activity.MaskPartyMatchActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class y implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        String value = b(uri.getQueryParameter("source")).getValue();
        String queryParameter = uri.getQueryParameter("startMatch");
        String queryParameter2 = uri.getQueryParameter("gameTypeList");
        List z02 = queryParameter2 != null ? StringsKt__StringsKt.z0(queryParameter2, new String[]{","}, false, 0, 6, null) : null;
        if (z02 != null) {
            ArrayList arrayList = new ArrayList(kotlin.collections.t.t(z02, 10));
            Iterator<E> iterator2 = z02.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(Integer.valueOf(z0.t.q((String) iterator2.next())));
            }
            MaskPartyMatchActivity.a.b(MaskPartyMatchActivity.f16245r, context, arrayList, kotlin.jvm.internal.s.d(queryParameter, "1"), false, value, 8, null);
        }
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
