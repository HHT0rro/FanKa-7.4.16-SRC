package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* compiled from: AudioBecomingNoisyManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19835a;

    /* renamed from: b, reason: collision with root package name */
    public final a f19836b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19837c;

    /* compiled from: AudioBecomingNoisyManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a extends BroadcastReceiver implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC0186b f19838b;

        /* renamed from: c, reason: collision with root package name */
        public final Handler f19839c;

        public a(Handler handler, InterfaceC0186b interfaceC0186b) {
            this.f19839c = handler;
            this.f19838b = interfaceC0186b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f19839c.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f19837c) {
                this.f19838b.c();
            }
        }
    }

    /* compiled from: AudioBecomingNoisyManager.java */
    /* renamed from: com.google.android.exoplayer2.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0186b {
        void c();
    }

    public b(Context context, Handler handler, InterfaceC0186b interfaceC0186b) {
        this.f19835a = context.getApplicationContext();
        this.f19836b = new a(handler, interfaceC0186b);
    }

    public void b(boolean z10) {
        if (z10 && !this.f19837c) {
            this.f19835a.registerReceiver(this.f19836b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f19837c = true;
        } else {
            if (z10 || !this.f19837c) {
                return;
            }
            this.f19835a.unregisterReceiver(this.f19836b);
            this.f19837c = false;
        }
    }
}
