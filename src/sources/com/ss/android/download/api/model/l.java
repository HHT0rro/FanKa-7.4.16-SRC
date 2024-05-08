package com.ss.android.download.api.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private String dk;

    /* renamed from: m, reason: collision with root package name */
    private String f38440m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {
        private String dk;

        /* renamed from: m, reason: collision with root package name */
        private String f38441m;

        public m dk(String str) {
            this.dk = str;
            return this;
        }

        public m m(String str) {
            this.f38441m = str;
            return this;
        }

        public l m() {
            return new l(this);
        }
    }

    public l(m mVar) {
        this.f38440m = mVar.f38441m;
        this.dk = mVar.dk;
    }

    public String m() {
        return this.f38440m;
    }
}
