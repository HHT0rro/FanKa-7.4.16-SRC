package com.tencent.turingface.sdk.mfa;

import android.util.Base64;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class F2BEC {

    /* renamed from: a, reason: collision with root package name */
    public static final String f45575a = kC0XR.a(kC0XR.O0);

    /* renamed from: b, reason: collision with root package name */
    public static final String f45576b = kC0XR.a(kC0XR.P0);

    /* renamed from: c, reason: collision with root package name */
    public static final String f45577c = kC0XR.a(kC0XR.Q0);

    /* renamed from: d, reason: collision with root package name */
    public static final String f45578d = kC0XR.a(kC0XR.R0);

    /* renamed from: e, reason: collision with root package name */
    public static final String f45579e = kC0XR.a(kC0XR.S0);

    /* renamed from: f, reason: collision with root package name */
    public long f45580f;

    /* renamed from: g, reason: collision with root package name */
    public int f45581g;

    /* renamed from: h, reason: collision with root package name */
    public String f45582h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<String> f45583i;

    public F2BEC(String str) {
        this.f45580f = -1L;
        this.f45581g = -1;
        this.f45582h = "";
        this.f45583i = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = f45579e;
            if (jSONObject.has(str2)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str2);
                optJSONArray.length();
                this.f45583i = new ArrayList<>();
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    this.f45583i.add(optJSONArray.getString(i10));
                }
                a((X509Certificate) CertificateFactory.getInstance(e.f29912b).generateCertificate(new ByteArrayInputStream(this.f45583i.get(0).getBytes())));
                jSONObject.put(f45577c, this.f45582h);
                jSONObject.put(f45578d, this.f45581g);
                jSONObject.put(f45576b, this.f45580f);
                jSONObject.toString();
                return;
            }
            this.f45580f = jSONObject.optLong(f45576b);
            this.f45581g = jSONObject.optInt(f45578d);
            this.f45582h = jSONObject.optString(f45577c);
            jSONObject.optString(f45575a);
        } catch (Exception unused) {
        }
    }

    public final void a(X509Certificate x509Certificate) {
        try {
            tfWT8.a(x509Certificate, this);
        } catch (Exception unused) {
        }
    }

    public F2BEC(Certificate[] certificateArr) {
        this.f45580f = -1L;
        this.f45581g = -1;
        this.f45582h = "";
        this.f45583i = null;
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < certificateArr.length; i10++) {
                    Certificate certificate = certificateArr[i10];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a10 = tfWT8.a(certificate);
                    if (i10 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.put(a10);
                    arrayList.add(a10);
                }
                this.f45583i = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f45579e, jSONArray);
                jSONObject.put(f45577c, this.f45582h);
                jSONObject.put(f45578d, this.f45581g);
                jSONObject.put(f45576b, this.f45580f);
                jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }
}
