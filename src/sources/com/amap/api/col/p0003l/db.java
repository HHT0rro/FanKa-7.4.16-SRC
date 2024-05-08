package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.id;
import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* compiled from: AbstractAMapRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class db extends id {
    public boolean isPostFlag = true;

    @Override // com.amap.api.col.p0003l.id
    public Map<String, String> getParams() {
        return null;
    }

    public byte[] makeHttpRequest() throws fi {
        ie makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.f6444a;
        }
        return null;
    }

    public ie makeHttpRequestNeedHeader() throws fi {
        if (ab.f4885a != null && fr.a(ab.f4885a, dx.a()).f5947a != fr.c.SuccessCode) {
            return null;
        }
        setHttpProtocol(MapsInitializer.getProtocol() == 1 ? id.c.HTTP : id.c.HTTPS);
        ic.c();
        if (this.isPostFlag) {
            return hw.a(this);
        }
        return ic.e(this);
    }

    public byte[] makeHttpRequestWithInterrupted() throws fi {
        setDegradeAbility(id.a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
