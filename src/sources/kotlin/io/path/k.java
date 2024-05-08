package kotlin.io.path;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathRecursiveFunctions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k extends j {

    /* compiled from: PathRecursiveFunctions.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51001a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f51002b;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f51001a = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f51002b = iArr2;
        }
    }

    public static final FileVisitResult c(Function3<? super kotlin.io.path.a, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32, Path path3, BasicFileAttributes basicFileAttributes) {
        try {
            return m(function3.invoke(b.f50981a, path3, d(path, path2, path3)));
        } catch (Exception e2) {
            return e(function32, path, path2, path3, e2);
        }
    }

    public static final Path d(Path path, Path path2, Path path3) {
        Path resolve = path2.resolve(l.o(path3, path).toString());
        s.h(resolve, "target.resolve(relativePath.pathString)");
        return resolve;
    }

    public static final FileVisitResult e(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3, Exception exc) {
        return n(function3.invoke(path3, d(path, path2, path3), exc));
    }

    public static final void f(@NotNull Path path) {
        s.i(path, "<this>");
        List<Exception> g3 = g(path);
        if (!g3.isEmpty()) {
            FileSystemException fileSystemException = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            Iterator<Exception> iterator2 = g3.iterator2();
            while (iterator2.hasNext()) {
                kotlin.a.a(fileSystemException, iterator2.next());
            }
            throw fileSystemException;
        }
    }

    public static final List<Exception> g(Path path) {
        DirectoryStream<Path> directoryStream;
        boolean z10 = false;
        boolean z11 = true;
        d dVar = new d(0, 1, null);
        Path parent = path.getParent();
        if (parent != null) {
            try {
                directoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStream = null;
            }
            if (directoryStream != null) {
                try {
                    if (directoryStream instanceof SecureDirectoryStream) {
                        dVar.f(parent);
                        Path fileName = path.getFileName();
                        s.h(fileName, "this.fileName");
                        i((SecureDirectoryStream) directoryStream, fileName, dVar);
                    } else {
                        z10 = true;
                    }
                    p pVar = p.f51048a;
                    kotlin.io.b.a(directoryStream, null);
                    z11 = z10;
                } finally {
                }
            }
        }
        if (z11) {
            k(path, dVar);
        }
        return dVar.d();
    }

    public static final void h(SecureDirectoryStream<Path> secureDirectoryStream, Path path, d dVar) {
        SecureDirectoryStream<Path> secureDirectoryStream2;
        try {
            try {
                secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            } catch (NoSuchFileException unused) {
                secureDirectoryStream2 = null;
            }
            if (secureDirectoryStream2 == null) {
                return;
            }
            try {
                Iterator<Path> it = secureDirectoryStream2.iterator2();
                while (it.hasNext()) {
                    Path fileName = it.next().getFileName();
                    s.h(fileName, "entry.fileName");
                    i(secureDirectoryStream2, fileName, dVar);
                }
                p pVar = p.f51048a;
                kotlin.io.b.a(secureDirectoryStream2, null);
            } finally {
            }
        } catch (Exception e2) {
            dVar.a(e2);
        }
    }

    public static final void i(SecureDirectoryStream<Path> secureDirectoryStream, Path path, d dVar) {
        dVar.b(path);
        try {
        } catch (Exception e2) {
            dVar.a(e2);
        }
        if (l(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
            int e10 = dVar.e();
            h(secureDirectoryStream, path, dVar);
            if (e10 == dVar.e()) {
                secureDirectoryStream.deleteDirectory(path);
                p pVar = p.f51048a;
            }
            dVar.c(path);
        }
        secureDirectoryStream.deleteFile(path);
        p pVar2 = p.f51048a;
        dVar.c(path);
    }

    public static final void j(Path path, d dVar) {
        DirectoryStream<Path> directoryStream;
        try {
            try {
                directoryStream = Files.newDirectoryStream(path);
            } catch (NoSuchFileException unused) {
                directoryStream = null;
            }
            if (directoryStream == null) {
                return;
            }
            try {
                for (Path entry : directoryStream) {
                    s.h(entry, "entry");
                    k(entry, dVar);
                }
                p pVar = p.f51048a;
                kotlin.io.b.a(directoryStream, null);
            } finally {
            }
        } catch (Exception e2) {
            dVar.a(e2);
        }
    }

    public static final void k(Path path, d dVar) {
        try {
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                int e2 = dVar.e();
                j(path, dVar);
                if (e2 == dVar.e()) {
                    Files.deleteIfExists(path);
                }
            } else {
                Files.deleteIfExists(path);
            }
        } catch (Exception e10) {
            dVar.a(e10);
        }
    }

    public static final boolean l(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean bool;
        try {
            bool = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException unused) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final FileVisitResult m(CopyActionResult copyActionResult) {
        int i10 = a.f51001a[copyActionResult.ordinal()];
        if (i10 == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i10 == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i10 == 3) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final FileVisitResult n(OnErrorResult onErrorResult) {
        int i10 = a.f51002b[onErrorResult.ordinal()];
        if (i10 == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i10 == 2) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
