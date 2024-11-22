package moe.lad.fabric.client;

import dev.architectury.event.events.client.ClientTickEvent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.core.*;
import io.wispforest.owo.ui.hud.Hud;
import io.wispforest.owo.ui.hud.HudContainer;
import moe.lad.Twoplayer_utils;
import moe.lad.fabric.events.KeyBindHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;


public final class Twoplayer_utilsFabricClient implements ClientModInitializer {



    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        ClientTickEvent.CLIENT_POST.register(KeyBindHandler::tickClientPost);
        //KeyBindingHelper.registerKeyBinding(Twoplayer_utils.RAY_TP);
        //KeyBindingHelper.registerKeyBinding(Twoplayer_utils.JUMP_MAPPING);


        Hud.add(ResourceLocation.parse("hud-generic"), () ->
                Containers.verticalFlow(Sizing.content(), Sizing.content())
                        .child(Components.label(
                                Component.empty()
                                        .append("Hello")
                        ).horizontalTextAlignment(HorizontalAlignment.CENTER).shadow(true))
                        .surface(Surface.flat(0x77000000).and(Surface.outline(0xFF121212)))
                        .padding(Insets.of(5))
                        .positioning(Positioning.relative(100, 35))
        );

    }
}
