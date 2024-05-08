package p6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SimpleCacheSpan.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o extends f {

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f52907h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f52908i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f52909j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public o(String str, long j10, long j11, long j12, @Nullable File file) {
        super(str, j10, j11, j12, file);
    }

    @Nullable
    public static o g(File file, long j10, long j11, h hVar) {
        File file2;
        String k10;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File l10 = l(file, hVar);
            if (l10 == null) {
                return null;
            }
            file2 = l10;
            name = l10.getName();
        }
        Matcher matcher = f52909j.matcher(name);
        if (!matcher.matches() || (k10 = hVar.k(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j10 == -1 ? file2.length() : j10;
        if (length == 0) {
            return null;
        }
        return new o(k10, Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), length, j11 == -9223372036854775807L ? Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))) : j11, file2);
    }

    @Nullable
    public static o h(File file, long j10, h hVar) {
        return g(file, j10, -9223372036854775807L, hVar);
    }

    public static o i(String str, long j10, long j11) {
        return new o(str, j10, j11, -9223372036854775807L, null);
    }

    public static o j(String str, long j10) {
        return new o(str, j10, -1L, -9223372036854775807L, null);
    }

    public static File k(File file, int i10, long j10, long j11) {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append(i10);
        sb2.append(".");
        sb2.append(j10);
        sb2.append(".");
        sb2.append(j11);
        sb2.append(".v3.exo");
        return new File(file, sb2.toString());
    }

    @Nullable
    public static File l(File file, h hVar) {
        String str;
        String name = file.getName();
        Matcher matcher = f52908i.matcher(name);
        if (matcher.matches()) {
            str = j0.X0((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        } else {
            matcher = f52907h.matcher(name);
            str = matcher.matches() ? (String) com.google.android.exoplayer2.util.a.e(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        File k10 = k((File) com.google.android.exoplayer2.util.a.i(file.getParentFile()), hVar.f(str), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))));
        if (file.renameTo(k10)) {
            return k10;
        }
        return null;
    }

    public o f(File file, long j10) {
        com.google.android.exoplayer2.util.a.g(this.f52870e);
        return new o(this.f52867b, this.f52868c, this.f52869d, j10, file);
    }
}
