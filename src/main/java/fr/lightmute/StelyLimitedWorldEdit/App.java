package fr.lightmute.StelyLimitedWorldEdit;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.james137137.LimitedWorldEdit.LimitedWorldEditListener;
import com.james137137.LimitedWorldEdit.hooks.API;
import com.james137137.LimitedWorldEdit.hooks.WorldGaurdAPI;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;

/**
 * Hello world!
 *
 */
public class App extends JavaPlugin {
	
	  static final Logger log = Logger.getLogger("Minecraft");
	  
	  public double delay;
	  
	  WorldGaurdAPI worldGaurdAPI = null;
	  
	  public static API api;
	  
	  public static WorldEditPlugin worldEdit;
	  
	  public void onEnable() {
	    saveConfig();
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
	    if (plugin != null)
	      api = new WorldGaurdAPI(); 
	    WorldEdit.getInstance().getEventBus().register(new LimitedWorldEditListener(this));
	    String version = Bukkit.getServer().getPluginManager().getPlugin(getName()).getDescription().getVersion();
	    log.log(Level.INFO, getName() + ":Version {0} enabled", version);
	  }
	  
	  public void onDisable() {
	    log.info("LimitedWorldEdit: disabled");
	  }
	}
