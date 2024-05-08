package com.kwad.sdk.utils.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class a {

    /* renamed from: com.kwad.sdk.utils.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0546a extends j {
        public C0546a(int i10, int i11, Object obj, int i12, boolean z10) {
            super(i10, i11, obj, i12, z10);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 7;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class b {
        public int offset;

        public abstract byte Ns();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends b {
        public boolean value;

        public c(int i10, boolean z10) {
            this.offset = i10;
            this.value = z10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d extends b {
        public double value;

        public d(int i10, double d10) {
            this.offset = i10;
            this.value = d10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 5;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e extends b {
        public float value;

        public e(int i10, float f10) {
            this.offset = i10;
            this.value = f10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 3;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f extends b {
        public int value;

        public f(int i10, int i11) {
            this.offset = i10;
            this.value = i11;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class g extends b {
        public long value;

        public g(int i10, long j10) {
            this.offset = i10;
            this.value = j10;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 4;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class h extends j {
        public h(int i10, int i11, Object obj, int i12, boolean z10) {
            super(i10, i11, obj, i12, z10);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 8;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class i extends j {
        public i(int i10, int i11, String str, int i12, boolean z10) {
            super(i10, i11, str, i12, z10);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 6;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class j extends b {
        public int aRl;
        public boolean aRm;
        public int start;
        public Object value;

        public j(int i10, int i11, Object obj, int i12, boolean z10) {
            this.start = i10;
            this.offset = i11;
            this.value = obj;
            this.aRl = i12;
            this.aRm = z10;
        }
    }
}
