package com.alibaba.security.biometrics.build;

import com.alibaba.security.biometrics.camera.size.AspectRatio;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: SizeMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<AspectRatio, SortedSet<f>> f2299a = new HashMap<>();

    private boolean a(f fVar) {
        for (AspectRatio aspectRatio : this.f2299a.h()) {
            int b4 = AspectRatio.b(fVar.f2297a, fVar.f2298b);
            if (aspectRatio.f2417b == fVar.f2297a / b4 && aspectRatio.f2418c == fVar.f2298b / b4) {
                SortedSet<f> sortedSet = this.f2299a.get(aspectRatio);
                if (sortedSet.contains(fVar)) {
                    return false;
                }
                sortedSet.add(fVar);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(fVar);
        this.f2299a.put(AspectRatio.a(fVar.f2297a, fVar.f2298b), treeSet);
        return true;
    }

    private void b(AspectRatio aspectRatio) {
        this.f2299a.remove(aspectRatio);
    }

    private Set<AspectRatio> a() {
        return this.f2299a.h();
    }

    public final SortedSet<f> a(AspectRatio aspectRatio) {
        return this.f2299a.get(aspectRatio);
    }
}
