package x4;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* compiled from: AudioCapabilities.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f54395c = new e(new int[]{2}, 8);

    /* renamed from: d, reason: collision with root package name */
    public static final e f54396d = new e(new int[]{2, 5, 6}, 8);

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f54397e = {5, 6, 18, 17, 14, 7, 8};

    /* renamed from: a, reason: collision with root package name */
    public final int[] f54398a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54399b;

    /* compiled from: AudioCapabilities.java */
    @RequiresApi(29)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        @DoNotInline
        public static int[] a() {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i10 : e.f54397e) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(i10).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    builder.a(Integer.valueOf(i10));
                }
            }
            builder.a(2);
            return Ints.m(builder.k());
        }
    }

    public e(@Nullable int[] iArr, int i10) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f54398a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f54398a = new int[0];
        }
        this.f54399b = i10;
    }

    public static boolean b() {
        if (j0.f22990a >= 17) {
            String str = j0.f22992c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static e c(Context context) {
        return d(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public static e d(Context context, @Nullable Intent intent) {
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f54396d;
        }
        if (j0.f22990a >= 29 && j0.r0(context)) {
            return new e(a.a(), 8);
        }
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new e(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return f54395c;
    }

    public int e() {
        return this.f54399b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Arrays.equals(this.f54398a, eVar.f54398a) && this.f54399b == eVar.f54399b;
    }

    public boolean f(int i10) {
        return Arrays.binarySearch(this.f54398a, i10) >= 0;
    }

    public int hashCode() {
        return this.f54399b + (Arrays.hashCode(this.f54398a) * 31);
    }

    public String toString() {
        int i10 = this.f54399b;
        String arrays = Arrays.toString(this.f54398a);
        StringBuilder sb2 = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb2.append("AudioCapabilities[maxChannelCount=");
        sb2.append(i10);
        sb2.append(", supportedEncodings=");
        sb2.append(arrays);
        sb2.append("]");
        return sb2.toString();
    }
}
