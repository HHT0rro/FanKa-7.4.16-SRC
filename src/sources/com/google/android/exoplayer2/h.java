package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import com.android.internal.os.PowerProfile;
import java.util.UUID;

/* compiled from: C.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final UUID f20704a = new UUID(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final UUID f20705b = new UUID(1186680826959645954L, -5988876978535335093L);

    /* renamed from: c, reason: collision with root package name */
    public static final UUID f20706c = new UUID(-2129748144642739255L, 8654423357094679310L);

    /* renamed from: d, reason: collision with root package name */
    public static final UUID f20707d = new UUID(-1301668207276963122L, -6645017420763422227L);

    /* renamed from: e, reason: collision with root package name */
    public static final UUID f20708e = new UUID(-7348484286925749626L, -6083546864340672619L);

    @RequiresApi(21)
    public static int a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static int b(int i10) {
        if (i10 == 2 || i10 == 4) {
            return 6005;
        }
        if (i10 == 10) {
            return 6004;
        }
        if (i10 == 7) {
            return 6005;
        }
        if (i10 == 8) {
            return 6003;
        }
        switch (i10) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i10) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static String c(int i10) {
        if (i10 == 0) {
            return "NO";
        }
        if (i10 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i10 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i10 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i10 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static long d(long j10) {
        return (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? j10 : j10 * 1000;
    }

    public static long e(long j10) {
        return (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? j10 : j10 / 1000;
    }
}
