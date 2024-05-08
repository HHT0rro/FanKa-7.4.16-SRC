package e;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final List<t> f48722a = new ArrayList();

    public void a(t tVar) {
        this.f48722a.add(tVar);
    }

    public void b(Path path) {
        for (int size = this.f48722a.size() - 1; size >= 0; size--) {
            n.h.b(path, this.f48722a.get(size));
        }
    }
}
