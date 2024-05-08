package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ClientSettings {

    /* renamed from: a, reason: collision with root package name */
    private String f29704a;

    /* renamed from: b, reason: collision with root package name */
    private String f29705b;

    /* renamed from: c, reason: collision with root package name */
    private List<Scope> f29706c;

    /* renamed from: d, reason: collision with root package name */
    private String f29707d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f29708e;

    /* renamed from: f, reason: collision with root package name */
    private String f29709f;

    /* renamed from: g, reason: collision with root package name */
    private SubAppInfo f29710g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f29711h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f29712i;

    /* renamed from: j, reason: collision with root package name */
    private String f29713j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f29714k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f29704a = str;
        this.f29705b = str2;
        this.f29706c = list;
        this.f29707d = str3;
        this.f29708e = list2;
    }

    public List<String> getApiName() {
        return this.f29708e;
    }

    public String getAppID() {
        return this.f29707d;
    }

    public String getClientClassName() {
        return this.f29705b;
    }

    public String getClientPackageName() {
        return this.f29704a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f29711h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f29709f;
    }

    public String getInnerHmsPkg() {
        return this.f29713j;
    }

    public List<Scope> getScopes() {
        return this.f29706c;
    }

    public SubAppInfo getSubAppID() {
        return this.f29710g;
    }

    public boolean isHasActivity() {
        return this.f29712i;
    }

    public boolean isUseInnerHms() {
        return this.f29714k;
    }

    public void setApiName(List<String> list) {
        this.f29708e = list;
    }

    public void setAppID(String str) {
        this.f29707d = str;
    }

    public void setClientClassName(String str) {
        this.f29705b = str;
    }

    public void setClientPackageName(String str) {
        this.f29704a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f29711h = new WeakReference<>(activity);
        this.f29712i = true;
    }

    public void setCpID(String str) {
        this.f29709f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f29713j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f29706c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f29710g = subAppInfo;
    }

    public void setUseInnerHms(boolean z10) {
        this.f29714k = z10;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f29710g = subAppInfo;
    }
}
