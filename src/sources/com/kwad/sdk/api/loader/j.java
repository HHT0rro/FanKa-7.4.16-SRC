package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {
    public static int ams;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private int amt;
        private int amu;
        private String amv;
        private String amw;
        private long amx;
        private int amy;
        private String amz;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aa(long j10) {
            this.amx = j10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bX(int i10) {
            this.amt = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bY(int i10) {
            this.amu = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bZ(int i10) {
            this.amy = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cd(String str) {
            this.amv = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ce(String str) {
            this.amw = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cf(String str) {
            this.amz = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.amt));
                jSONObject.putOpt("update_count", Integer.valueOf(this.amu));
                jSONObject.putOpt("dynamic_version", this.amv);
                jSONObject.putOpt("download_url", this.amw);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.amx));
                jSONObject.putOpt("error_code", Integer.valueOf(this.amy));
                jSONObject.putOpt("error_msg", this.amz);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.amt + ", update_count=" + this.amu + ", dynamic_version='" + this.amv + "', download_url='" + this.amw + "', duration_ms=" + this.amx + ", error_code=" + this.amy + ", error_msg='" + this.amz + "'}";
        }
    }

    public static void a(a.C0509a c0509a) {
        ams++;
        a(1, c0509a, 0L, 0, "");
    }

    public static void b(a.C0509a c0509a) {
        a(5, c0509a, 0L, 0, "");
    }

    public static void b(a.C0509a c0509a, long j10) {
        a(6, c0509a, j10, 0, "");
    }

    public static void a(a.C0509a c0509a, long j10) {
        a(2, c0509a, j10, 0, "");
    }

    public static void b(a.C0509a c0509a, int i10, String str) {
        a(7, c0509a, 0L, i10, str);
    }

    public static void a(a.C0509a c0509a, long j10, String str) {
        a(3, c0509a, j10, 0, str);
    }

    public static void a(a.C0509a c0509a, int i10, String str) {
        a(4, c0509a, 0L, i10, str);
    }

    private static void a(int i10, a.C0509a c0509a, long j10, int i11, String str) {
        if (c0509a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).bX(i10).bY(ams).cd(c0509a.sdkVersion).ce(c0509a.alX).aa(j10).bZ(i11).cf(str).toJson();
            Objects.toString(json);
            com.kwad.sdk.api.c.f("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
