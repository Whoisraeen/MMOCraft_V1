package net.raeen.mmocraft;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.raeen.mmocraft.client.gui.CharacterSelectionScreen;
import net.raeen.mmocraft.network.NetworkHandler;
import org.slf4j.Logger;
import net.minecraft.client.Minecraft;

@Mod(MMOCraft.MOD_ID)
public class MMOCraft {
    public static final String MOD_ID = "mmocraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MMOCraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        NetworkHandler.registerMessages(); // Moved the call here to ensure it's called once.
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // Client setup code here
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Server starting code here
    }

    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getPlayer().getLevel().isClientSide) { // Use getPlayer() and getLevel() for proper access
            Minecraft.getInstance().tell(() -> {
                try {
                    Minecraft.getInstance().setScreen(new CharacterSelectionScreen()); // Ensure CharacterSelectionScreen constructor is public
                } catch (IllegalAccessError e) {
                    LOGGER.error("Cannot instantiate CharacterSelectionScreen due to access restrictions.", e);
                }
            });
        }
    }

    // Removed the duplicate MMOCraft class definition

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Client setup code here
        }
    }
}
