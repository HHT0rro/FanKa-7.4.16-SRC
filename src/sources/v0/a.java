package v0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;

/* compiled from: BaseViewBindings.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {
    @BindingAdapter({"app:initData"})
    public static final void a(@NotNull RecyclerView recyclerView, @Nullable List<? extends Object> list) {
        s.i(recyclerView, "recyclerView");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter = adapter instanceof FKBaseRecyclerViewAdapter ? (FKBaseRecyclerViewAdapter) adapter : null;
        if (fKBaseRecyclerViewAdapter != null) {
            fKBaseRecyclerViewAdapter.m(list);
        }
    }

    @BindingAdapter({"app:isBold"})
    public static final void b(@NotNull TextView textView, boolean z10) {
        s.i(textView, "textView");
        textView.setTypeface(null, z10 ? 1 : 0);
    }

    @BindingAdapter({"loadImg"})
    public static final void c(@NotNull ImageLoaderView imgView, @Nullable ImageModel imageModel) {
        s.i(imgView, "imgView");
        ImageLoaderView.g(imgView, imageModel, null, null, 6, null);
    }

    @BindingAdapter({"drawableEnd", "drawableStart"})
    public static final void d(@NotNull TextView textView, int i10, int i11) {
        s.i(textView, "textView");
        u.e(textView, i11, 0, i10, 0, 10, null);
    }

    @BindingAdapter({"setFakeBoldText"})
    public static final void e(@NotNull TextView textView, boolean z10) {
        s.i(textView, "textView");
        textView.getPaint().setFakeBoldText(z10);
    }

    @BindingAdapter({"app:setImageResource"})
    public static final void f(@NotNull ImageView imageView, int i10) {
        s.i(imageView, "imageView");
        imageView.setImageResource(i10);
    }

    @BindingAdapter({"setVisibility"})
    public static final void g(@NotNull View view, boolean z10) {
        s.i(view, "view");
        view.setVisibility(z10 ? 0 : 8);
    }
}
