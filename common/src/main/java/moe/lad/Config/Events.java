package moe.lad.Config;

import dev.architectury.event.EventResult;
import moe.lad.Twoplayer_utils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class Events {
    public static boolean JUMP = false;
    public static boolean SNEAK = false;
    public static EventResult hurt(LivingEntity entity, DamageSource source, float amount) {
        if (!(source.getEntity() instanceof Player)) return EventResult.pass();
        if (!(entity instanceof Player)) return EventResult.pass();
        if (!(entity.getName().toString().equals(Minecraft.getInstance().player.getName().toString())))
            return EventResult.pass();
        JUMP = false;
        SNEAK = true;
        return EventResult.pass();
    }
}
