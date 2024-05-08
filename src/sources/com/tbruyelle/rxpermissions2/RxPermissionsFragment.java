package com.tbruyelle.rxpermissions2;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
import xb.a;
import xb.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RxPermissionsFragment extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public Map<String, PublishSubject<a>> f38990b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public boolean f38991c;

    public boolean N0(@NonNull String str) {
        return this.f38990b.containsKey(str);
    }

    public PublishSubject<a> O0(@NonNull String str) {
        return this.f38990b.get(str);
    }

    public boolean P0(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.checkSelfPermission(str) == 0;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    public boolean Q0(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    public void R0(String str) {
        if (this.f38991c) {
            String str2 = b.f54615b;
        }
    }

    public void S0(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            R0("onRequestPermissionsResult  " + strArr[i10]);
            PublishSubject<a> publishSubject = this.f38990b.get(strArr[i10]);
            if (publishSubject == null) {
                String str = b.f54615b;
                return;
            }
            this.f38990b.remove(strArr[i10]);
            publishSubject.onNext(new a(strArr[i10], iArr[i10] == 0, zArr[i10]));
            publishSubject.onComplete();
        }
    }

    public void T0(@NonNull String[] strArr) {
        requestPermissions(strArr, 42);
    }

    public void U0(@NonNull String str, @NonNull PublishSubject<a> publishSubject) {
        this.f38990b.put(str, publishSubject);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 != 42) {
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            zArr[i11] = shouldShowRequestPermissionRationale(strArr[i11]);
        }
        S0(strArr, iArr, zArr);
    }
}
