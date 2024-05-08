package com.tencent.liteav.videobase.videobase;

import androidx.annotation.NonNull;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Map<com.tencent.liteav.videobase.videobase.a, g> f43565a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.e f43566b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(int i10, @NonNull PixelFrame pixelFrame);
    }

    public final void a(com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, int i10, a aVar2) {
        g gVar = this.f43565a.get(aVar);
        if (gVar == null) {
            gVar = new g(aVar);
            com.tencent.liteav.videobase.frame.e eVar = this.f43566b;
            if (eVar != null) {
                gVar.a(eVar);
            }
            this.f43565a.put(aVar, gVar);
        }
        List<g.a> list = gVar.f43571e.get(pixelFormatType);
        if (list == null) {
            list = new ArrayList<>();
            gVar.f43571e.put(pixelFormatType, list);
        }
        for (g.a aVar3 : list) {
            if (aVar3.f43580b == i10 && aVar3.f43581c == aVar2) {
                return;
            }
        }
        list.add(new g.a(pixelBufferType, i10, aVar2));
    }

    public final void a(int i10, a aVar) {
        ArrayList<com.tencent.liteav.videobase.videobase.a> arrayList = new ArrayList();
        for (Map.Entry<com.tencent.liteav.videobase.videobase.a, g> entry : this.f43565a.entrySet()) {
            entry.getValue().a(i10, aVar);
            if (!(!entry.getValue().f43571e.isEmpty())) {
                arrayList.add(entry.getKey());
            }
        }
        for (com.tencent.liteav.videobase.videobase.a aVar2 : arrayList) {
            g gVar = this.f43565a.get(aVar2);
            if (gVar != null) {
                gVar.a();
            }
            this.f43565a.remove(aVar2);
        }
    }

    public final void a(@NonNull com.tencent.liteav.videobase.frame.e eVar) {
        this.f43566b = eVar;
        Iterator<g> iterator2 = this.f43565a.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b A[EDGE_INSN: B:89:0x011b->B:40:0x011b BREAK  A[LOOP:1: B:33:0x0107->B:37:0x0118], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r25, com.tencent.liteav.videobase.frame.d r27) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.videobase.d.a(long, com.tencent.liteav.videobase.frame.d):void");
    }

    public final void a() {
        Iterator<g> iterator2 = this.f43565a.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a();
        }
    }
}
