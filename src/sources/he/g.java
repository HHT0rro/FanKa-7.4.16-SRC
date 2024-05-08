package he;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g {

    /* renamed from: d, reason: collision with root package name */
    public static final List<g> f49628d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public Object f49629a;

    /* renamed from: b, reason: collision with root package name */
    public m f49630b;

    /* renamed from: c, reason: collision with root package name */
    public g f49631c;

    public g(Object obj, m mVar) {
        this.f49629a = obj;
        this.f49630b = mVar;
    }

    public static g a(m mVar, Object obj) {
        List<g> list = f49628d;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                g remove = list.remove(size - 1);
                remove.f49629a = obj;
                remove.f49630b = mVar;
                remove.f49631c = null;
                return remove;
            }
            return new g(obj, mVar);
        }
    }

    public static void b(g gVar) {
        gVar.f49629a = null;
        gVar.f49630b = null;
        gVar.f49631c = null;
        List<g> list = f49628d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(gVar);
            }
        }
    }
}
