package com.google.android.datatransport.runtime.dagger.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
enum MembersInjectors$NoOpMembersInjector {
    INSTANCE;

    public void injectMembers(Object obj) {
        d.c(obj, "Cannot inject members into a null reference");
    }
}
