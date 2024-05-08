package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FileTreeWalk.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f implements kotlin.sequences.g<File> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final File f50954a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final FileWalkDirection f50955b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Function1<File, Boolean> f50956c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Function1<File, p> f50957d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Function2<File, IOException, p> f50958e;

    /* renamed from: f, reason: collision with root package name */
    public final int f50959f;

    /* compiled from: FileTreeWalk.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull File rootDir) {
            super(rootDir);
            s.i(rootDir, "rootDir");
        }
    }

    /* compiled from: FileTreeWalk.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class b extends kotlin.collections.a<File> {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public final ArrayDeque<c> f50960d;

        /* compiled from: FileTreeWalk.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class a extends a {

            /* renamed from: b, reason: collision with root package name */
            public boolean f50962b;

            /* renamed from: c, reason: collision with root package name */
            @Nullable
            public File[] f50963c;

            /* renamed from: d, reason: collision with root package name */
            public int f50964d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f50965e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f50966f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull b bVar, File rootDir) {
                super(rootDir);
                s.i(rootDir, "rootDir");
                this.f50966f = bVar;
            }

            @Override // kotlin.io.f.c
            @Nullable
            public File b() {
                if (!this.f50965e && this.f50963c == null) {
                    Function1 function1 = f.this.f50956c;
                    boolean z10 = false;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        z10 = true;
                    }
                    if (z10) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f50963c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = f.this.f50958e;
                        if (function2 != null) {
                            function2.mo1743invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f50965e = true;
                    }
                }
                File[] fileArr = this.f50963c;
                if (fileArr != null) {
                    int i10 = this.f50964d;
                    s.f(fileArr);
                    if (i10 < fileArr.length) {
                        File[] fileArr2 = this.f50963c;
                        s.f(fileArr2);
                        int i11 = this.f50964d;
                        this.f50964d = i11 + 1;
                        return fileArr2[i11];
                    }
                }
                if (!this.f50962b) {
                    this.f50962b = true;
                    return a();
                }
                Function1 function12 = f.this.f50957d;
                if (function12 != null) {
                    function12.invoke(a());
                }
                return null;
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* renamed from: kotlin.io.f$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class C0777b extends c {

            /* renamed from: b, reason: collision with root package name */
            public boolean f50967b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f50968c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0777b(@NotNull b bVar, File rootFile) {
                super(rootFile);
                s.i(rootFile, "rootFile");
                this.f50968c = bVar;
            }

            @Override // kotlin.io.f.c
            @Nullable
            public File b() {
                if (this.f50967b) {
                    return null;
                }
                this.f50967b = true;
                return a();
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class c extends a {

            /* renamed from: b, reason: collision with root package name */
            public boolean f50969b;

            /* renamed from: c, reason: collision with root package name */
            @Nullable
            public File[] f50970c;

            /* renamed from: d, reason: collision with root package name */
            public int f50971d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f50972e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull b bVar, File rootDir) {
                super(rootDir);
                s.i(rootDir, "rootDir");
                this.f50972e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
            
                if (r0.length == 0) goto L33;
             */
            @Override // kotlin.io.f.c
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f50969b
                    r1 = 0
                    if (r0 != 0) goto L2c
                    kotlin.io.f$b r0 = r10.f50972e
                    kotlin.io.f r0 = kotlin.io.f.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.f.d(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L22
                    java.io.File r4 = r10.a()
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L22
                    r2 = 1
                L22:
                    if (r2 == 0) goto L25
                    return r1
                L25:
                    r10.f50969b = r3
                    java.io.File r0 = r10.a()
                    return r0
                L2c:
                    java.io.File[] r0 = r10.f50970c
                    if (r0 == 0) goto L4b
                    int r2 = r10.f50971d
                    kotlin.jvm.internal.s.f(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L39
                    goto L4b
                L39:
                    kotlin.io.f$b r0 = r10.f50972e
                    kotlin.io.f r0 = kotlin.io.f.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.f.f(r0)
                    if (r0 == 0) goto L4a
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L4a:
                    return r1
                L4b:
                    java.io.File[] r0 = r10.f50970c
                    if (r0 != 0) goto L97
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f50970c = r0
                    if (r0 != 0) goto L7b
                    kotlin.io.f$b r0 = r10.f50972e
                    kotlin.io.f r0 = kotlin.io.f.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.f.e(r0)
                    if (r0 == 0) goto L7b
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.mo1743invoke(r2, r9)
                L7b:
                    java.io.File[] r0 = r10.f50970c
                    if (r0 == 0) goto L85
                    kotlin.jvm.internal.s.f(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L97
                L85:
                    kotlin.io.f$b r0 = r10.f50972e
                    kotlin.io.f r0 = kotlin.io.f.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.f.f(r0)
                    if (r0 == 0) goto L96
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L96:
                    return r1
                L97:
                    java.io.File[] r0 = r10.f50970c
                    kotlin.jvm.internal.s.f(r0)
                    int r1 = r10.f50971d
                    int r2 = r1 + 1
                    r10.f50971d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.f.b.c.b():java.io.File");
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public /* synthetic */ class d {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f50973a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f50973a = iArr;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f50960d = arrayDeque;
            if (f.this.f50954a.isDirectory()) {
                arrayDeque.push(e(f.this.f50954a));
            } else if (f.this.f50954a.isFile()) {
                arrayDeque.push(new C0777b(this, f.this.f50954a));
            } else {
                b();
            }
        }

        @Override // kotlin.collections.a
        public void a() {
            File f10 = f();
            if (f10 != null) {
                c(f10);
            } else {
                b();
            }
        }

        public final a e(File file) {
            int i10 = d.f50973a[f.this.f50955b.ordinal()];
            if (i10 == 1) {
                return new c(this, file);
            }
            if (i10 == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final File f() {
            File b4;
            while (true) {
                c peek = this.f50960d.peek();
                if (peek == null) {
                    return null;
                }
                b4 = peek.b();
                if (b4 == null) {
                    this.f50960d.pop();
                } else {
                    if (s.d(b4, peek.a()) || !b4.isDirectory() || this.f50960d.size() >= f.this.f50959f) {
                        break;
                    }
                    this.f50960d.push(e(b4));
                }
            }
            return b4;
        }
    }

    /* compiled from: FileTreeWalk.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final File f50974a;

        public c(@NotNull File root) {
            s.i(root, "root");
            this.f50974a = root;
        }

        @NotNull
        public final File a() {
            return this.f50974a;
        }

        @Nullable
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, p> function12, Function2<? super File, ? super IOException, p> function2, int i10) {
        this.f50954a = file;
        this.f50955b = fileWalkDirection;
        this.f50956c = function1;
        this.f50957d = function12;
        this.f50958e = function2;
        this.f50959f = i10;
    }

    @NotNull
    public final f h(@NotNull Function2<? super File, ? super IOException, p> function) {
        s.i(function, "function");
        return new f(this.f50954a, this.f50955b, this.f50956c, this.f50957d, function, this.f50959f);
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<File> iterator() {
        return new b();
    }

    public /* synthetic */ f(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i11 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i11 & 32) != 0 ? Integer.MAX_VALUE : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NotNull File start, @NotNull FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        s.i(start, "start");
        s.i(direction, "direction");
    }
}
