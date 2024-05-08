package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    public int direction;
    public WidgetRun firstRun;
    public int groupIndex;
    public WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    public ArrayList<WidgetRun> runs = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i10) {
        this.firstRun = null;
        this.lastRun = null;
        int i11 = index;
        this.groupIndex = i11;
        index = i11 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i10;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i10) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.widget.isTerminalWidget[i10]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.dependencies) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> iterator2 = ((ChainRun) widgetRun).widgets.iterator2();
                    while (iterator2.hasNext()) {
                        defineTerminalWidget(iterator2.next(), i10);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i10] = false;
                }
                defineTerminalWidget(dependencyNode2.run, i10);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> iterator22 = ((ChainRun) widgetRun).widgets.iterator2();
                    while (iterator22.hasNext()) {
                        defineTerminalWidget(iterator22.next(), i10);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i10] = false;
                }
                defineTerminalWidget(dependencyNode.run, i10);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j10;
        }
        int size = dependencyNode.dependencies.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            Dependency dependency = dependencyNode.dependencies.get(i10);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j11 = Math.min(j11, traverseEnd(dependencyNode2, dependencyNode2.margin + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j11;
        }
        long wrapDimension = j10 - widgetRun.getWrapDimension();
        return Math.min(Math.min(j11, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
    }

    private long traverseStart(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j10;
        }
        int size = dependencyNode.dependencies.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            Dependency dependency = dependencyNode.dependencies.get(i10);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j11 = Math.max(j11, traverseStart(dependencyNode2, dependencyNode2.margin + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j11;
        }
        long wrapDimension = j10 + widgetRun.getWrapDimension();
        return Math.max(Math.max(j11, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i10) {
        long wrapDimension;
        int i11;
        WidgetRun widgetRun = this.firstRun;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).orientation != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i10 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
        DependencyNode dependencyNode2 = (i10 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
        boolean contains = widgetRun.start.targets.contains(dependencyNode);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode2);
        long wrapDimension2 = this.firstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.firstRun.start, 0L);
            long traverseEnd = traverseEnd(this.firstRun.end, 0L);
            long j10 = traverseStart - wrapDimension2;
            WidgetRun widgetRun2 = this.firstRun;
            int i12 = widgetRun2.end.margin;
            if (j10 >= (-i12)) {
                j10 += i12;
            }
            int i13 = widgetRun2.start.margin;
            long j11 = ((-traverseEnd) - wrapDimension2) - i13;
            if (j11 >= i13) {
                j11 -= i13;
            }
            float f10 = (float) (widgetRun2.widget.getBiasPercent(i10) > 0.0f ? (((float) j11) / r13) + (((float) j10) / (1.0f - r13)) : 0L);
            long j12 = (f10 * r13) + 0.5f + wrapDimension2 + (f10 * (1.0f - r13)) + 0.5f;
            wrapDimension = r13.start.margin + j12;
            i11 = this.firstRun.end.margin;
        } else {
            if (contains) {
                return Math.max(traverseStart(this.firstRun.start, r13.margin), this.firstRun.start.margin + wrapDimension2);
            }
            if (contains2) {
                return Math.max(-traverseEnd(this.firstRun.end, r13.margin), (-this.firstRun.end.margin) + wrapDimension2);
            }
            wrapDimension = r13.start.margin + this.firstRun.getWrapDimension();
            i11 = this.firstRun.end.margin;
        }
        return wrapDimension - i11;
    }

    public void defineTerminalWidgets(boolean z10, boolean z11) {
        if (z10) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z11) {
            WidgetRun widgetRun2 = this.firstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
