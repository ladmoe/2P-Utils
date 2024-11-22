package moe.lad.fabric.events;

import moe.lad.Twoplayer_utils;
import moe.lad.fabric.Config.ConfigScreenComplex;
import net.minecraft.client.Minecraft;

public class KeyBindHandler {
    public static void tickClientPost(Minecraft minecraft) {

        if (Twoplayer_utils.GUIKEY.consumeClick()) {
            minecraft.setScreen(new ConfigScreenComplex());

        }
    }
}
