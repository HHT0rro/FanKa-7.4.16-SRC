package com.alibaba.security.biometrics.build;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.build.k;
import com.alibaba.security.common.log.RPLogging;
import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.util.Locale;

/* compiled from: MediaService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aa implements y {

    /* renamed from: h, reason: collision with root package name */
    private static final String f2196h = "MediaService";

    /* renamed from: a, reason: collision with root package name */
    public MediaPlayer f2197a;

    /* renamed from: b, reason: collision with root package name */
    public Context f2198b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2199c = false;

    /* renamed from: d, reason: collision with root package name */
    public AssetFileDescriptor f2200d;

    /* renamed from: e, reason: collision with root package name */
    public int f2201e;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f2202f;

    /* renamed from: g, reason: collision with root package name */
    public Handler f2203g;

    /* renamed from: i, reason: collision with root package name */
    private int f2204i;

    /* renamed from: j, reason: collision with root package name */
    private long f2205j;

    public aa(Context context) {
        this.f2198b = context;
        HandlerThread handlerThread = new HandlerThread("face-sound-play-thread");
        this.f2202f = handlerThread;
        handlerThread.start();
        this.f2203g = new Handler(this.f2202f.getLooper());
        this.f2197a = new MediaPlayer();
    }

    private static int c(k.a aVar) {
        if (aVar == k.a.POS_PITCH_UP) {
            return 1620;
        }
        if (aVar == k.a.MOUTH) {
            return MetricsProto.MetricsEvent.ACTION_SMART_BATTERY_TIP;
        }
        if (aVar == k.a.POS_YAW) {
            return 1600;
        }
        if (aVar == k.a.BLINK) {
            return 1400;
        }
        k.a aVar2 = k.a.DING;
        return 200;
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final void a() {
        try {
            if (e()) {
                this.f2197a.pause();
                this.f2197a.stop();
            }
            MediaPlayer mediaPlayer = this.f2197a;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
            }
        } catch (Throwable th) {
            ak.b().a(th);
        }
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final void b() {
        MediaPlayer mediaPlayer = this.f2197a;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setOnCompletionListener(null);
                this.f2197a.reset();
                this.f2197a.release();
                this.f2197a = null;
            } catch (Throwable th) {
                ak.b().a(th);
            }
        }
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final boolean d() {
        return this.f2199c;
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final boolean e() {
        try {
            MediaPlayer mediaPlayer = this.f2197a;
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final long c() {
        long currentTimeMillis = (this.f2204i + this.f2205j) - System.currentTimeMillis();
        if (currentTimeMillis < 0 || currentTimeMillis > com.huawei.openalliance.ad.ipc.c.Code) {
            return 0L;
        }
        return currentTimeMillis;
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final int a(final k.a aVar) {
        if (this.f2199c) {
            return 0;
        }
        long currentTimeMillis = (this.f2204i + this.f2205j) - System.currentTimeMillis();
        if (currentTimeMillis < 0 || currentTimeMillis > com.huawei.openalliance.ad.ipc.c.Code) {
            currentTimeMillis = 0;
        }
        this.f2205j = System.currentTimeMillis();
        this.f2204i = c(aVar);
        if (currentTimeMillis > 0) {
            this.f2203g.postDelayed(new Runnable() { // from class: com.alibaba.security.biometrics.build.aa.1
                @Override // java.lang.Runnable
                public final void run() {
                    aa.this.b(aVar);
                }
            }, currentTimeMillis);
        } else {
            this.f2203g.post(new Runnable() { // from class: com.alibaba.security.biometrics.build.aa.2
                @Override // java.lang.Runnable
                public final void run() {
                    aa.this.b(aVar);
                }
            });
        }
        return (int) (this.f2204i + currentTimeMillis);
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final int b(k.a aVar) {
        try {
            if (this.f2199c) {
                return 0;
            }
            this.f2204i = c(aVar);
            Context context = this.f2198b;
            Resources resources = context.getResources();
            String str = aVar.resourceName;
            if (!Locale.getDefault().getLanguage().equals(Locale.CHINA.getLanguage())) {
                str = str + "_" + Locale.getDefault().getLanguage();
            }
            int identifier = resources.getIdentifier(str, "raw", context.getPackageName());
            this.f2201e = identifier;
            if (identifier == 0) {
                return 0;
            }
            b();
            MediaPlayer create = MediaPlayer.create(this.f2198b, this.f2201e);
            this.f2197a = create;
            if (create != null) {
                if (create.isPlaying()) {
                    this.f2197a.pause();
                }
                this.f2197a.reset();
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f2200d;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    AssetFileDescriptor openRawResourceFd = this.f2198b.getResources().openRawResourceFd(this.f2201e);
                    this.f2200d = openRawResourceFd;
                    this.f2197a.setDataSource(openRawResourceFd.getFileDescriptor(), this.f2200d.getStartOffset(), this.f2200d.getLength());
                    this.f2197a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.alibaba.security.biometrics.build.aa.3
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            try {
                                AssetFileDescriptor assetFileDescriptor2 = aa.this.f2200d;
                                if (assetFileDescriptor2 != null) {
                                    assetFileDescriptor2.close();
                                    aa.this.f2200d = null;
                                }
                            } catch (IOException e2) {
                                RPLogging.e(aa.f2196h, e2);
                            }
                        }
                    });
                    this.f2197a.prepare();
                    this.f2197a.start();
                    this.f2205j = System.currentTimeMillis();
                    this.f2204i = this.f2197a.getDuration();
                } catch (Throwable th) {
                    ak.b().a(th);
                }
            }
            return this.f2204i;
        } catch (Throwable th2) {
            ak.b().a(th2);
            return 0;
        }
    }

    @Override // com.alibaba.security.biometrics.build.y
    public final void a(boolean z10) {
        this.f2199c = z10;
        if (z10) {
            a();
        }
    }
}
