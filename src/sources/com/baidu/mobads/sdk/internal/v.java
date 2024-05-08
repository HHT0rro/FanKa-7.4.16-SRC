package com.baidu.mobads.sdk.internal;

import java.util.Observer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface v {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum a {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");


        /* renamed from: i, reason: collision with root package name */
        private int f10309i;

        /* renamed from: j, reason: collision with root package name */
        private String f10310j;

        a(int i10, String str) {
            this.f10309i = i10;
            this.f10310j = str;
        }

        public int b() {
            return this.f10309i;
        }

        public String c() {
            return this.f10310j;
        }
    }

    void a();

    void a(boolean z10);

    void addObserver(Observer observer);

    void b();

    void c();

    void d();

    String e();

    String f();

    String g();

    String h();

    String i();

    int j();

    float k();

    a l();

    void m();

    boolean n();
}
