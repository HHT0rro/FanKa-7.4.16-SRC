package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.internal.os.PowerProfile;
import com.google.android.exoplayer2.d;

/* compiled from: AudioFocusManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager f19846a;

    /* renamed from: b, reason: collision with root package name */
    public final a f19847b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public b f19848c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public x4.d f19849d;

    /* renamed from: f, reason: collision with root package name */
    public int f19851f;

    /* renamed from: h, reason: collision with root package name */
    public AudioFocusRequest f19853h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f19854i;

    /* renamed from: g, reason: collision with root package name */
    public float f19852g = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public int f19850e = 0;

    /* compiled from: AudioFocusManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final Handler f19855b;

        public a(Handler handler) {
            this.f19855b = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i10) {
            d.this.h(i10);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i10) {
            this.f19855b.post(new Runnable() { // from class: com.google.android.exoplayer2.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.this.b(i10);
                }
            });
        }
    }

    /* compiled from: AudioFocusManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void r(float f10);

        void t(int i10);
    }

    public d(Context context, Handler handler, b bVar) {
        this.f19846a = (AudioManager) com.google.android.exoplayer2.util.a.e((AudioManager) context.getApplicationContext().getSystemService(PowerProfile.POWER_AUDIO));
        this.f19848c = bVar;
        this.f19847b = new a(handler);
    }

    public static int e(@Nullable x4.d dVar) {
        if (dVar == null) {
            return 0;
        }
        int i10 = dVar.f54388c;
        switch (i10) {
            case 0:
                com.google.android.exoplayer2.util.m.h("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (dVar.f54386a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Unidentified audio usage: ");
                sb2.append(i10);
                com.google.android.exoplayer2.util.m.h("AudioFocusManager", sb2.toString());
                return 0;
            case 16:
                return com.google.android.exoplayer2.util.j0.f22990a >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        this.f19846a.abandonAudioFocus(this.f19847b);
    }

    public final void b() {
        if (this.f19850e == 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.j0.f22990a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    @RequiresApi(26)
    public final void c() {
        AudioFocusRequest audioFocusRequest = this.f19853h;
        if (audioFocusRequest != null) {
            this.f19846a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public final void f(int i10) {
        b bVar = this.f19848c;
        if (bVar != null) {
            bVar.t(i10);
        }
    }

    public float g() {
        return this.f19852g;
    }

    public final void h(int i10) {
        if (i10 == -3 || i10 == -2) {
            if (i10 != -2 && !q()) {
                n(3);
                return;
            } else {
                f(0);
                n(2);
                return;
            }
        }
        if (i10 == -1) {
            f(-1);
            b();
        } else {
            if (i10 != 1) {
                StringBuilder sb2 = new StringBuilder(38);
                sb2.append("Unknown focus change type: ");
                sb2.append(i10);
                com.google.android.exoplayer2.util.m.h("AudioFocusManager", sb2.toString());
                return;
            }
            n(1);
            f(1);
        }
    }

    public void i() {
        this.f19848c = null;
        b();
    }

    public final int j() {
        if (this.f19850e == 1) {
            return 1;
        }
        if ((com.google.android.exoplayer2.util.j0.f22990a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    public final int k() {
        return this.f19846a.requestAudioFocus(this.f19847b, com.google.android.exoplayer2.util.j0.c0(((x4.d) com.google.android.exoplayer2.util.a.e(this.f19849d)).f54388c), this.f19851f);
    }

    @RequiresApi(26)
    public final int l() {
        AudioFocusRequest.Builder builder;
        AudioFocusRequest audioFocusRequest = this.f19853h;
        if (audioFocusRequest == null || this.f19854i) {
            if (audioFocusRequest == null) {
                builder = new AudioFocusRequest.Builder(this.f19851f);
            } else {
                builder = new AudioFocusRequest.Builder(this.f19853h);
            }
            this.f19853h = builder.setAudioAttributes(((x4.d) com.google.android.exoplayer2.util.a.e(this.f19849d)).a()).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.f19847b).build();
            this.f19854i = false;
        }
        return this.f19846a.requestAudioFocus(this.f19853h);
    }

    public void m(@Nullable x4.d dVar) {
        if (com.google.android.exoplayer2.util.j0.c(this.f19849d, dVar)) {
            return;
        }
        this.f19849d = dVar;
        int e2 = e(dVar);
        this.f19851f = e2;
        boolean z10 = true;
        if (e2 != 1 && e2 != 0) {
            z10 = false;
        }
        com.google.android.exoplayer2.util.a.b(z10, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void n(int i10) {
        if (this.f19850e == i10) {
            return;
        }
        this.f19850e = i10;
        float f10 = i10 == 3 ? 0.2f : 1.0f;
        if (this.f19852g == f10) {
            return;
        }
        this.f19852g = f10;
        b bVar = this.f19848c;
        if (bVar != null) {
            bVar.r(f10);
        }
    }

    public final boolean o(int i10) {
        return i10 == 1 || this.f19851f != 1;
    }

    public int p(boolean z10, int i10) {
        if (o(i10)) {
            b();
            return z10 ? 1 : -1;
        }
        if (z10) {
            return j();
        }
        return -1;
    }

    public final boolean q() {
        x4.d dVar = this.f19849d;
        return dVar != null && dVar.f54386a == 1;
    }
}
