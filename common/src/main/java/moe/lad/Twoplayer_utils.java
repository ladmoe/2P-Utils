package moe.lad;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import moe.lad.Config.Events;
import moe.lad.Config.KeyBindHandler;
import moe.lad.modules.RayTeleport;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Twoplayer_utils {

    public static final String MOD_ID = "twoplayer_utils";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final KeyMapping RAY_TP = new KeyMapping(
            "TP Ahead", // The translation key of the name shown in the Controls screen
            InputConstants.Type.KEYSYM, // This key mapping is for Keyboards by default
            GLFW.GLFW_KEY_U, // The default keycode
            "2P Utils" // The category translation key used to categorize in the Controls screen
    );
    public static final KeyMapping JUMP_MAPPING = new KeyMapping(
            "Jump Lock", // The translation key of the name shown in the Controls screen
            InputConstants.Type.KEYSYM, // This key mapping is for Keyboards by default
            GLFW.GLFW_KEY_I, // The default keycode
            "2P Utils" // The category translation key used to categorize in the Controls screen
    );
    public static final KeyMapping GUIKEY = new KeyMapping(
            "Open UI", // The translation key of the name shown in the Controls screen
            InputConstants.Type.KEYSYM, // This key mapping is for Keyboards by default
            GLFW.GLFW_KEY_H, // The default keycode
            "`2P Utils" // The category translation key used to categorize in the Controls screen)
    );
    public static void init() {
        // Write common init code here.



        EntityEvent.LIVING_HURT.register(Events::hurt);
        //KeyMappingRegistry.register(RAY_TP);
        //KeyMappingRegistry.register(JUMP_MAPPING);
        KeyMappingRegistry.register(GUIKEY);

        ClientTickEvent.CLIENT_POST.register(KeyBindHandler::tickClientPost);

    }


}
