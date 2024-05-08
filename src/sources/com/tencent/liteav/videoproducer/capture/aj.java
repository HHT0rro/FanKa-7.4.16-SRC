package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.Size;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class aj implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private static final aj f44277a = new aj();

    private aj() {
    }

    public static Comparator a() {
        return f44277a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Size) obj2).getArea() - ((Size) obj).getArea();
    }
}
