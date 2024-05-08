package m6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.huawei.openalliance.ad.constant.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttParserUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f51930a = Pattern.compile("^NOTE([ \t].*)?$");

    @Nullable
    public static Matcher a(ParsableByteArray parsableByteArray) {
        String p10;
        while (true) {
            String p11 = parsableByteArray.p();
            if (p11 == null) {
                return null;
            }
            if (f51930a.matcher(p11).matches()) {
                do {
                    p10 = parsableByteArray.p();
                    if (p10 != null) {
                    }
                } while (!p10.isEmpty());
            } else {
                Matcher matcher = f.f51903a.matcher(p11);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(ParsableByteArray parsableByteArray) {
        String p10 = parsableByteArray.p();
        return p10 != null && p10.startsWith("WEBVTT");
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] N0 = j0.N0(str, "\\.");
        long j10 = 0;
        for (String str2 : j0.M0(N0[0], u.bD)) {
            j10 = (j10 * 60) + Long.parseLong(str2);
        }
        long j11 = j10 * 1000;
        if (N0.length == 2) {
            j11 += Long.parseLong(N0[1]);
        }
        return j11 * 1000;
    }

    public static void e(ParsableByteArray parsableByteArray) throws ParserException {
        int e2 = parsableByteArray.e();
        if (b(parsableByteArray)) {
            return;
        }
        parsableByteArray.P(e2);
        String valueOf = String.valueOf(parsableByteArray.p());
        throw ParserException.createForMalformedContainer(valueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(valueOf) : new String("Expected WEBVTT. Got "), null);
    }
}
