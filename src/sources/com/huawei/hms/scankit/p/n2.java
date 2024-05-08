package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DriverInfoResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n2 extends t6 {

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f31307c = new a();

    /* renamed from: b, reason: collision with root package name */
    private String f31308b = "";

    /* compiled from: DriverInfoResultParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends ArrayList<String> {
        public a() {
            add("");
            add("DCT");
            add("DAD");
            add("DCS");
            add("DBC");
            add("DBB");
            add("DAG");
            add("DAI");
            add("DAJ");
            add("DAK");
            add("DAQ");
            add("DCG");
            add("DBD");
            add("DBA");
        }
    }

    public HmsScan.DriverInfo a(String[] strArr, String str) {
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        strArr2[0] = str;
        boolean z10 = false;
        for (String str2 : strArr) {
            if (str2.length() <= 3) {
                return null;
            }
            int indexOf = f31307c.indexOf(str2.substring(0, 3));
            if (indexOf != -1) {
                strArr2[indexOf] = str2.substring(3).trim();
                z10 = true;
            }
        }
        if (!z10) {
            return null;
        }
        this.f31308b = strArr2[0] + " " + strArr2[3] + " " + strArr2[1];
        return new HmsScan.DriverInfo(strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], strArr2[9], strArr2[10], strArr2[11], strArr2[12], strArr2[13], null, null, null, null);
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (!TextUtils.isEmpty(a10) && a10.startsWith("@") && a10.length() > 34 && a10.substring(4, 8).equals("ANSI")) {
            String valueOf = String.valueOf(a10.charAt(1));
            String valueOf2 = String.valueOf(a10.charAt(3));
            String substring = a10.substring(21, 23);
            HmsScan.DriverInfo a11 = a(a10.substring(a10.indexOf(substring, 23) + 2).split(valueOf2)[0].split(valueOf), substring);
            if (a11 != null) {
                return new HmsScan(s6Var.k(), t6.a(s6Var.c()), this.f31308b, HmsScan.DRIVER_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(a11));
            }
        }
        return null;
    }
}
