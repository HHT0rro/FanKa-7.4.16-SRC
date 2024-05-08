package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private dj f10242a;

    /* renamed from: b, reason: collision with root package name */
    private String f10243b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();

        void a(int i10, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i10);

        void a(List<NativeResponse> list);

        void b();

        void b(int i10, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public f(Context context, String str, a aVar, boolean z10, int i10) {
        this(context, aVar, new dj(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z10, i10));
    }

    public void a() {
        dj djVar = this.f10242a;
        if (djVar != null) {
            djVar.e();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public f(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z10, int i10) {
        dj djVar = new dj(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z10, i10);
        this.f10242a = djVar;
        djVar.a(expressAdListener);
        this.f10242a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dj djVar = this.f10242a;
        if (djVar != null) {
            djVar.h(this.f10243b);
        }
        this.f10242a.a(requestParameters);
        this.f10242a.a();
    }

    public void a(b bVar) {
        dj djVar = this.f10242a;
        if (djVar != null) {
            djVar.a(bVar);
        }
    }

    public void a(int i10) {
        dj djVar = this.f10242a;
        if (djVar != null) {
            djVar.f9886p = i10;
        }
    }

    public f(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z10, int i10) {
        dj djVar = new dj(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z10, i10);
        this.f10242a = djVar;
        djVar.a(entryAdListener);
    }

    public void a(boolean z10) {
        dj djVar = this.f10242a;
        if (djVar != null) {
            djVar.c(z10);
        }
    }

    public void b(String str) {
        this.f10243b = str;
    }

    public f(Context context, String str, a aVar, boolean z10, int i10, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f10242a = new dj(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z10, i10);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f10242a = new dj(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z10, i10);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f10242a = new dj(context, str, "video", z10, i10);
            } else {
                this.f10242a = new dj(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z10, i10);
            }
        }
        this.f10242a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.f10242a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.f10242a.h(this.f10243b);
        this.f10242a.a(requestParameters);
        return this.f10242a.m();
    }

    public void a(String str) {
        dj djVar = this.f10242a;
        if (djVar != null) {
            djVar.b(str);
        }
    }

    public f(Context context, a aVar, dj djVar) {
        this.f10242a = djVar;
        djVar.a(aVar);
    }
}
