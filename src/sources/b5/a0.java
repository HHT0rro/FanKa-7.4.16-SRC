package b5;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.Map;

/* compiled from: WidevineUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a0 {
    public static long a(Map<String, String> map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    @Nullable
    public static Pair<Long, Long> b(DrmSession drmSession) {
        Map<String, String> c4 = drmSession.c();
        if (c4 == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(c4, "LicenseDurationRemaining")), Long.valueOf(a(c4, "PlaybackDurationRemaining")));
    }
}
