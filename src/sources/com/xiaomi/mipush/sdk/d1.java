package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.jb;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d1 {
    public static <T extends jb<T, ?>> void a(Context context, gc.a aVar) {
        if (aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", aVar.g());
        intent.putExtra("action_cr_event_frequency", aVar.c());
        intent.putExtra("action_cr_perf_switch", aVar.h());
        intent.putExtra("action_cr_perf_frequency", aVar.e());
        intent.putExtra("action_cr_event_en", aVar.f());
        intent.putExtra("action_cr_max_file_size", aVar.d());
        h0.g(context).o(intent);
    }
}
