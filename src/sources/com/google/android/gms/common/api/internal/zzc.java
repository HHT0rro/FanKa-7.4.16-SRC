package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzc extends Fragment implements i {

    /* renamed from: e, reason: collision with root package name */
    public static WeakHashMap<FragmentActivity, WeakReference<zzc>> f23512e = new WeakHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, LifecycleCallback> f23513b = Collections.synchronizedMap(new ArrayMap());

    /* renamed from: c, reason: collision with root package name */
    public int f23514c = 0;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Bundle f23515d;

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> iterator2 = this.f23513b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Iterator<LifecycleCallback> iterator2 = this.f23513b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b(i10, i11, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f23514c = 1;
        this.f23515d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f23513b.entrySet()) {
            entry.getValue().c(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f23514c = 5;
        Iterator<LifecycleCallback> iterator2 = this.f23513b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f23514c = 3;
        Iterator<LifecycleCallback> iterator2 = this.f23513b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f23513b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().f(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f23514c = 2;
        Iterator<LifecycleCallback> iterator2 = this.f23513b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f23514c = 4;
        Iterator<LifecycleCallback> iterator2 = this.f23513b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().h();
        }
    }
}
