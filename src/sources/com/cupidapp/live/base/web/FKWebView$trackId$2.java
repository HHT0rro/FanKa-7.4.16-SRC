package com.cupidapp.live.base.web;

import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKWebView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKWebView$trackId$2 extends Lambda implements Function0<String> {
    public static final FKWebView$trackId$2 INSTANCE = new FKWebView$trackId$2();

    public FKWebView$trackId$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final String invoke() {
        return UUID.randomUUID().toString();
    }
}
