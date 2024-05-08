package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j5 extends k5 {
    public boolean A;

    /* renamed from: o, reason: collision with root package name */
    public String f47830o;

    /* renamed from: p, reason: collision with root package name */
    public String f47831p;

    /* renamed from: q, reason: collision with root package name */
    public String f47832q;

    /* renamed from: r, reason: collision with root package name */
    public String f47833r;

    /* renamed from: s, reason: collision with root package name */
    public String f47834s;

    /* renamed from: t, reason: collision with root package name */
    public String f47835t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f47836u;

    /* renamed from: v, reason: collision with root package name */
    public String f47837v;

    /* renamed from: w, reason: collision with root package name */
    public String f47838w;

    /* renamed from: x, reason: collision with root package name */
    public String f47839x;

    /* renamed from: y, reason: collision with root package name */
    public String f47840y;

    /* renamed from: z, reason: collision with root package name */
    public String f47841z;

    public j5() {
        this.f47830o = null;
        this.f47831p = null;
        this.f47836u = false;
        this.f47838w = "";
        this.f47839x = "";
        this.f47840y = "";
        this.f47841z = "";
        this.A = false;
    }

    public j5(Bundle bundle) {
        super(bundle);
        this.f47830o = null;
        this.f47831p = null;
        this.f47836u = false;
        this.f47838w = "";
        this.f47839x = "";
        this.f47840y = "";
        this.f47841z = "";
        this.A = false;
        this.f47830o = bundle.getString("ext_msg_type");
        this.f47832q = bundle.getString("ext_msg_lang");
        this.f47831p = bundle.getString("ext_msg_thread");
        this.f47833r = bundle.getString("ext_msg_sub");
        this.f47834s = bundle.getString("ext_msg_body");
        this.f47835t = bundle.getString("ext_body_encode");
        this.f47837v = bundle.getString("ext_msg_appid");
        this.f47836u = bundle.getBoolean("ext_msg_trans", false);
        this.A = bundle.getBoolean("ext_msg_encrypt", false);
        this.f47838w = bundle.getString("ext_msg_seq");
        this.f47839x = bundle.getString("ext_msg_mseq");
        this.f47840y = bundle.getString("ext_msg_fseq");
        this.f47841z = bundle.getString("ext_msg_status");
    }

    public void A(boolean z10) {
        this.f47836u = z10;
    }

    public String B() {
        return this.f47830o;
    }

    public void C(String str) {
        this.f47838w = str;
    }

    public void D(boolean z10) {
        this.A = z10;
    }

    public String E() {
        return this.f47837v;
    }

    public void F(String str) {
        this.f47839x = str;
    }

    public String G() {
        return this.f47838w;
    }

    public void H(String str) {
        this.f47840y = str;
    }

    public String I() {
        return this.f47839x;
    }

    public void J(String str) {
        this.f47841z = str;
    }

    public String K() {
        return this.f47840y;
    }

    public void L(String str) {
        this.f47830o = str;
    }

    public String M() {
        return this.f47841z;
    }

    public void N(String str) {
        this.f47833r = str;
    }

    public String O() {
        return this.f47832q;
    }

    public void P(String str) {
        this.f47834s = str;
    }

    public void Q(String str) {
        this.f47831p = str;
    }

    public void R(String str) {
        this.f47832q = str;
    }

    @Override // com.xiaomi.push.k5
    public Bundle a() {
        Bundle a10 = super.a();
        if (!TextUtils.isEmpty(this.f47830o)) {
            a10.putString("ext_msg_type", this.f47830o);
        }
        String str = this.f47832q;
        if (str != null) {
            a10.putString("ext_msg_lang", str);
        }
        String str2 = this.f47833r;
        if (str2 != null) {
            a10.putString("ext_msg_sub", str2);
        }
        String str3 = this.f47834s;
        if (str3 != null) {
            a10.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f47835t)) {
            a10.putString("ext_body_encode", this.f47835t);
        }
        String str4 = this.f47831p;
        if (str4 != null) {
            a10.putString("ext_msg_thread", str4);
        }
        String str5 = this.f47837v;
        if (str5 != null) {
            a10.putString("ext_msg_appid", str5);
        }
        if (this.f47836u) {
            a10.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f47838w)) {
            a10.putString("ext_msg_seq", this.f47838w);
        }
        if (!TextUtils.isEmpty(this.f47839x)) {
            a10.putString("ext_msg_mseq", this.f47839x);
        }
        if (!TextUtils.isEmpty(this.f47840y)) {
            a10.putString("ext_msg_fseq", this.f47840y);
        }
        if (this.A) {
            a10.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f47841z)) {
            a10.putString("ext_msg_status", this.f47841z);
        }
        return a10;
    }

    @Override // com.xiaomi.push.k5
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j5 j5Var = (j5) obj;
        if (!super.equals(j5Var)) {
            return false;
        }
        String str = this.f47834s;
        if (str == null ? j5Var.f47834s != null : !str.equals(j5Var.f47834s)) {
            return false;
        }
        String str2 = this.f47832q;
        if (str2 == null ? j5Var.f47832q != null : !str2.equals(j5Var.f47832q)) {
            return false;
        }
        String str3 = this.f47833r;
        if (str3 == null ? j5Var.f47833r != null : !str3.equals(j5Var.f47833r)) {
            return false;
        }
        String str4 = this.f47831p;
        if (str4 == null ? j5Var.f47831p == null : str4.equals(j5Var.f47831p)) {
            return this.f47830o == j5Var.f47830o;
        }
        return false;
    }

    @Override // com.xiaomi.push.k5
    public String f() {
        n5 d10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<message");
        if (w() != null) {
            sb2.append(" xmlns=\"");
            sb2.append(w());
            sb2.append("\"");
        }
        if (this.f47832q != null) {
            sb2.append(" xml:lang=\"");
            sb2.append(O());
            sb2.append("\"");
        }
        if (l() != null) {
            sb2.append(" id=\"");
            sb2.append(l());
            sb2.append("\"");
        }
        if (o() != null) {
            sb2.append(" to=\"");
            sb2.append(u5.b(o()));
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(G())) {
            sb2.append(" seq=\"");
            sb2.append(G());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(I())) {
            sb2.append(" mseq=\"");
            sb2.append(I());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(K())) {
            sb2.append(" fseq=\"");
            sb2.append(K());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(M())) {
            sb2.append(" status=\"");
            sb2.append(M());
            sb2.append("\"");
        }
        if (q() != null) {
            sb2.append(" from=\"");
            sb2.append(u5.b(q()));
            sb2.append("\"");
        }
        if (m() != null) {
            sb2.append(" chid=\"");
            sb2.append(u5.b(m()));
            sb2.append("\"");
        }
        if (this.f47836u) {
            sb2.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f47837v)) {
            sb2.append(" appid=\"");
            sb2.append(E());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(this.f47830o)) {
            sb2.append(" type=\"");
            sb2.append(this.f47830o);
            sb2.append("\"");
        }
        if (this.A) {
            sb2.append(" s=\"1\"");
        }
        sb2.append(">");
        if (this.f47833r != null) {
            sb2.append("<subject>");
            sb2.append(u5.b(this.f47833r));
            sb2.append("</subject>");
        }
        if (this.f47834s != null) {
            sb2.append("<body");
            if (!TextUtils.isEmpty(this.f47835t)) {
                sb2.append(" encode=\"");
                sb2.append(this.f47835t);
                sb2.append("\"");
            }
            sb2.append(">");
            sb2.append(u5.b(this.f47834s));
            sb2.append("</body>");
        }
        if (this.f47831p != null) {
            sb2.append("<thread>");
            sb2.append(this.f47831p);
            sb2.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f47830o) && (d10 = d()) != null) {
            sb2.append(d10.b());
        }
        sb2.append(u());
        sb2.append("</message>");
        return sb2.toString();
    }

    @Override // com.xiaomi.push.k5
    public int hashCode() {
        String str = this.f47830o;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f47834s;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f47831p;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f47832q;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f47833r;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void y(String str) {
        this.f47837v = str;
    }

    public void z(String str, String str2) {
        this.f47834s = str;
        this.f47835t = str2;
    }
}
