package com.tencent.cloud.huiyansdkface.wehttp2;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NamedCookie {

    /* renamed from: a, reason: collision with root package name */
    private Cookie f42289a;

    public NamedCookie(Cookie cookie) {
        this.f42289a = cookie;
    }

    public static List<NamedCookie> a(Collection<Cookie> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<Cookie> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new NamedCookie(iterator2.next()));
        }
        return arrayList;
    }

    public Cookie a() {
        return this.f42289a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NamedCookie)) {
            return false;
        }
        NamedCookie namedCookie = (NamedCookie) obj;
        return namedCookie.f42289a.name().equals(this.f42289a.name()) && namedCookie.f42289a.domain().equals(this.f42289a.domain()) && namedCookie.f42289a.path().equals(this.f42289a.path()) && namedCookie.f42289a.secure() == this.f42289a.secure() && namedCookie.f42289a.hostOnly() == this.f42289a.hostOnly();
    }

    public int hashCode() {
        return ((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f42289a.name().hashCode()) * 31) + this.f42289a.domain().hashCode()) * 31) + this.f42289a.path().hashCode()) * 31) + (!this.f42289a.secure() ? 1 : 0)) * 31) + (!this.f42289a.hostOnly() ? 1 : 0);
    }
}
