package b6;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.j0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RtspSessionTiming.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    public static final x f1370c = new x(0, -9223372036854775807L);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f1371d = Pattern.compile("npt=([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    /* renamed from: a, reason: collision with root package name */
    public final long f1372a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1373b;

    public x(long j10, long j11) {
        this.f1372a = j10;
        this.f1373b = j11;
    }

    public static String b(long j10) {
        return j0.D("npt=%.3f-", Double.valueOf(j10 / 1000.0d));
    }

    public static x d(String str) throws ParserException {
        long parseFloat;
        Matcher matcher = f1371d.matcher(str);
        com.google.android.exoplayer2.util.a.a(matcher.matches());
        long parseFloat2 = ((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))).equals("now") ? 0L : Float.parseFloat(r1) * 1000.0f;
        String group = matcher.group(2);
        if (group != null) {
            try {
                parseFloat = Float.parseFloat(group) * 1000.0f;
                com.google.android.exoplayer2.util.a.a(parseFloat > parseFloat2);
            } catch (NumberFormatException e2) {
                throw ParserException.createForMalformedManifest(group, e2);
            }
        } else {
            parseFloat = -9223372036854775807L;
        }
        return new x(parseFloat2, parseFloat);
    }

    public long a() {
        return this.f1373b - this.f1372a;
    }

    public boolean c() {
        return this.f1373b == -9223372036854775807L;
    }
}
