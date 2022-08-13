package de.tomjuri.gtbc;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.IOException;

@Mod(modid = "gtbc", useMetadata = true)
public class GuessTheBuildCheat {

    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        System.out.println("Loaded " + GTBUtils.getWords().length + " words.");
    }
}
