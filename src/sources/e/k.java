package e;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k implements l, i {

    /* renamed from: d, reason: collision with root package name */
    public final String f48788d;

    /* renamed from: f, reason: collision with root package name */
    public final MergePaths f48790f;

    /* renamed from: a, reason: collision with root package name */
    public final Path f48785a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Path f48786b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f48787c = new Path();

    /* renamed from: e, reason: collision with root package name */
    public final List<l> f48789e = new ArrayList();

    /* compiled from: MergePathsContent.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48791a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f48791a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48791a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48791a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48791a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f48791a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public k(MergePaths mergePaths) {
        this.f48788d = mergePaths.b();
        this.f48790f = mergePaths;
    }

    public final void a() {
        for (int i10 = 0; i10 < this.f48789e.size(); i10++) {
            this.f48787c.addPath(this.f48789e.get(i10).getPath());
        }
    }

    @Override // e.i
    public void c(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof l) {
                this.f48789e.add((l) previous);
                listIterator.remove();
            }
        }
    }

    public final void e(Path.Op op) {
        this.f48786b.reset();
        this.f48785a.reset();
        for (int size = this.f48789e.size() - 1; size >= 1; size--) {
            l lVar = this.f48789e.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List<l> k10 = cVar.k();
                for (int size2 = k10.size() - 1; size2 >= 0; size2--) {
                    Path path = k10.get(size2).getPath();
                    path.transform(cVar.l());
                    this.f48786b.addPath(path);
                }
            } else {
                this.f48786b.addPath(lVar.getPath());
            }
        }
        l lVar2 = this.f48789e.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List<l> k11 = cVar2.k();
            for (int i10 = 0; i10 < k11.size(); i10++) {
                Path path2 = k11.get(i10).getPath();
                path2.transform(cVar2.l());
                this.f48785a.addPath(path2);
            }
        } else {
            this.f48785a.set(lVar2.getPath());
        }
        this.f48787c.op(this.f48785a, this.f48786b, op);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        for (int i10 = 0; i10 < this.f48789e.size(); i10++) {
            this.f48789e.get(i10).f(list, list2);
        }
    }

    @Override // e.l
    public Path getPath() {
        this.f48787c.reset();
        if (this.f48790f.c()) {
            return this.f48787c;
        }
        int i10 = a.f48791a[this.f48790f.a().ordinal()];
        if (i10 == 1) {
            a();
        } else if (i10 == 2) {
            e(Path.Op.UNION);
        } else if (i10 == 3) {
            e(Path.Op.REVERSE_DIFFERENCE);
        } else if (i10 == 4) {
            e(Path.Op.INTERSECT);
        } else if (i10 == 5) {
            e(Path.Op.XOR);
        }
        return this.f48787c;
    }
}
