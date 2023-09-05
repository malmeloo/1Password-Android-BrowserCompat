package ooo.mikealmel.xposed.onepassbc;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;


public class HookLoader implements IXposedHookLoadPackage {
    private final static String PACKAGE_ID = "com.onepassword.android";
    private final static String HOOK_CLASS = "com.onepassword.android.autofill.AppId";
    private final static String HOOK_METHOD = "isKnownBrowser";

    public void handleLoadPackage(final LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals(HookLoader.PACKAGE_ID)) return;

        XposedBridge.log(String.format("Hooking into %s/%s", HookLoader.HOOK_CLASS, HookLoader.HOOK_METHOD));

        findAndHookMethod(HookLoader.HOOK_CLASS, lpparam.classLoader, HookLoader.HOOK_METHOD, new Hook());
    }
}
