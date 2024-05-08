package com.opensource.svgaplayer;

import android.media.SoundPool;
import java.io.FileDescriptor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGASoundManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static SoundPool f38006b;

    /* renamed from: e, reason: collision with root package name */
    public static final h f38009e = new h();

    /* renamed from: a, reason: collision with root package name */
    public static final String f38005a = h.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Integer, a> f38007c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static float f38008d = 1.0f;

    /* compiled from: SVGASoundManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
    }

    public final boolean a() {
        boolean b4 = b();
        if (!b4) {
            ub.c cVar = ub.c.f54010a;
            String TAG = f38005a;
            s.e(TAG, "TAG");
            cVar.b(TAG, "soundPool is null, you need call init() !!!");
        }
        return b4;
    }

    public final boolean b() {
        return f38006b != null;
    }

    public final int c(@Nullable a aVar, @Nullable FileDescriptor fileDescriptor, long j10, long j11, int i10) {
        if (!a()) {
            return -1;
        }
        SoundPool soundPool = f38006b;
        if (soundPool == null) {
            s.u();
        }
        int load = soundPool.load(fileDescriptor, j10, j11, i10);
        ub.c cVar = ub.c.f54010a;
        String TAG = f38005a;
        s.e(TAG, "TAG");
        cVar.a(TAG, "load soundId=" + load + " callBack=" + ((Object) aVar));
        if (aVar != null) {
            Map<Integer, a> map = f38007c;
            if (!map.containsKey(Integer.valueOf(load))) {
                map.put(Integer.valueOf(load), aVar);
            }
        }
        return load;
    }

    public final int d(int i10) {
        if (!a()) {
            return -1;
        }
        ub.c cVar = ub.c.f54010a;
        String TAG = f38005a;
        s.e(TAG, "TAG");
        cVar.a(TAG, "play soundId=" + i10);
        SoundPool soundPool = f38006b;
        if (soundPool == null) {
            s.u();
        }
        float f10 = f38008d;
        return soundPool.play(i10, f10, f10, 1, 0, 1.0f);
    }

    public final void e(int i10) {
        if (a()) {
            ub.c cVar = ub.c.f54010a;
            String TAG = f38005a;
            s.e(TAG, "TAG");
            cVar.a(TAG, "stop soundId=" + i10);
            SoundPool soundPool = f38006b;
            if (soundPool == null) {
                s.u();
            }
            soundPool.stop(i10);
        }
    }

    public final void f(int i10) {
        if (a()) {
            ub.c cVar = ub.c.f54010a;
            String TAG = f38005a;
            s.e(TAG, "TAG");
            cVar.a(TAG, "unload soundId=" + i10);
            SoundPool soundPool = f38006b;
            if (soundPool == null) {
                s.u();
            }
            soundPool.unload(i10);
            f38007c.remove(Integer.valueOf(i10));
        }
    }
}
