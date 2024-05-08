package com.bytedance.pangle.transform;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class HostPartUtils {
    private Class fragmentActivityClazz;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final HostPartUtils f10968a = new HostPartUtils();
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }

    public static final Class getFragmentActivityClass() {
        return a.f10968a.fragmentActivityClazz;
    }
}
