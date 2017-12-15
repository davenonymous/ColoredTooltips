package org.dave.coloredtooltips.config;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.dave.coloredtooltips.ColoredTooltips;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationHandler {
    public static Configuration configuration;

    public static void init(File configFile) {
        if (configuration != null) {
            return;
        }

        configuration = new Configuration(configFile, null);
        loadConfiguration();
    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(ColoredTooltips.MODID)) {
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        Settings.backgroundColor = configuration.getString(
                "backgroundColor",
                "General",
                "0xF0100010",
                "Background color of all tooltips (ARGB)"
        );

        Settings.borderColor = configuration.getString(
                "borderColor",
                "General",
                "0x505000FF",
                "Border color of all tooltips (ARGB)"
        );
    }

    public static List<IConfigElement> getConfigElements() {
        List<IConfigElement> result = new ArrayList<>();
        result.add(new ConfigElement(configuration.getCategory("General")));
        return result;
    }

    public static class Settings {
        private static String backgroundColor;
        private static String borderColor;

        public static long getBackgroundColor() {
            return Long.decode(backgroundColor);
        }

        public static long getBorderColor() {
            return Long.decode(borderColor);
        }
    }
}
