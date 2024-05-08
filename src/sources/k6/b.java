package k6;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableSet;
import com.huawei.quickcard.base.Attributes;
import java.util.regex.Pattern;

/* compiled from: TextEmphasis.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f50663d = Pattern.compile("\\s+");

    /* renamed from: e, reason: collision with root package name */
    public static final ImmutableSet<String> f50664e = ImmutableSet.of(Attributes.LayoutDirection.AUTO, "none");

    /* renamed from: f, reason: collision with root package name */
    public static final ImmutableSet<String> f50665f = ImmutableSet.of("dot", "sesame", "circle");

    /* renamed from: g, reason: collision with root package name */
    public static final ImmutableSet<String> f50666g = ImmutableSet.of("filled", "open");

    /* renamed from: h, reason: collision with root package name */
    public static final ImmutableSet<String> f50667h = ImmutableSet.of("after", "before", "outside");

    /* renamed from: a, reason: collision with root package name */
    public final int f50668a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50669b;

    /* renamed from: c, reason: collision with root package name */
    public final int f50670c;

    public b(int i10, int i11, int i12) {
        this.f50668a = i10;
        this.f50669b = i11;
        this.f50670c = i12;
    }

    @Nullable
    public static b a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String e2 = com.google.common.base.a.e(str.trim());
        if (e2.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(e2, f50663d)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        if (r9.equals(com.huawei.quickcard.base.Attributes.LayoutDirection.AUTO) != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static k6.b b(com.google.common.collect.ImmutableSet<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.b.b(com.google.common.collect.ImmutableSet):k6.b");
    }
}
