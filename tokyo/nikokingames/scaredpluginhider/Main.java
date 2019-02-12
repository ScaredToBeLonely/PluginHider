package tokyo.nikokingames.scaredpluginhider;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		
		ConsoleCommandSender localConsoleCommandSender = Bukkit.getServer().getConsoleSender();
		localConsoleCommandSender.sendMessage("Plugin has enabled.");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void onDisable() {
		ConsoleCommandSender localConsoleCommandSender = Bukkit.getServer().getConsoleSender();
		localConsoleCommandSender.sendMessage("Plugin has disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("scaredcmd")) {
			if(!p.hasPermission("scared.cmd")) {
				p.sendMessage(ChatColor.DARK_RED + "You don't have permission execute this command.");
				return true;
			}
			int a = 1;int b = 100;
			while(a < b) {
				Bukkit.broadcastMessage("");
				a++;
			}
			Bukkit.broadcastMessage(ChatColor.DARK_RED + getConfig().getString("ccleaner"));
		}
		if(cmd.getName().equalsIgnoreCase("ScaredPluginHider")) {
			p.sendMessage(ChatColor.GREEN + "ScaredPluginHider" + ChatColor.RED + "Plugin made by " + ChatColor.RED + "ScaredToBeLonely");
		}
		return false;
	}

	  @EventHandler
	  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
	  {
	    Player p = event.getPlayer();
	    if (((event.getMessage().equals("/?")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/help")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/bukkit:plugins")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/bukkit:?")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/bukkit:help")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/icanhasbukkit")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/version")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/ver")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/bukkit:ver")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/bukkit:about")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/bukkit:pl")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().contains("/bukkit:msg")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().contains("/bukkit:kill")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().contains("/bukkit:tell")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/bukkit:w")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().contains("/bukkit:me")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/pl")) && (!event.getPlayer().isOp())) || 
	      ((event.getMessage().equalsIgnoreCase("/plugins")) && (!event.getPlayer().isOp())) || (
	      (event.getMessage().equalsIgnoreCase("/about")) && (!event.getPlayer().isOp())))
	    {
	      event.setCancelled(true);
	      p.sendMessage(ChatColor.RED + getConfig().getString("PluginsMessage"));
	    }
	  }
	}
