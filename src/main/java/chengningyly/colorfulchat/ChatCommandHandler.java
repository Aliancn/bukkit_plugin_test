package chengningyly.colorfulchat;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;

/**
 * ClassName : ChatCommandHandler
 * Package : chengningyly.colorfulchat
 * Description :
 *
 * @Author Aliancn
 * @Create 2023/4/28 15:13
 * @Version 1.0
 */
public class ChatCommandHandler implements CommandExecutor {

    private ColorfulChat _plugin;

    public ChatCommandHandler(ColorfulChat plugin){
        _plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //先判断指令的发送者是否合法
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "only player can use this command ");
            return true;
        }
        Player player = (Player) commandSender;

        //再执行逻辑块
        if (_plugin.get_enableTable().containsKey(player) && _plugin.get_enableTable().get(player)){
            _plugin.get_enableTable().put(player,false);
        } else {
            _plugin.get_enableTable().put(player , true);
        }

        player.sendMessage(ChatColor.YELLOW +"切换到彩色聊天模式");

        return true;
    }
}
