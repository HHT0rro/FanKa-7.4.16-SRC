package com.cupidapp.live.base.router.jumper;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.scan.activity.ScanCodeActivity;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenQRScanUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenQRScanUrlJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        final String queryParameter = uri.getQueryParameter("completeCallback");
        if (queryParameter == null || queryParameter.length() == 0) {
            ScanCodeActivity.a.c(ScanCodeActivity.f17907u, context, null, 2, null);
        } else {
            ScanCodeActivity.f17907u.b(context, new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.OpenQRScanUrlJumper$jump$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(String str2) {
                    invoke2(str2);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str2) {
                    Context context2 = context;
                    Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                    com.cupidapp.live.base.utils.j.f12332a.a("OpenQRScanUrlJumper", "ac:" + ((Object) activity) + "  eventName:" + queryParameter + "  result:" + str2);
                    if (activity != null) {
                        com.cupidapp.live.base.web.bridge.b.f13062a.d(activity, queryParameter, kotlin.collections.i0.h(kotlin.f.a("result", str2)));
                    }
                }
            });
        }
    }
}
