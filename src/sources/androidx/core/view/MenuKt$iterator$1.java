package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Menu.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, zd.a {
    public final /* synthetic */ Menu $this_iterator;
    private int index;

    public MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        p pVar;
        Menu menu = this.$this_iterator;
        int i10 = this.index - 1;
        this.index = i10;
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            s.h(item, "getItem(index)");
            menu.removeItem(item.getItemId());
            pVar = p.f51048a;
        } else {
            pVar = null;
        }
        if (pVar == null) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i10 = this.index;
        this.index = i10 + 1;
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
