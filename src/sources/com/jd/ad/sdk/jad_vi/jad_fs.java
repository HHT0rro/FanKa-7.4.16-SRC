package com.jd.ad.sdk.jad_vi;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_vi.jad_iv;
import org.json.JSONObject;

/* compiled from: EventReporter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_fs {
    public static void jad_an(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, int i18, int i19, int i20) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 1);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i12));
        JsonUtils.put(jSONObject, "plwd", Integer.valueOf(i14));
        JsonUtils.put(jSONObject, "plht", Integer.valueOf(i13));
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i15));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i16));
        JsonUtils.put(jSONObject, "tcbr", Long.valueOf(j10));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i17));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i18));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i19));
        JsonUtils.put(jSONObject, "toti", Integer.valueOf(i20));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, int i15, long j11, int i16, int i17, int i18, int i19, int i20, int i21) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 2);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i12));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i13));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i14));
        JsonUtils.put(jSONObject, "sddu", Long.valueOf(j10));
        JsonUtils.put(jSONObject, "alct", Integer.valueOf(i15));
        JsonUtils.put(jSONObject, "alct", Integer.valueOf(i15));
        JsonUtils.put(jSONObject, "jdad", Long.valueOf(j11));
        JsonUtils.put(jSONObject, "adat", Integer.valueOf(i16));
        JsonUtils.put(jSONObject, "catp", Integer.valueOf(i17));
        JsonUtils.put(jSONObject, "msst", Integer.valueOf(i18));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i19));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i20));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i21));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, long j10, long j11, int i16, int i17, int i18, int i19, JSONObject jSONObject, int i20, int i21, int i22) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.put(jSONObject2, "tp", 3);
        JsonUtils.put(jSONObject2, "adrid", str);
        JsonUtils.put(jSONObject2, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject2, "pfid", Integer.valueOf(i10));
        JsonUtils.put(jSONObject2, "adt", Integer.valueOf(i11));
        JsonUtils.put(jSONObject2, "exid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject2, "tpid", Integer.valueOf(i12));
        JsonUtils.put(jSONObject2, "sen", Integer.valueOf(i13));
        JsonUtils.put(jSONObject2, "rem", Integer.valueOf(i14));
        JsonUtils.put(jSONObject2, "imm", Integer.valueOf(i15));
        JsonUtils.put(jSONObject2, "sedu", Long.valueOf(j10));
        JsonUtils.put(jSONObject2, "dedu", Long.valueOf(j11));
        JsonUtils.put(jSONObject2, "sspt", Integer.valueOf(i16));
        JsonUtils.put(jSONObject2, "scav", Integer.valueOf(i17));
        JsonUtils.put(jSONObject2, "adat", Integer.valueOf(i18));
        JsonUtils.put(jSONObject2, "catp", Integer.valueOf(i19));
        JsonUtils.put(jSONObject2, "cons", jSONObject);
        JsonUtils.put(jSONObject2, "dstp", Integer.valueOf(i20));
        JsonUtils.put(jSONObject2, "srtp", Integer.valueOf(i21));
        JsonUtils.put(jSONObject2, "ipl", Integer.valueOf(i22));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject2);
    }

    public static void jad_an(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, long j10, long j11, long j12, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 4);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "clid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i12));
        JsonUtils.put(jSONObject, "clf", Integer.valueOf(CommonConstants.ClickFrom.AD.ordinal()));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i13));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i14));
        JsonUtils.put(jSONObject, "dety", Integer.valueOf(i15));
        JsonUtils.put(jSONObject, "scdu", Long.valueOf(j10));
        JsonUtils.put(jSONObject, "dcdu", Long.valueOf(j11));
        JsonUtils.put(jSONObject, "ecdu", Long.valueOf(j12));
        JsonUtils.put(jSONObject, "sspt", Integer.valueOf(i16));
        JsonUtils.put(jSONObject, "scav", Integer.valueOf(i17));
        JsonUtils.put(jSONObject, "adat", Integer.valueOf(i18));
        JsonUtils.put(jSONObject, "atst", Integer.valueOf(i19));
        JsonUtils.put(jSONObject, "catp", Integer.valueOf(i20));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i21));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i22));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i23));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, long j10, long j11, long j12, int i16, int i17, int i18, int i19, int i20, int i21) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 4);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "clid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i12));
        JsonUtils.put(jSONObject, "clf", Integer.valueOf(i18));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i13));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i14));
        JsonUtils.put(jSONObject, "dety", Integer.valueOf(i15));
        JsonUtils.put(jSONObject, "scdu", Long.valueOf(j10));
        JsonUtils.put(jSONObject, "dcdu", Long.valueOf(j11));
        JsonUtils.put(jSONObject, "ecdu", Long.valueOf(j12));
        JsonUtils.put(jSONObject, "sspt", Integer.valueOf(i16));
        JsonUtils.put(jSONObject, "scav", Integer.valueOf(i17));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i19));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i20));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i21));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, int i10, String str2) {
        jad_an(str, 5, i10, str2, 0);
    }

    public static void jad_an(String str, int i10, int i11, String str2, int i12) {
        if (com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_NET_IS_UNAVAILABLE_ERROR.jad_an(new String[0]).equals(str2)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 5);
        if (i10 != 2 && i10 != 3) {
            JsonUtils.put(jSONObject, "rid", "");
        } else {
            JsonUtils.put(jSONObject, "rid", str);
        }
        JsonUtils.put(jSONObject, "extp", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "ercd", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "erin", str2);
        if (i10 == 3) {
            JsonUtils.put(jSONObject, "sen", Integer.valueOf(i12));
        } else {
            JsonUtils.put(jSONObject, "sen", 0);
        }
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 6);
        JsonUtils.put(jSONObject, "iid", str);
        JsonUtils.put(jSONObject, "init", 2);
        JsonUtils.put(jSONObject, "idu", 0);
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, long j10) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 6);
        JsonUtils.put(jSONObject, "iid", str);
        JsonUtils.put(jSONObject, "init", 3);
        JsonUtils.put(jSONObject, "idu", Long.valueOf(j10));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }
}
