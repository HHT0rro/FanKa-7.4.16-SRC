package h;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f49478c = new c("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f49479a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public d f49480b;

    public c(String... strArr) {
        this.f49479a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public c a(String str) {
        c cVar = new c(this);
        cVar.f49479a.add(str);
        return cVar;
    }

    public final boolean b() {
        return this.f49479a.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i10) {
        if (i10 >= this.f49479a.size()) {
            return false;
        }
        boolean z10 = i10 == this.f49479a.size() - 1;
        String str2 = this.f49479a.get(i10);
        if (!str2.equals("**")) {
            return (z10 || (i10 == this.f49479a.size() + (-2) && b())) && (str2.equals(str) || str2.equals(StringUtils.NO_PRINT_CODE));
        }
        if (!z10 && this.f49479a.get(i10 + 1).equals(str)) {
            return i10 == this.f49479a.size() + (-2) || (i10 == this.f49479a.size() + (-3) && b());
        }
        if (z10) {
            return true;
        }
        int i11 = i10 + 1;
        if (i11 < this.f49479a.size() - 1) {
            return false;
        }
        return this.f49479a.get(i11).equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d d() {
        return this.f49480b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i10) {
        if (f(str)) {
            return 0;
        }
        if (this.f49479a.get(i10).equals("**")) {
            return (i10 != this.f49479a.size() - 1 && this.f49479a.get(i10 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f49479a.equals(cVar.f49479a)) {
            return false;
        }
        d dVar = this.f49480b;
        d dVar2 = cVar.f49480b;
        return dVar != null ? dVar.equals(dVar2) : dVar2 == null;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i10) {
        if (f(str)) {
            return true;
        }
        if (i10 >= this.f49479a.size()) {
            return false;
        }
        return this.f49479a.get(i10).equals(str) || this.f49479a.get(i10).equals("**") || this.f49479a.get(i10).equals(StringUtils.NO_PRINT_CODE);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i10) {
        return "__container".equals(str) || i10 < this.f49479a.size() - 1 || this.f49479a.get(i10).equals("**");
    }

    public int hashCode() {
        int hashCode = this.f49479a.hashCode() * 31;
        d dVar = this.f49480b;
        return hashCode + (dVar != null ? dVar.hashCode() : 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public c i(d dVar) {
        c cVar = new c(this);
        cVar.f49480b = dVar;
        return cVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append((Object) this.f49479a);
        sb2.append(",resolved=");
        sb2.append(this.f49480b != null);
        sb2.append('}');
        return sb2.toString();
    }

    public c(c cVar) {
        this.f49479a = new ArrayList(cVar.f49479a);
        this.f49480b = cVar.f49480b;
    }
}
