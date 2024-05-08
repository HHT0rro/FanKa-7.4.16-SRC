package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ku {
    public Long B;
    public Boolean C;
    public Long Code;
    public Integer I;
    public String S;
    public Integer V;
    public String Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a {
        public Long B;
        public Boolean C;
        public Long Code;
        public Integer I;
        public String S;
        public Integer V;
        public String Z;

        public a Code(Boolean bool) {
            this.C = bool;
            return this;
        }

        public a Code(Integer num) {
            this.V = num;
            return this;
        }

        public a Code(Long l10) {
            this.Code = l10;
            return this;
        }

        public a Code(String str) {
            this.Z = str;
            return this;
        }

        public ku Code() {
            ku kuVar = new ku();
            kuVar.Code = this.Code;
            kuVar.V = this.V;
            kuVar.I = this.I;
            kuVar.B = this.B;
            kuVar.Z = this.Z;
            kuVar.C = this.C;
            kuVar.S = this.S;
            return kuVar;
        }

        public a V(Integer num) {
            this.I = num;
            return this;
        }

        public a V(Long l10) {
            this.B = l10;
            return this;
        }

        public a V(String str) {
            this.S = str;
            return this;
        }
    }

    public Long B() {
        return this.B;
    }

    public Boolean C() {
        return this.C;
    }

    public Long Code() {
        return this.Code;
    }

    public void Code(Boolean bool) {
        this.C = bool;
    }

    public void Code(Integer num) {
        this.V = num;
    }

    public void Code(Long l10) {
        this.Code = l10;
    }

    public void Code(String str) {
        this.Z = str;
    }

    public Integer I() {
        return this.I;
    }

    public String S() {
        return this.S;
    }

    public Integer V() {
        return this.V;
    }

    public void V(Integer num) {
        this.I = num;
    }

    public void V(Long l10) {
        this.B = l10;
    }

    public void V(String str) {
        this.S = str;
    }

    public String Z() {
        return this.Z;
    }
}
