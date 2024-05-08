package b6;

import android.net.Uri;
import com.google.android.exoplayer2.util.j0;

/* compiled from: RtpUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i {
    public static com.google.android.exoplayer2.upstream.b a(int i10) {
        return new com.google.android.exoplayer2.upstream.b(Uri.parse(j0.D("%s:%d", "rtp://0.0.0.0", Integer.valueOf(i10))));
    }
}
