package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: OfflineMapRemoveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class be {

    /* renamed from: a, reason: collision with root package name */
    private Context f5117a;

    public be(Context context) {
        this.f5117a = context;
    }

    private boolean b(ax axVar) {
        if (axVar != null) {
            String pinyin = axVar.getPinyin();
            boolean a10 = a(pinyin, this.f5117a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z10 = true;
            boolean z11 = a(pinyin, this.f5117a, "map/") || a10;
            if (!b(bv.b(axVar.getUrl()), this.f5117a, "map/") && !z11) {
                z10 = false;
            }
            if (z10) {
                axVar.i();
                return z10;
            }
            axVar.h();
        }
        return false;
    }

    public final void a(ax axVar) {
        b(axVar);
    }

    private static boolean a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b4 = dx.b(context);
        try {
            File file = new File(b4 + str2 + str + ".dat");
            if (file.exists()) {
                if (!bv.b(file)) {
                    return false;
                }
            }
            try {
                bv.a(b4 + str2);
                bv.b(str, context);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        } catch (Exception e12) {
            e12.printStackTrace();
            return false;
        }
    }

    private static boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a10 = dx.a(context);
        try {
            File file = new File(a10 + str2 + str);
            if (file.exists()) {
                if (!bv.b(file)) {
                    return false;
                }
            }
            try {
                bv.a(a10 + str2);
                bv.b(str, context);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        } catch (Exception e12) {
            e12.printStackTrace();
            return false;
        }
    }
}
