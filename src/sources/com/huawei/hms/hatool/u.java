package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private List<b1> f30233a;

    /* renamed from: b, reason: collision with root package name */
    private String f30234b;

    /* renamed from: c, reason: collision with root package name */
    private String f30235c;

    /* renamed from: d, reason: collision with root package name */
    private String f30236d;

    public u(List<b1> list, String str, String str2, String str3) {
        this.f30233a = list;
        this.f30234b = str;
        this.f30235c = str2;
        this.f30236d = str3;
    }

    private void a(List<b1> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = i10 * 500;
            List<b1> subList = list.subList(i11, Math.min(list.size(), i11 + 500));
            String replace = UUID.randomUUID().toString().replace("-", "");
            long currentTimeMillis = System.currentTimeMillis();
            long b4 = a1.b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (b1 b1Var : subList) {
                if (!c0.a(b1Var.b(), currentTimeMillis, b4)) {
                    arrayList.add(b1Var);
                }
            }
            if (arrayList.size() > 0) {
                new l0(str2, str, this.f30236d, arrayList, replace).a();
            } else {
                v.e("hmsSdk", "No data to report handler");
            }
        }
    }

    public void a() {
        if (!"_default_config_tag".equals(this.f30235c)) {
            a(this.f30233a, this.f30235c, this.f30234b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (b1 b1Var : this.f30233a) {
            String c4 = b1Var.c();
            if (TextUtils.isEmpty(c4) || FrameworkConstant.DataType.STRING_OPER.equals(c4)) {
                arrayList4.add(b1Var);
            } else if (FrameworkConstant.DataType.STRING_MAINT.equals(c4)) {
                arrayList.add(b1Var);
            } else if (FrameworkConstant.DataType.STRING_PREINS.equals(c4)) {
                arrayList2.add(b1Var);
            } else if (FrameworkConstant.DataType.STRING_DIFFPRIVACY.equals(c4)) {
                arrayList3.add(b1Var);
            }
        }
        a(arrayList4, FrameworkConstant.DataType.STRING_OPER, "_default_config_tag");
        a(arrayList, FrameworkConstant.DataType.STRING_MAINT, "_default_config_tag");
        a(arrayList2, FrameworkConstant.DataType.STRING_PREINS, "_default_config_tag");
        a(arrayList3, FrameworkConstant.DataType.STRING_DIFFPRIVACY, "_default_config_tag");
    }
}
