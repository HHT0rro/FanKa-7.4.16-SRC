package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.utils.ap;
import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface g extends d, Serializable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        public static g Code(String str) {
            Serializable V = ap.V(str);
            if (V instanceof AdContentData) {
                return new n((AdContentData) V);
            }
            return null;
        }

        public static String Code(g gVar) {
            if (gVar instanceof n) {
                return ap.Code(((n) gVar).Code);
            }
            return null;
        }
    }

    v B();

    k I();

    List<k> Z();

    boolean d_();

    List<String> n();
}
