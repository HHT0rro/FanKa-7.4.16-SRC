package com.android.internal.os;

import android.os.Binder;
import com.android.modules.utils.BasicShellCommandHandler;
import java.io.FileDescriptor;
import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class BaseCommand {
    public static final String FATAL_ERROR_CODE = "Error type 1";
    public static final String NO_CLASS_ERROR_CODE = "Error type 3";
    public static final String NO_SYSTEM_ERROR_CODE = "Error type 2";
    protected final BasicShellCommandHandler mArgs = new BasicShellCommandHandler() { // from class: com.android.internal.os.BaseCommand.1
        public int onCommand(String cmd) {
            return 0;
        }

        public void onHelp() {
        }
    };
    private String[] mRawArgs;

    public abstract void onRun() throws Exception;

    public abstract void onShowUsage(PrintStream printStream);

    public void run(String[] args) {
        if (args.length < 1) {
            onShowUsage(System.out);
            return;
        }
        this.mRawArgs = args;
        this.mArgs.init((Binder) null, (FileDescriptor) null, (FileDescriptor) null, (FileDescriptor) null, args, 0);
        try {
            onRun();
        } catch (IllegalArgumentException e2) {
            onShowUsage(System.err);
            System.err.println();
            System.err.println("Error: " + e2.getMessage());
        } catch (Exception e10) {
            e10.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public void showUsage() {
        onShowUsage(System.err);
    }

    public void showError(String message) {
        onShowUsage(System.err);
        System.err.println();
        System.err.println(message);
    }

    public String nextOption() {
        return this.mArgs.getNextOption();
    }

    public String nextArg() {
        return this.mArgs.getNextArg();
    }

    public String peekNextArg() {
        return this.mArgs.peekNextArg();
    }

    public String nextArgRequired() {
        return this.mArgs.getNextArgRequired();
    }

    public String[] getRawArgs() {
        return this.mRawArgs;
    }
}
