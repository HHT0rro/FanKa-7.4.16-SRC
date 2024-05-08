package h;

import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: Font.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f49467a;

    /* renamed from: b, reason: collision with root package name */
    public final String f49468b;

    /* renamed from: c, reason: collision with root package name */
    public final String f49469c;

    /* renamed from: d, reason: collision with root package name */
    public final float f49470d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Typeface f49471e;

    public a(String str, String str2, String str3, float f10) {
        this.f49467a = str;
        this.f49468b = str2;
        this.f49469c = str3;
        this.f49470d = f10;
    }

    public String a() {
        return this.f49467a;
    }

    public String b() {
        return this.f49468b;
    }

    public String c() {
        return this.f49469c;
    }

    @Nullable
    public Typeface d() {
        return this.f49471e;
    }

    public void e(@Nullable Typeface typeface) {
        this.f49471e = typeface;
    }
}
