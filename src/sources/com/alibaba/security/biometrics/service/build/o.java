package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;

/* compiled from: ABListenerOperator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class o implements n {

    /* renamed from: q, reason: collision with root package name */
    private static final String f2821q = "ABListenerOperator";

    /* renamed from: o, reason: collision with root package name */
    public a f2822o = new a(this);

    /* renamed from: p, reason: collision with root package name */
    public ALBiometricsService f2823p;

    /* compiled from: ABListenerOperator.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final o f2824a;

        public a(o oVar) {
            super(Looper.getMainLooper());
            this.f2824a = oVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ALBiometricsServiceEventListener aBEventListener = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener != null) {
                        aBEventListener.onDetectStart();
                        return;
                    }
                    return;
                case 2:
                    ALBiometricsServiceEventListener aBEventListener2 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener2 != null) {
                        aBEventListener2.onDetectContinue((ABImageResult) message.obj);
                        return;
                    }
                    return;
                case 3:
                    ALBiometricsServiceEventListener aBEventListener3 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener3 != null) {
                        aBEventListener3.onAdjustStart();
                        return;
                    }
                    return;
                case 4:
                    ALBiometricsServiceEventListener aBEventListener4 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener4 != null) {
                        aBEventListener4.onAdjustEnd();
                        return;
                    }
                    return;
                case 5:
                    ALBiometricsServiceEventListener aBEventListener5 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener5 != null) {
                        p pVar = (p) message.obj;
                        aBEventListener5.onActionStart(pVar.f2825a, pVar.f2826b, pVar.f2827c);
                        return;
                    }
                    return;
                case 6:
                    ALBiometricsServiceEventListener aBEventListener6 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener6 != null) {
                        p pVar2 = (p) message.obj;
                        aBEventListener6.onActionEnd(pVar2.f2825a, pVar2.f2826b, pVar2.f2827c);
                        return;
                    }
                    return;
                case 7:
                    ALBiometricsServiceEventListener aBEventListener7 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener7 != null) {
                        aBEventListener7.onRecognizeStart();
                        return;
                    }
                    return;
                case 8:
                    ALBiometricsServiceEventListener aBEventListener8 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener8 != null) {
                        aBEventListener8.onRecognizeEnd();
                        return;
                    }
                    return;
                case 9:
                    ALBiometricsServiceEventListener aBEventListener9 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener9 != null) {
                        aBEventListener9.onReflectStart();
                        return;
                    }
                    return;
                case 10:
                    ALBiometricsServiceEventListener aBEventListener10 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener10 != null) {
                        aBEventListener10.onReflectEnd();
                        return;
                    }
                    return;
                case 11:
                    ALBiometricsServiceEventListener aBEventListener11 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener11 != null) {
                        aBEventListener11.onFrameDetected((ABDetectFrame) message.obj);
                        return;
                    }
                    return;
                case 12:
                    ALBiometricsServiceEventListener aBEventListener12 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener12 != null) {
                        q qVar = (q) message.obj;
                        aBEventListener12.onMessage(qVar.f2828a, qVar.f2829b);
                        return;
                    }
                    return;
                case 13:
                    ALBiometricsServiceEventListener aBEventListener13 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener13 != null) {
                        q qVar2 = (q) message.obj;
                        aBEventListener13.onFinish(qVar2.f2828a, qVar2.f2829b);
                        return;
                    }
                    return;
                case 14:
                    ALBiometricsServiceEventListener aBEventListener14 = this.f2824a.f2823p.getABEventListener();
                    if (aBEventListener14 != null) {
                        aBEventListener14.onOldLogRecord((Bundle) message.obj);
                        return;
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public o(ALBiometricsService aLBiometricsService) {
        this.f2823p = aLBiometricsService;
    }

    private void a() {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onDetectStart();
        }
    }

    private void b(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onDetectContinue((ABImageResult) message.obj);
        }
    }

    private void c() {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onAdjustEnd();
        }
    }

    private void d(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            p pVar = (p) message.obj;
            aBEventListener.onActionEnd(pVar.f2825a, pVar.f2826b, pVar.f2827c);
        }
    }

    private void e() {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onRecognizeEnd();
        }
    }

    private void f() {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onReflectStart();
        }
    }

    private void g() {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onReflectEnd();
        }
    }

    private void h(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onOldLogRecord((Bundle) message.obj);
        }
    }

    private Message a(int i10) {
        return Message.obtain(this.f2822o, i10);
    }

    private void c(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            p pVar = (p) message.obj;
            aBEventListener.onActionStart(pVar.f2825a, pVar.f2826b, pVar.f2827c);
        }
    }

    private void e(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onFrameDetected((ABDetectFrame) message.obj);
        }
    }

    private void f(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            q qVar = (q) message.obj;
            aBEventListener.onMessage(qVar.f2828a, qVar.f2829b);
        }
    }

    private void g(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            q qVar = (q) message.obj;
            aBEventListener.onFinish(qVar.f2828a, qVar.f2829b);
        }
    }

    private Message a(int i10, Object obj) {
        return Message.obtain(this.f2822o, i10, obj);
    }

    private void b() {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onAdjustStart();
        }
    }

    private void d() {
        ALBiometricsServiceEventListener aBEventListener = this.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onRecognizeStart();
        }
    }

    public final void a(Message message) {
        if (message != null) {
            this.f2822o.sendMessage(message);
        }
    }

    private static /* synthetic */ void a(o oVar) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onDetectStart();
        }
    }

    private static /* synthetic */ void b(o oVar) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onAdjustStart();
        }
    }

    private static /* synthetic */ void c(o oVar) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onAdjustEnd();
        }
    }

    private static /* synthetic */ void d(o oVar) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onRecognizeStart();
        }
    }

    private static /* synthetic */ void e(o oVar) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onRecognizeEnd();
        }
    }

    private static /* synthetic */ void f(o oVar) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onReflectStart();
        }
    }

    private static /* synthetic */ void g(o oVar) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onReflectEnd();
        }
    }

    private static /* synthetic */ void a(o oVar, Message message) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onDetectContinue((ABImageResult) message.obj);
        }
    }

    private static /* synthetic */ void b(o oVar, Message message) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            p pVar = (p) message.obj;
            aBEventListener.onActionStart(pVar.f2825a, pVar.f2826b, pVar.f2827c);
        }
    }

    private static /* synthetic */ void c(o oVar, Message message) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            p pVar = (p) message.obj;
            aBEventListener.onActionEnd(pVar.f2825a, pVar.f2826b, pVar.f2827c);
        }
    }

    private static /* synthetic */ void d(o oVar, Message message) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onFrameDetected((ABDetectFrame) message.obj);
        }
    }

    private static /* synthetic */ void e(o oVar, Message message) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            q qVar = (q) message.obj;
            aBEventListener.onMessage(qVar.f2828a, qVar.f2829b);
        }
    }

    private static /* synthetic */ void f(o oVar, Message message) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            q qVar = (q) message.obj;
            aBEventListener.onFinish(qVar.f2828a, qVar.f2829b);
        }
    }

    private static /* synthetic */ void g(o oVar, Message message) {
        ALBiometricsServiceEventListener aBEventListener = oVar.f2823p.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onOldLogRecord((Bundle) message.obj);
        }
    }
}
