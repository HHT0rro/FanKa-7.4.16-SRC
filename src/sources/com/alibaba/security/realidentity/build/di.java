package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.common.HttpMethod;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectURLPresigner.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class di {

    /* renamed from: a, reason: collision with root package name */
    public URI f3461a;

    /* renamed from: b, reason: collision with root package name */
    public bt f3462b;

    /* renamed from: c, reason: collision with root package name */
    private cj f3463c;

    public di(URI uri, cj cjVar, bt btVar) {
        this.f3461a = uri;
        this.f3463c = cjVar;
        this.f3462b = btVar;
    }

    private String a(String str, String str2, long j10) throws ClientException {
        ek ekVar = new ek(str, str2);
        ekVar.f3556e = j10;
        return a(ekVar);
    }

    private String a(String str, String str2) {
        String host = this.f3461a.getHost();
        if (!OSSUtils.c(host) || OSSUtils.a(host, (List<String>) Collections.unmodifiableList(this.f3462b.f3210f))) {
            host = str + "." + host;
        }
        return this.f3461a.getScheme() + "://" + host + "/" + ct.a(str2, "utf-8");
    }

    public final String a(ek ekVar) throws ClientException {
        String a10;
        String str = ekVar.f3553b;
        String str2 = ekVar.f3554c;
        String valueOf = String.valueOf((cr.a() / 1000) + ekVar.f3556e);
        HttpMethod httpMethod = ekVar.f3552a;
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        dj djVar = new dj();
        djVar.f3465b = this.f3461a;
        djVar.f3468e = httpMethod;
        djVar.f3466c = str;
        djVar.f3467d = str2;
        djVar.a().put("Date", valueOf);
        String str3 = ekVar.f3557f;
        if (str3 != null && !str3.trim().equals("")) {
            djVar.a().put("Content-Type", ekVar.f3557f);
        }
        String str4 = ekVar.f3558g;
        if (str4 != null && !str4.trim().equals("")) {
            djVar.a().put(cs.P, ekVar.f3558g);
        }
        Map<String, String> map = ekVar.f3559h;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : ekVar.f3559h.entrySet()) {
                djVar.f3470g.put(entry.getKey(), entry.getValue());
            }
        }
        String str5 = ekVar.f3555d;
        if (str5 != null && !str5.trim().equals("")) {
            djVar.f3470g.put(cg.I, ekVar.f3555d);
        }
        cm cmVar = null;
        cj cjVar = this.f3463c;
        if (cjVar instanceof cl) {
            cmVar = ((cl) cjVar).b();
            djVar.f3470g.put(cg.A, cmVar.f3347c);
        } else if (cjVar instanceof co) {
            cmVar = ((co) cjVar).a();
            djVar.f3470g.put(cg.A, cmVar.f3347c);
        }
        String a11 = OSSUtils.a(djVar);
        cj cjVar2 = this.f3463c;
        if (!(cjVar2 instanceof cl) && !(cjVar2 instanceof co)) {
            if (cjVar2 instanceof cn) {
                a10 = OSSUtils.a(((cn) cjVar2).f3349a, ((cn) cjVar2).f3350b, a11);
            } else if (cjVar2 instanceof ck) {
                a10 = ((ck) cjVar2).b();
            } else {
                throw new ClientException("Unknown credentialProvider!");
            }
        } else {
            a10 = OSSUtils.a(cmVar.f3345a, cmVar.f3346b, a11);
        }
        String substring = a10.split(com.huawei.openalliance.ad.constant.u.bD)[0].substring(4);
        String str6 = a10.split(com.huawei.openalliance.ad.constant.u.bD)[1];
        String host = this.f3461a.getHost();
        if (!OSSUtils.c(host) || OSSUtils.a(host, (List<String>) Collections.unmodifiableList(this.f3462b.f3210f))) {
            host = str + "." + host;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Expires", valueOf);
        linkedHashMap.put(cg.f3336z, substring);
        linkedHashMap.put(cg.f3335y, str6);
        linkedHashMap.putAll(djVar.f3470g);
        return this.f3461a.getScheme() + "://" + host + "/" + ct.a(str2, "utf-8") + SymbolValues.QUESTION_EN_SYMBOL + ct.a(linkedHashMap, "utf-8");
    }
}
