package com.bytedance.pangle.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Array;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public Fragment f10772a;

    public c(Fragment fragment) {
        this.f10772a = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Object[] objArr;
        if (this.f10772a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            Object obj = null;
            for (Object obj2 : objArr) {
                Object readField = FieldUtils.readField(obj2, "mTag");
                if (!"androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) && (!(readField instanceof String) || (!((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") && !((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                }
                obj = obj2;
                break;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i10 = 0;
                for (int i11 = 0; i11 < objArr.length; i11++) {
                    if (objArr[i11] != obj) {
                        objArr2[i10] = objArr[i11];
                        iArr[i10] = i11;
                        i10++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Object[] objArr;
        if (this.f10772a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            Object obj = null;
            for (Object obj2 : objArr) {
                Object readField = FieldUtils.readField(obj2, "mTag");
                if (!"androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) && (!(readField instanceof String) || (!((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") && !((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                }
                obj = obj2;
                break;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i10 = 0;
                for (int i11 = 0; i11 < objArr.length; i11++) {
                    if (objArr[i11] != obj) {
                        objArr2[i10] = objArr[i11];
                        iArr[i10] = i11;
                        i10++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
