package com.james137137.LimitedWorldEdit.hooks;

import com.james137137.LimitedWorldEdit.RegionWrapper;
import java.util.List;
import org.bukkit.entity.Player;

public interface API {
  List<RegionWrapper> getRegions(Player paramPlayer);
}