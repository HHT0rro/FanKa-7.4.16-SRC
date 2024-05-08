package h;

import androidx.annotation.RestrictTo;
import j.i;
import java.util.List;

/* compiled from: FontCharacter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final List<i> f49472a;

    /* renamed from: b, reason: collision with root package name */
    public final char f49473b;

    /* renamed from: c, reason: collision with root package name */
    public final double f49474c;

    /* renamed from: d, reason: collision with root package name */
    public final double f49475d;

    /* renamed from: e, reason: collision with root package name */
    public final String f49476e;

    /* renamed from: f, reason: collision with root package name */
    public final String f49477f;

    public b(List<i> list, char c4, double d10, double d11, String str, String str2) {
        this.f49472a = list;
        this.f49473b = c4;
        this.f49474c = d10;
        this.f49475d = d11;
        this.f49476e = str;
        this.f49477f = str2;
    }

    public static int c(char c4, String str, String str2) {
        return (((c4 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<i> a() {
        return this.f49472a;
    }

    public double b() {
        return this.f49475d;
    }

    public int hashCode() {
        return c(this.f49473b, this.f49477f, this.f49476e);
    }
}
