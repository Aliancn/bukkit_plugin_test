package chengningyly.colorfulchat;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * ClassName : ChatListener
 * Package : chengningyly.colorfulchat
 * Description :
 *
 * @Author Aliancn
 * @Create 2023/4/28 15:14
 * @Version 1.0
 */
public class ChatListener implements org.bukkit.event.Listener{

    //构造的板块
    private ColorfulChat _plugin;

    private IColorGeneratePolicy _policy;

    public ChatListener (ColorfulChat plugin,IColorGeneratePolicy policy){
        _plugin = plugin;
        _policy = policy;
    }

    //监听事件，当事件发生时执行逻辑
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e ){
        if(_plugin.get_enableTable().getOrDefault(e.getPlayer(),false)){
            String msg  = _policy.getNextColorString(e.getMessage());
            e.setMessage(msg);
        }
    }
}
