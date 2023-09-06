package ooo.mikealmel.xposed.onepassbc;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class Hook extends XC_MethodHook {
    private final static String[] ALLOWED_APPS = new String[]{
        "org.mozilla.fennec_fdroid",
        "io.github.forkmaintainers.iceraven",
        "us.spotco.fennec_dos"
    };
    @Override
    protected void beforeHookedMethod(MethodHookParam param) {
        String appValue = XposedHelpers.getObjectField(param.thisObject, "value").toString();
        String[] valueParts = appValue.split("@");
        if (valueParts.length < 2) {
            XposedBridge.log("Error: Could not find app ID from value: " + appValue);
            return;
        }
        String appId = valueParts[valueParts.length - 1];

        for (String allowedId : Hook.ALLOWED_APPS) {
            if (appId.equals(allowedId)) {
                param.setResult(true);
                return;
            }
        }
    }
}
