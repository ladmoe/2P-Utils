package moe.lad.modules;

import moe.lad.Twoplayer_utils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;


public class RayTeleport {
    private static final Minecraft MC = Minecraft.getInstance();
    public static void SightTeleport(Minecraft mc) {


        BlockHitResult hitResult = rayTrace(100);
        BlockPos bp = hitResult.getBlockPos();
        BlockState bs = mc.level.getBlockState(bp);
        if (bs.isAir()) return;
        double boundsMaxY = bs.getCollisionShape(mc.level,bp).max(Direction.Axis.Y);
        Vec3 rtPos = new Vec3(bp.getX()+0.5D,bp.getY()+boundsMaxY,bp.getZ()+0.5D);
        sendTpTo(rtPos,3);
        mc.player.playSound(SoundEvents.BUBBLE_POP);

    }
    private static void particle(Vec3 pos) {
        //TODO: DEBUG METHOD
        MC.getConnection().sendCommand("particle crit "+String.format("%.1f",pos.x)+" "+String.format("%.1f",pos.y)+" "+String.format("%.1f",pos.z));
    }

    public static BlockHitResult rayTrace(float dist) {
        Vec3 lookVec = MC.player.getViewVector(1f);

        Vec3 start = MC.player.getPosition(1f);
        start = start.add(0,MC.player.getEyeHeight(),0);
        Vec3 end = start.add(lookVec.x *dist,lookVec.y *dist,lookVec.z *dist);
        ClipContext clipContext = new ClipContext(start,end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, CollisionContext.empty());
        return MC.level.clip(clipContext);
    }
    public static BlockState blockAtVec(Vec3 vec3) {
        BlockPos bp = new BlockPos((int)vec3.x,(int)vec3.y,(int) vec3.z);
        return MC.level.getBlockState(bp);
    }
    public static BlockPos blockPosAtVec(Vec3 vec3) {
        BlockPos bp = new BlockPos((int)vec3.x,(int)vec3.y,(int) vec3.z);
        return bp;
    }
    public static Vec3 getPos(int dist) {
        Vec3 lookVec = MC.player.getViewVector(1f);
        Vec3 playerPos = MC.player.getPosition(1f);
        return playerPos.add(lookVec.x * dist, lookVec.y * dist + MC.player.getEyeHeight(), lookVec.z * dist);

    }
    public static void sendTpTo(Vec3 pos, int decimal) {
        String format = "%."+decimal+"f";
        MC.getConnection().sendCommand("tp "+String.format(format,pos.x)+" "+String.format(format,pos.y)+" "+String.format(format,pos.z));
    }
}
