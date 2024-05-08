package com.cupidapp.live.voiceparty.helper;

import android.content.Context;
import android.media.SoundPool;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceSoundPlayHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public SoundPool f19015a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Integer f19016b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19017c;

    public static /* synthetic */ void d(b bVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        bVar.c(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(b bVar, Context context, int i10, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        bVar.e(context, i10, function0);
    }

    public static final void g(Function0 function0, SoundPool soundPool, int i10, int i11) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void b() {
        Integer num;
        if (this.f19017c && (num = this.f19016b) != null) {
            int intValue = num.intValue();
            this.f19017c = false;
            SoundPool soundPool = this.f19015a;
            if (soundPool != null) {
                soundPool.pause(intValue);
            }
        }
    }

    public final void c(int i10) {
        Integer num;
        if (this.f19017c || (num = this.f19016b) == null) {
            return;
        }
        int intValue = num.intValue();
        this.f19017c = true;
        SoundPool soundPool = this.f19015a;
        this.f19016b = soundPool != null ? Integer.valueOf(soundPool.play(intValue, 1.0f, 1.0f, 1, i10, 1.0f)) : null;
    }

    public final void e(@NotNull Context context, int i10, @Nullable final Function0<p> function0) {
        s.i(context, "context");
        SoundPool build = new SoundPool.Builder().build();
        this.f19015a = build;
        this.f19016b = build != null ? Integer.valueOf(build.load(context, i10, 1)) : null;
        SoundPool soundPool = this.f19015a;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.cupidapp.live.voiceparty.helper.a
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public final void onLoadComplete(SoundPool soundPool2, int i11, int i12) {
                    b.g(Function0.this, soundPool2, i11, i12);
                }
            });
        }
    }

    public final void h() {
        SoundPool soundPool = this.f19015a;
        if (soundPool != null) {
            soundPool.release();
        }
    }
}
