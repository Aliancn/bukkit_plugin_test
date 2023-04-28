package chengningyly.colorfulchat;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public final class ColorfulChat extends JavaPlugin {

    private final Map<Player ,Boolean > _enableTable;

    public Map<Player,Boolean> get_enableTable(){
        return _enableTable;
    }

    public ColorfulChat(){
        _enableTable = new HashMap<>();
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        IColorGeneratePolicy policy;
        try{
            net.md_5.bungee.api.ChatColor.of("#66ccff");
            policy = new GradientRgbGeneratePolicy();
        } catch (Throwable ignore){
            policy = new GradientGeneratePolicy();
        }
        getLogger().info("Using "+ policy.getClass().getSimpleName());
        //注册监听
        Bukkit.getPluginManager().registerEvents(new ChatListener(this,policy),this);
        //绑定指令名称
        PluginCommand command = Bukkit.getPluginCommand("colorfulchat");
        //注册控制器
        ChatCommandHandler handler = new ChatCommandHandler(this);
        command.setExecutor(handler);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
