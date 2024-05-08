package com.baidu.mobads.sdk.internal;

import android.app.Fragment;
import com.baidu.mobads.sdk.api.CPUComponent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cx extends com.baidu.mobads.sdk.internal.a.e implements CPUComponent {

    /* renamed from: a, reason: collision with root package name */
    private final cy f10128a;

    /* renamed from: b, reason: collision with root package name */
    private Fragment f10129b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.fragment.app.Fragment f10130c;

    public cx(cy cyVar) {
        this.f10128a = cyVar;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void destroy() {
        cy cyVar = this.f10128a;
        if (cyVar != null) {
            cyVar.e();
        }
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public Fragment getFragment() {
        Fragment fragment = this.f10129b;
        if (fragment != null) {
            if (fragment instanceof FragmentDelegate) {
                ((FragmentDelegate) fragment).setProxy(this);
            }
            return this.f10129b;
        }
        cy cyVar = this.f10128a;
        if (cyVar == null) {
            return null;
        }
        Fragment a10 = cyVar.a((com.baidu.mobads.sdk.internal.a.e) this);
        this.f10129b = a10;
        return a10;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public androidx.fragment.app.Fragment getSupportFragment() {
        androidx.fragment.app.Fragment fragment = this.f10130c;
        if (fragment != null) {
            if (fragment instanceof FragmentV4Delegate) {
                ((FragmentV4Delegate) fragment).setProxy(this);
            }
            return this.f10130c;
        }
        cy cyVar = this.f10128a;
        if (cyVar == null) {
            return null;
        }
        androidx.fragment.app.Fragment b4 = cyVar.b((com.baidu.mobads.sdk.internal.a.e) this);
        this.f10130c = b4;
        return b4;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void refresh() {
        cy cyVar = this.f10128a;
        if (cyVar != null) {
            cyVar.f();
        }
    }
}
