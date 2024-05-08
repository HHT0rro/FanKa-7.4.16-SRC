package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxFeedUt extends TanxBaseUt {
    public static void utClose(ITanxAd iTanxAd, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            if (iTanxAd.getBidInfo() != null) {
                String requestId = iTanxAd.getRequestId();
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = pid;
                str4 = requestId;
            } else {
                str = "";
                str2 = str;
                str4 = str2;
                str5 = str4;
                str3 = pid;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("option", i10 + "");
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_CANCEL;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, str6, buildArgs, str5);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void utViewDraw(com.alimm.tanx.core.ad.ITanxAd r17, int r18) {
        /*
            r0 = r18
            java.lang.String r1 = ""
            if (r17 == 0) goto L64
            com.alimm.tanx.core.request.TanxAdSlot r2 = r17.getAdSlot()
            if (r2 == 0) goto L15
            com.alimm.tanx.core.request.TanxAdSlot r2 = r17.getAdSlot()
            java.lang.String r2 = r2.getPid()
            goto L16
        L15:
            r2 = r1
        L16:
            java.lang.String r3 = r17.getRequestId()
            com.alimm.tanx.core.ad.bean.BidInfo r4 = r17.getBidInfo()
            if (r4 == 0) goto L62
            com.alimm.tanx.core.ad.bean.BidInfo r4 = r17.getBidInfo()
            java.lang.String r4 = r4.getCreativeId()
            com.alimm.tanx.core.ad.bean.BidInfo r5 = r17.getBidInfo()
            java.lang.String r5 = r5.getTemplateId()
            com.alimm.tanx.core.ad.bean.BidInfo r6 = r17.getBidInfo()
            java.lang.String r6 = r6.getSessionId()
            com.alimm.tanx.core.ad.bean.BidInfo r7 = r17.getBidInfo()
            com.alimm.tanx.core.ad.bean.TemplateConfig r7 = r7.getTemplateConf()
            if (r7 == 0) goto L69
            com.alimm.tanx.core.ad.bean.BidInfo r7 = r17.getBidInfo()
            com.alimm.tanx.core.ad.bean.TemplateConfig r7 = r7.getTemplateConf()
            java.lang.String r7 = r7.getPidStyleId()
            if (r7 == 0) goto L69
            com.alimm.tanx.core.ad.bean.BidInfo r7 = r17.getBidInfo()
            com.alimm.tanx.core.ad.bean.TemplateConfig r7 = r7.getTemplateConf()
            java.lang.String r7 = r7.getPidStyleId()
            r10 = r2
            r11 = r3
            r16 = r6
            r14 = r7
            goto L6e
        L62:
            r4 = r1
            goto L67
        L64:
            r2 = r1
            r3 = r2
            r4 = r3
        L67:
            r5 = r4
            r6 = r5
        L69:
            r14 = r1
            r10 = r2
            r11 = r3
            r16 = r6
        L6e:
            java.util.Map r15 = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(r10, r11, r4, r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "is_suc"
            r15.put(r2, r1)
            r1 = 1
            if (r0 != r1) goto L8c
            r0 = 0
            r9 = 0
            goto L8d
        L8c:
            r9 = 1
        L8d:
            com.alimm.tanx.core.ut.AdUtConstants r0 = com.alimm.tanx.core.ut.AdUtConstants.FLOW_VIEW_CREATE
            java.lang.String r12 = r0.arg1
            int r8 = r0.eventId
            java.lang.String r13 = ""
            r7 = r12
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ut.impl.TanxFeedUt.utViewDraw(com.alimm.tanx.core.ad.ITanxAd, int):void");
    }
}
