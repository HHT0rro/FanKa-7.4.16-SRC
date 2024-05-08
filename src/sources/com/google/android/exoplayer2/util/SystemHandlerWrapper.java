package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.HandlerWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SystemHandlerWrapper implements HandlerWrapper {

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("messagePool")
    public static final List<SystemMessage> f22935b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f22936a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class SystemMessage implements HandlerWrapper.Message {

        @Nullable
        private SystemHandlerWrapper handler;

        @Nullable
        private Message message;

        private SystemMessage() {
        }

        private void recycle() {
            this.message = null;
            this.handler = null;
            SystemHandlerWrapper.m(this);
        }

        @Override // com.google.android.exoplayer2.util.HandlerWrapper.Message
        public HandlerWrapper getTarget() {
            return (HandlerWrapper) a.e(this.handler);
        }

        public boolean sendAtFrontOfQueue(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) a.e(this.message));
            recycle();
            return sendMessageAtFrontOfQueue;
        }

        @Override // com.google.android.exoplayer2.util.HandlerWrapper.Message
        public void sendToTarget() {
            ((Message) a.e(this.message)).sendToTarget();
            recycle();
        }

        public SystemMessage setMessage(Message message, SystemHandlerWrapper systemHandlerWrapper) {
            this.message = message;
            this.handler = systemHandlerWrapper;
            return this;
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f22936a = handler;
    }

    public static SystemMessage l() {
        SystemMessage remove;
        List<SystemMessage> list = f22935b;
        synchronized (list) {
            if (list.isEmpty()) {
                remove = new SystemMessage();
            } else {
                remove = list.remove(list.size() - 1);
            }
        }
        return remove;
    }

    public static void m(SystemMessage systemMessage) {
        List<SystemMessage> list = f22935b;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(systemMessage);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message a(int i10) {
        return l().setMessage(this.f22936a.obtainMessage(i10), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean b(int i10) {
        return this.f22936a.hasMessages(i10);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message c(int i10, @Nullable Object obj) {
        return l().setMessage(this.f22936a.obtainMessage(i10, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void d(@Nullable Object obj) {
        this.f22936a.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message e(int i10, int i11, int i12) {
        return l().setMessage(this.f22936a.obtainMessage(i10, i11, i12), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean f(HandlerWrapper.Message message) {
        return ((SystemMessage) message).sendAtFrontOfQueue(this.f22936a);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message g(int i10, int i11, int i12, @Nullable Object obj) {
        return l().setMessage(this.f22936a.obtainMessage(i10, i11, i12, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean h(int i10) {
        return this.f22936a.sendEmptyMessage(i10);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean i(int i10, long j10) {
        return this.f22936a.sendEmptyMessageAtTime(i10, j10);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void j(int i10) {
        this.f22936a.removeMessages(i10);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean post(Runnable runnable) {
        return this.f22936a.post(runnable);
    }
}
