package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class i0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f47022a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(h0 h0Var, Looper looper) {
        super(looper);
        this.f47022a = h0Var;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        h0 h0Var;
        Context context5;
        HashMap<String, String> c4;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        h0 h0Var2;
        Context context13;
        Context context14;
        if (message.what != 19) {
            return;
        }
        String str = (String) message.obj;
        int i10 = message.arg1;
        synchronized (z.class) {
            context = this.f47022a.f47010b;
            if (z.b(context).f(str)) {
                context2 = this.f47022a.f47010b;
                if (z.b(context2).a(str) < 10) {
                    av avVar = av.DISABLE_PUSH;
                    if (avVar.ordinal() == i10) {
                        context14 = this.f47022a.f47010b;
                        if ("syncing".equals(z.b(context14).c(avVar))) {
                            h0Var2 = this.f47022a;
                            h0Var2.A(str, avVar, true, null);
                            context13 = this.f47022a.f47010b;
                            z.b(context13).g(str);
                        }
                    }
                    avVar = av.ENABLE_PUSH;
                    if (avVar.ordinal() == i10) {
                        context12 = this.f47022a.f47010b;
                        if ("syncing".equals(z.b(context12).c(avVar))) {
                            h0Var2 = this.f47022a;
                            h0Var2.A(str, avVar, true, null);
                            context13 = this.f47022a.f47010b;
                            z.b(context13).g(str);
                        }
                    }
                    av avVar2 = av.UPLOAD_HUAWEI_TOKEN;
                    if (avVar2.ordinal() == i10) {
                        context10 = this.f47022a.f47010b;
                        if ("syncing".equals(z.b(context10).c(avVar2))) {
                            h0Var = this.f47022a;
                            context11 = h0Var.f47010b;
                            c4 = t0.c(context11, d.ASSEMBLE_PUSH_HUAWEI);
                            h0Var.A(str, avVar2, false, c4);
                            context13 = this.f47022a.f47010b;
                            z.b(context13).g(str);
                        }
                    }
                    avVar2 = av.UPLOAD_FCM_TOKEN;
                    if (avVar2.ordinal() == i10) {
                        context8 = this.f47022a.f47010b;
                        if ("syncing".equals(z.b(context8).c(avVar2))) {
                            h0Var = this.f47022a;
                            context9 = h0Var.f47010b;
                            c4 = t0.c(context9, d.ASSEMBLE_PUSH_FCM);
                            h0Var.A(str, avVar2, false, c4);
                            context13 = this.f47022a.f47010b;
                            z.b(context13).g(str);
                        }
                    }
                    avVar2 = av.UPLOAD_COS_TOKEN;
                    if (avVar2.ordinal() == i10) {
                        context6 = this.f47022a.f47010b;
                        if ("syncing".equals(z.b(context6).c(avVar2))) {
                            h0Var = this.f47022a;
                            context7 = h0Var.f47010b;
                            c4 = t0.c(context7, d.ASSEMBLE_PUSH_COS);
                            h0Var.A(str, avVar2, false, c4);
                            context13 = this.f47022a.f47010b;
                            z.b(context13).g(str);
                        }
                    }
                    avVar2 = av.UPLOAD_FTOS_TOKEN;
                    if (avVar2.ordinal() == i10) {
                        context4 = this.f47022a.f47010b;
                        if ("syncing".equals(z.b(context4).c(avVar2))) {
                            h0Var = this.f47022a;
                            context5 = h0Var.f47010b;
                            c4 = t0.c(context5, d.ASSEMBLE_PUSH_FTOS);
                            h0Var.A(str, avVar2, false, c4);
                        }
                    }
                    context13 = this.f47022a.f47010b;
                    z.b(context13).g(str);
                } else {
                    context3 = this.f47022a.f47010b;
                    z.b(context3).h(str);
                }
            }
        }
    }
}
