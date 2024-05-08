package com.cupidapp.live.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* compiled from: PhoneUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l0 f12345a = new l0();

    public final boolean a(String str) {
        Pattern compile = Pattern.compile("[0-9]*");
        Matcher matcher = compile != null ? compile.matcher(str) : null;
        if (matcher != null) {
            return matcher.matches();
        }
        return false;
    }

    public final boolean b(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "str");
        boolean a10 = a(str);
        return a10 ? !c(str) : a10;
    }

    public final boolean c(String str) {
        Pattern compile = Pattern.compile("(13|14|15|16|17|18|19)[0-9]{9}");
        Matcher matcher = compile != null ? compile.matcher(str) : null;
        if (matcher != null) {
            return matcher.matches();
        }
        return false;
    }
}
