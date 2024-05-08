package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.alibaba.security.realidentity.build.bh;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, b> f45155a = new HashMap<>();

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call(java.lang.String r11, java.util.List<java.lang.String> r12, com.tencent.open.a.C0649a r13) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.b.call(java.lang.String, java.util.List, com.tencent.open.a$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.f45155a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0649a c0649a) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                list.set(i10, URLDecoder.decode(list.get(i10), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        b bVar = this.f45155a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0649a);
        } else {
            SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0649a != null) {
                c0649a.a();
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0649a {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<WebView> f45157a;

        /* renamed from: b, reason: collision with root package name */
        public long f45158b;

        /* renamed from: c, reason: collision with root package name */
        public String f45159c;

        public C0649a(WebView webView, long j10, String str) {
            this.f45157a = new WeakReference<>(webView);
            this.f45158b = j10;
            this.f45159c = str;
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f45157a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                obj2 = obj instanceof Boolean ? obj.toString() : "'undefined'";
            } else {
                obj2 = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f45158b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a() {
            WebView webView = this.f45157a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f45158b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f45157a.get();
            if (webView != null) {
                webView.loadUrl(bh.f3176j + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        C0649a c0649a = new C0649a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, subList, c0649a);
        return true;
    }
}
