package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.avQ = jSONObject.optLong("request_prepare_cost");
        jVar.avR = jSONObject.optLong("request_add_params_cost");
        jVar.avS = jSONObject.optLong("request_create_cost");
        jVar.avT = jSONObject.optInt("keep_alive");
        jVar.avU = jSONObject.optLong("dns_start");
        jVar.avV = jSONObject.optLong("dns_cost");
        jVar.avW = jSONObject.optLong("connect_establish_start");
        jVar.avX = jSONObject.optLong("connect_establish_cost");
        jVar.avY = jSONObject.optLong("request_start");
        jVar.avZ = jSONObject.optLong("request_cost");
        jVar.awa = jSONObject.optLong("request_size");
        jVar.awb = jSONObject.optLong("response_start");
        jVar.awc = jSONObject.optLong("response_cost");
        jVar.awd = jSONObject.optLong("response_parse_cost");
        jVar.awe = jSONObject.optLong("response_size");
        jVar.awf = jSONObject.optLong("waiting_response_cost");
        jVar.awg = jSONObject.optLong("total_cost");
        jVar.awh = jSONObject.optInt("proxy_used");
        jVar.awi = jSONObject.optString(com.huawei.openalliance.ad.constant.ax.f32264g);
        if (JSONObject.NULL.toString().equals(jVar.awi)) {
            jVar.awi = "";
        }
        jVar.awj = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.awk = jSONObject.optLong("response_done_cost");
        jVar.awl = jSONObject.optString(MonitorConstants.HOST_IP);
        if (JSONObject.NULL.toString().equals(jVar.awl)) {
            jVar.awl = "";
        }
        jVar.awm = jSONObject.optInt("ip_type");
        jVar.awn = jSONObject.optInt("recommend_ping_time");
        jVar.awo = jSONObject.optInt("backup_ping_time");
        jVar.awp = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = jVar.avQ;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_prepare_cost", j10);
        }
        long j11 = jVar.avR;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_add_params_cost", j11);
        }
        long j12 = jVar.avS;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_create_cost", j12);
        }
        int i10 = jVar.avT;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "keep_alive", i10);
        }
        long j13 = jVar.avU;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_start", j13);
        }
        long j14 = jVar.avV;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_cost", j14);
        }
        long j15 = jVar.avW;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_start", j15);
        }
        long j16 = jVar.avX;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_cost", j16);
        }
        long j17 = jVar.avY;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_start", j17);
        }
        long j18 = jVar.avZ;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_cost", j18);
        }
        long j19 = jVar.awa;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_size", j19);
        }
        long j20 = jVar.awb;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_start", j20);
        }
        long j21 = jVar.awc;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_cost", j21);
        }
        long j22 = jVar.awd;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_parse_cost", j22);
        }
        long j23 = jVar.awe;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_size", j23);
        }
        long j24 = jVar.awf;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "waiting_response_cost", j24);
        }
        long j25 = jVar.awg;
        if (j25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_cost", j25);
        }
        int i11 = jVar.awh;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "proxy_used", i11);
        }
        String str = jVar.awi;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.constant.ax.f32264g, jVar.awi);
        }
        int i12 = jVar.awj;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "has_data_v2", i12);
        }
        int i13 = jVar.result;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "result", i13);
        }
        long j26 = jVar.awk;
        if (j26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_done_cost", j26);
        }
        String str2 = jVar.awl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.HOST_IP, jVar.awl);
        }
        int i14 = jVar.awm;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ip_type", i14);
        }
        int i15 = jVar.awn;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recommend_ping_time", i15);
        }
        int i16 = jVar.awo;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backup_ping_time", i16);
        }
        int i17 = jVar.awp;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "other_ping_time", i17);
        }
        return jSONObject;
    }
}
