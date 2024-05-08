package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.List;

/* compiled from: VEventResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class y7 extends t6 {
    private static void a(String[] strArr, HmsScan.EventTime eventTime) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            d3.a(str, eventTime);
        }
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (!a10.startsWith("BEGIN:VEVENT")) {
            return null;
        }
        String str = a10 + "\n";
        String a11 = a("SUMMARY", str, true);
        String a12 = a("LOCATION", str, true);
        String a13 = a("ORGANIZER", str, true);
        String a14 = a("DESCRIPTION", str, true);
        String a15 = a("STATUS", str, true);
        String[] b4 = b("DTSTART", str, true);
        String[] b10 = b("DTEND", str, true);
        HmsScan.EventTime eventTime = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        HmsScan.EventTime eventTime2 = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        a(b4, eventTime);
        a(b10, eventTime2);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a11, HmsScan.EVENT_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.EventInfo(a11, eventTime, eventTime2, a12, a14, a13, a15)));
    }

    private static String a(CharSequence charSequence, String str, boolean z10) {
        List<List<String>> b4 = x7.b(charSequence, str, z10, false);
        return (b4 == null || b4.isEmpty()) ? "" : b4.get(b4.size() - 1).get(0);
    }

    private static String[] b(CharSequence charSequence, String str, boolean z10) {
        List<List<String>> b4 = x7.b(charSequence, str, z10, false);
        if (b4 == null || b4.isEmpty()) {
            return new String[0];
        }
        int size = b4.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = b4.get(i10).get(0);
        }
        return strArr;
    }
}
