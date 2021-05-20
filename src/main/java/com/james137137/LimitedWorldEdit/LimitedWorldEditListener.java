package com.james137137.LimitedWorldEdit;

import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.event.extent.EditSessionEvent;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.util.eventbus.EventHandler;
import com.sk89q.worldedit.util.eventbus.Subscribe;

import fr.lightmute.StelyLimitedWorldEdit.App;

import java.util.HashSet;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LimitedWorldEditListener implements Listener {
  boolean checkByPass = true;
  
  public LimitedWorldEditListener(App aThis) {
  }
  
  @SuppressWarnings("deprecation")
@Subscribe(priority = EventHandler.Priority.VERY_EARLY)
  public void onEditSession(EditSessionEvent event) {
	  Bukkit.broadcastMessage("il prend bien l'event");
    if (event.getActor() == null || !event.getActor().isPlayer())
      return; 
    Player player = Bukkit.getPlayer(event.getActor().getName().toLowerCase());
    if (this.checkByPass && player != null && player.hasPermission("LimitedWorldEdit.bypass"))
      return; 
    checkLimit(player);
    HashSet<RegionWrapper> mask = WEManager.getMask(player);
    event.setExtent((Extent)new WEExtent(mask, event.getExtent()));
  }
  
  private void checkLimit(Player player) {
    try {
      WorldEdit.getInstance().getSessionManager().findByName(player.getName()).setBlockChangeLimit(100);
    } catch (Exception exception) {}
  }
}
