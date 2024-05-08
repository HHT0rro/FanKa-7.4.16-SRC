package kotlin.io.path;

import android.view.textclassifier.ConversationAction;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PathRecursiveFunctions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5 extends Lambda implements Function1<e, p> {
    public final /* synthetic */ Function3<a, Path, Path, CopyActionResult> $copyAction;
    public final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
    public final /* synthetic */ Path $target;
    public final /* synthetic */ Path $this_copyToRecursively;

    /* compiled from: PathRecursiveFunctions.kt */
    /* renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
        public final /* synthetic */ Function3<a, Path, Path, CopyActionResult> $copyAction;
        public final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
        public final /* synthetic */ Path $target;
        public final /* synthetic */ Path $this_copyToRecursively;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super a, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
            super(2, s.a.class, ConversationAction.TYPE_COPY, "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
            this.$copyAction = function3;
            this.$this_copyToRecursively = path;
            this.$target = path2;
            this.$onError = function32;
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final FileVisitResult mo1743invoke(@NotNull Path p02, @NotNull BasicFileAttributes p12) {
            FileVisitResult c4;
            s.i(p02, "p0");
            s.i(p12, "p1");
            c4 = k.c(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, p02, p12);
            return c4;
        }
    }

    /* compiled from: PathRecursiveFunctions.kt */
    /* renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
        public final /* synthetic */ Function3<a, Path, Path, CopyActionResult> $copyAction;
        public final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
        public final /* synthetic */ Path $target;
        public final /* synthetic */ Path $this_copyToRecursively;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super a, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
            super(2, s.a.class, ConversationAction.TYPE_COPY, "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
            this.$copyAction = function3;
            this.$this_copyToRecursively = path;
            this.$target = path2;
            this.$onError = function32;
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final FileVisitResult mo1743invoke(@NotNull Path p02, @NotNull BasicFileAttributes p12) {
            FileVisitResult c4;
            s.i(p02, "p0");
            s.i(p12, "p1");
            c4 = k.c(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, p02, p12);
            return c4;
        }
    }

    /* compiled from: PathRecursiveFunctions.kt */
    /* renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<Path, Exception, FileVisitResult> {
        public final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
        public final /* synthetic */ Path $target;
        public final /* synthetic */ Path $this_copyToRecursively;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2) {
            super(2, s.a.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
            this.$onError = function3;
            this.$this_copyToRecursively = path;
            this.$target = path2;
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final FileVisitResult mo1743invoke(@NotNull Path p02, @NotNull Exception p12) {
            FileVisitResult e2;
            s.i(p02, "p0");
            s.i(p12, "p1");
            e2 = k.e(this.$onError, this.$this_copyToRecursively, this.$target, p02, p12);
            return e2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5(Function3<? super a, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
        super(1);
        this.$copyAction = function3;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$onError = function32;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(e eVar) {
        invoke2(eVar);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e visitFileTree) {
        s.i(visitFileTree, "$this$visitFileTree");
        visitFileTree.c(new AnonymousClass1(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError));
        visitFileTree.b(new AnonymousClass2(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError));
        visitFileTree.d(new AnonymousClass3(this.$onError, this.$this_copyToRecursively, this.$target));
        final Function3<Path, Path, Exception, OnErrorResult> function3 = this.$onError;
        final Path path = this.$this_copyToRecursively;
        final Path path2 = this.$target;
        visitFileTree.a(new Function2<Path, IOException, FileVisitResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final FileVisitResult mo1743invoke(@NotNull Path directory, @Nullable IOException iOException) {
                FileVisitResult e2;
                s.i(directory, "directory");
                if (iOException == null) {
                    return FileVisitResult.CONTINUE;
                }
                e2 = k.e(function3, path, path2, directory, iOException);
                return e2;
            }
        });
    }
}
