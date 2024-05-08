package m4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: CCTDestination.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements n4.c {

    /* renamed from: c, reason: collision with root package name */
    public static final String f51805c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f51806d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f51807e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<com.google.android.datatransport.a> f51808f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f51809g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f51810h;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f51811a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f51812b;

    static {
        String a10 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f51805c = a10;
        String a11 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f51806d = a11;
        String a12 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f51807e = a12;
        f51808f = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.google.android.datatransport.a.b("proto"), com.google.android.datatransport.a.b("json"))));
        f51809g = new a(a10, null);
        f51810h = new a(a11, a12);
    }

    public a(@NonNull String str, @Nullable String str2) {
        this.f51811a = str;
        this.f51812b = str2;
    }

    @NonNull
    public static a c(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Override // n4.c
    public Set<com.google.android.datatransport.a> a() {
        return f51808f;
    }

    @Nullable
    public byte[] b() {
        String str = this.f51812b;
        if (str == null && this.f51811a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f51811a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @Nullable
    public String d() {
        return this.f51812b;
    }

    @NonNull
    public String e() {
        return this.f51811a;
    }

    @Override // n4.b
    @Nullable
    public byte[] getExtras() {
        return b();
    }

    @Override // n4.b
    @NonNull
    public String getName() {
        return "cct";
    }
}
