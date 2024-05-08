package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    private final ExecutorService aCA = GlobalThreadPools.FB();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: CS, reason: merged with bridge method [inline-methods] */
        public Void call() {
            e.this.z(this.file);
            return null;
        }
    }

    private void B(List<File> list) {
        long C = C(list);
        list.size();
        for (File file : list) {
            if (!au(C)) {
                long length = file.length();
                if (file.delete()) {
                    C -= length;
                } else {
                    com.kwad.sdk.core.e.c.e("LruDiskUsage", "Error deleting file " + ((Object) file) + " for trimming cache");
                }
            }
        }
    }

    private static long C(List<File> list) {
        Iterator<File> iterator2 = list.iterator2();
        long j10 = 0;
        while (iterator2.hasNext()) {
            j10 += iterator2.next().length();
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) {
        d.w(file);
        B(d.v(file.getParentFile()));
    }

    public abstract boolean au(long j10);

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.aCA.submit(new a(file));
    }
}
