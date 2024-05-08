package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.cr;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomStyleTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cs extends je {

    /* renamed from: a, reason: collision with root package name */
    private Context f5241a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f5242b;

    /* renamed from: c, reason: collision with root package name */
    private cr f5243c;

    /* renamed from: d, reason: collision with root package name */
    private String f5244d;

    /* renamed from: e, reason: collision with root package name */
    private String f5245e;

    /* renamed from: g, reason: collision with root package name */
    private String f5246g;

    /* renamed from: h, reason: collision with root package name */
    private a f5247h;

    /* renamed from: i, reason: collision with root package name */
    private int f5248i;

    /* compiled from: CustomStyleTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(byte[] bArr, int i10);

        void b(byte[] bArr, int i10);
    }

    public cs(Context context, a aVar, int i10, String str) {
        this.f5244d = null;
        this.f5245e = null;
        this.f5246g = null;
        this.f5241a = context;
        this.f5247h = aVar;
        this.f5248i = i10;
        if (this.f5243c == null) {
            this.f5243c = new cr(context, "", i10 != 0);
        }
        this.f5243c.b(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10);
        sb2.append(str == null ? "" : str);
        sb2.append(".amapstyle");
        this.f5244d = sb2.toString();
        this.f5245e = context.getCacheDir().getPath();
    }

    private byte[] b(String str) {
        if (str == null || this.f5245e == null) {
            return null;
        }
        return FileUtil.readFileContents(this.f5245e + File.separator + str);
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        Object b4 = dt.b(this.f5241a, "amap_style_config", "lastModified".concat(str), "");
        if (!(b4 instanceof String) || b4 == "") {
            return null;
        }
        return (String) b4;
    }

    public final void a(String str) {
        cr crVar = this.f5243c;
        if (crVar != null) {
            crVar.c(str);
        }
        this.f5246g = str;
    }

    @Override // com.amap.api.col.p0003l.je
    public final void runTask() {
        byte[] bArr;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.f5243c != null) {
                    String str = this.f5246g + this.f5244d;
                    String c4 = c(str);
                    if (c4 != null) {
                        this.f5243c.d(c4);
                    }
                    byte[] b4 = b(str);
                    a aVar = this.f5247h;
                    if (aVar != null && b4 != null) {
                        aVar.a(b4, this.f5248i);
                    }
                    cr.a d10 = this.f5243c.d();
                    if (d10 != null && (bArr = d10.f5237a) != null) {
                        JSONObject jSONObject = null;
                        try {
                            jSONObject = new JSONObject(new String(bArr));
                        } catch (JSONException unused) {
                        }
                        if (jSONObject == null) {
                            if (this.f5247h != null) {
                                if (!Arrays.equals(d10.f5237a, b4)) {
                                    this.f5247h.b(d10.f5237a, this.f5248i);
                                }
                            } else {
                                IAMapDelegate iAMapDelegate = this.f5242b;
                                if (iAMapDelegate != null) {
                                    iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), d10.f5237a);
                                }
                            }
                            a(str, d10.f5237a);
                            a(str, d10.f5239c);
                        }
                    }
                }
                gy.a(this.f5241a, dx.a());
                IAMapDelegate iAMapDelegate2 = this.f5242b;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            gy.b(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        dv.a().a(this);
    }

    private void a(String str, byte[] bArr) {
        if (str == null || bArr == null || this.f5245e == null) {
            return;
        }
        FileUtil.saveFileContents(this.f5245e + File.separator + str, bArr);
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        dt.a(this.f5241a, "amap_style_config", "lastModified".concat(str), str2);
    }

    public final void a() {
        this.f5241a = null;
        if (this.f5243c != null) {
            this.f5243c = null;
        }
    }

    public cs(Context context, IAMapDelegate iAMapDelegate) {
        this.f5244d = null;
        this.f5245e = null;
        this.f5246g = null;
        this.f5248i = 0;
        this.f5241a = context;
        this.f5242b = iAMapDelegate;
        if (this.f5243c == null) {
            this.f5243c = new cr(context, "");
        }
    }
}
