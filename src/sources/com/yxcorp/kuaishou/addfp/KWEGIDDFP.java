package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.a.d;
import com.yxcorp.kuaishou.addfp.android.a.e;
import com.yxcorp.kuaishou.addfp.android.b.g;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class KWEGIDDFP {
    private static final int EGID_LENGTH = 64;
    public static final int ERROR_TYPE_ACCESS_EXPTION = -1;
    public static final int ERROR_TYPE_NULL = -3;
    public static final int ERROR_TYPE_PROCESS = -4;
    public static final int ERROR_TYPE_UNKNOW = -2;
    private static int PROCESSALLOW = -1;
    private ResponseDfpCallback mCallBack;
    private String mEgid;
    private String mLocal;
    private Context mParamContext;
    private String mPkgName;
    private boolean mUserAgree;

    private KWEGIDDFP() {
        this.mPkgName = "";
        this.mEgid = "";
        this.mLocal = "";
        this.mUserAgree = false;
    }

    public /* synthetic */ KWEGIDDFP(a aVar) {
        this();
    }

    public static String doSign(Context context, String str) {
        return Orange.getInstance().getClockWrapper(context, str.getBytes(), 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEGid(ResponseDfpCallback responseDfpCallback) {
        try {
            getEGidImpl(new e(this.mParamContext).a());
            this.mLocal = c.c().a(this.mParamContext, responseDfpCallback, TextUtils.isEmpty(this.mEgid));
            if (responseDfpCallback == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.mEgid) || (!TextUtils.isEmpty(this.mLocal) && !this.mLocal.startsWith("KWE"))) {
                responseDfpCallback.onSuccess(this.mEgid, this.mLocal);
            } else {
                if (this.mLocal.equals("KWE_PE")) {
                    return;
                }
                responseDfpCallback.onFailed(-2, "need check");
            }
        } catch (Throwable th) {
            if (responseDfpCallback != null) {
                try {
                    responseDfpCallback.onFailed(-1, g.a(th));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private void getEGidImpl(boolean z10) {
        Object obj;
        try {
            Pair a10 = d.a(this.mParamContext).a();
            if (a10 != null && (obj = a10.second) != null) {
                String str = (String) ((ConcurrentHashMap) obj).get("cache_e");
                if (!TextUtils.isEmpty(str)) {
                    this.mEgid = str;
                }
            }
            if (TextUtils.isEmpty(this.mEgid)) {
                try {
                    String a11 = Build.VERSION.SDK_INT < 29 ? com.yxcorp.kuaishou.addfp.c.a.a.a(this.mParamContext, "k_w_o_d_out_dtt") : null;
                    String a12 = (TextUtils.isEmpty(a11) && g.a(this.mParamContext, new String[]{com.kuaishou.weapon.p0.g.f36123i, com.kuaishou.weapon.p0.g.f36124j})) ? d.a(this.mParamContext).a("Lm91a2R0ZnQ=") : "";
                    if (TextUtils.isEmpty(a11) && TextUtils.isEmpty(a12)) {
                        return;
                    }
                    LinkedHashMap b4 = d.a(this.mParamContext).b(a11);
                    if (b4 == null || b4.size() == 0) {
                        b4 = d.a(this.mParamContext).b(a12);
                    }
                    if (b4 == null || b4.size() <= 0) {
                        return;
                    }
                    String str2 = (String) b4.get(c.c().a());
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    this.mEgid = str2;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void handlePolicy(JSONObject jSONObject) {
        c.a(jSONObject);
    }

    public static KWEGIDDFP instance() {
        return b.a();
    }

    public void getEGidByCallback(Context context, boolean z10, ResponseDfpCallback responseDfpCallback) {
        try {
            this.mCallBack = responseDfpCallback;
            this.mParamContext = context;
            this.mUserAgree = z10;
            Thread thread = new Thread(new a(this));
            thread.setName("adsence-dfp");
            thread.start();
        } catch (Throwable th) {
            String a10 = g.a(th);
            if (responseDfpCallback != null) {
                responseDfpCallback.onFailed(-1, a10);
            }
        }
    }

    public String getEGidLocal(Context context, String str, boolean z10) {
        if (TextUtils.isEmpty(this.mEgid)) {
            return null;
        }
        return this.mEgid;
    }

    public Context getParamContext() {
        return this.mParamContext;
    }

    public boolean setEgid(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("DFP") || str.length() != 64) {
            return false;
        }
        d.a(context).a(str, "");
        return true;
    }

    public void setLog(boolean z10) {
        g.a(z10);
    }
}