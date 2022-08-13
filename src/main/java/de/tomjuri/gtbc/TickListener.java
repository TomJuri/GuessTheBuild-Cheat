package de.tomjuri.gtbc;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;
import java.util.Optional;

public class TickListener {

    private int ticks = 0;
    private List<String> lastWords = null;
    private String lastActionBar = "";

    @SubscribeEvent
    public void onTick(final TickEvent.PlayerTickEvent tickEvent) {
        if (ticks++ != 20) return;
        ticks = 0;

        final Optional<String> optionalActionBar = GTBUtils.getActionBar();
        if (!optionalActionBar.isPresent()) return;

        final String actionBar = optionalActionBar.get();
        if (!GTBUtils.isGTBActionBar(actionBar)) return;

        if (actionBar.equals(lastActionBar)) return;
        lastActionBar = actionBar;

        String newactionbar = actionBar.replace("§bThe theme is §e", "");
        final List<String> words = GTBUtils.match(newactionbar);


        if (words.equals(lastWords)) return;

        final String wordString = String.join("§8, §e", words);
        final String message = "§e["
                + words.size()
                + "] §8: §e" + wordString;

        lastWords = words;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }
}
