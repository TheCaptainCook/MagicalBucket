package thecaptaincook.magicalbucket.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class colorTranslate {

    public static String translateStringColor(String string){
        return (ChatColor.translateAlternateColorCodes('&', string));
    }
    public static List<String> colorArrayTranslate(List<String> lore){
        List<String> colour = new ArrayList<>();
        for(String s : lore){
            colour.add(translateStringColor(s));
        }
        return colour;
    }

}
