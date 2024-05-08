package com.huawei.qcardsupport.qcard.cardmanager.impl;

import androidx.annotation.NonNull;
import com.huawei.qcardsupport.qcard.cardmanager.InputStreamProvider;
import com.huawei.quickcard.cardmanager.appgallery.PresetCardStreamProvider;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: QuickStreamProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g implements PresetCardStreamProvider {

    /* renamed from: a, reason: collision with root package name */
    private final Object f33230a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<InputStreamProvider> f33231b = new ArrayList<>();

    public void a(InputStreamProvider inputStreamProvider) {
        synchronized (this.f33230a) {
            if (inputStreamProvider != null) {
                if (!this.f33231b.contains(inputStreamProvider)) {
                    this.f33231b.add(inputStreamProvider);
                }
            }
        }
    }

    @Override // com.huawei.quickcard.cardmanager.appgallery.PresetCardStreamProvider
    @NonNull
    public InputStream open(int i10) throws IOException {
        InputStreamProvider inputStreamProvider;
        InputStream open;
        synchronized (this.f33230a) {
            if (i10 < this.f33231b.size() && (inputStreamProvider = this.f33231b.get(i10)) != null) {
                open = inputStreamProvider.open();
            } else {
                throw new IOException("Not found.");
            }
        }
        return open;
    }

    @Override // com.huawei.quickcard.cardmanager.appgallery.PresetCardStreamProvider
    public int size() {
        int size;
        synchronized (this.f33230a) {
            size = this.f33231b.size();
        }
        return size;
    }
}
