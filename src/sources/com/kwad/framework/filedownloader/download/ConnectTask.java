package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ConnectTask {
    public final int afG;
    public final com.kwad.framework.filedownloader.d.b afH;
    private com.kwad.framework.filedownloader.download.a afI;
    private String afJ;
    private Map<String, List<String>> afK;
    private List<String> afL;
    public final String url;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        public Reconnect() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private com.kwad.framework.filedownloader.d.b afH;
        private String afJ;
        private Integer afM;
        private com.kwad.framework.filedownloader.download.a afN;
        private String url;

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.afH = bVar;
            return this;
        }

        public final a bf(String str) {
            this.url = str;
            return this;
        }

        public final a bg(String str) {
            this.afJ = str;
            return this;
        }

        public final a bs(int i10) {
            this.afM = Integer.valueOf(i10);
            return this;
        }

        public final ConnectTask vn() {
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num = this.afM;
            if (num != null && (aVar = this.afN) != null && this.url != null) {
                return new ConnectTask(aVar, num.intValue(), this.url, this.afJ, this.afH, (byte) 0);
            }
            throw new IllegalArgumentException();
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.afN = aVar;
            return this;
        }
    }

    public /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i10, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b4) {
        this(aVar, i10, str, str2, bVar);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> wk;
        com.kwad.framework.filedownloader.d.b bVar2 = this.afH;
        if (bVar2 == null || (wk = bVar2.wk()) == null) {
            return;
        }
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.afG), wk);
        }
        for (Map.Entry<String, List<String>> entry : wk.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> iterator2 = value.iterator2();
                while (iterator2.hasNext()) {
                    bVar.addHeader(key, iterator2.next());
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        if (!TextUtils.isEmpty(this.afJ)) {
            bVar.addHeader("If-Match", this.afJ);
        }
        com.kwad.framework.filedownloader.download.a aVar = this.afI;
        bVar.addHeader("Range", aVar.afQ == 0 ? com.kwad.framework.filedownloader.f.f.b("bytes=%d-", Long.valueOf(aVar.afP)) : com.kwad.framework.filedownloader.f.f.b("bytes=%d-%d", Long.valueOf(aVar.afP), Long.valueOf(this.afI.afQ)));
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.afH;
        if (bVar2 == null || bVar2.wk().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.wT());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.afK;
    }

    public final com.kwad.framework.filedownloader.a.b vj() {
        com.kwad.framework.filedownloader.a.b bh = b.vo().bh(this.url);
        a(bh);
        b(bh);
        c(bh);
        this.afK = bh.vc();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.afG), this.afK);
        }
        bh.execute();
        ArrayList arrayList = new ArrayList();
        this.afL = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.afK, bh, arrayList);
    }

    public final boolean vk() {
        return this.afI.afP > 0;
    }

    public final String vl() {
        List<String> list = this.afL;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.afL.get(r0.size() - 1);
    }

    public final com.kwad.framework.filedownloader.download.a vm() {
        return this.afI;
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i10, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.afG = i10;
        this.url = str;
        this.afJ = str2;
        this.afH = bVar;
        this.afI = aVar;
    }
}
