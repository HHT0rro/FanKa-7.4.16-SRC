package com.cupidapp.live.mediapicker.newmediapicker.view;

import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaFolder;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: MediaFolderPopupWindow.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class MediaFolderPopupWindow$1 extends Lambda implements Function1<Object, p> {
    public final /* synthetic */ a this$0;

    public MediaFolderPopupWindow$1(a aVar) {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Object obj) {
        invoke2(obj);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Object obj) {
        if (obj instanceof LocalMediaFolder) {
            throw null;
        }
    }
}
