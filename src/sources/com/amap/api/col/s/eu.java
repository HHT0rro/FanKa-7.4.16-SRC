package com.amap.api.col.s;

/* compiled from: UpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class eu {

    /* renamed from: c, reason: collision with root package name */
    public eu f7936c;

    public eu() {
    }

    public void a(boolean z10) {
        eu euVar = this.f7936c;
        if (euVar != null) {
            euVar.a(z10);
        }
    }

    public abstract boolean a();

    public int b() {
        eu euVar = this.f7936c;
        return Math.min(Integer.MAX_VALUE, euVar != null ? euVar.b() : Integer.MAX_VALUE);
    }

    public final boolean c() {
        eu euVar = this.f7936c;
        if (euVar != null ? euVar.c() : true) {
            return a();
        }
        return false;
    }

    public eu(eu euVar) {
        this.f7936c = euVar;
    }

    public void a(int i10) {
        eu euVar = this.f7936c;
        if (euVar != null) {
            euVar.a(i10);
        }
    }
}
