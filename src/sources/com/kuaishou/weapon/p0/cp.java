package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cp {
    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, String str, final String str2, final boolean z10, boolean z11) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f35992a + cu.f35996e;
            String a10 = cv.a(context);
            if (!TextUtils.isEmpty(a10)) {
                if (cu.a() && str2 != null) {
                    str3 = str3 + "?logId=" + str2 + "&" + a10;
                } else {
                    str3 = str3 + SymbolValues.QUESTION_EN_SYMBOL + a10;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z11) {
                jSONObject = new JSONObject();
                String c4 = new bn(context).c(str);
                if (!TextUtils.isEmpty(c4)) {
                    jSONObject.put("data", c4);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l a11 = l.a(context);
            m mVar = new m(str3, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a11.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cp.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str4) {
                    if (TextUtils.isEmpty(String.this)) {
                        return;
                    }
                    try {
                        if (String.this.equals(ck.f35932b)) {
                            df.a(context).a(System.currentTimeMillis());
                        } else if (String.this.equals(ck.f35933c)) {
                            df.a(context).a(df.bj, System.currentTimeMillis());
                        } else if (String.this.equals(ck.f35934d)) {
                            df.a(context).a(df.bi, System.currentTimeMillis());
                        } else if (String.this.equals(ck.f35937g)) {
                            df.a(context).a(df.bm, System.currentTimeMillis());
                        } else if (String.this.equals(ck.f35939i)) {
                            df.a(context).a(df.bh, System.currentTimeMillis());
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str4) {
                    if (z10) {
                        TextUtils.isEmpty(String.this);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
