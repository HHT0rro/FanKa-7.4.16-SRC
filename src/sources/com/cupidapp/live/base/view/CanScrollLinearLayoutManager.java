package com.cupidapp.live.base.view;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: CustomLayoutManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CanScrollLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f12424a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12425b = true;

    /* compiled from: CustomLayoutManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return CanScrollLinearLayoutManager.f12425b;
        }

        public final void b(boolean z10) {
            CanScrollLinearLayoutManager.f12425b = z10;
        }
    }

    public /* synthetic */ CanScrollLinearLayoutManager(Context context, int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? 1 : i10, (i11 & 4) != 0 ? false : z10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return f12425b && super.canScrollVertically();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CanScrollLinearLayoutManager(@NotNull Context context, int i10, boolean z10) {
        super(context, i10, z10);
        kotlin.jvm.internal.s.i(context, "context");
    }
}
