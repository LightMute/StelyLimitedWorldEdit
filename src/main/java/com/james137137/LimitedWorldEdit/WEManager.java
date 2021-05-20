package com.james137137.LimitedWorldEdit;

import java.util.HashSet;
import org.bukkit.entity.Player;

import fr.lightmute.StelyLimitedWorldEdit.App;

public class WEManager {
  
  public static boolean maskContains(HashSet<RegionWrapper> mask, int x, int y, int z) {
    for (RegionWrapper region : mask) {
      if (region.isIn(x, y, z))
        return true; 
    } 
    return false;
  }
  
  public static boolean maskContains(HashSet<RegionWrapper> mask, int x, int z) {
    for (RegionWrapper region : mask) {
      if (region.isIn(x, z))
        return true; 
    } 
    return false;
  }
  
  public static HashSet<RegionWrapper> getMask(Player player) {
    HashSet<RegionWrapper> regions = new HashSet<RegionWrapper>();
    regions.addAll(App.api.getRegions(player));
    return regions;
  }
}
