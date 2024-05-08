package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;

/* renamed from: com.alibaba.wireless.security.open.initialize.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0082 implements IInitializeComponent {

    /* renamed from: а, reason: contains not printable characters */
    public C0083 f183;

    public C0082() {
        this.f183 = new C0083();
    }

    public C0082(String str) {
        this.f183 = new C0083(str);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int initialize(Context context) throws SecException {
        return loadLibrarySync(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void initializeAsync(Context context) {
        try {
            loadLibraryAsync(context);
        } catch (SecException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public boolean isSoValid(Context context) throws SecException {
        return this.f183.m1950(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void loadLibraryAsync(Context context) throws SecException {
        this.f183.m1948(context, null, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context) throws SecException {
        return this.f183.m1951(context, null, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context, String str) throws SecException {
        return this.f183.m1951(context, str, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void registerInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.f183.m1949(iInitFinishListener);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.f183.m1952(iInitFinishListener);
    }

    /* renamed from: а, reason: contains not printable characters */
    public ISGPluginManager m1942() {
        return this.f183.m1947();
    }
}
