package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.parser.DataKeys;

/* compiled from: DataKeysNonNull.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class z0 extends DataKeys {

    /* renamed from: a, reason: collision with root package name */
    private final DataKeys f28676a;

    /* compiled from: DataKeysNonNull.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f28677a = "flex";

        /* renamed from: b, reason: collision with root package name */
        public static final String f28678b = "align";

        /* renamed from: c, reason: collision with root package name */
        public static final String f28679c = "spacing";

        /* renamed from: d, reason: collision with root package name */
        public static final String f28680d = "mode";
    }

    public z0(DataKeys dataKeys) {
        this.f28676a = dataKeys;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String children() {
        return a(this.f28676a.children());
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String data() {
        return a(this.f28676a.data());
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String groupId() {
        return a(this.f28676a.groupId());
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String link() {
        return a(this.f28676a.link());
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String style() {
        return a(this.f28676a.style());
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String type() {
        return a(this.f28676a.type());
    }

    @Override // com.huawei.flexiblelayout.parser.DataKeys
    public String uri() {
        return a(this.f28676a.uri());
    }
}
