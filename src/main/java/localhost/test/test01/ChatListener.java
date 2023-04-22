package localhost.test.test01;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;

/**
 * ClassName : ColorfulListener
 * Package : localhost.test.test01
 * Description :
 *
 * @Author Aliancn
 * @Create 2023/4/22 21:16
 * @Version 1.0
 */
public class ChatListener implements org.bukkit.event.Listener{

    private ColorfulChat _plugin;

    private IColorGeneratePolicy _policy;

    public ChatListener(ColorfulChat plugin , IColorGeneratePolicy policy){
        _plugin = plugin;
        _policy = policy;
    }

    @EventHandler
    public void onPlayerTable(AsyncChatEvent e){
        if (_plugin.getEnableTable().getOrDefault(e.getPlayer(),false)){
            String msg  = _policy.getNextColerString(e.getMessage());
            e.setMessage(msg);
        }
    }
}
