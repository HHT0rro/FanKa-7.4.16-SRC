package com.cupidapp.live.base.share.view;

import com.cupidapp.live.base.share.model.ShareBaseType;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: IShareItemMenuListener.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: IShareItemMenuListener.kt */
    @d
    /* renamed from: com.cupidapp.live.base.share.view.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0144a {
        public static void a(@NotNull a aVar, @NotNull ShareBaseType type) {
            s.i(type, "type");
        }
    }

    void Z(@NotNull ShareBaseType shareBaseType);

    void q(@NotNull ShareBaseType shareBaseType);
}
