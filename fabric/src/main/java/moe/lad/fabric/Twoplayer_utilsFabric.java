package moe.lad.fabric;

import moe.lad.Twoplayer_utils;
import moe.lad.fabric.Config.ConfigManager;
import moe.lad.fabric.Config.TwoConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.Minecraft;

public final class Twoplayer_utilsFabric implements ModInitializer {

    public static final TwoConfig CONFIG = TwoConfig.createAndLoad();
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Twoplayer_utils.init();

        if (CONFIG.anEnumOption() == ConfigManager.Choices.A_CHOICE)
            Twoplayer_utils.LOGGER.info("This is a useless string!");


    }
}
