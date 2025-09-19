package your.pkg;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "meteordevelopment.meteorclient.pathing.PathManagers", remap = false)
public class MeteorNoBaritoneMixin {
    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = false)
    private static void chatclef$skipBaritoneInit(CallbackInfo ci) {
        // Cancel PathManagers.init() so Meteor doesn't touch Baritone
        ci.cancel();
    }
}
