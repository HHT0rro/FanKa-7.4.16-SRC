package o0;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f52242a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f52243b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f52244c = null;

    /* renamed from: d, reason: collision with root package name */
    public ValueSet f52245d = null;

    /* renamed from: o0.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0797b implements Result {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f52246a;

        /* renamed from: b, reason: collision with root package name */
        public final int f52247b;

        /* renamed from: c, reason: collision with root package name */
        public final String f52248c;

        /* renamed from: d, reason: collision with root package name */
        public final ValueSet f52249d;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f52247b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f52246a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f52248c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f52249d;
        }

        public C0797b(boolean z10, int i10, String str, ValueSet valueSet) {
            this.f52246a = z10;
            this.f52247b = i10;
            this.f52248c = str;
            this.f52249d = valueSet;
        }
    }

    public static final b b() {
        return new b();
    }

    public Result a() {
        boolean z10 = this.f52242a;
        int i10 = this.f52243b;
        String str = this.f52244c;
        ValueSet valueSet = this.f52245d;
        if (valueSet == null) {
            valueSet = o0.a.b().a();
        }
        return new C0797b(z10, i10, str, valueSet);
    }

    public b c(int i10) {
        this.f52243b = i10;
        return this;
    }

    public b d(ValueSet valueSet) {
        this.f52245d = valueSet;
        return this;
    }

    public b e(String str) {
        this.f52244c = str;
        return this;
    }

    public b f(boolean z10) {
        this.f52242a = z10;
        return this;
    }
}
