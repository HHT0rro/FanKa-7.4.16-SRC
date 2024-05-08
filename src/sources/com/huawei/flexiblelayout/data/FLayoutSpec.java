package com.huawei.flexiblelayout.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.card.FLProvider;
import com.huawei.flexiblelayout.creator.CardResolver;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.codec.JsonCodec;
import com.huawei.flexiblelayout.json.codec.JsonException;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.directive.Directives;
import com.huawei.flexiblelayout.parser.directive.FormulaMap;
import com.huawei.flexiblelayout.parser.directive.StyleDirective;
import com.huawei.flexiblelayout.services.task.TaskHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLayoutSpec {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28078a = "FLayoutSpec";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class FCardSpec implements Spec {

        /* renamed from: a, reason: collision with root package name */
        private String f28079a;

        /* renamed from: b, reason: collision with root package name */
        private final String f28080b;

        /* renamed from: c, reason: collision with root package name */
        private FLMap f28081c;

        /* renamed from: d, reason: collision with root package name */
        private Directives f28082d;

        public FLCardData a(@NonNull b bVar) {
            FLCardData fLCardData;
            CardResolver cardResolver = FLResolverRegistry.getCardResolver(this.f28080b);
            if (cardResolver != null) {
                fLCardData = cardResolver.createData();
            } else {
                fLCardData = new FLCardData(this.f28080b);
            }
            fLCardData.a(this.f28079a);
            fLCardData.a(new FormulaMap(this.f28081c, bVar));
            FLayoutSpec.b(fLCardData);
            if (bVar.c() != null) {
                FLayoutSpec.b(fLCardData, bVar.c(), bVar);
            }
            return fLCardData;
        }

        public FLCardData build() {
            return build(new b.C0271b().a());
        }

        public FCardSpec data(FLMap fLMap) {
            this.f28081c = fLMap;
            return this;
        }

        public FCardSpec directive(f fVar) {
            if (fVar != null) {
                if (this.f28082d == null) {
                    this.f28082d = new Directives(this);
                }
                this.f28082d.addDirective(fVar);
            }
            return this;
        }

        public FCardSpec id(String str) {
            this.f28079a = str;
            return this;
        }

        public FCardSpec style(String str) {
            if (!TextUtils.isEmpty(str)) {
                directive(new StyleDirective(str));
            }
            return this;
        }

        private FCardSpec(String str) {
            this.f28080b = str;
        }

        public FLCardData build(@NonNull b bVar) {
            Directives directives = this.f28082d;
            if (directives == null) {
                return a(bVar);
            }
            return directives.execute(bVar);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class FNodeSpec implements Spec {

        /* renamed from: a, reason: collision with root package name */
        private final List<Spec> f28083a;

        /* renamed from: b, reason: collision with root package name */
        private String f28084b;

        /* renamed from: c, reason: collision with root package name */
        private final String f28085c;

        /* renamed from: d, reason: collision with root package name */
        private FLMap f28086d;

        /* renamed from: e, reason: collision with root package name */
        private String f28087e;

        /* renamed from: f, reason: collision with root package name */
        private TaskHandler f28088f;

        /* renamed from: g, reason: collision with root package name */
        private Directives f28089g;

        public FLNodeData a(@NonNull b bVar) {
            FLNodeData createData = FLResolverRegistry.getNodeResolver(this.f28085c).createData(this.f28085c);
            createData.a(this.f28084b);
            TaskHandler taskHandler = this.f28088f;
            if (taskHandler != null) {
                createData.a(taskHandler);
            }
            createData.a(new FormulaMap(this.f28086d, bVar));
            FLayoutSpec.b(createData);
            if (bVar.c() != null) {
                FLayoutSpec.b(createData, bVar.c(), bVar);
            }
            return createData;
        }

        public FLNodeData build() {
            return build(new b.C0271b().a());
        }

        public FNodeSpec child(Spec spec) {
            this.f28083a.add(spec);
            return this;
        }

        public FNodeSpec data(FLMap fLMap) {
            this.f28086d = fLMap;
            return this;
        }

        public FNodeSpec directive(g gVar) {
            if (gVar != null) {
                if (this.f28089g == null) {
                    this.f28089g = new Directives(this);
                }
                this.f28089g.addDirective(gVar);
            }
            return this;
        }

        public FNodeSpec id(String str) {
            this.f28084b = str;
            return this;
        }

        public String name() {
            return this.f28087e;
        }

        public FNodeSpec style(String str) {
            if (!TextUtils.isEmpty(str)) {
                directive(new StyleDirective(str));
            }
            return this;
        }

        public FNodeSpec taskHandler(TaskHandler taskHandler) {
            this.f28088f = taskHandler;
            return this;
        }

        private FNodeSpec(String str) {
            this.f28083a = new ArrayList();
            this.f28085c = str;
            this.f28087e = str + hashCode();
        }

        public FLNodeData build(@NonNull b bVar) {
            Directives directives = this.f28089g;
            if (directives == null) {
                FLNodeData a10 = a(bVar);
                a(a10, bVar);
                return a10;
            }
            return (FLNodeData) directives.execute(bVar);
        }

        public FNodeSpec name(String str) {
            this.f28087e = str;
            return this;
        }

        public void a(FLNodeData fLNodeData, @NonNull b bVar) {
            for (int i10 = 0; i10 < this.f28083a.size(); i10++) {
                bVar.a(fLNodeData);
                Spec spec = this.f28083a.get(i10);
                if (spec instanceof FCardSpec) {
                    ((FCardSpec) spec).build(bVar);
                } else {
                    ((FNodeSpec) spec).build(bVar);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Spec {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void b(FLCardData fLCardData, FLNodeData fLNodeData, @NonNull b bVar) {
        if (fLCardData instanceof FLProvider) {
            Iterator<? extends FLCardData> iterator2 = ((FLProvider) fLCardData).supply(bVar.d(), null, fLNodeData).iterator2();
            while (iterator2.hasNext()) {
                fLNodeData.addChild(iterator2.next());
            }
            return;
        }
        fLNodeData.addChild(fLCardData);
    }

    public static FCardSpec card(String str) {
        return new FCardSpec(str);
    }

    public static FNodeSpec node(String str) {
        FNodeSpec nodeSpec = FLResolverRegistry.getNodeSpec(str);
        return nodeSpec == null ? new FNodeSpec(str) : nodeSpec;
    }

    public static FNodeSpec node() {
        return new FNodeSpec(FLNode.TYPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FLCardData fLCardData) {
        try {
            JsonCodec.toObject(fLCardData.getData(), fLCardData);
        } catch (JsonException unused) {
            Log.e(f28078a, "Failed to decode json to the object.");
        }
    }
}
