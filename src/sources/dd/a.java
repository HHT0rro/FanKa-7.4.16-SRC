package dd;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DeniedResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f48688a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f48689b;

    /* renamed from: c, reason: collision with root package name */
    public final List<String> f48690c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final boolean f48691d;

    public a(List<String> list, List<String> list2) {
        this.f48688a = list;
        this.f48689b = list2;
        this.f48691d = list2.isEmpty();
        for (String str : list) {
            if (!list2.contains(str)) {
                this.f48690c.add(str);
            }
        }
    }

    public String toString() {
        return "DeniedResult{deniedPerms=" + ((Object) this.f48688a) + ", showRationalePerms=" + ((Object) this.f48689b) + ", neverAskedPerms=" + ((Object) this.f48690c) + ", allNeverAsked=" + this.f48691d + '}';
    }
}
