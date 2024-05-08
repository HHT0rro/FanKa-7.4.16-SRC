package com.kwad.sdk.core.webview.b.c;

import com.huawei.openalliance.ad.constant.bb;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static final List<String> aEB;

    static {
        ArrayList arrayList = new ArrayList();
        aEB = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add(bb.V);
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add(bb.B);
        arrayList.add(bb.Z);
        arrayList.add("application/javascript");
        arrayList.add(bb.Code);
        arrayList.add("audio/mpeg");
        arrayList.add("application/json");
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
    }

    public static boolean eX(String str) {
        return aEB.contains(str);
    }
}
