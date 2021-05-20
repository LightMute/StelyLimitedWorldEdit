package com.james137137.LimitedWorldEdit.hooks;

import com.james137137.LimitedWorldEdit.RegionWrapper;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class WorldGaurdAPI implements API {

	@SuppressWarnings("deprecation")
	public List<RegionWrapper> getRegions(Player player) {
		List<RegionWrapper> output = new ArrayList<RegionWrapper>();
		RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
		RegionManager mgr = container.get(BukkitAdapter.adapt(player.getWorld()));
		Collection<ProtectedRegion> values = mgr.getRegions().values();
		for (ProtectedRegion value : values) {
			if (value.getOwners().contains(player.getName().toLowerCase())) {
				Bukkit.broadcastMessage("velue" + value);
				BlockVector3 minimumPoint = value.getMinimumPoint();
				BlockVector3 maximumPoint = value.getMaximumPoint();
				RegionWrapper regionWrapper = new RegionWrapper(minimumPoint.getBlockX(), maximumPoint.getBlockX(), minimumPoint.getBlockY(), maximumPoint.getBlockY(), minimumPoint.getBlockZ(), maximumPoint.getBlockZ());
				output.add(regionWrapper);
			} 
		} 
		return output;
	}
}
