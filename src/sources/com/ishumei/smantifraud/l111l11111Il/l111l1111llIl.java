package com.ishumei.smantifraud.l111l11111Il;

import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;
import com.wangmai.okhttp.model.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class l111l1111llIl<T> extends com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111llIl<T> {
    private static String l111l11111I1l = "application/octet-stream";
    private static String l111l11111Il = "Connection";
    private static String l111l11111lIl = "Content-Type";
    private static String l111l1111l1Il = "Close";

    public l111l1111llIl(int i10, String str, String str2, String str3, l11l1111lIIl.l111l11111lIl<T> l111l11111lil, l11l1111lIIl.l1111l111111Il l1111l111111il) {
        super(i10, str, str2, str3, l111l11111lil, l1111l111111il);
    }

    public l111l1111llIl(String str, String str2, String str3) {
        this(1, str, str2, str3, new l11l1111lIIl.l111l11111lIl<T>() { // from class: com.ishumei.smantifraud.l111l11111Il.l111l1111llIl.1
            @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l111l11111lIl
            public final void l1111l111111Il(T t2) {
            }
        }, new l11l1111lIIl.l1111l111111Il() { // from class: com.ishumei.smantifraud.l111l11111Il.l111l1111llIl.2
            @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l1111l111111Il
            public final void l1111l111111Il(l11l1111I1ll l11l1111i1ll) {
            }
        });
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public final Map<String, String> l111l11111lIl() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put(HttpHeaders.HEAD_KEY_CONNECTION, "Close");
        return hashMap;
    }
}
