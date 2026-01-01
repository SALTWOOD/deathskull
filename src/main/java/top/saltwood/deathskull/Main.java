package top.saltwood.deathskull;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import top.saltwood.deathskull.util.DeathHandle;
import top.saltwood.deathskull.util.DeathInfo;
import top.saltwood.deathskull.util.DeathSkullInterface;

import java.util.*;

public class Main implements ModInitializer {
    public static final String MOD_ID = "deathskull";

    @Override
    public void onInitialize() {
        registerPlayerDeathEvent();
    }

    private void registerPlayerDeathEvent() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            if (!(entity instanceof ServerPlayerEntity player)) return true;
            DeathHandle.handle(player);
            return true;
        });
    }
}