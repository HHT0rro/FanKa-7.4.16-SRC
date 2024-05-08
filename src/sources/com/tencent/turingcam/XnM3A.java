package com.tencent.turingcam;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class XnM3A {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, spXPg> f45409a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f45410b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final CvowV f45411a;

        public spXPg(XnM3A xnM3A, HandlerThread handlerThread, CvowV cvowV) {
            super(handlerThread.getLooper());
            this.f45411a = cvowV;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                this.f45411a.a(message);
            } catch (Throwable th) {
                this.f45411a.a(th);
            }
        }
    }

    public XnM3A() {
        HandlerThread handlerThread = new HandlerThread("MFA-ASYNC-WORKER");
        this.f45410b = handlerThread;
        handlerThread.setPriority(10);
        this.f45410b.start();
        new Handler(this.f45410b.getLooper());
    }

    public void a(String str, int i10, long j10) {
        spXPg spxpg = this.f45409a.get(str);
        if (spxpg != null) {
            spxpg.sendEmptyMessageDelayed(i10, j10);
        }
    }

    public void a(String str, Message message) {
        spXPg spxpg = this.f45409a.get(str);
        if (spxpg != null) {
            spxpg.sendMessageDelayed(message, 0L);
        }
    }

    public void a(String str, int i10) {
        spXPg spxpg = this.f45409a.get(str);
        if (spxpg != null) {
            spxpg.removeMessages(i10);
        }
    }

    public String a(CvowV cvowV) {
        String uuid = UUID.randomUUID().toString();
        HandlerThread handlerThread = new HandlerThread("MFA-ASYNC-WORKER-" + uuid);
        handlerThread.start();
        this.f45409a.put(uuid, new spXPg(this, handlerThread, cvowV));
        return uuid;
    }
}
