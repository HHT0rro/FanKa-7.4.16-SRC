package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.by;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ca extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ by f10009a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(by byVar, Looper looper) {
        super(looper);
        this.f10009a = byVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bs bsVar;
        boolean z10;
        Context context;
        bs bsVar2;
        boolean z11;
        boolean p10;
        String string = message.getData().getString(by.f9991n);
        bw bwVar = (bw) message.getData().getParcelable(by.f9990m);
        if (by.f9988k.equals(string)) {
            String e2 = bwVar.e();
            context = this.f10009a.f10002y;
            br brVar = new br(e2, context, bwVar);
            try {
                try {
                    by byVar = this.f10009a;
                    if (byVar.f9999u != by.f9997t) {
                        byVar.a(brVar);
                        brVar.a(by.f());
                        this.f10009a.a(true);
                    } else {
                        brVar.a();
                        brVar.a(by.f());
                        if (by.f9993p != null) {
                            by.f9993p.f9916b = bwVar.b();
                        }
                        this.f10009a.l();
                        z11 = this.f10009a.A;
                        if (z11) {
                            this.f10009a.A = false;
                            by byVar2 = this.f10009a;
                            p10 = byVar2.p();
                            byVar2.a(p10, "load remote file just downloaded");
                        }
                    }
                } catch (by.a e10) {
                    String str = "download apk file failed: " + e10.toString();
                    this.f10009a.a(false);
                    bsVar2 = this.f10009a.f10003z;
                    bsVar2.a(by.f9978a, str);
                }
                return;
            } finally {
                brVar.delete();
            }
        }
        bsVar = this.f10009a.f10003z;
        bsVar.a(by.f9978a, "mOnApkDownloadCompleted: download failed, code: " + string);
        this.f10009a.a(false);
        z10 = this.f10009a.A;
        if (z10) {
            this.f10009a.A = false;
            this.f10009a.a(false, "Refused to download remote for version...");
        }
    }
}
