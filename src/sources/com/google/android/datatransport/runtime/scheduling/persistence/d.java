package com.google.android.datatransport.runtime.scheduling.persistence;

import javax.inject.Named;

/* compiled from: EventStoreModule.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class d {
    @Named("SQLITE_DB_NAME")
    public static String a() {
        return "com.google.android.datatransport.events";
    }

    @Named("SCHEMA_VERSION")
    public static int b() {
        return f0.f19443d;
    }

    public static c c() {
        return c.f19437a;
    }
}
