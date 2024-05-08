package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: NearbyDeleteHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class z extends f<String, Integer> {

    /* renamed from: g, reason: collision with root package name */
    private Context f8020g;

    /* renamed from: h, reason: collision with root package name */
    private String f8021h;

    public z(Context context, String str) {
        super(context, str);
        this.f8020g = context;
        this.f8021h = str;
    }

    private static Integer j() throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return j();
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bw.f(this.f8020g));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f8021h);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.d() + "/nearby/data/delete";
    }
}
