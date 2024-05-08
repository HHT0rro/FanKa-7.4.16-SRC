package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushSelfShowThread.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f30450a;

    /* renamed from: b, reason: collision with root package name */
    private o f30451b;

    public p(Context context, o oVar) {
        this.f30450a = context;
        this.f30451b = oVar;
    }

    private static Intent a(Context context, o oVar) {
        if (oVar == null) {
            return null;
        }
        Intent b4 = e.b(context, oVar.c());
        if (oVar.m() != null) {
            try {
                Intent parseUri = Intent.parseUri(oVar.m(), 0);
                parseUri.setSelector(null);
                if (parseUri.getClipData() == null) {
                    parseUri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                }
                HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                return e.a(context, oVar.c(), parseUri).booleanValue() ? parseUri : b4;
            } catch (Exception e2) {
                HMSLog.w("PushSelfShowLog", "intentUri error," + e2.toString());
                return b4;
            }
        }
        if (oVar.a() != null) {
            Intent intent = new Intent(oVar.a());
            if (e.a(context, oVar.c(), intent).booleanValue()) {
                b4 = intent;
            }
        }
        b4.setPackage(oVar.c());
        return b4;
    }

    private boolean b(Context context) {
        if ("cosa".equals(this.f30451b.h())) {
            return a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.f30450a) || b(this.f30450a, this.f30451b)) {
                return;
            }
            n.a(this.f30450a, this.f30451b);
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", e2.toString());
        }
    }

    private boolean b(Context context, o oVar) {
        if (!"cosa".equals(oVar.h()) || a(context, oVar) != null) {
            return false;
        }
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    private boolean a(Context context) {
        return e.c(context, this.f30451b.c());
    }
}
