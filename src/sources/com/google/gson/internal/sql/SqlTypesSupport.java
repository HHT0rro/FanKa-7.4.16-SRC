package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SqlTypesSupport {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f27028a;

    /* renamed from: b, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType<? extends Date> f27029b;

    /* renamed from: c, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType<? extends Date> f27030c;

    /* renamed from: d, reason: collision with root package name */
    public static final TypeAdapterFactory f27031d;

    /* renamed from: e, reason: collision with root package name */
    public static final TypeAdapterFactory f27032e;

    /* renamed from: f, reason: collision with root package name */
    public static final TypeAdapterFactory f27033f;

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f27028a = z10;
        if (z10) {
            f27029b = new DefaultDateTypeAdapter.DateType<java.sql.Date>(java.sql.Date.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.1
                @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public java.sql.Date d(Date date) {
                    return new java.sql.Date(date.getTime());
                }
            };
            f27030c = new DefaultDateTypeAdapter.DateType<Timestamp>(Timestamp.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.2
                @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public Timestamp d(Date date) {
                    return new Timestamp(date.getTime());
                }
            };
            f27031d = SqlDateTypeAdapter.f27022b;
            f27032e = SqlTimeTypeAdapter.f27024b;
            f27033f = SqlTimestampTypeAdapter.f27026b;
            return;
        }
        f27029b = null;
        f27030c = null;
        f27031d = null;
        f27032e = null;
        f27033f = null;
    }

    private SqlTypesSupport() {
    }
}
