package localhost.test.test01;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Test01 extends JavaPlugin {
    //创建玩家是否开启的列表
    private final Map<Player,Boolean> _enableTable;

    //接口：提供列表
    public Map<Player,Boolean> getEnableTable(){ return _enableTable;}

    //默认构造函数
    public Test01(){ _enableTable = new HashMap<>();}

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Hello the server ");

        //这里干什么的
        IColorGeneratePolicy policy;
        try{
            net.md_5.bungee.api.ChatColor.of("#66ccff");
            policy = new GradientRgbGeneratePolicy();
        }catch(Throwable ignore){
            policy = new GradientGeneratePolicy();
        }
        getLogger().info("Using " + policy.getClass().getSimpleName());
        Bukkit.getPluginManager().registerEvents(new ChatListener( this, policy), this);
        PluginCommand command = Bukkit.getPluginCommand("colorfulchat");
        ChatCommandHandler handler = new ChatCommandHandler(this);
        command.setExecutor(handler);

        //这句与color无关
        Bukkit.getPluginManager().registerEvents(new Listener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("my plugin is stopped ");
    }
}
