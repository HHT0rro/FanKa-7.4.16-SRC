package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.dz;
import com.huawei.hms.ads.gd;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kt;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j extends q {
    private static final String V = "InnerWebAction";
    private final boolean C;
    public gd Code;
    private boolean S;

    public j(Context context, AdContentData adContentData, boolean z10) {
        super(context, adContentData);
        this.Code = new gd();
        this.S = false;
        this.C = z10;
    }

    public j(Context context, AdContentData adContentData, boolean z10, Map<String, String> map) {
        super(context, adContentData);
        this.Code = new gd();
        this.S = false;
        this.C = z10;
        Code(map);
    }

    private boolean Code(AdContentData adContentData) {
        if (!kt.Code(this.Z.r()) && !ai.Z(this.I)) {
            return V();
        }
        Code("web");
        dz.Code(this.I, adContentData, this.Code, this.S);
        return true;
    }

    public void Code(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        gl.Code(V, "buildLinkedAdConfig");
        if (map == null || map.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            str = map.getOrDefault(ax.f32271n, String.valueOf(0));
            str2 = map.getOrDefault(ax.f32270m, String.valueOf(0));
            str3 = map.getOrDefault(ax.f32274q, "false");
            str4 = map.getOrDefault(ax.f32272o, null);
            str5 = map.getOrDefault(ax.f32273p, "n");
        } else {
            str = map.get(ax.f32271n);
            str2 = map.get(ax.f32270m);
            str3 = map.get(ax.f32274q);
            str4 = map.get(ax.f32272o);
            str5 = map.get(ax.f32273p);
        }
        String str6 = str5;
        Integer F = au.F(str);
        if (F != null) {
            this.Code.V(F.intValue());
        } else {
            this.Code.V(0);
        }
        this.Code.V(str2);
        Integer F2 = au.F(str4);
        if (F2 != null) {
            this.Code.Code(F2.intValue());
            gl.V(V, "set progress from native view " + ((Object) F2));
        } else {
            this.Code.Code(0);
        }
        this.Code.Code(str6);
        this.Code.Code("true".equals(str3));
    }

    public void Code(boolean z10) {
        this.S = z10;
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        if (this.Z == null) {
            return V();
        }
        gl.V(V, "handle inner web action");
        this.Z.V(this.C);
        gl.V(V, "needAppDownload: %s", Boolean.valueOf(this.C));
        return TextUtils.isEmpty(this.Z.e()) ? V() : Code(this.Z);
    }
}
