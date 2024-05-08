package com.hailiang.advlib.open;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Keep;
import com.hailiang.advlib.common.c;
import com.hailiang.advlib.common.d;
import com.hailiang.advlib.open.oaid.hla.f;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JFIdentifierManager {
    public static volatile JFIdentifierManager manager;
    public boolean isRetry;
    public Context mContext;
    public Object mInvokeResult;
    public long mNTime;
    public String mOAID = "";
    public String cOAID = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object invoke;
            if (method != null) {
                try {
                    if ("OnSupport".equals(method.getName())) {
                        invoke = objArr[1].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                    } else {
                        invoke = "onSupport".equals(method.getName()) ? objArr[0].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]) : null;
                    }
                    if (invoke instanceof String) {
                        JFIdentifierManager.this.mOAID = (String) invoke;
                    }
                    if (TextUtils.isEmpty(JFIdentifierManager.this.mOAID)) {
                        if (!TextUtils.isEmpty(JFIdentifierManager.this.cOAID)) {
                            JFIdentifierManager jFIdentifierManager = JFIdentifierManager.this;
                            jFIdentifierManager.mOAID = jFIdentifierManager.cOAID;
                        } else {
                            JFIdentifierManager.this.getNativeOaid();
                        }
                    }
                } catch (Throwable th) {
                    JFIdentifierManager jFIdentifierManager2 = JFIdentifierManager.this;
                    jFIdentifierManager2.report("oaid_ref_exp", jFIdentifierManager2.mInvokeResult, String.valueOf(th.getMessage()), method);
                    th.printStackTrace();
                }
            }
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements com.hailiang.advlib.open.oaid.a {
        public b() {
        }

        @Override // com.hailiang.advlib.open.oaid.a
        public void a(Exception exc) {
        }

        @Override // com.hailiang.advlib.open.oaid.a
        public void a(String str) {
            JFIdentifierManager.this.mOAID = str;
        }
    }

    public static JFIdentifierManager getInstance() {
        if (manager == null) {
            synchronized (JFIdentifierManager.class) {
                if (manager == null) {
                    manager = new JFIdentifierManager();
                }
            }
        }
        return manager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNativeOaid() {
        if (TextUtils.isEmpty(this.mOAID)) {
            f.a(this.mContext).a(new b());
        }
    }

    private boolean isSpecialVale(String str) {
        return str.equals("00000000000000000000000000000000") || str.equals("00000000-0000-0000-0000-000000000000");
    }

    private boolean isSpecialVersion() {
        return Build.VERSION.SDK_INT <= 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(String str, Object obj, String str2, Method method) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("op1", str);
            hashMap.put("opt_oaid_code", "" + obj);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("op2", str2);
            }
            if (method != null) {
                hashMap.put("opt_reflect_method", method.toString());
            }
            d.c(this.mContext, "init_oaid", hashMap);
        } catch (Throwable unused) {
        }
    }

    public void acquireOAID(Context context) {
        Class<?> cls;
        if (!this.isRetry && TextUtils.isEmpty(this.cOAID) && TextUtils.isEmpty(this.mOAID)) {
            this.isRetry = true;
            this.mContext = context;
            if (context == null || this.mNTime == 0 || System.currentTimeMillis() - this.mNTime <= 1000) {
                return;
            }
            try {
            } catch (Throwable th) {
                report("oaid_exception", this.mInvokeResult, String.valueOf(th.getMessage()), null);
            }
            if (isSpecialVersion()) {
                this.mNTime = System.currentTimeMillis();
                this.mInvokeResult = -1000;
                getNativeOaid();
                return;
            }
            Class<?> cls2 = Class.forName(new String(Base64.decode("Y29tLmJ1bi5taWl0bWRpZC5jb3JlLk1kaWRTZGtIZWxwZXI", 3)));
            try {
                cls = Class.forName(new String(Base64.decode("Y29tLmJ1bi5taWl0bWRpZC5pbnRlcmZhY2VzLklJZGVudGlmaWVyTGlzdGVuZXI", 3)));
            } catch (ClassNotFoundException unused) {
                cls = Class.forName(new String(Base64.decode("Y29tLmJ1bi5zdXBwbGllci5JSWRlbnRpZmllckxpc3RlbmVy", 3)));
            }
            Object newProxyInstance = Proxy.newProxyInstance(context.getClassLoader(), new Class[]{cls}, new a());
            c a10 = c.b(cls2).a("InitSdk", context, Boolean.TRUE, newProxyInstance);
            if (a10 != null) {
                this.mInvokeResult = a10.d();
            }
            try {
                Object obj = this.mInvokeResult;
                if (obj == null || ((obj instanceof Integer) && ((Integer) obj).intValue() != 1008610 && ((Integer) this.mInvokeResult).intValue() != 1008614)) {
                    getNativeOaid();
                }
            } catch (Throwable unused2) {
            }
            this.mNTime = System.currentTimeMillis();
        }
    }

    public String getOaid() {
        return this.mOAID;
    }

    public void setOaid(String str) {
        if (TextUtils.isEmpty(str) || isSpecialVale(str)) {
            return;
        }
        this.cOAID = str;
        if (TextUtils.isEmpty(this.mOAID)) {
            this.mOAID = this.cOAID;
        }
    }
}
