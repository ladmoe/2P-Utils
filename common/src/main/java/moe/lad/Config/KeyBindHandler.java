package moe.lad.Config;


import jdk.jfr.Event;
import moe.lad.Twoplayer_utils;
import moe.lad.modules.RayTeleport;
import net.minecraft.client.Minecraft;

public class KeyBindHandler {
    public static void tickClientPost(Minecraft minecraft){
        if (Twoplayer_utils.JUMP_MAPPING.consumeClick()) {
            Events.JUMP=!Events.JUMP;
        }
        if (Events.JUMP) {
            assert minecraft.player != null;
            if (minecraft.player.onGround()&&!(minecraft.player.isInLiquid())) {
                minecraft.player.jumpFromGround();
            }
        }

        while (Twoplayer_utils.RAY_TP.consumeClick()) {

            Twoplayer_utils.LOGGER.info("Button is pressed! " +System.currentTimeMillis()/1000);
            assert minecraft.player != null;

            RayTeleport.SightTeleport(minecraft);
        }
    }
}
