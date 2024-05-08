package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private String f30164a;

    /* renamed from: b, reason: collision with root package name */
    private String f30165b;

    /* renamed from: c, reason: collision with root package name */
    private String f30166c;

    /* renamed from: d, reason: collision with root package name */
    private List<b1> f30167d;

    /* renamed from: e, reason: collision with root package name */
    private String f30168e;

    public l0(String str, String str2, String str3, List<b1> list, String str4) {
        this.f30164a = str;
        this.f30165b = str2;
        this.f30166c = str3;
        this.f30167d = list;
        this.f30168e = str4;
    }

    private String a(String str, String str2) {
        String str3;
        String f10 = a1.f(str, str2);
        if (TextUtils.isEmpty(f10)) {
            v.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if (FrameworkConstant.DataType.STRING_OPER.equals(str2)) {
            str3 = FrameworkConstant.HttpUrls.OPER_DATA_UPLOAD_URL;
        } else if (FrameworkConstant.DataType.STRING_MAINT.equals(str2)) {
            str3 = FrameworkConstant.HttpUrls.MAINT_DATA_UPLOAD_URL;
        } else {
            if (!FrameworkConstant.DataType.STRING_DIFFPRIVACY.equals(str2)) {
                return "";
            }
            str3 = FrameworkConstant.HttpUrls.DIFFPRC_DATA_UPLOAD_URL;
        }
        return str3.replace(FrameworkConstant.URL_PALCEHOLDER, f10);
    }

    private byte[] a(h1 h1Var) {
        String str;
        try {
            JSONObject a10 = h1Var.a();
            if (a10 != null) {
                return k1.a(a10.toString().getBytes("UTF-8"));
            }
            v.e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            v.e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            v.e("hmsSdk", str);
            return new byte[0];
        }
    }

    private void b() {
        if (c0.a(q0.i(), "backup_event", 5242880)) {
            v.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c4 = c();
        String a10 = n1.a(this.f30164a, this.f30165b, this.f30168e);
        v.c("hmsSdk", "Update data cached into backup,spKey: " + a10);
        d.b(q0.i(), "backup_event", a10, c4.toString());
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<b1> iterator2 = this.f30167d.iterator2();
        while (iterator2.hasNext()) {
            try {
                jSONArray.put(iterator2.next().d());
            } catch (JSONException unused) {
                v.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    private h1 d() {
        return k.a(this.f30167d, this.f30164a, this.f30165b, this.f30168e, this.f30166c);
    }

    public void a() {
        g d1Var;
        b0 c4;
        String str;
        String a10 = a(this.f30164a, this.f30165b);
        if (!TextUtils.isEmpty(a10) || FrameworkConstant.DataType.STRING_PREINS.equals(this.f30165b)) {
            if (!"_hms_config_tag".equals(this.f30164a) && !"_openness_config_tag".equals(this.f30164a)) {
                b();
            }
            h1 d10 = d();
            if (d10 != null) {
                byte[] a11 = a(d10);
                if (a11.length == 0) {
                    str = "request body is empty";
                } else {
                    d1Var = new f(a11, a10, this.f30164a, this.f30165b, this.f30168e, this.f30167d);
                    c4 = b0.b();
                }
            } else {
                d1Var = new d1(this.f30167d, this.f30164a, this.f30168e, this.f30165b);
                c4 = b0.c();
            }
            c4.a(d1Var);
            return;
        }
        str = "collectUrl is empty";
        v.e("hmsSdk", str);
    }
}
