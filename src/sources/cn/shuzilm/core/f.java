package cn.shuzilm.core;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DUListener f1764b;

    public f(Context context, DUListener dUListener) {
        this.f1763a = context;
        this.f1764b = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        AIClient aIClient;
        AIClient aIClient2;
        AIClient aIClient3;
        AIClient aIClient4;
        AIClient aIClient5;
        AIClient unused;
        AIClient unused2;
        try {
            lock = DUHelper.f1684f;
            lock.lock();
            aIClient = DUHelper.f1681c;
            if (aIClient == null) {
                AIClient unused3 = DUHelper.f1681c = new AIClient(this.f1763a);
                aIClient5 = DUHelper.f1681c;
                aIClient5.asynAI();
            }
            unused = DUHelper.f1681c;
            if (!AIClient.isf) {
                aIClient4 = DUHelper.f1681c;
                aIClient4.asynAI();
            }
            unused2 = DUHelper.f1681c;
            if (AIClient.isf) {
                String str = null;
                String upperCase = Build.MANUFACTURER.toUpperCase();
                aIClient2 = DUHelper.f1681c;
                if (aIClient2.m(upperCase)) {
                    aIClient3 = DUHelper.f1681c;
                    str = DUHelper.zZVTFJRA(this.f1763a, aIClient3.cm(upperCase));
                }
                if (str == null) {
                    str = "NA";
                }
                this.f1764b.handle(str);
            } else {
                this.f1764b.handle("NA_F");
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
