package your.pkg.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Use string target so you DON'T need meteor on the compile classpath
@Mixin(targets = "meteordevelopment.meteorclient.pathing.PathManagers")
public class MeteorNoBaritoneMixin {
    // Cancel PathManagers.init() at the start so Meteor doesn't reflect into Baritone
    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = false)
    private static void chatclef$skipBaritoneInit(CallbackInfo ci) {
        ci.cancel();
    }
}
