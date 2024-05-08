package cn.shuzilm.core;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1765a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1766b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Listener f1767c;

    public g(Context context, int i10, Listener listener) {
        this.f1765a = context;
        this.f1766b = i10;
        this.f1767c = listener;
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
                AIClient unused3 = DUHelper.f1681c = new AIClient(this.f1765a);
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
                if (this.f1766b == 1) {
                    upperCase = "HUAWEI";
                }
                aIClient2 = DUHelper.f1681c;
                if (aIClient2.m(upperCase)) {
                    aIClient3 = DUHelper.f1681c;
                    str = DUHelper.zZVTFJRA(this.f1765a, aIClient3.cm(upperCase));
                }
                if (str == null) {
                    str = "NA";
                }
                this.f1767c.handler(str);
            } else {
                this.f1767c.handler("NA_F");
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
