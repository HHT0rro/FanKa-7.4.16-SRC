package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f36007a;

    public cw(Context context) {
        this.f36007a = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(44:7|(2:8|9)|(45:11|12|13|14|15|16|17|18|(1:20)|22|23|(1:25)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(3:55|(1:57)|58)|60|61|(1:63)|65|66|(1:68)|70)|94|95|17|18|(0)|22|23|(0)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(0)|60|61|(0)|65|66|(0)|70) */
    /* JADX WARN: Can't wrap try/catch for region: R(45:7|8|9|(45:11|12|13|14|15|16|17|18|(1:20)|22|23|(1:25)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(3:55|(1:57)|58)|60|61|(1:63)|65|66|(1:68)|70)|94|95|17|18|(0)|22|23|(0)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(0)|60|61|(0)|65|66|(0)|70) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0336, code lost:
    
        r13 = com.kuaishou.weapon.p0.t.f36217b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0339, code lost:
    
        r13 = com.kuaishou.weapon.p0.t.f36217b;
        r10 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0340, code lost:
    
        r13 = com.kuaishou.weapon.p0.t.f36217b;
        r10 = r18;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x028d, code lost:
    
        r17 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x033e, code lost:
    
        r17 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0102 A[Catch: Exception -> 0x0129, TRY_LEAVE, TryCatch #4 {Exception -> 0x0129, blocks: (B:18:0x00f3, B:20:0x0102), top: B:17:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013d A[Catch: Exception -> 0x0200, TRY_LEAVE, TryCatch #9 {Exception -> 0x0200, blocks: (B:23:0x0129, B:25:0x013d), top: B:22:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03e2 A[Catch: Exception -> 0x0447, TryCatch #14 {Exception -> 0x0447, blocks: (B:53:0x03d3, B:55:0x03e2, B:57:0x040e, B:58:0x0444), top: B:52:0x03d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0458 A[Catch: Exception -> 0x0489, TRY_LEAVE, TryCatch #3 {Exception -> 0x0489, blocks: (B:61:0x0447, B:63:0x0458), top: B:60:0x0447 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x049a A[Catch: Exception -> 0x04dd, TRY_LEAVE, TryCatch #12 {Exception -> 0x04dd, blocks: (B:66:0x0489, B:68:0x049a), top: B:65:0x0489 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kuaishou.weapon.p0.y b(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.cw.b(java.lang.String):com.kuaishou.weapon.p0.y");
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String a10 = new bn(this.f36007a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(a10)) {
                    return;
                }
                y b4 = b(a10);
                if (b4 != null) {
                    df.a(this.f36007a).a(str, b4);
                } else {
                    df.a(this.f36007a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = cu.f35992a + cu.f35995d;
            String a10 = cv.a(this.f36007a);
            if (!TextUtils.isEmpty(a10)) {
                str = str + SymbolValues.QUESTION_EN_SYMBOL + a10;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject b4 = cv.b(this.f36007a);
            if (b4 != null) {
                jSONObject.put("data", new bn(this.f36007a).c(b4.toString()));
            }
            l a11 = l.a(this.f36007a);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a11.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cw.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str2) {
                    try {
                        cw.this.a(str2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str2) {
                }
            });
        } catch (Exception unused) {
        }
    }
}
