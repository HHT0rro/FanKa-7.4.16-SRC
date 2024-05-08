package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class ab implements w {
    private final SparseArray<Handler> afh = new SparseArray<>();

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bh(int i10) {
        return this.afh.get(i10) != null;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void p(List<Integer> list) {
        Iterator<Integer> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            b(this.afh.get(iterator2.next().intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void va() {
        for (int i10 = 0; i10 < this.afh.size(); i10++) {
            a(this.afh.get(this.afh.keyAt(i10)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int vb() {
        return this.afh.size();
    }
}
