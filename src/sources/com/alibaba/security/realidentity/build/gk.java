package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import java.io.File;

/* compiled from: ResumableUploadRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gk extends fq {

    /* renamed from: j, reason: collision with root package name */
    public Boolean f3739j;

    /* renamed from: m, reason: collision with root package name */
    public String f3740m;

    private gk(String str, String str2, String str3) {
        this(str, str2, str3, null, null);
    }

    private void a(Boolean bool) {
        this.f3739j = bool;
    }

    private void b(String str) {
        if (!OSSUtils.a(str)) {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                throw new IllegalArgumentException("Record directory must exist, and it should be a directory!");
            }
        }
        this.f3740m = str;
    }

    private String i() {
        return this.f3740m;
    }

    private Boolean j() {
        return this.f3739j;
    }

    private gk(String str, String str2, String str3, fu fuVar) {
        this(str, str2, str3, fuVar, null);
    }

    private gk(String str, String str2, String str3, String str4) {
        this(str, str2, str3, null, str4);
    }

    private gk(String str, String str2, String str3, fu fuVar, String str4) {
        super(str, str2, str3, fuVar);
        this.f3739j = Boolean.TRUE;
        if (!OSSUtils.a(str4)) {
            File file = new File(str4);
            if (!file.exists() || !file.isDirectory()) {
                throw new IllegalArgumentException("Record directory must exist, and it should be a directory!");
            }
        }
        this.f3740m = str4;
    }
}
