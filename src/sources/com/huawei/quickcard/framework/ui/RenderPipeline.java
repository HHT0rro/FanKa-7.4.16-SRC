package com.huawei.quickcard.framework.ui;

import android.view.Choreographer;
import android.view.View;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RenderPipeline {
    public final List<RenderCommand> immediatelyCommands = new ArrayList();
    public final List<RenderCommand> pseudoCommands = new ArrayList();
    public final List<RenderCommand> postCommands = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CommandOptions commandOptions, CardContext cardContext, View view, long j10) {
        notifyRenderStart(commandOptions);
        renderByCommandList(this.postCommands);
        if (ViewUtils.renderCSSTag(cardContext, view)) {
            renderByCommandList(this.pseudoCommands);
        }
        notifyRenderEnd(commandOptions);
    }

    public RenderPipeline addCommand(RenderCommand renderCommand) {
        if (renderCommand != null) {
            if (renderCommand.isPseudoClass()) {
                this.pseudoCommands.add(renderCommand);
            } else if (renderCommand.immediately()) {
                this.immediatelyCommands.add(renderCommand);
            } else {
                this.postCommands.add(renderCommand);
            }
        }
        return this;
    }

    public void invalidateYogaLayout(View view) {
        ViewUtils.refreshSelf(view);
    }

    public boolean isEmpty() {
        return this.immediatelyCommands.isEmpty() && this.postCommands.isEmpty() && this.pseudoCommands.isEmpty();
    }

    public void notifyRenderEnd(CommandOptions commandOptions) {
        if (commandOptions != null) {
            commandOptions.onEnd();
        }
    }

    public void notifyRenderStart(CommandOptions commandOptions) {
        if (commandOptions != null) {
            commandOptions.onStart();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void render(final CardContext cardContext, final View view) {
        final CommandOptions commandOptions = view instanceof CommandOptions ? (CommandOptions) view : null;
        notifyRenderStart(commandOptions);
        renderByCommandList(this.immediatelyCommands);
        if (ViewUtils.renderCSSTag(cardContext, view)) {
            renderByCommandList(this.pseudoCommands);
        }
        notifyRenderEnd(commandOptions);
        boolean z10 = false;
        boolean z11 = true;
        if (!this.immediatelyCommands.isEmpty()) {
            Iterator<RenderCommand> iterator2 = this.immediatelyCommands.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                } else if (iterator2.next().needRefresh()) {
                    z10 = true;
                    break;
                }
            }
        }
        if (!this.postCommands.isEmpty() && !z10) {
            Iterator<RenderCommand> iterator22 = this.pseudoCommands.iterator2();
            while (iterator22.hasNext()) {
                if (iterator22.next().needRefresh()) {
                    break;
                }
            }
        }
        z11 = z10;
        if (z11) {
            invalidateYogaLayout(view);
        }
        if (this.postCommands.isEmpty()) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.huawei.quickcard.framework.ui.b
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                RenderPipeline.this.a(commandOptions, cardContext, view, j10);
            }
        });
    }

    public void renderByCommandList(List<RenderCommand> list) {
        Iterator<RenderCommand> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().doRender();
        }
    }
}
