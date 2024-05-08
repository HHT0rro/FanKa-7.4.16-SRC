package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.s;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Charsets.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f51096a = new c();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Charset f51097b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Charset f51098c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Charset f51099d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Charset f51100e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Charset f51101f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final Charset f51102g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static volatile Charset f51103h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static volatile Charset f51104i;

    static {
        Charset forName = Charset.forName("UTF-8");
        s.h(forName, "forName(\"UTF-8\")");
        f51097b = forName;
        Charset forName2 = Charset.forName(CharEncoding.UTF_16);
        s.h(forName2, "forName(\"UTF-16\")");
        f51098c = forName2;
        Charset forName3 = Charset.forName(CharEncoding.UTF_16BE);
        s.h(forName3, "forName(\"UTF-16BE\")");
        f51099d = forName3;
        Charset forName4 = Charset.forName(CharEncoding.UTF_16LE);
        s.h(forName4, "forName(\"UTF-16LE\")");
        f51100e = forName4;
        Charset forName5 = Charset.forName(CharEncoding.US_ASCII);
        s.h(forName5, "forName(\"US-ASCII\")");
        f51101f = forName5;
        Charset forName6 = Charset.forName(CharEncoding.ISO_8859_1);
        s.h(forName6, "forName(\"ISO-8859-1\")");
        f51102g = forName6;
    }

    @NotNull
    public final Charset a() {
        Charset charset = f51104i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        s.h(forName, "forName(\"UTF-32BE\")");
        f51104i = forName;
        return forName;
    }

    @NotNull
    public final Charset b() {
        Charset charset = f51103h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        s.h(forName, "forName(\"UTF-32LE\")");
        f51103h = forName;
        return forName;
    }
}
