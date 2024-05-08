package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewGroup.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, zd.a {
    public final /* synthetic */ ViewGroup $this_iterator;
    private int index;

    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.$this_iterator = viewGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.getChildCount();
    }

    @Override // java.util.Iterator
    public void remove() {
        ViewGroup viewGroup = this.$this_iterator;
        int i10 = this.index - 1;
        this.index = i10;
        viewGroup.removeViewAt(i10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public View next() {
        ViewGroup viewGroup = this.$this_iterator;
        int i10 = this.index;
        this.index = i10 + 1;
        View childAt = viewGroup.getChildAt(i10);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
