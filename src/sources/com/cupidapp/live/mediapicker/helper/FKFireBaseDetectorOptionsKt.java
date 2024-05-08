package com.cupidapp.live.mediapicker.helper;

import android.content.Context;
import android.graphics.Bitmap;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.utils.j;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import o8.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFireBaseDetectorOptions.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKFireBaseDetectorOptionsKt {
    public static final void e(boolean z10, boolean z11, i iVar, Function1<? super Boolean, p> function1) {
        if (z10) {
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(z11));
            }
            iVar.g();
        }
    }

    public static final o8.d f() {
        o8.d a10 = new d.a().e(1).c(1).b(1).d(0.1f).a();
        s.h(a10, "Builder()\n            .s….1f)\n            .build()");
        return a10;
    }

    public static final boolean g(List<o8.a> list) {
        j.f12332a.a("fileUploadImage", "  size " + list.size());
        return list.size() > 0;
    }

    public static final void h(@NotNull Context context, @NotNull String image, @Nullable final Function1<? super Boolean, p> function1) {
        s.i(context, "<this>");
        s.i(image, "image");
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        final i iVar = new i();
        iVar.c(2, 1, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt$startFaceDetection$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKFireBaseDetectorOptionsKt.e(Ref$BooleanRef.this.element, false, iVar, function1);
                Ref$BooleanRef.this.element = false;
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt$startFaceDetection$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
            }
        });
        try {
            Bitmap k10 = z0.f.k(context, image, true, 300);
            if (k10 == null) {
                e(ref$BooleanRef.element, false, iVar, function1);
            } else {
                p7.f<List<o8.a>> n10 = o8.c.a(f()).n(m8.a.a(k10, 0));
                final Function1<List<o8.a>, p> function12 = new Function1<List<o8.a>, p>() { // from class: com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt$startFaceDetection$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(List<o8.a> list) {
                        invoke2(list);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<o8.a> faces) {
                        boolean g3;
                        boolean z10 = Ref$BooleanRef.this.element;
                        s.h(faces, "faces");
                        g3 = FKFireBaseDetectorOptionsKt.g(faces);
                        FKFireBaseDetectorOptionsKt.e(z10, g3, iVar, function1);
                    }
                };
                n10.d(new p7.d() { // from class: com.cupidapp.live.mediapicker.helper.c
                    @Override // p7.d
                    public final void onSuccess(Object obj) {
                        FKFireBaseDetectorOptionsKt.i(Function1.this, obj);
                    }
                }).b(new p7.c() { // from class: com.cupidapp.live.mediapicker.helper.b
                    @Override // p7.c
                    public final void onFailure(Exception exc) {
                        FKFireBaseDetectorOptionsKt.j(Ref$BooleanRef.this, iVar, function1, exc);
                    }
                });
            }
        } catch (Exception unused) {
            j.f12332a.a("fileUploadImage", "catch");
            e(ref$BooleanRef.element, false, iVar, function1);
        }
    }

    public static final void i(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void j(Ref$BooleanRef needReturn, i fkCountTimerWrapper, Function1 function1, Exception it) {
        s.i(needReturn, "$needReturn");
        s.i(fkCountTimerWrapper, "$fkCountTimerWrapper");
        s.i(it, "it");
        e(needReturn.element, false, fkCountTimerWrapper, function1);
    }
}
