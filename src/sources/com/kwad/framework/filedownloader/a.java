package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0494a {
        boolean aY(int i10);

        void free();

        boolean isOver();

        a ud();

        x.a ue();

        int uf();

        void ug();

        boolean uh();

        void ui();

        void uj();

        boolean uk();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        int ul();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void onBegin();

        void um();
    }

    a a(i iVar);

    a aX(int i10);

    a aZ(String str);

    a ba(String str);

    a ba(boolean z10);

    a bb(boolean z10);

    a bc(boolean z10);

    a c(String str, boolean z10);

    boolean cancel();

    a e(Object obj);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    boolean pause();

    int start();

    a t(String str, String str2);

    b tM();

    boolean tN();

    boolean tO();

    int tP();

    int tQ();

    boolean tR();

    i tS();

    long tT();

    long tU();

    byte tV();

    boolean tW();

    Throwable tX();

    int tY();

    int tZ();

    boolean ua();

    boolean ub();

    boolean uc();
}
