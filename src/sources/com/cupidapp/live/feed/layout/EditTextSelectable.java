package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EditTextSelectable.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EditTextSelectable extends AppCompatEditText {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public List<a> f14441b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14442c;

    /* compiled from: EditTextSelectable.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(int i10, int i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextSelectable(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14442c = new LinkedHashMap();
    }

    public final void a(@NotNull a o10) {
        kotlin.jvm.internal.s.i(o10, "o");
        if (this.f14441b == null) {
            this.f14441b = new ArrayList();
        }
        List<a> list = this.f14441b;
        if (list != null) {
            list.add(o10);
        }
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i10, int i11) {
        super.onSelectionChanged(i10, i11);
        List<a> list = this.f14441b;
        if (list != null) {
            Iterator<a> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(i10, i11);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextSelectable(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14442c = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextSelectable(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14442c = new LinkedHashMap();
    }
}
