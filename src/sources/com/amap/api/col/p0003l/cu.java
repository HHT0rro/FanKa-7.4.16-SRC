package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.ct;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

/* compiled from: CustomStyleTextureTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cu extends je {

    /* renamed from: a, reason: collision with root package name */
    private Context f5251a;

    /* renamed from: b, reason: collision with root package name */
    private ct f5252b;

    /* renamed from: c, reason: collision with root package name */
    private da f5253c;

    /* renamed from: d, reason: collision with root package name */
    private a f5254d;

    /* compiled from: CustomStyleTextureTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(String str, da daVar);
    }

    public cu(Context context) {
        this.f5251a = context;
        if (this.f5252b == null) {
            this.f5252b = new ct(context, "");
        }
    }

    public final void a(String str) {
        ct ctVar = this.f5252b;
        if (ctVar != null) {
            ctVar.b(str);
        }
    }

    public final void b() {
        dv.a().a(this);
    }

    @Override // com.amap.api.col.p0003l.je
    public final void runTask() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                ct ctVar = this.f5252b;
                if (ctVar != null) {
                    ct.a d10 = ctVar.d();
                    String str = null;
                    if (d10 != null && d10.f5249a != null) {
                        str = a(this.f5251a) + "/custom_texture_data";
                        a(str, d10.f5249a);
                    }
                    a aVar = this.f5254d;
                    if (aVar != null) {
                        aVar.a(str, this.f5253c);
                    }
                }
                gy.a(this.f5251a, dx.a());
            }
        } catch (Throwable th) {
            gy.b(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    private static void a(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    private static String a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    public final void a() {
        this.f5251a = null;
        if (this.f5252b != null) {
            this.f5252b = null;
        }
    }

    public final void a(a aVar) {
        this.f5254d = aVar;
    }

    public final void a(da daVar) {
        this.f5253c = daVar;
    }
}
