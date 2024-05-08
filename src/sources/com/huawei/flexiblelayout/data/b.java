package com.huawei.flexiblelayout.data;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.FLDataParser;
import com.huawei.flexiblelayout.parser.csslink.LinkProvider;

/* compiled from: DataContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends o0 {

    /* renamed from: a, reason: collision with root package name */
    private FLMap f28091a;

    /* renamed from: b, reason: collision with root package name */
    private LinkProvider f28092b;

    /* renamed from: c, reason: collision with root package name */
    private FLNodeData f28093c;

    /* renamed from: d, reason: collision with root package name */
    private FLDataParser f28094d;

    /* compiled from: DataContext.java */
    /* renamed from: com.huawei.flexiblelayout.data.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0271b {

        /* renamed from: a, reason: collision with root package name */
        private final b f28095a;

        public C0271b(b bVar) {
            b bVar2 = new b();
            this.f28095a = bVar2;
            if (bVar != null) {
                bVar2.f28091a = bVar.f28091a;
                bVar2.f28092b = bVar.f28092b;
                bVar2.f28093c = bVar.f28093c;
                bVar2.f28094d = bVar.f28094d;
            }
        }

        public C0271b a(FLDataParser fLDataParser) {
            this.f28095a.f28094d = fLDataParser;
            return this;
        }

        public C0271b a(FLMap fLMap) {
            this.f28095a.f28091a = fLMap;
            return this;
        }

        public C0271b a(LinkProvider linkProvider) {
            this.f28095a.f28092b = linkProvider;
            return this;
        }

        public b a() {
            return this.f28095a;
        }

        public C0271b() {
            this.f28095a = new b();
        }
    }

    private b() {
    }

    public LinkProvider b() {
        return this.f28092b;
    }

    public FLNodeData c() {
        return this.f28093c;
    }

    public FLDataParser d() {
        return this.f28094d;
    }

    @Override // com.huawei.flexiblelayout.o0
    @NonNull
    public FLMap a() {
        FLMap fLMap = this.f28091a;
        return fLMap != null ? fLMap : Jsons.newJson();
    }

    public void a(FLNodeData fLNodeData) {
        this.f28093c = fLNodeData;
    }
}
