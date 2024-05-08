package com.jd.ad.sdk.jad_jt;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alipay.sdk.packet.e;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JADRequestBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_hu {
    public static JSONArray jad_an(JADSlot jADSlot) {
        JSONArray jad_bo;
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = new String[0];
        if (!TextUtils.isEmpty(jADSlot.getSlotID())) {
            objArr = jADSlot.getSlotID().split(",");
        }
        for (Object obj : objArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", UUIDUtils.uuid());
            jSONObject.put("tagid", obj);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.WIDTH, jADSlot.getAdImageWidth());
            jSONObject2.put("h", jADSlot.getAdImageHeight());
            jSONObject2.put("count", 1);
            jSONObject2.put("imgnum", 1);
            jSONObject.put(AgdManager.SOURCE_NATIVE, jSONObject2);
            jSONObject.put("isdeeplink", true);
            jSONObject.put("secure", 1);
            if (jADSlot.getDynamicRenderTemplateHelper() != null && (jad_bo = jADSlot.getDynamicRenderTemplateHelper().jad_bo()) != null && jad_bo.length() > 0) {
                jSONObject.put("template_list", jADSlot.getDynamicRenderTemplateHelper().jad_bo());
            }
            jSONObject.put("render_form", jADSlot.isFromNativeAd() ? 1 : 0);
            jSONObject.put("display_scene", jADSlot.getDisplayScene());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static byte[] jad_bo(@NonNull JADSlot jADSlot) {
        JSONObject jSONObject = new JSONObject();
        boolean z10 = true;
        try {
            jSONObject.put("id", jADSlot.getRequestId());
            jSONObject.put("version", "4.0");
            jSONObject.put("imp", jad_an(jADSlot));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", JADYunSdk.getAppId());
            jSONObject2.put(TTLiveConstants.BUNDLE_KEY, com.jd.ad.sdk.jad_ob.jad_hu.jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
            jSONObject2.put("sdkversion", "2.4.6");
            jSONObject.put("app", jSONObject2);
            jSONObject.put(e.f4642n, jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
            jSONObject.put("anti", jad_an());
        } catch (Exception e2) {
            String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
            int i10 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_JSON_ERROR.jad_an;
            String slotID = jADSlot != null ? jADSlot.getSlotID() : "";
            int adType = jADSlot != null ? jADSlot.getAdType() : 0;
            String jad_an = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_OTHER_ERROR.jad_an(e2.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.put(jSONObject3, ExposeManager.UtArgsNames.pid, slotID);
            JsonUtils.put(jSONObject3, "adt", Integer.valueOf(adType));
            JsonUtils.put(jSONObject3, "error", jad_an);
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(requestId, 3, i10, jSONObject3.toString(), jADSlot != null ? jADSlot.getSen() : 0);
        }
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Gateway API Request: ");
        jad_an2.append(jSONObject.toString());
        Logger.d(jad_an2.toString());
        String jSONObject4 = jSONObject.toString();
        com.jd.ad.sdk.jad_na.jad_an jad_an3 = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        if (jad_an3 != null && "1".equals(jad_an3.jad_bo)) {
            z10 = false;
        }
        if (z10) {
            jSONObject4 = ANEProxy.jd(jSONObject.toString());
            if (TextUtils.isEmpty(jSONObject4)) {
                return null;
            }
        }
        return jSONObject4.getBytes(Charset.forName("UTF-8"));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:39:0x01af
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0069 A[Catch: Exception -> 0x005f, TryCatch #2 {Exception -> 0x005f, blocks: (B:12:0x0050, B:100:0x0057, B:102:0x0061, B:104:0x0069, B:105:0x006e), top: B:11:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x006e A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #2 {Exception -> 0x005f, blocks: (B:12:0x0050, B:100:0x0057, B:102:0x0061, B:104:0x0069, B:105:0x006e), top: B:11:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0236 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0237 A[Catch: Exception -> 0x0254, TryCatch #10 {Exception -> 0x0254, blocks: (B:41:0x0230, B:50:0x0237, B:53:0x0240, B:55:0x0248, B:56:0x024d), top: B:40:0x0230 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0248 A[Catch: Exception -> 0x0254, TryCatch #10 {Exception -> 0x0254, blocks: (B:41:0x0230, B:50:0x0237, B:53:0x0240, B:55:0x0248, B:56:0x024d), top: B:40:0x0230 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024d A[Catch: Exception -> 0x0254, TRY_LEAVE, TryCatch #10 {Exception -> 0x0254, blocks: (B:41:0x0230, B:50:0x0237, B:53:0x0240, B:55:0x0248, B:56:0x024d), top: B:40:0x0230 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a7 A[Catch: Exception -> 0x01af, TryCatch #1 {Exception -> 0x01af, blocks: (B:33:0x01a0, B:58:0x01a7, B:60:0x01b1, B:62:0x01b9, B:63:0x01be), top: B:32:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b9 A[Catch: Exception -> 0x01af, TryCatch #1 {Exception -> 0x01af, blocks: (B:33:0x01a0, B:58:0x01a7, B:60:0x01b1, B:62:0x01b9, B:63:0x01be), top: B:32:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01be A[Catch: Exception -> 0x01af, TRY_LEAVE, TryCatch #1 {Exception -> 0x01af, blocks: (B:33:0x01a0, B:58:0x01a7, B:60:0x01b1, B:62:0x01b9, B:63:0x01be), top: B:32:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb A[Catch: Exception -> 0x00d3, TryCatch #11 {Exception -> 0x00d3, blocks: (B:27:0x00c4, B:70:0x00cb, B:72:0x00d5, B:74:0x00dd, B:75:0x00e2, B:83:0x00ec), top: B:26:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dd A[Catch: Exception -> 0x00d3, TryCatch #11 {Exception -> 0x00d3, blocks: (B:27:0x00c4, B:70:0x00cb, B:72:0x00d5, B:74:0x00dd, B:75:0x00e2, B:83:0x00ec), top: B:26:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e2 A[Catch: Exception -> 0x00d3, TryCatch #11 {Exception -> 0x00d3, blocks: (B:27:0x00c4, B:70:0x00cb, B:72:0x00d5, B:74:0x00dd, B:75:0x00e2, B:83:0x00ec), top: B:26:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0092 A[Catch: Exception -> 0x009a, TryCatch #6 {Exception -> 0x009a, blocks: (B:20:0x008b, B:87:0x0092, B:89:0x009c, B:91:0x00a4, B:92:0x00a9), top: B:19:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a4 A[Catch: Exception -> 0x009a, TryCatch #6 {Exception -> 0x009a, blocks: (B:20:0x008b, B:87:0x0092, B:89:0x009c, B:91:0x00a4, B:92:0x00a9), top: B:19:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a9 A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #6 {Exception -> 0x009a, blocks: (B:20:0x008b, B:87:0x0092, B:89:0x009c, B:91:0x00a4, B:92:0x00a9), top: B:19:0x008b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an() {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an():java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:144:0x04cf
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0500 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x054b A[Catch: Exception -> 0x0551, TRY_LEAVE, TryCatch #25 {Exception -> 0x0551, blocks: (B:119:0x0542, B:125:0x054b), top: B:118:0x0542 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0501 A[Catch: Exception -> 0x0532, TryCatch #9 {Exception -> 0x0532, blocks: (B:114:0x04fa, B:128:0x0501, B:132:0x050c, B:135:0x0524), top: B:113:0x04fa }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0510 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04c7 A[Catch: NumberFormatException -> 0x04cf, TryCatch #13 {NumberFormatException -> 0x04cf, blocks: (B:108:0x04c0, B:145:0x04c7, B:147:0x04d1, B:149:0x04d9, B:150:0x04de), top: B:107:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04d9 A[Catch: NumberFormatException -> 0x04cf, TryCatch #13 {NumberFormatException -> 0x04cf, blocks: (B:108:0x04c0, B:145:0x04c7, B:147:0x04d1, B:149:0x04d9, B:150:0x04de), top: B:107:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04de A[Catch: NumberFormatException -> 0x04cf, TRY_LEAVE, TryCatch #13 {NumberFormatException -> 0x04cf, blocks: (B:108:0x04c0, B:145:0x04c7, B:147:0x04d1, B:149:0x04d9, B:150:0x04de), top: B:107:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x049a A[Catch: Exception -> 0x0497, TRY_LEAVE, TryCatch #20 {Exception -> 0x0497, blocks: (B:101:0x0491, B:159:0x049a), top: B:100:0x0491 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0466 A[Catch: Exception -> 0x0488, TryCatch #34 {Exception -> 0x0488, blocks: (B:95:0x045f, B:175:0x0466, B:177:0x0470, B:179:0x0478, B:183:0x047d), top: B:94:0x045f }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0478 A[Catch: Exception -> 0x0488, TryCatch #34 {Exception -> 0x0488, blocks: (B:95:0x045f, B:175:0x0466, B:177:0x0470, B:179:0x0478, B:183:0x047d), top: B:94:0x045f }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x047d A[Catch: Exception -> 0x0488, TRY_LEAVE, TryCatch #34 {Exception -> 0x0488, blocks: (B:95:0x045f, B:175:0x0466, B:177:0x0470, B:179:0x0478, B:183:0x047d), top: B:94:0x045f }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x040c A[Catch: Exception -> 0x0457, TryCatch #21 {Exception -> 0x0457, blocks: (B:89:0x0405, B:189:0x040c, B:192:0x0415, B:194:0x041f), top: B:88:0x0405 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x041f A[Catch: Exception -> 0x0457, TRY_LEAVE, TryCatch #21 {Exception -> 0x0457, blocks: (B:89:0x0405, B:189:0x040c, B:192:0x0415, B:194:0x041f), top: B:88:0x0405 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03c8 A[Catch: Exception -> 0x03f8, TRY_LEAVE, TryCatch #5 {Exception -> 0x03f8, blocks: (B:83:0x03c1, B:198:0x03c8, B:205:0x03f1, B:210:0x03ee, B:203:0x03d5), top: B:82:0x03c1, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0373 A[Catch: Exception -> 0x0370, TryCatch #0 {Exception -> 0x0370, blocks: (B:77:0x036a, B:212:0x0373, B:215:0x037c, B:217:0x0384, B:218:0x0391, B:220:0x0399, B:221:0x03a1), top: B:76:0x036a }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0384 A[Catch: Exception -> 0x0370, TryCatch #0 {Exception -> 0x0370, blocks: (B:77:0x036a, B:212:0x0373, B:215:0x037c, B:217:0x0384, B:218:0x0391, B:220:0x0399, B:221:0x03a1), top: B:76:0x036a }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0391 A[Catch: Exception -> 0x0370, TryCatch #0 {Exception -> 0x0370, blocks: (B:77:0x036a, B:212:0x0373, B:215:0x037c, B:217:0x0384, B:218:0x0391, B:220:0x0399, B:221:0x03a1), top: B:76:0x036a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0345 A[Catch: Exception -> 0x0363, TryCatch #17 {Exception -> 0x0363, blocks: (B:72:0x033d, B:232:0x0345, B:234:0x034d, B:238:0x0356), top: B:71:0x033d }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0318 A[Catch: Exception -> 0x0332, TryCatch #10 {Exception -> 0x0332, blocks: (B:64:0x030e, B:247:0x0318, B:249:0x0320, B:253:0x0329), top: B:63:0x030e }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x02d0 A[Catch: Exception -> 0x0305, TryCatch #36 {Exception -> 0x0305, blocks: (B:58:0x02c7, B:259:0x02d0, B:261:0x02d8, B:266:0x02df), top: B:57:0x02c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x02a4 A[Catch: Exception -> 0x02bc, TryCatch #29 {Exception -> 0x02bc, blocks: (B:53:0x029a, B:272:0x02a4, B:274:0x02ac, B:278:0x02b1), top: B:52:0x029a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0282 A[Catch: Exception -> 0x0292, TryCatch #23 {Exception -> 0x0292, blocks: (B:47:0x027b, B:284:0x0282, B:287:0x028b), top: B:46:0x027b }] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0230 A[Catch: Exception -> 0x0254, TryCatch #22 {Exception -> 0x0254, blocks: (B:36:0x0229, B:293:0x0230, B:295:0x023a, B:297:0x0242, B:301:0x024b), top: B:35:0x0229 }] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0242 A[Catch: Exception -> 0x0254, TryCatch #22 {Exception -> 0x0254, blocks: (B:36:0x0229, B:293:0x0230, B:295:0x023a, B:297:0x0242, B:301:0x024b), top: B:35:0x0229 }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x024b A[Catch: Exception -> 0x0254, TRY_LEAVE, TryCatch #22 {Exception -> 0x0254, blocks: (B:36:0x0229, B:293:0x0230, B:295:0x023a, B:297:0x0242, B:301:0x024b), top: B:35:0x0229 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0209 A[Catch: Exception -> 0x0221, TryCatch #19 {Exception -> 0x0221, blocks: (B:30:0x01fe, B:307:0x0209, B:310:0x0214), top: B:29:0x01fe }] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x01d4 A[Catch: Exception -> 0x01ea, TryCatch #4 {Exception -> 0x01ea, blocks: (B:25:0x01ca, B:314:0x01d4, B:316:0x01dc, B:320:0x01e1), top: B:24:0x01ca }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0193 A[Catch: Exception -> 0x01bd, TryCatch #28 {Exception -> 0x01bd, blocks: (B:19:0x0187, B:327:0x0193, B:329:0x019b, B:330:0x01a2), top: B:18:0x0187 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x022f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x040b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0465 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject jad_an(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 1374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an(android.content.Context):org.json.JSONObject");
    }

    public static String jad_an(com.jd.ad.sdk.jad_na.jad_cp jad_cpVar, String str) {
        if (jad_cpVar == null) {
            return "";
        }
        com.jd.ad.sdk.jad_wj.jad_an jad_an = com.jd.ad.sdk.jad_mz.jad_jt.jad_an(str);
        if (jad_an != null && jad_an.jad_cp == 4) {
            String str2 = jad_cpVar.jad_an.jad_bo;
            Logger.w("The url is currently in a non-online environment ", new Object[0]);
            return str2;
        }
        Logger.i("The url is currently in a online environment ", new Object[0]);
        return jad_cpVar.jad_an.jad_an;
    }
}
