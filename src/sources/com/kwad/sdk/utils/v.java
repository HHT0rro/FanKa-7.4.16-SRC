package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class v {
    private static Handler fS = new Handler(Looper.getMainLooper());
    private static volatile boolean HE = false;

    public static void O(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i10, long j10) {
        if (com.kwad.framework.a.a.adH.booleanValue() && !HE) {
            HE = true;
            View inflate = com.kwad.sdk.n.l.inflate(context, i10, null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            fS.postDelayed(new ay() { // from class: com.kwad.sdk.utils.v.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    v.access$002(false);
                }
            }, j10);
        }
    }

    public static /* synthetic */ boolean access$002(boolean z10) {
        HE = false;
        return false;
    }

    private static void b(Context context, String str, int i10) {
        a(context, str, i10, 800L);
    }

    public static void c(Context context, String str, long j10) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, long j10) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    public static void c(Context context, String str, int i10) {
        if (com.kwad.framework.a.a.adH.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }
}
