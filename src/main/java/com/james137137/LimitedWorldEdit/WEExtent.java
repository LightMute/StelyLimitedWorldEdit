package com.james137137.LimitedWorldEdit;

import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.entity.BaseEntity;
import com.sk89q.worldedit.entity.Entity;
import com.sk89q.worldedit.extent.AbstractDelegateExtent;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldedit.world.biome.BiomeType;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockState;

import java.util.HashSet;

public class WEExtent extends AbstractDelegateExtent {
  private final HashSet<RegionWrapper> mask;
  
  public WEExtent(HashSet<RegionWrapper> mask, Extent extent) {
    super(extent);
    this.mask = mask;
  }
  
  public boolean setBlock(BlockVector3 location, BaseBlock block) throws WorldEditException {
    return (WEManager.maskContains(this.mask, location.getBlockX(), location.getBlockY(), location.getBlockZ()) && super.setBlock(location, block));
  }
  
  public Entity createEntity(Location location, BaseEntity entity) {
    if (WEManager.maskContains(this.mask, location.getBlockX(), location.getBlockY(), location.getBlockZ()))
      return super.createEntity(location, entity); 
    return null;
  }
  
  public boolean setBiome(BlockVector3 position, BiomeType biome) {
    return (WEManager.maskContains(this.mask, position.getBlockX(), position.getBlockZ()) && super.setBiome(position, biome));
  }
  
  public BlockState getBlock(BlockVector3 location) {
    if (WEManager.maskContains(this.mask, location.getBlockX(), location.getBlockY(), location.getBlockZ()))
      return super.getBlock(location);
	return null;  
  }
}

