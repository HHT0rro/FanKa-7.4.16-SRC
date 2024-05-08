package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PathTreeWalk.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c extends SimpleFileVisitor<Path> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f50982a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public g f50983b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public kotlin.collections.i<g> f50984c = new kotlin.collections.i<>();

    public c(boolean z10) {
        this.f50982a = z10;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(@NotNull Path dir, @NotNull BasicFileAttributes attrs) {
        s.i(dir, "dir");
        s.i(attrs, "attrs");
        this.f50984c.add(new g(dir, attrs.fileKey(), this.f50983b));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        s.h(preVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return preVisitDirectory;
    }

    @NotNull
    public final List<g> b(@NotNull g directoryNode) {
        s.i(directoryNode, "directoryNode");
        this.f50983b = directoryNode;
        Files.walkFileTree(directoryNode.d(), f.f50989a.b(this.f50982a), 1, this);
        this.f50984c.removeFirst();
        kotlin.collections.i<g> iVar = this.f50984c;
        this.f50984c = new kotlin.collections.i<>();
        return iVar;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(@NotNull Path file, @NotNull BasicFileAttributes attrs) {
        s.i(file, "file");
        s.i(attrs, "attrs");
        this.f50984c.add(new g(file, null, this.f50983b));
        FileVisitResult visitFile = super.visitFile(file, attrs);
        s.h(visitFile, "super.visitFile(file, attrs)");
        return visitFile;
    }
}
